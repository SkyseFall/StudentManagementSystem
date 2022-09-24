package com.iacsd.helperobjects;

import java.util.Comparator;

import com.iacsd.dto.Marksheet;

public class SortByPercentage implements Comparator<Marksheet> {

	@Override
	public int compare(Marksheet m1, Marksheet m2) {
		return  (int) (m2.getPercentage() - m1.getPercentage());
	}

}
