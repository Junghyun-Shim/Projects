package blackJack;

import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;

public class Dealer {
	String[] deck_ = {
			"��A","��2","��3","��4","��5","��6","��7","��8","��9","��10","��J","��Q","��K",
			"��A","��2","��3","��4","��5","��6","��7","��8","��9","��10","��J","��Q","��K",
			"��A","��2","��3","��4","��5","��6","��7","��8","��9","��10","��J","��Q","��K",
			"��A","��2","��3","��4","��5","��6","��7","��8","��9","��10","��J","��Q","��K",
	};
	
	ArrayList<String> deck = new ArrayList<>(Arrays.asList(deck_));
	

	
	// shuffle deck
	public void shuffleDeck() {
//		Collections.shuffle(Arrays.asList(this.deck));
		Collections.shuffle(this.deck);
	}
	


	
	

}
