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
	private Date registrationDate;
	private String notes;

	public Registration() {
	}

	public Registration(long id, String eventId, String customerId, Date registrationDate, String notes) {
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
