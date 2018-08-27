package org.kjtc.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 日期工具类
 * 
 * @author MaChao
 * 
 */
public class DateUtil {


	public static String getBirStrByBirthDay(Date birth, int status){
		//Calendar birthday = new GregorianCalendar(y, m, d);//2010年10月12日，month从0开始
		GregorianCalendar birthday =initCalendar(birth);
	    Calendar now = Calendar.getInstance();
	    int day = now.get(Calendar.DAY_OF_MONTH) - birthday.get(Calendar.DAY_OF_MONTH);
	    int month = now.get(Calendar.MONTH) - birthday.get(Calendar.MONTH);
	    int year = now.get(Calendar.YEAR) - birthday.get(Calendar.YEAR);
	    //按照减法原理，先day相减，不够向month借；然后month相减，不够向year借；最后year相减。
	    if(day<0){
	    	month -= 1;
	    	now.add(Calendar.MONTH, -1);//得到上一个月，用来得到上个月的天数。
	    	day = day + now.getActualMaximum(Calendar.DAY_OF_MONTH);
	    }
	    if(month<0){
	    	month = (month+12)%12;
	    	year--;
	    }
	    String str = "";
	    if(status == 1){
	    	str = year+"岁"+month+"个月"+day+"天";
	    }else{
	    	if(month == 0){
	    		str = year+"岁";
	    	}else{
	    		str = year+"岁"+month+"个月";
	    	}
	    }
	    return str;
	}
	private static GregorianCalendar initCalendar(Date date) {
		if (date == null) {
			throw new IllegalArgumentException("argument date must be not null");
		}
		GregorianCalendar gc = new GregorianCalendar(Locale.CHINA);
		gc.setLenient(true);
		gc.setFirstDayOfWeek(Calendar.MONDAY);
		gc.clear();
		gc.setTime(date);
		return gc;
	}

	/**
	 * 返回传入日期的后一天
	 * 
	 * @param date
	 *            date
	 * @return Date
	 * @author MaChao
	 */
	public static Date getNextDay(Date date) {
		GregorianCalendar gc=initCalendar(date);
		long tomorrow = gc.getTimeInMillis() + 1 * 60 * 60 * 24 * 1000;
		gc.setTimeInMillis(tomorrow);
		return gc.getTime();
	}

	/**
	 * 返回传入日期的前一天
	 * 
	 * @param date
	 *            date
	 * @return Date
	 * @author MaChao
	 */
	public static Date getLastDay(Date date) {
		GregorianCalendar gc=initCalendar(date);
		long yestarday = gc.getTimeInMillis() - 1 * 60 * 60 * 24 * 1000;
		gc.setTimeInMillis(yestarday);
		return gc.getTime();
	}

	/**
	 * 获得日期所在月的最后一天
	 * 
	 * @param dateStr
	 *            dateStr(yyyy-MM-dd)
	 * @return String(yyyy-MM-dd)
	 * @throws ParseException
	 * @author MaChao
	 */
	public static String getLastMonthDay(String dateStr) throws ParseException {
		Date date = praseString2Date(dateStr);
		Date lastMonthDay = getLastMonthDay(date);
		return formatDate2ShortString(lastMonthDay);
	}

	/**
	 * 将Date格式化为短型String
	 * 
	 * @param Date
	 *            date
	 * @return String(yyyy-MM-dd)
	 * @author MaChao
	 */
	public static String formatDate2ShortString(Date date) {
		initCalendar(date);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = sdf.format(date);
		return dateStr;
	}
	/**
	 * 将Date格式化为短型String
	 * 
	 * @param Date
	 *            date
	 * @return String(yyyy/MM/dd)
	 * @author MaChao
	 */
	public static String formatDate2ShortString2(Date date) {
		initCalendar(date);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String dateStr = sdf.format(date);
		return dateStr;
	}

