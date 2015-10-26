package com.swed.puzzle.builder.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.Map.Entry;

import com.swed.puzzle.builder.PuzzleBuilder;
import com.swed.puzzle.domain.Hint;
import com.swed.puzzle.domain.Puzzle;

/**
 * Builds the Puzzle object from the specified .csv file
 * 
 * @author mmackevicius
 *
 */
public class CsvPuzzleBuilder implements PuzzleBuilder {

	private static final String DELIMITER = ";";
	private String fileName;

	public CsvPuzzleBuilder(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public Puzzle readAndBuild() {
		Puzzle puzzle = null;

		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			int housesCount = Integer.parseInt(br.readLine());
			puzzle = new Puzzle(housesCount);

			String line = null;
			while ((line = br.readLine()) != null) {
				String[] props = line.split(DELIMITER);

				puzzle.getHints().add(createHint(props));
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return puzzle;
	}

	private Hint createHint(String[] props) {
		Hint hint = new Hint(props[0]);

		for (int i = 1; i < props.length; i += 2) {
			Entry<String, String> property = new AbstractMap.SimpleEntry<>(props[i], props[i + 1]);
			hint.addProperty(property);
		}

		return hint;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
