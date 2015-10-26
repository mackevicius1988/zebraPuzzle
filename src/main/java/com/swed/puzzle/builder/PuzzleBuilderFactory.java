package com.swed.puzzle.builder;

import com.swed.puzzle.builder.impl.CsvPuzzleBuilder;

/**
 * 
 * @author mmackevicius
 *
 */
public class PuzzleBuilderFactory {

	private PuzzleBuilderFactory() {
	}

	public static PuzzleBuilder getBuilder(String fileName) {
		if (fileName.endsWith(".csv"))
			return new CsvPuzzleBuilder(fileName);
		else
			throw new UnsupportedOperationException("Only csv format is supported");
	}

}
