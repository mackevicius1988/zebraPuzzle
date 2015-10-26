package com.swed.puzzle.main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.swed.puzzle.domain.Hint;
import com.swed.puzzle.domain.House;
import com.swed.puzzle.domain.Puzzle;
import com.swed.puzzle.domain.Solution;

/**
 * 
 * @author mmackevicius
 *
 */
public class PuzzleSolver {

	/**
	 * Solves the puzzle in well known brutforce algorithm
	 * 
	 * @param puzzle
	 * @return
	 */
	public List<Solution> solvePuzzle(Puzzle puzzle) {
		List<Solution> solutions = new ArrayList<>();
		Solution initialSolution = new Solution(puzzle.getHouseCount());

		for (int i = 0; i < puzzle.getHouseCount(); i++) {
			initialSolution.getHouses().add(new House(i + 1));
		}
		solutions.add(initialSolution);

		for (Hint hint : puzzle.getHints()) {
			List<Solution> newSolutions = new ArrayList<>();

			for (Solution solution : solutions) {
				for (int i = 0; i < solution.getHouses().size(); i++) {
					newSolutions.addAll((applyHint(hint, solution, i)));
				}
			}
			solutions = newSolutions;
		}

		return solutions;

	}
	
	/**
	 * Applies the hint to the current solution 
	 * 
	 * @param hint
	 * @param solution
	 * @param houseIndex
	 * @return
	 */
	private Collection<? extends Solution> applyHint(Hint hint, Solution solution, int houseIndex) {

		List<Solution> ret = new ArrayList<>();
		Solution newSolution;

		switch (hint.getType()) {
		case SAME:
			newSolution = solution.clone();
			if (addProperty(newSolution.getHouse(houseIndex), hint.getLeftProperty())
					&& (hint.getRightProperty() == null
							|| addProperty(newSolution.getHouse(houseIndex), hint.getRightProperty()))) {

				ret.add(newSolution);
			}
			break;
		case NEXT_TO:
			if (houseIndex < solution.housesCount() - 1) {
				newSolution = solution.clone();
				if (addProperty(newSolution.getHouse(houseIndex + 1), hint.getLeftProperty())
						&& addProperty(newSolution.getHouse(houseIndex), hint.getRightProperty())) {
					ret.add(newSolution);
				}
			}
			// fall through to left house processing
		case TO_THE_LEFT_OF:
			if (houseIndex > 0) {
				newSolution = solution.clone();

				if (addProperty(newSolution.getHouse(houseIndex - 1), hint.getLeftProperty())
						&& addProperty(newSolution.getHouse(houseIndex), hint.getRightProperty())) {
					ret.add(newSolution);
				}
			}
			break;
		}

		return ret;
	}
	
	/**
	 * 
	 * @param house
	 * @param property
	 * @return
	 */
	protected boolean addProperty(House house, Map.Entry<String, String> property) {
		String value = house.getProperties().get(property.getKey());
		if (value == null) {
			house.getProperties().put(property.getKey(), property.getValue());
			return true;
		} else {
			if (value.equals(property.getValue())) {
				return true;
			}
		}
		return false;
	}

}
