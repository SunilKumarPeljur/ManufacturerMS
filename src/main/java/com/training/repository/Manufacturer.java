/**
 * 
 */
package com.training.repository;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author admin
 *
 */

@Document
public class Manufacturer {
	
	public Manufacturer() {
		// TODO Auto-generated constructor stub
	}

	public Manufacturer(int id, String name, Date inceptionDate, Boolean isActive) {
		super();
		this.id = id;
		this.name = name;
		this.inceptionDate = inceptionDate;
		this.isActive = isActive;
	}


	@Id
	private int id;
	
	private String name;	
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date inceptionDate;
	
	private Boolean isActive;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getInceptionDate() {
		return inceptionDate;
	}

	public void setInceptionDate(Date inceptionDate) {
		this.inceptionDate = inceptionDate;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "Manufacturer [id=" + id + ", name=" + name + ", inceptionDate=" + inceptionDate + ", isActive="
				+ isActive + "]";
	}
	
}
