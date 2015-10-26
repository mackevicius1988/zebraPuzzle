package com.swed.puzzle.writer;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.swed.puzzle.writer.impl.XslOutputWriter;

/**
 * 
 * @author mmackevicius
 *
 */
public class OutputWriterFactoryTest {

	@Test
	public void getWriterSuccessCase() {
		// Given
		String type = "xsl";

		// When
		OutputWriter builder = OutputWriterFactory.getWriter(type);

		// Then
		assertTrue(builder instanceof XslOutputWriter);
	}

	@Test(expected = UnsupportedOperationException.class)
	public void getWriterFailCase() {
		// Given
		String type = "html";

		// When throw UnsupportedOperationException exception
		OutputWriter builder = OutputWriterFactory.getWriter(type);
	}
}
