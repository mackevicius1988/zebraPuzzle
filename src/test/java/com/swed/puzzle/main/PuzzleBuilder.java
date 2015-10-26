package com.swed.puzzle.main;

import java.util.ArrayList;
import java.util.List;
import java.util.AbstractMap.SimpleEntry;

import com.swed.puzzle.domain.Hint;
import com.swed.puzzle.domain.Puzzle;

/**
 * 
 * @author mmackevicius
 *
 */
public class PuzzleBuilder {

	static Puzzle buildFullPuzzle() {
		List<Hint> hints = new ArrayList<Hint>();

		hints.add(new Hint("SAME", new SimpleEntry<>("nationality", "English"), new SimpleEntry<>("color", "Red")));
		hints.add(new Hint("SAME", new SimpleEntry<>("nationality", "Spaniard"), new SimpleEntry<>("pet", "Dog")));
		hints.add(new Hint("SAME", new SimpleEntry<>("drink", "Coffee"), new SimpleEntry<>("color", "Green")));
		hints.add(new Hint("SAME", new SimpleEntry<>("drink", "Tea"), new SimpleEntry<>("nationality", "Ukrainian")));
		hints.add(new Hint("TO_THE_LEFT_OF", new SimpleEntry<>("color", "Ivory"), new SimpleEntry<>("color", "Green")));
		hints.add(new Hint("SAME", new SimpleEntry<>("smoke", "Old gold"), new SimpleEntry<>("pet", "Snails")));
		hints.add(new Hint("SAME", new SimpleEntry<>("smoke", "Kools"), new SimpleEntry<>("color", "Yellow")));
		hints.add(new Hint("SAME", new SimpleEntry<>("drink", "Milk"), new SimpleEntry<>("position", "3")));
		hints.add(new Hint("SAME", new SimpleEntry<>("nationality", "Norwegian"), new SimpleEntry<>("position", "1")));
		hints.add(new Hint("NEXT_TO", new SimpleEntry<>("smoke", "Chesterfields"), new SimpleEntry<>("pet", "Fox")));
		hints.add(new Hint("NEXT_TO", new SimpleEntry<>("smoke", "Kools"), new SimpleEntry<>("pet", "Horse")));
		hints.add(new Hint("SAME", new SimpleEntry<>("smoke", "Lucky strike"),
				new SimpleEntry<>("drink", "Orange juice")));
		hints.add(new Hint("SAME", new SimpleEntry<>("smoke", "Parliaments"),
				new SimpleEntry<>("nationality", "Japanese")));
		hints.add(
				new Hint("NEXT_TO", new SimpleEntry<>("color", "Blue"), new SimpleEntry<>("nationality", "Norwegian")));
		hints.add(new Hint("SAME", new SimpleEntry<>("drink", "Water")));
		hints.add(new Hint("SAME", new SimpleEntry<>("pet", "Zebra")));

		Puzzle ret = new Puzzle(5);
		ret.setHints(hints);
		return ret;
	}

	static Puzzle buildFullWithExtraHintPuzzle(Hint hint) {
		Puzzle ret = buildFullPuzzle();
		ret.addHint(hint);
		return ret;
	}

}
