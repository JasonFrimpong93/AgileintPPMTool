package io.agileintelligence.ppmtool.domain;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@Entity
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String projectName;
	private String projectIdentifier;
	private String description;
	private Date start_date;
	private Date end_Date;

	private Date created_At;
	private Date updated_At;

	public Project() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectIdentifier() {
		return projectIdentifier;
	}

	public void setProjectIdentifier(String projectIdentifier) {
		this.projectIdentifier = projectIdentifier;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_Date() {
		return end_Date;
	}

	public void setEnd_Date(Date end_Date) {
		this.end_Date = end_Date;
	}

	public Date getCreated_At() {
		return created_At;
	}

	public void setCreated_At(Date created_At) {
		this.created_At = created_At;
	}

	public Date getUpdated_At() {
		return updated_At;
	}

	public void setUpdated_At(Date updated_At) {
		this.updated_At = updated_At;
	}

	@PrePersist
	protected void onCreate() {
		this.created_At = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updated_At = new Date();
	}
}
