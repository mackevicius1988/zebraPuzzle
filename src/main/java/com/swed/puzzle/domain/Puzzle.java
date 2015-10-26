package com.swed.puzzle.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author mmackevicius
 *
 */
public class Puzzle {

	private int houseCount;
	private List<Hint> hints;
	private Solution solution;

	public Puzzle(int housesCount) {
		this.houseCount = housesCount;
		hints = new ArrayList<>();
		solution = new Solution(housesCount);
	}

	public List<Hint> getHints() {
		return hints;
	}

	public void setHints(List<Hint> hints) {
		this.hints = hints;
	}

	public int getHouseCount() {
		return houseCount;
	}

	public void setHouseCount(int houseCount) {
		this.houseCount = houseCount;
	}

	public Solution getSolution() {
		return solution;
	}

	public void setSolution(Solution solution) {
		this.solution = solution;
	}
	
	public void addHint(Hint hint) {
		getHints().add(hint);
	}

	@Override
	public String toString() {
		return "Puzzle [houseCount=" + houseCount + ", hints=" + hints + ", solution=" + solution + "]";
	}

}
