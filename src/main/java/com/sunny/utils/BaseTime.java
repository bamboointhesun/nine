package com.sunny.utils;

import java.sql.Timestamp;
import java.util.Date;

public class BaseTime {

	
	protected static Timestamp time() {
		Date date = new Date();  
		Timestamp timeStamp = new Timestamp(date.getTime());
		return timeStamp;
	}
}
