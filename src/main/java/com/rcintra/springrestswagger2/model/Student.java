package com.rcintra.springrestswagger2.model;

import io.swagger.annotations.ApiModelProperty;

public class Student {

	@ApiModelProperty(notes = "Name of the Student",name="name",required=true,value="test name")
	private String name;
	
	@ApiModelProperty(notes = "Class of the Student",name="cls",required=true,value="test class")
	private String cls;
	
    @ApiModelProperty(notes = "Country of the Student",name="country",required=true,value="test country")
	private String country;
    
    public Student(String name) {
		super();
		this.name = name;
	}

	public Student(String name, String cls, String country) {
		super();
		this.name = name;
		this.cls = cls;
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCls() {
		return cls;
	}

	public void setCls(String cls) {
		this.cls = cls;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", cls=" + cls + ", country=" + country + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
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
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
