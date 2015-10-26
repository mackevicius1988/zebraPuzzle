package com.swed.puzzle.main;

import static org.junit.Assert.assertTrue;

import java.util.AbstractMap.SimpleEntry;
import java.util.List;

import org.junit.Test;

import com.swed.puzzle.domain.Hint;
import com.swed.puzzle.domain.Puzzle;
import com.swed.puzzle.domain.Solution;
/**
 * 
 * @author mmackevicius
 *
 */
public class PuzzleSolverTest {

	private PuzzleSolver solver = new PuzzleSolver();

	@Test
	public void testFullSuccessCase() {
		// Given puzzle with extra hint
		Puzzle puzzle = PuzzleBuilder.buildFullPuzzle();

		// When solve the puzzle
		List<Solution> solutions = solver.solvePuzzle(puzzle);
		
		// Then only one solution
		assertTrue(solutions.size() == 1);
		assertTrue("Zebra".equals(solutions.get(0).getHouse(4).getProperty("pet")));
		assertTrue("Water".equals(solutions.get(0).getHouse(0).getProperty("drink")));
	}
	
	@Test
	public void testWithExtraNoSolutionsCase() {
		// Given puzzle with extra hint
		Puzzle puzzle = PuzzleBuilder.buildFullWithExtraHintPuzzle(new Hint("SAME", new SimpleEntry<>("pet", "Cobra")));

		// When solve the puzzle
		List<Solution> solutions = solver.solvePuzzle(puzzle);
		
		// Then no solutions 
		assertTrue(solutions.size() == 0);
	}	
	
}
