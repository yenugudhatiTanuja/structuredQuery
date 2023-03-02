package com.aegisisc.pvt.test;

public class Student {
	public int s_RollNo;
	public String s_Name;
	public String s_ContactNo;
	public String s_EmailId;
    public String s_Standard;
    
    
	public String getS_Standard() {
		return s_Standard;
	}

	public void setS_Standard(String s_Standard) {
		this.s_Standard = s_Standard;
	}

	public int getS_RollNo() {
		return s_RollNo;
	}

	public void setS_RollNo(int s_RollNo) {
		this.s_RollNo = s_RollNo;
	}

	public String getS_Name() {
		return s_Name;
	}

	public void setS_Name(String s_Name) {
		this.s_Name = s_Name;
	}

	public String getS_ContactNo() {
		return s_ContactNo;
	}

	public void setS_ContactNo(String s_ContactNo) {
		this.s_ContactNo = s_ContactNo;
	}

	public String getS_EmailId() {
		return s_EmailId;
	}

	public void setS_EmailId(String s_EmailId) {
		this.s_EmailId = s_EmailId;
	}

	
	public Student(int s_RollNo, String s_Name, String s_ContactNo, String s_EmailId, String s_Standard) {
		super();
		this.s_RollNo = s_RollNo;
		this.s_Name = s_Name;
		this.s_ContactNo = s_ContactNo;
		this.s_EmailId = s_EmailId;
		this.s_Standard = s_Standard;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

}
