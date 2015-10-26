package com.swed.puzzle.domain;

import java.util.Map.Entry;

/**
 * 
 * @author mmackevicius
 *
 */
public class Hint {

	private AssosiationType assosiationType;
	private Entry<String, String> leftProperty;
	private Entry<String, String> rightProperty;

	public Hint(String assosiationType) {
		this.assosiationType = AssosiationType.valueOf(assosiationType);
	}

	public Hint(String assosiationType, Entry<String, String> prop1, Entry<String, String> prop2) {
		this(assosiationType);
		leftProperty = prop1;
		rightProperty = prop2;
	}

	public Hint(String assosiationType, Entry<String, String> simpleEntry) {
		this(assosiationType, simpleEntry, null);
	}

	public AssosiationType getAssosiationType() {
		return assosiationType;
	}

	public void setAssosiationType(AssosiationType assosiationType) {
		this.assosiationType = assosiationType;
	}

	public Entry<String, String> getLeftProperty() {
		return leftProperty;
	}

	public void setLeftProperty(Entry<String, String> leftProperty) {
		this.leftProperty = leftProperty;
	}

	public Entry<String, String> getRightProperty() {
		return rightProperty;
	}

	public void setRightProperty(Entry<String, String> rightProperty) {
		this.rightProperty = rightProperty;
	}

	public enum AssosiationType {
		SAME, NEXT_TO, TO_THE_LEFT_OF;
	}

	public void addProperty(Entry<String, String> property) {
		if (leftProperty == null)
			leftProperty = property;
		else if (rightProperty == null)
			rightProperty = property;
	}

	@Override
	public String toString() {
		return "Hint [type=" + assosiationType + ", leftProperty=" + leftProperty + ", rightProperty=" + rightProperty + "]";
	}

}
