package com.comcast.crm.generic.webdriverutility;

import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Random;

public class JavaUtility {
	public int getRandomNumber() {
		Random r=new Random();
		int ranDomnumber=r.nextInt(5000);
		return ranDomnumber;
	}
	public String getSystemDateYYYYMMDD() {
		Date d=new Date();
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		String date=sim.format(d);
		return date;
	}
	public String getRequiredDateYYYYMMDD(int days) {
		Date d=new Date();
		SimpleDateFormat sim=new SimpleDateFormat("YYYY-MM-dd");
		String date=sim.format(d);
		Calendar cal=sim.getCalendar();
		
		cal.add(Calendar.DAY_OF_MONTH, days);
		String reqDate=sim.format(cal.getTime());
		return reqDate;
	}
public JavaUtility() {
	// TODO Auto-generated constructor stub
}
}
