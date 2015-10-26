package com.swed.puzzle.builder;

import com.swed.puzzle.domain.Puzzle;

/**
 * 
 * @author mmackevicius
 *
 */
public interface PuzzleBuilder {
	
	/**
	 * Reads and creates the Puzzle object from the specified file
	 * 
	 * @param fileName
	 * @return
	 */
	Puzzle readAndBuild();
}
