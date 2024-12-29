package com.ashokit.dto;

import java.util.Objects;

public class ResultDTO {
	
	Integer seatno;
	String name;
	String surname;
	Integer dob;
	String grade;
	Integer points;
	
	public Integer getSeatno() {
		return seatno;
	}
	public void setSeatno(Integer seatno) {
		this.seatno = seatno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public Integer getDob() {
		return dob;
	}
	public void setDob(Integer dob) {
		this.dob = dob;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public Integer getPoints() {
		return points;
	}
	public void setPoints(Integer points) {
		this.points = points;
	}
	
	@Override
	public String toString() {
		return "ResultDTO [seatno=" + seatno + ", name=" + name + ", surname=" + surname + ", dob=" + dob + ", grade="
				+ grade + ", points=" + points + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(seatno);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResultDTO other = (ResultDTO) obj;
		return Objects.equals(seatno, other.seatno);
	}
	
}
