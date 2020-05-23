package com.LECFLY.LF.model.vo.virtual;

public class MemberStatVO {
	public static String MONTH_1 = "JAN";
	public static String MONTH_2 = "FEB";
	public static String MONTH_3 = "MAR";
	public static String MONTH_4 = "APR";
	public static String MONTH_5 = "MAY";
	public static String MONTH_6 = "JUN";
	public static String MONTH_7 = "JUL";
	public static String MONTH_8 = "AUG";
	public static String MONTH_9 = "SEP";
	public static String MONTH_10 = "OCT";
	public static String MONTH_11 = "NOV";
	public static String MONTH_12 = "DEC";
	
	private int month;
	private String monthName;
	private int msCount;
	
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public String getMonthName() {
		switch (this.month) {
		case 1:
			return MONTH_1;
		case 2:
			return MONTH_2;
		case 3:
			return MONTH_3;
		case 4:
			return MONTH_4;
		case 5:
			return MONTH_5;
		case 6:
			return MONTH_6;
		case 7:
			return MONTH_7;
		case 8:
			return MONTH_8;
		case 9:
			return MONTH_9;
		case 10:
			return MONTH_10;
		case 11:
			return MONTH_11;
		case 12:
			return MONTH_12;
		default: 
			break;
		}
		return monthName;
	}
	public void setMonthName(String monthName) {
		this.monthName = monthName;
	}
	public int getMsCount() {
		return msCount;
	}
	public void setMsCount(int msCount) {
		this.msCount = msCount;
	}
	
	public MemberStatVO() {}
	
	public MemberStatVO(int month, String monthName, int msCount) {
		super();
		this.month = month;
		this.monthName = monthName;
		this.msCount = msCount;
	}
	@Override
	public String toString() {
		return "MemberStatVO [month=" + month + ", monthName=" + monthName + ", msCount=" + msCount + "]";
	}
	
}
