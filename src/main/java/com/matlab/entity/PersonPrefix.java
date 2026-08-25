package com.matlab.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="person_prefix")
public class PersonPrefix {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	String prefix;
	String gender;
	@Column(name="prefix_of")
	String prefixOf;
	LocalDateTime createdDate;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
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
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	
}
