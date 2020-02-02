library(tidyverse)

wine <- read.csv(file = 'https://bit.ly/2RmU1Wd', sep = ";")

str(object = wine)

wine$grade <- ifelse(test = wine$quality> = 7,yes = 'best',no = 'good')

wine$grade <- as.factor(x = wine$grade)

table(wine$grade,wine$quality)

scale(x = wine[,1:11])%>%
  as.data.frame() -> wineScaled

wineScaled <- cbind(wineScaled, grade = wine$grade)

set.seed(seed = 1234)

index <- sample(x = 1:2,
              size = nrow(x = wineScaled),
              prob = c(0.7,0.3),
              replace = TRUE)

trainSet <- wineScaled[index =  = 1,]
testSet <- wineScaled[index =  = 2,]

library(class)

set.seed(seed = 1234)

k <- trainSet%>%nrow()%>%sqrt()%>%ceiling()

knn(train = trainSet[,1:11],
    test = testSet[,1:11],
    cl = trainSet$grade,
    k = k,
    prob = TRUE) -> fitKnn

fitKnn[1:100]

pred <- fitKnn

real <- testSet$grade

library(caret)
confusionMatrix(data = pred,reference = real,positive = 'best')

library(MLmetrics)
F1_Score(y_pred = pred,y_true = real,positive = 'best')

library(ROCR)
predObj <- prediction(predictions = as.numeric(x = pred),
                     labels = as.numeric(x = real))
perform <- performance(prediction.obj = predObj,
                      measure = 'tpr',
                      x.measure = 'fpr')
plot(x = perform,main = 'ROCcurve')

library(pROC)
auc(response = as.numeric(x = real),
    predictor = as.numeric(x = pred))


library(ROSE)
ovun.sample(formula = grade~.,
            data = trainSet,
            method = 'both',
            p = 0.5,
            seed = 123) -> trainSetBal

trainSetBal <- trainSetBal$data

trainSetBal$grade%>%
  table()%>%
  prop.table()

knn(train = trainSetBal[,1:11],
    test = testSet[,1:11],
    cl = trainSetBal$grade,
    k = k,
    prob = TRUE) -> fitKnnBal

predBal <- fitKnnBal

levels(x = predBal)

table(predBal,real)

relevel(x = predBal,ref = 'best') -> predBal

confusionMatrix(data = predBal,reference = real,positive = 'best')
F1_Score(y_pred = predBal,y_true = real,positive = 'best')

predObj <- prediction(predictions = as.numeric(x = predBal),
                    labels = as.numeric(x = real))
perform <- performance(prediction.obj = predObj,
                      measure = 'tpr',
                      x.measure = 'fpr')
plot(x = perform,main = 'ROCcurve')
auc(response = as.numeric(x = real),
    predictor = as.numeric(x = predBal))


library(kknn)
kknn(formula = grade ~ ., 
     train = trainSet, 
     test = testSet, 
     k = k, 
     kernel = 'triangular') -> fitKnnW

class(x = fitKnnW)
predW <- fitKnnW$fitted.values
class(x = predW)
levels(x=predW)
levels(x=real)
# relevel(x = predW, ref = 'best') -> imsi
# levels(x = imsi)

confusionMatrix(data = pred,
                reference = real, 
                positive = 'best')

confusionMatrix(data = predW,
                reference = real, 
                positive = 'best')

F1_Score(y_true = real, y_pred = pred, positive = 'best')
F1_Score(y_true = real, y_pred = predW, positive = 'best')

predObj <- prediction(predictions = as.numeric(x = predW),
                      labels = as.numeric(x = real))

perform <- performance(prediction.obj = predObj,
                       measure = 'tpr',
                       x.measure = 'fpr')

plot(x = perform, main = 'ROC curve')

auc(response = as.numeric(x = real),
    predictor = as.numeric(x = pred))

auc(response = as.numeric(x = real),
    predictor = as.numeric(x = predW))



# 성능이 졸은 K값 찾기!!!!

ks <- seq(from = 3, to = 59, by = 2)

fitKnnFun <- function(k) {
  library(kknn)
  kknn(formula = grade ~ ., 
       train = trainSet, 
       test = testSet, 
       k = k, 
       kernel = 'triangular') -> fit
  
  pred <- fit$fitted.values
  real <- testSet$grade
  
  F1_Score(y_true = real, 
           y_pred = pred, 
           positive = 'best') %>% return()
  
}


predCV <- c()

for (i in 1:length(ks)) {
  k <- ks[i]
  predCV[i] <- fitKnnFun(k = k)
}

plot(x = ks, 
     y = predCV, 
     pch = 19, 
     col = 'red', 
     type = 'b')

