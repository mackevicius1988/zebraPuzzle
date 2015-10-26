package com.swed.puzzle.builder;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.swed.puzzle.builder.impl.CsvPuzzleBuilder;

/**
 * 
 * @author mmackevicius
 *
 */
public class PuzzleBuilderFactoryTest {

	@Test
	public void getBuiderSuccessCase() {
		// Given 
		String fileName = "test.csv";
		
		// When
		PuzzleBuilder builder = PuzzleBuilderFactory.getBuilder(fileName);
		
		// Then
		assertTrue(builder instanceof CsvPuzzleBuilder);
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void getBuiderFailCase() {
		// Given 
		String fileName = "test.xml";
		
		// When throw UnsupportedOperationException exception
		PuzzleBuilder builder = PuzzleBuilderFactory.getBuilder(fileName);
	}

}
