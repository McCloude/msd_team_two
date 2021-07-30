package com.bah.msd.domain;

public class Event {
	private long id;
	private String code;
	private String title;
	private String description;
	
	public Event() {
	}
	
	public Event(long id, String code, String title, String description) {
		this.id = id;
		this.code = code;
		this.title = title;
		this.description = description;
	}

	public String toJSON(){
		return "{\"id:\"" + id + ", \"code:\"" + code + ", \"title:\"" + title + ", \"description:\"" + description + " }";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

}
