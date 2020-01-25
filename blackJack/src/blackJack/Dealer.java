package blackJack;

import java.util.Arrays;
import java.util.Collections;

public class Dealer {
	String[] deck = {
			"¢½A","¢½2","¢½3","¢½4","¢½5","¢½6","¢½7","¢½8","¢½9","¢½10","¢½J","¢½Q","¢½K",
			"¢ÀA","¢À2","¢À3","¢À4","¢À5","¢À6","¢À7","¢À8","¢À9","¢À10","¢ÀJ","¢ÀQ","¢ÀK",
			"¡ÞA","¡Þ2","¡Þ3","¡Þ4","¡Þ5","¡Þ6","¡Þ7","¡Þ8","¡Þ9","¡Þ10","¡ÞJ","¡ÞQ","¡ÞK",
			"¢¼A","¢¼2","¢¼3","¢¼4","¢¼5","¢¼6","¢¼7","¢¼8","¢¼9","¢¼10","¢¼J","¢¼Q","¢¼K",
	};
	
	// shuffle deck
	public void shuffleDeck() {
		Collections.shuffle(Arrays.asList(this.deck));
	}

}
