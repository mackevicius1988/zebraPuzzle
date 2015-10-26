package com.swed.puzzle.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author mmackevicius
 *
 */
public class Solution implements Cloneable {
	private List<House> houses;

	public Solution(int housesCount) {
		houses = new ArrayList<>(housesCount);
	}

	public List<House> getHouses() {
		return houses;
	}

	public void setHouses(List<House> houses) {
		this.houses = houses;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Solution [house=");
		for (House house : houses) {
			sb.append(house).append("\n");
		}
		return sb.toString();
	}

	public House getHouse(int houseIndex) {
		return getHouses().get(houseIndex);
	}

	public void add(House house) {
		getHouses().add(house);

	}

	public int housesCount() {
		return getHouses().size();
	}

	@Override
	public Solution clone() {
		Solution result = new Solution(this.getHouses().size());

		for (int i = 0; i < this.housesCount(); i++) {
			result.add(this.getHouse(i).clone());
		}
		return result;
	}
	
}
