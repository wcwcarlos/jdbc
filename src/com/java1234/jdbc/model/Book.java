package com.java1234.jdbc.model;

import java.io.File;

public class Book {
	
	private int id;
	private String type;
	private String auther;
	private float price;
	private File context;
	private File pic;
	
	
	public Book(int id, String type, String auther, float price) {
		super();
		this.id = id;
		this.type = type;
		this.auther = auther;
		this.price = price;
	}

	public Book(String type, String auther, float price) {
		super();
		this.type = type;
		this.auther = auther;
		this.price = price;
	}
	
	public Book(String type, String auther, float price, File context) {
		super();
		this.type = type;
		this.auther = auther;
		this.price = price;
		this.context = context;
	}

	public Book(String type, String auther, float price, File context, File pic) {
		super();
		this.type = type;
		this.auther = auther;
		this.price = price;
		this.context = context;
		this.pic = pic;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAuther() {
		return auther;
	}
	public void setAuther(String auther) {
		this.auther = auther;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}

	public File getContext() {
		return context;
	}

	public void setContext(File context) {
		this.context = context;
	}

	public File getPic() {
		return pic;
	}

	public void setPic(File pic) {
		this.pic = pic;
	}

	@Override
	public String toString() {
		return "["+this.id+", "+this.type+", "+this.auther+", "+this.price+"]";
	}
	
	
}
