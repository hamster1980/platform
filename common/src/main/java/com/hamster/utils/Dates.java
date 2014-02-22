package com.hamster.utils;

import java.util.Date;

public class Dates {

	private Dates() {
	}
	
	public static Date get(Date value) {
		if(value == null) {
			return value;
		}
		return new Date(value.getTime());
	}
	
}