	/**
	 * 将短日期格式的String转化为Date类型
	 * 
	 * @param String
	 *            dateStr(yyyy-MM-dd)
	 * @return Date
	 * @throws ParseException
	 * @author MaChao
	 */
	public static Date praseString2Date(String dateStr) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = (Date) sdf.parse(dateStr);
		return date;
	}
	public static String formatDate2ShortStringNoStr(Date date) {
		initCalendar(date);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String dateStr = sdf.format(date);
		return dateStr;
	}
	
	public static String formatDate3ShortStringNoStr(Date date) {
		initCalendar(date);
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		String dateStr = sdf.format(date);
		return dateStr;
	}

	/**
	 * 将Date格式化为长型String
	 * @param date
	 * @return
	 * @author baiys
	 */
	public static String formatDate2LongString(Date date) {
		initCalendar(date);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = sdf.format(date);
		return dateStr;
	}
	public static String formatDateLongString(Date date) {
		initCalendar(date);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		String dateStr = sdf.format(date);
		return dateStr;
	}
	public static String formatDate2LongStringNoStr(Date date) {
		initCalendar(date);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String dateStr = sdf.format(date);
		return dateStr;
	}
	public static String formatDate2Long(Date date) {
		initCalendar(date);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String dateStr = sdf.format(date);
		return dateStr;
	}
	
	public static String formatDate2HourAndMin(Date date) {
		GregorianCalendar gc=initCalendar(date);
		gc.add(Calendar.HOUR_OF_DAY, 1);
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		String dateStr = sdf.format(gc.getTime());
		return dateStr;
	}
	public static String formatDateHourAndMin(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		String dateStr = sdf.format(date.getTime());
		return dateStr;
	}

	/**
	 * 将长日期格式的String转化为Date类型
	 * 
	 * @param String
	 *            dateStr(yyyy-MM-dd HH:mm:ss)
	 * @return Date
	 * @throws ParseException
	 * @author MaChao
	 */
	public static Date praseString2LongDate(String dateStr)
			throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = (Date) sdf.parse(dateStr);
		return date;
	}
	public static Date praseString2LongDate(String dateStr, Integer number)
	throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:00");
		Date date = (Date) sdf.parse(dateStr);
		GregorianCalendar gc=initCalendar(date);
		number -=1;
		number =  number * 7;
		gc.add(Calendar.DAY_OF_YEAR, number);
		return gc.getTime();
}
	/**
	 * 取得日期所在周的第一天
	 * 
	 * @param Date
	 *            date
	 * @return Date
	 */
	public static Date getFirstWeekDay(Date date) {
		GregorianCalendar gc=initCalendar(date);
		gc.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		return gc.getTime();
	}

	/**
	 * 取得日期所在周的最后一天
	 * 
	 * @param Date
	 *            date
	 * @return Date
	 */
	public static Date getLastWeekDay(Date date) {
		GregorianCalendar gc=initCalendar(date);
		gc.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		return gc.getTime();
	}

	/**
	 * 取得日期所在月的第一天
	 * 
	 * @param Date
	 *            date
	 * @return Date
	 */
	public static Date getFirstMonthDay(Date date) {
		GregorianCalendar gc=initCalendar(date);
		int dayOfMonth = gc.get(Calendar.DAY_OF_MONTH);
		gc.add(Calendar.DAY_OF_MONTH, 1 - dayOfMonth);
		return gc.getTime();
	}

	/**
	 * 取得日期所在月的最后一天
	 * 
	 * @param Date
	 *            date
	 * @return Date
	 */
	public static Date getLastMonthDay(Date date) {
		GregorianCalendar gc=initCalendar(date);
		int dayOfMonth = gc.get(Calendar.DAY_OF_MONTH);
		int maxDaysOfMonth = gc.getActualMaximum(Calendar.DAY_OF_MONTH);
		gc.add(Calendar.DAY_OF_MONTH, maxDaysOfMonth - dayOfMonth);
		return gc.getTime();
	}

	/**
	 * 取得日期所在旬的最后一天
	 * 
	 * @param Date
	 *            date
	 * @return Date
	 */
	public static Date getFirstTenDaysDay(Date date) {
		GregorianCalendar gc=initCalendar(date);
		int dayOfMonth = gc.get(Calendar.DAY_OF_MONTH);
		if (dayOfMonth <= 10) {
			gc.set(Calendar.DAY_OF_MONTH, 1);
		} else if (dayOfMonth > 20) {
			gc.set(Calendar.DAY_OF_MONTH, 21);
		} else {
			gc.set(Calendar.DAY_OF_MONTH, 11);
		}
		return gc.getTime();
	}

	/**
	 * 取得日期所在旬的最后一天
	 * 
	 * @param Date
	 *            date
	 * @return Date
	 */
	public static Date getLastTenDaysDay(Date date) {
		GregorianCalendar gc=initCalendar(date);
		int dayOfMonth = gc.get(Calendar.DAY_OF_MONTH);
		if (dayOfMonth <= 10) {
			gc.set(Calendar.DAY_OF_MONTH, 10);
		} else if (dayOfMonth > 20) {
			gc.set(Calendar.DAY_OF_MONTH, gc
					.getActualMaximum(Calendar.DAY_OF_MONTH));
		} else {
			gc.set(Calendar.DAY_OF_MONTH, 19);
		}
		return gc.getTime();
	}

	public static String getStringByTimestamp(Timestamp t){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//定义格式，不显示毫秒
		String str = df.format(t);
		return str;
	}

	
	
	 
	
	
	public static int getDay(Date date ) throws Exception {
		  Calendar cal = Calendar.getInstance();
		  cal.setTime(date);
		  int num = 0 ;
		  switch (cal.get(Calendar.DAY_OF_WEEK)) {
			case 1:
				num =7;
				break;
			case 2:
				num =1;
				break;
			case 3:
				num =2;
				break;
			case 4:
				num =3;
				break;
			case 5:
				num =4;
				break;
			case 6:
				num =5;
				break;
			case 7:
				num =6;
				break;
			default:
				break;
			}
		  return num;
	}
	public static int getNowHour(){
		 Calendar now= Calendar.getInstance();
		return now.get(Calendar.HOUR_OF_DAY);
	}
	public static int getHour(Date date){
		GregorianCalendar gc=initCalendar(date);
		return gc.get(Calendar.HOUR_OF_DAY);
	}
	public static Date toCurrentDate (String day, String time, String second) throws ParseException {
		 Calendar now= Calendar.getInstance();
		 if(day.equals("明天")){
		     now.set(Calendar.DATE,now.get(Calendar.DATE)+1);
		 }else if(day.equals("后天")){
			 now.set(Calendar.DATE,now.get(Calendar.DATE)+2);
		 }else if(day.equals("大后天")){
			 now.set(Calendar.DATE,now.get(Calendar.DATE)+3);
		 }else{
			 now.set(Calendar.DATE,now.get(Calendar.DATE)+4);
		 }
		 int year = now.get(Calendar.YEAR);
		 int month = now.get(Calendar.MONTH)+ 1;
		 int date = now.get(Calendar.DATE);
		 String day_time = year+"-"+month+"-"+date+" "+time+":"+second+":00";
		 return praseString2LongDate(day_time);
		 
	}
	
	public static Date toCurrentDate2 (Integer day, Integer hour) throws ParseException {
		 Calendar now= Calendar.getInstance();
		 switch (day) {
		case 1:
			 now.set(Calendar.DATE,now.get(Calendar.DATE));
			break;
		case 2:
			 now.set(Calendar.DATE,now.get(Calendar.DATE)+1);
			break;
		case 3:
			 now.set(Calendar.DATE,now.get(Calendar.DATE)+2);
			break;
		case 4:
			 now.set(Calendar.DATE,now.get(Calendar.DATE)+3);
			break;

		default:
			break;
		}
		 int year = now.get(Calendar.YEAR);
		 int month = now.get(Calendar.MONTH)+ 1;
		 int date = now.get(Calendar.DATE);
		 String day_time = year+"-"+month+"-"+date+" "+hour+":00:00";
		 return praseString2LongDate(day_time);
		 
	}
	
	public static String toCurrentDate (Integer day) throws ParseException {
		 Calendar now= Calendar.getInstance();
		 switch (day) {
		case 1:
			 now.set(Calendar.DATE,now.get(Calendar.DATE));
			break;
		case 2:
			 now.set(Calendar.DATE,now.get(Calendar.DATE)+1);
			break;
		case 3:
			 now.set(Calendar.DATE,now.get(Calendar.DATE)+2);
			break;
		case 4:
			 now.set(Calendar.DATE,now.get(Calendar.DATE)+3);
			break;
		case 5:
			 now.set(Calendar.DATE,now.get(Calendar.DATE)+4);
			break;
		case 6:
			 now.set(Calendar.DATE,now.get(Calendar.DATE)+5);
			break;
		case 7:
			 now.set(Calendar.DATE,now.get(Calendar.DATE)+6);
			break;
		default:
			break;
		}
		 int year = now.get(Calendar.YEAR);
		 int month = now.get(Calendar.MONTH)+ 1;
		 int date = now.get(Calendar.DATE);
		 String day_time = year+"-"+month+"-"+date;
		 return day_time;
		 
	}
	

   

   


   public static Date[] getCurrentWeekdays() {
		Date dateArr[] = new Date[7];
		Calendar calendar = Calendar.getInstance();
		while (calendar.get(Calendar.DAY_OF_WEEK) != 1) {
			calendar.add(Calendar.DATE, -1);
		}			
		for (int i = 0; i < 7; i++) {	
			calendar.add(Calendar.DATE, 1);
			dateArr[i] = calendar.getTime();
		}
		return dateArr;
	}	
   public static Date getDayByWeek(int week) {
		Calendar calendar = Calendar.getInstance();
		while (calendar.get(Calendar.DAY_OF_WEEK) != 1) {
			calendar.add(Calendar.DATE, -1);
		}	
		Date date = null;
		for (int i = 0; i < 7; i++) {	
			calendar.add(Calendar.DATE, 1);
			if(i+1 == week){
				date = calendar.getTime();
			}
		}
		return date;
	}
   /**
    * 获取当前时间之后的几天时间
    * @param count
    * @return
    */
    public static Date getDateByAfter(int count) {
 		Calendar calendar = Calendar.getInstance();
 		calendar.add(Calendar.DATE, count);
 		Date date = calendar.getTime();
 		return date;
 	}	
	public static void main(String[] args) throws Throwable {
        System.out.println(dayTomin(""));

	}
	

	 public static String getWeek(Date date){
	        String[] weeks = {"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
	        Calendar cal = Calendar.getInstance();
	        cal.setTime(date);  
	        int week_index = cal.get(Calendar.DAY_OF_WEEK) - 1;
	        if(week_index<0){  
	            week_index = 0;  
	        }   
	        return weeks[week_index];  
	 } 
	 public static List<Map<String, Object>> getOrderCalendar() {
		   List<Map<String, Object>> mapList = new ArrayList<Map<String,Object>>();
	       Calendar calendar = Calendar.getInstance();
	       for(int i = 0; i < 7; i++){
	    	   Map<String, Object> calendarMap = new HashMap<String, Object>();
	    	   if(i == 0){
	    		   calendar.add(Calendar.DATE,0);
	    	   }else{
	    		   calendar.add(Calendar.DATE, 1);
	    	   }
		       Date today = calendar.getTime();
		       String date = formatDate2ShortString(today);
		       calendarMap.put("date", date);
		       calendarMap.put("status", 0);
		       calendarMap.put("count", 0);
		       mapList.add(calendarMap);
	       }
	       return mapList;  
	   }

	/*
* 将时间戳转换为时间
*/
	public static String stampToDate(String s){
		String res;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long lt = new Long(s);
		Date date = new Date(lt);
		res = simpleDateFormat.format(date);
		return res;
	}

	public static String secToTime(int time) {
		String timeStr = null;
		int hour = 0;
		int minute = 0;
		int second = 0;
		if (time <= 0)
			return "00:00";
		else {
			minute = time / 60;
			if (minute < 60) {
				second = time % 60;
				timeStr = unitFormat(minute) + ":" + unitFormat(second);
			} else {
				hour = minute / 60;
				if (hour > 99)
					return "99:59:59";
				minute = minute % 60;
				second = time - hour * 3600 - minute * 60;
				timeStr = unitFormat(hour) + "小时" + unitFormat(minute) + "分" + unitFormat(second)+"秒";
			}
		}
		return timeStr;
	}

	public static String unitFormat(int i) {
		String retStr = null;
		if (i >= 0 && i < 10)
			retStr = "0" + Integer.toString(i);
		else
			retStr = "" + i;
		return retStr;
	}

	/***
	 *
	 * @param date
	 * @param dateFormat : e.g:yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String formatDateByPattern(Date date,String dateFormat){
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		String formatTimeStr = null;
		if (date != null) {
			formatTimeStr = sdf.format(date);
		}
		return formatTimeStr;
	}
	/***
	 * convert Date to cron ,eg.  "0 07 10 15 1 ? 2016"
	 * @param date  : 时间点
	 * @return
	 */
	public static String getCron(Date  date){
		String dateFormat="ss mm HH dd MM ? yyyy";
		return formatDateByPattern(date, dateFormat);
	}


	/**
	 * Description:格式化日期,String字符串转化为Date
	 *
	 * @param date
	 * @param dtFormat
	 *            例如:yyyy-MM-dd HH:mm:ss yyyyMMdd
	 * @return
	 */
	public static String fmtDateToStr(Date date, String dtFormat) {
		if (date == null)
			return "";
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat(dtFormat);
			return dateFormat.format(date);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}


	public static String getDuration(int durationSeconds){
		int hours = durationSeconds /(60*60);
		int leftSeconds = durationSeconds % (60*60);
		int minutes = leftSeconds / 60;
		int seconds = leftSeconds % 60;

		StringBuffer sBuffer = new StringBuffer();
		sBuffer.append(addZeroPrefix(hours));
		sBuffer.append(":");
		sBuffer.append(addZeroPrefix(minutes));
		sBuffer.append(":");
		sBuffer.append(addZeroPrefix(seconds));

		return sBuffer.toString();
	}

	public static String addZeroPrefix(int number){
		if(number < 10){
			return "0"+number;
		}else{
			return ""+number;
		}

	}

	/**
	 * 日期转时间戳
	 * @param date
	 * @return
	 */
	public static Integer transForMilliSecond(Date date){
		if(date==null) return null;
		return (int)(date.getTime()/1000);
	}

	/**
	 * 获取当前时间戳
	 * @return
	 */
	public static Integer currentTimeStamp(){
		return (int)(System.currentTimeMillis()/1000);
	}


	/**
	 * 返回传入日期的后一天时间戳
	 *
	 * @param date
	 *            date
	 * @return Date
	 * @author MaChao
	 */
	public static Long getNextDayLong(Date date) {
		GregorianCalendar gc=initCalendar(date);
		long tomorrow = gc.getTimeInMillis() + 1 * 60 * 60 * 24 * 1000;
		return tomorrow;
	}

	/**
	 * 将天装换为秒
	 *
	 * @param day 天
	 */
	public static Long  getformatDateTime(long day) {
		return  day * 60 * 60 * 24 ;
	}

	/**
	 * 返回传入日期的后一天某天时间戳
	 *
	 * @param date
	 *            date
	 * @return Date
	 * @author MaChao
	 */
	public static Long getDayLongTtime(Date date,long day) {
		GregorianCalendar gc=initCalendar(date);

		long time = gc.getTimeInMillis() + day * 60 * 60 * 24 * 1000;
		return time;
	}


	public static String date2Str(Date date,String format){
		if(date!=null){
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.format(date);
		}else{
			return "";
		}
	}
	public static String dayTomin(String day){
		if(day!=null && day !=""){

			return Integer.parseInt(day)*60*60*24+"";
		}else{
			return "0";
		}
	}


}
