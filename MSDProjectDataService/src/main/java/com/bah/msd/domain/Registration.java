package com.bah.msd.domain;

import java.util.Date;

public class Registration {

	private long id;
	private long eventId;
	private long customerId;
	private Date registrationDate;
	private String notes;
	
	public Registration() {
	}
	
	public Registration(long id, long eventId, long customerId, Date registrationDate, String notes) {
		this.id = id;
		this.eventId = eventId;
		this.customerId = customerId;
		this.registrationDate = registrationDate;
		this.notes = notes;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getEventId() {
		return eventId;
	}

	public void setEventId(long eventId) {
		this.eventId = eventId;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Override
	public String toString() {
		return "Registration [id=" + id + ", eventId=" + eventId + ", customerId=" + customerId + ", registrationDate="
				+ registrationDate + ", notes=" + notes + "]";
	}
}
