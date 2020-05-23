package com.LECFLY.LF.model.vo.virtual;

public class CategoryLectureStatVO {
	public static String CATEGORY_NAME_0 = "전체";
	public static String CATEGORY_NAME_1 = "미술";
	public static String CATEGORY_NAME_2 = "음악";
	public static String CATEGORY_NAME_3 = "요리";
	public static String CATEGORY_NAME_4 = "라이프스타일";
	public static String CATEGORY_NAME_5 = "운동";
	public static String CATEGORY_NAME_6 = "커리어";
	public static String CATEGORY_NAME_7 = "여행";
	
	private int category;
	private String name;
	private int lectureCnt;
	
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public String getName() {
		switch (this.category) {
		case 0:
			return CATEGORY_NAME_0;
		case 1:
			return CATEGORY_NAME_1;
		case 2:
			return CATEGORY_NAME_2;
		case 3:
			return CATEGORY_NAME_3;
		case 4:
			return CATEGORY_NAME_4;
		case 5:
			return CATEGORY_NAME_5;
		case 6:
			return CATEGORY_NAME_6;
		case 7:
			return CATEGORY_NAME_7;	
		default:
			break;
		}
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLectureCnt() {
		return lectureCnt;
	}
	public void setLectureCnt(int lectureCnt) {
		this.lectureCnt = lectureCnt;
	}
	
	public CategoryLectureStatVO() {
	}
	public CategoryLectureStatVO(int category, String name, int lectureCnt) {
		super();
		this.category = category;
		this.name = name;
		this.lectureCnt = lectureCnt;
	}
	@Override
	public String toString() {
		return "CategoryLectureStatVO [category=" + category + ", name=" + name + ", lectureCnt=" + lectureCnt + "]";
	}
	
	
}
