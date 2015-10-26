package com.swed.puzzle.main;

import java.util.List;

import com.swed.puzzle.builder.PuzzleBuilder;
import com.swed.puzzle.builder.PuzzleBuilderFactory;
import com.swed.puzzle.domain.Puzzle;
import com.swed.puzzle.domain.Solution;
import com.swed.puzzle.writer.OutputWriter;
import com.swed.puzzle.writer.OutputWriterFactory;


/**
 * 
 * @author mmackevicius
 *
 */
public class ZebraPuzzle {
	
	public static void main(String[] args) {
		// read input file and create domain puzzle object
		PuzzleBuilder builder = PuzzleBuilderFactory.getBuilder(args[0]);
		Puzzle puzzle = builder.readAndBuild();
		
		// Solve the puzzle for the given domain object
		PuzzleSolver solver = new PuzzleSolver();
		List<Solution> solutions = solver.solvePuzzle(puzzle);
		
		// Print results
		OutputWriter writer = OutputWriterFactory.getWriter("xsl");
		writer.write(solutions);
	}
}
