package com.bah.msd.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "REGISTRATIONS")
public class Registration {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "EVENT_ID")
	private String eventId;
	@Column(name = "CUSTOMER_ID")
	private String customerId;
	private Date registration_date; // must be named like this for the react client
	private String notes;

	public Registration() {
	}

	public Registration(long id, String eventId, String customerId, Date registration_date, String notes) {
		this.id = id;
		this.eventId = eventId;
		this.customerId = customerId;
		this.registration_date = registration_date;
		this.notes = notes;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public Date getRegistration_date() {
		return registration_date;
	}

	public void setRegistration_date(Date registration_date) {
		this.registration_date = registration_date;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Override
	public String toString() {
		return "Registration [id=" + id + ", eventId=" + eventId + ", customerId=" + customerId + ", registration_date="
				+ registration_date + ", notes=" + notes + "]";
	}
}
