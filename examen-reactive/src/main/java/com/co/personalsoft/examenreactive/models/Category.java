package com.co.personalsoft.examenreactive.models;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
@Table("categorys")
public class Category implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4363850081853649629L;
	@Id
	private Long id;
	private String name;
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Category(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}


	public Category(String nombre) {
		this.name = nombre;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", nombre=" + name + "]";
	}
	

}
