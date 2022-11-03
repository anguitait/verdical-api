package com.verdical.api.verdical_api.model;

import java.sql.Timestamp;

public class VlUser {
	
	private Integer id;
	
	private Timestamp create_date;
	
	private String name;
	
	private String firstName;
	
	private String lastName;
	
	private Timestamp last_login_date;
	
	private Timestamp email_prediction_date;
	
	private Timestamp email_behaviour_date;
	
	private String email;
	
	private boolean is_active;
	
	private Integer role_id;
	
	private String gender;
	
	private String course;
	
	private boolean can_leave;
	
	private boolean prediction_sent;
	
	private boolean behaviour_sent;
	
	private String dtCreateDate;
	
	private String dtLastLoginDate;
	
	private String canLeave;
	
	private String sentPrediction;
	
	private String sentBehaviour;
	
	private String maritalStatus;
	
	private String city;
	
	private String country;

	public VlUser() {
	}
	
	public VlUser(Timestamp create_date, String name, Timestamp last_login_date,
			String email, boolean is_active, int role_id, String gender, String course,
			boolean can_leave, boolean prediction_sent, boolean behaviour_sent) {
		this.create_date = create_date;
		this.name = name;
		this.last_login_date = last_login_date;
		this.email = email;
		this.is_active = is_active;
		this.role_id = role_id;
		this.gender = gender;
		this.course = course;
		this.can_leave = can_leave;
		this.prediction_sent = prediction_sent;
		this.behaviour_sent = behaviour_sent;	
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Timestamp create_date) {
		this.create_date = create_date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getLast_login_date() {
		return last_login_date;
	}

	public void setLast_login_date(Timestamp last_login_date) {
		this.last_login_date = last_login_date;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isIs_active() {
		return is_active;
	}

	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}

	public Integer getRole_id() {
		return role_id;
	}

	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public boolean isCan_leave() {
		return can_leave;
	}

	public void setCan_leave(boolean can_leave) {
		this.can_leave = can_leave;
	}

	public String getDtCreateDate() {
		return dtCreateDate;
	}

	public void setDtCreateDate(String dtCreateDate) {
		this.dtCreateDate = dtCreateDate;
	}

	public String getDtLastLoginDate() {
		return dtLastLoginDate;
	}

	public void setDtLastLoginDate(String dtLastLoginDate) {
		this.dtLastLoginDate = dtLastLoginDate;
	}

	public String getCanLeave() {
		return canLeave;
	}

	public void setCanLeave(String canLeave) {
		this.canLeave = canLeave;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public boolean isPrediction_sent() {
		return prediction_sent;
	}

	public void setPrediction_sent(boolean prediction_sent) {
		this.prediction_sent = prediction_sent;
	}

	public boolean isBehaviour_sent() {
		return behaviour_sent;
	}

	public void setBehaviour_sent(boolean behaviour_sent) {
		this.behaviour_sent = behaviour_sent;
	}

	public String getSentPrediction() {
		return sentPrediction;
	}

	public void setSentPrediction(String sentPrediction) {
		this.sentPrediction = sentPrediction;
	}

	public String getSentBehaviour() {
		return sentBehaviour;
	}

	public void setSentBehaviour(String sentBehaviour) {
		this.sentBehaviour = sentBehaviour;
	}

	public Timestamp getEmail_prediction_date() {
		return email_prediction_date;
	}

	public void setEmail_prediction_date(Timestamp email_prediction_date) {
		this.email_prediction_date = email_prediction_date;
	}

	public Timestamp getEmail_behaviour_date() {
		return email_behaviour_date;
	}

	public void setEmail_behaviour_date(Timestamp email_behaviour_date) {
		this.email_behaviour_date = email_behaviour_date;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Param [id=" + id + ", name=" + name + ", email=" + email + ", is_active=" + is_active + "]";
	}

}
