package com.acs560.Sport_analyzer.services.impl;

import java.util.HashSet;
import java.util.Set;

public class YearRangeUtil {

	public static Set<Integer> getRange(int year, int range) {
		
		if (year < 2018 || year > 2021) {
			throw new IllegalArgumentException("Year must be between 2018 and 2021");
		} else if (range < 0 || range > 3) {
			throw new IllegalArgumentException("Range must be between 0 and 3");
		}
		
		int lowerRange = year - range;
		int upperRange = year + range;
		
		Set<Integer> years = new HashSet<>();
		
		for (int i = lowerRange; i <= upperRange; i++) {
			if (i >= 2018 && i <= 2021) {
				years.add(i);
			}
		}
		
		return years;
	}
}