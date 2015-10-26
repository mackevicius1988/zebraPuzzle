package com.swed.puzzle.writer;

import com.swed.puzzle.writer.impl.XslOutputWriter;

/**
 * 
 * @author mmackevicius
 *
 */
public class OutputWriterFactory {

	private OutputWriterFactory() {
	}

	public static OutputWriter getWriter(String type) {
		if (type.equals("xsl"))
			return new XslOutputWriter();
		else
			throw new UnsupportedOperationException("Only XSL format is supported");

	}
}
