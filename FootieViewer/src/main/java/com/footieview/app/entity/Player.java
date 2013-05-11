package com.footieview.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "players")
public class Player {
	
	private String uuid;
	private Integer espnId;
	private String firstName;
	private String lastName;
	private String espnUrl;
	
	/**
	 * @return the uuid
	 */
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name = "uuid", unique = true)
	public String getUuid() {
		return uuid;
	}
	/**
	 * @param uuid the uuid to set
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	/**
	 * @return the espnId
	 */
	@Column(name = "espnid")
	public Integer getEspnId() {
		return espnId;
	}
	/**
	 * @param espnId the espnId to set
	 */
	public void setEspnId(Integer espnId) {
		this.espnId = espnId;
	}
	/**
	 * @return the firstName
	 */
	@Column(name = "firstname")
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	@Column(name = "lastname")
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the espnUrl
	 */
	public String getEspnUrl() {
		return espnUrl;
	}
	/**
	 * @param espnUrl the espnUrl to set
	 */
	@Column(name = "espnurl")
	public void setEspnUrl(String espnUrl) {
		this.espnUrl = espnUrl;
	}
	
	
}
