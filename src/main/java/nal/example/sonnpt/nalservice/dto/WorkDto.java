package nal.example.sonnpt.nalservice.dto;

import nal.example.sonnpt.nalservice.util.WorkStatus;

/**
* @author  Son
* @version 1.0
* @since   2020-03-04
*/
public class WorkDto {

	private long workId;

	private String workName;

	private String startingDate;

	private String endingDate;

	private WorkStatus status;

	public WorkDto(String workName, String startingDate, String endingDate, WorkStatus status) {
		super();
		this.workName = workName;
		this.startingDate = startingDate;
		this.endingDate = endingDate;
		this.status = status;
	}

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

	public String getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(String startingDate) {
		this.startingDate = startingDate;
	}

	public String getEndingDate() {
		return endingDate;
	}

	public void setEndingDate(String endingDate) {
		this.endingDate = endingDate;
	}

	public WorkStatus getStatus() {
		return status;
	}

	public void setStatus(WorkStatus status) {
		this.status = status;
	}

}
