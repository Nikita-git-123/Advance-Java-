package com.prac.dao;

public class Student {
	
		String studName;
		Integer studPRN;
		String studCourse;
		
		public String getStudName() {
			return studName;
		}
		public void setStudName(String studName) {
			this.studName = studName;
		}
		public Integer getStudPRN() {
			return studPRN;
		}
		public void setStudPRN(Integer studPRN) {
			this.studPRN = studPRN;
		}
		public String getStudCourse() {
			return studCourse;
		}
		public void setStudCourse(String studCourse) {
			this.studCourse = studCourse;
		}
		
		@Override
		public String toString() {
			return "Student [studName=" + studName + ", studPRN=" + studPRN + ", studCourse=" + studCourse + "]";
		}
		
		
}
