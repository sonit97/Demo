package nal.example.sonnpt.nalservice.entity;

import java.util.Date;

import javax.persistence.*;

import nal.example.sonnpt.nalservice.util.WorkStatus;

/**
* @author  Son
* @version 1.0
* @since   2020-03-04
*/
@Entity
@Table(name = "WORK", schema = "public")
public class Work {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long workId;

	@Column(name = "WORK_NAME", length = 255, nullable = false)
	private String workName;

	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "STARTING_DATE", nullable = true) 
	private Date startingDate;

	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "ENDING_DATE", nullable = true)
	private Date endingDate;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "STATUS", nullable = true)
	private WorkStatus status;

	public long getWorkId() {
		return workId;
	}

	public void setWorkId(long workId) {
		this.workId = workId;
	}

	public String getWorkName() {
		return workName;
	}

	public void setWorkName(String workName) {
		this.workName = workName;
	}

	public Date getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(Date startingDate) {
		this.startingDate = startingDate;
	}

	public Date getEndingDate() {
		return endingDate;
	}

	public void setEndingDate(Date endingDate) {
		this.endingDate = endingDate;
	}

	public WorkStatus getStatus() {
		return status;
	}

	public void setStatus(WorkStatus status) {
		this.status = status;
	}

}
