package com.swed.puzzle.writer;

import java.util.List;

import com.swed.puzzle.domain.Solution;

/**
 * 
 * @author mmackevicius
 *
 */
public interface OutputWriter {
	void write(List<Solution> solutions);
}
