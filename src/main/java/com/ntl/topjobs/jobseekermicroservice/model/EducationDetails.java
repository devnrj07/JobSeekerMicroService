package com.ntl.topjobs.jobseekermicroservice.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EducationDetails {
	
	@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long eduID;
	private String resumeID;
	private String degree;
	private String score;
	private String institution;
	private LocalDate startdate;
	private LocalDate enddate;
	private String board;
	
	
	
	
	
	/**
	 * 
	 */
	public EducationDetails() {
		super();
	}
	/**
	 * @return the eduID
	 */
	public Long getEduID() {
		return eduID;
	}
	/**
	 * @param eduID the eduID to set
	 */
	public void setEduID(Long eduID) {
		this.eduID = eduID;
	}
	/**
	 * @return the resumeID
	 */
	public String getResumeID() {
		return resumeID;
	}
	/**
	 * @param resumeID the resumeID to set
	 */
	public void setResumeID(String resumeID) {
		this.resumeID = resumeID;
	}
	/**
	 * @return the degree
	 */
	public String getDegree() {
		return degree;
	}
	/**
	 * @param degree the degree to set
	 */
	public void setDegree(String degree) {
		this.degree = degree;
	}
	/**
	 * @return the score
	 */
	public String getScore() {
		return score;
	}
	/**
	 * @param score the score to set
	 */
	public void setScore(String score) {
		this.score = score;
	}
	/**
	 * @return the institution
	 */
	public String getInstitution() {
		return institution;
	}
	/**
	 * @param institution the institution to set
	 */
	public void setInstitution(String institution) {
		this.institution = institution;
	}
	/**
	 * @return the startdate
	 */
	public LocalDate getStartdate() {
		return startdate;
	}
	/**
	 * @param startdate the startdate to set
	 */
	public void setStartdate(LocalDate startdate) {
		this.startdate = startdate;
	}
	/**
	 * @return the enddate
	 */
	public LocalDate getEnddate() {
		return enddate;
	}
	/**
	 * @param enddate the enddate to set
	 */
	public void setEnddate(LocalDate enddate) {
		this.enddate = enddate;
	}
	/**
	 * @return the board
	 */
	public String getBoard() {
		return board;
	}
	/**
	 * @param board the board to set
	 */
	public void setBoard(String board) {
		this.board = board;
	}
	
	

}


