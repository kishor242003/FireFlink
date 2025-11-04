package com.ninza.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
		
		public int getRandomNo() {
			Random r=new Random();
			int randomNo=r.nextInt(3000);
			return randomNo;
			
		}
		
		public String getTodayDate() {
			
			Date d=new Date();
			SimpleDateFormat sim=new SimpleDateFormat("dd-MM-yyyy");
			String date = sim.format(d);
			return date;	
		}
		
		public String getFutureDate(int days) {
			
			Date d=new Date();
			SimpleDateFormat sim=new SimpleDateFormat("dd-MM-yyyy");
			sim.format(d);
			Calendar c=sim.getCalendar();
			c.add(Calendar.DAY_OF_MONTH, days);
			String updatedDate=sim.format(c.getTime());
			return updatedDate;	
			
		}

	}



