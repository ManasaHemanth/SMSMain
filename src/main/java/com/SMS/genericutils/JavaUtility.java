package com.SMS.genericutils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
/**
 * This method is used to get the random number
 * @return
 */
	public int getRandomNumber() {
		Random r=new Random();
		int randNum=r.nextInt(1000);
		return randNum;
	}
	public String getSystemDate() {
		Date date=new Date();
		return date.toString();
		
	}
	public String getSystemDateInFormat() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy hh-MM-ss");
		Date date=new Date();
		String SystemDateInFormat = sdf.format(date);
		return SystemDateInFormat;
		
	}
}
