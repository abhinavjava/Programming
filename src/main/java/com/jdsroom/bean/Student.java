package com.jdsroom.bean;

import java.util.Objects;

public class Student implements Comparable<Student>{

	private String name;
	
	private Integer rollNo;
	
	public Student() {
		super();
	}

	public Student(String name, Integer rollNo) {
		super();
		this.name = name;
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRollNo() {
		return rollNo;
	}

	public void setRollNo(Integer rollNo) {
		this.rollNo = rollNo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, rollNo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(name, other.name) && Objects.equals(rollNo, other.rollNo);
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", rollNo=" + rollNo + "]";
	}

	@Override
	public int compareTo(Student o) {

		if(this.equals(o))
		return 0;
		else if(this.getName().equals(o.getName()))
		return this.getRollNo().compareTo(o.getRollNo());
		else
		return this.getName().compareTo(o.getName());	
	}
	
	
}
