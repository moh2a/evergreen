package com.evergreen.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class GreenPoint implements Serializable {
@Id @GeneratedValue
private Long idGreenPoint;
@Column(length=100)
private String description;
private Float latitude;
private Float longitude;

	public GreenPoint(String description, Float latitude, Float longitude) {
		this.description = description;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	public GreenPoint() {}
	
	public Long getIdGreenPoint() {
		return idGreenPoint;
	}
	public void setIdGreenPoint(Long idGreenPoint) {
		this.idGreenPoint = idGreenPoint;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Float getLatitude() {
		return latitude;
	}
	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}
	public Float getLongitude() {
		return longitude;
	}
	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}
}