package blackJack;

import java.util.Arrays;
import java.util.Collections;

public class Dealer {
	String[] deck = {
			"��A","��2","��3","��4","��5","��6","��7","��8","��9","��10","��J","��Q","��K",
			"��A","��2","��3","��4","��5","��6","��7","��8","��9","��10","��J","��Q","��K",
			"��A","��2","��3","��4","��5","��6","��7","��8","��9","��10","��J","��Q","��K",
			"��A","��2","��3","��4","��5","��6","��7","��8","��9","��10","��J","��Q","��K",
	};
	
	// shuffle deck
	public void shuffleDeck() {
		Collections.shuffle(Arrays.asList(this.deck));
	}

}
