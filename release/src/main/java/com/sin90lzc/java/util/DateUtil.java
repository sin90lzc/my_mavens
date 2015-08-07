/**
 * 
 */
package com.sin90lzc.java.util;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author liangzhicong
 * 
 * create at 2015年8月7日 下午2:24:19
 */
public class DateUtil {

	/**
	 * 
	 * 
	 * @category 两个日期之间相差的天数,endDate-startDate
	 * @param startDate
	 * @param endDate
	 * @return
	 *
	 * @author liangzhicong
	 */
	public static int getIntervalDays(Date startDate,Date endDate){
		Calendar s1=Calendar.getInstance();
		Calendar s2=Calendar.getInstance();
		s1.setTime(startDate);
		s2.setTime(endDate);
		s1.set(Calendar.HOUR_OF_DAY, 0);
		s1.set(Calendar.MINUTE, 0);
		s1.set(Calendar.SECOND, 0);
		s1.set(Calendar.MILLISECOND, 0);
		s2.set(Calendar.HOUR_OF_DAY, 0);
		s2.set(Calendar.MINUTE, 0);
		s2.set(Calendar.SECOND, 0);
		s2.set(Calendar.MILLISECOND, 0);
		int days=(int)(s2.getTimeInMillis()-s1.getTimeInMillis())/(3600*24*1000);
		return days;
	}
	
}
