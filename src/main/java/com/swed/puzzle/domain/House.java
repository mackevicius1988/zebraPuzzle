package com.swed.puzzle.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author mmackevicius
 *
 */
public class House implements Cloneable {

	public House() {
	}

	public House(int position) {
		this.properties.put("position", String.valueOf(position));
	}

	private Map<String, String> properties = new HashMap<>();

	public Map<String, String> getProperties() {
		return properties;
	}

	public void setProperties(Map<String, String> properties) {
		this.properties = properties;
	}

	public void addPropery(Map.Entry<String, String> property) {
		getProperties().put(property.getKey(), property.getValue());
	}
	
	public String getProperty(String key) {
		return properties.get(key);
	}

	@Override
	public String toString() {
		return "House [properties=" + properties + "]";
	}

	@Override
	public House clone() {
		House house = new House();
		house.properties.putAll(this.properties);
		return house;
	}

}
