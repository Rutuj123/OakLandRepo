package com.matlab.DTO;

import javax.persistence.Column;

public class PersonPrefixDto {
	String prefix;
	String gender;
	String prefixOf;
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPrefixOf() {
		return prefixOf;
	}
	public void setPrefixOf(String prefixOf) {
		this.prefixOf = prefixOf;
	}
	
}
