package com.evergreen.entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class GreenPoint implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idGreenPoint;
  private Long idNettoyeur;
  private Long idPosteur;
  private Integer score;
  @Column(length = 500)
  private String description;
  @Column(nullable = true,length = 100)
  private String photo_avant;
  @Column(length = 20)
  private String statut;
  @Column(nullable = true,length = 100)
  private String photo_apres;
  private Float latitude;
  private Float longitude;

  public GreenPoint(String description,String statut, Float latitude, Float longitude, String photo_avant, String photo_apres, Long idNettoyeur, Long idPosteur) {
    this.description = description;
    this.latitude = latitude;
    this.statut = statut;
    this.longitude = longitude;
    this.photo_avant = photo_avant;
    this.photo_apres = photo_apres;
    this.idNettoyeur = idNettoyeur;
    this.idPosteur = idPosteur;
  }

  public String getPhoto_avant() {
	return photo_avant;
}

public void setPhoto_avant(String photo_avant) {
	this.photo_avant = photo_avant;
}

public String getPhoto_apres() {
	return photo_apres;
}

public void setPhoto_apres(String photo_apres) {
	this.photo_apres = photo_apres;
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

  public Long getIdNettoyeur() {
    return idNettoyeur;
  }

  public void setIdNettoyeur(Long idNettoyeur) {
    this.idNettoyeur = idNettoyeur;
  }

  public Long getIdPosteur() {
    return idPosteur;
  }

  public void setIdPosteur(Long idPosteur) {
    this.idPosteur = idPosteur;
  }

  public Integer getScore() {
    return score;
  }

  public void setScore(Integer score) {
    this.score = score;
  }

  public String getStatut() {
    return statut;
  }

  public void setStatut(String statut) {
    this.statut = statut;
  }
}
