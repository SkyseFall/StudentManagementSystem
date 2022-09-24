package com.iacsd.dto;

public class attendanceListReadable {
	private String date;
	private String status;
	
	public attendanceListReadable() {
	}

	public attendanceListReadable(String date, String status) {
		this.date = date;
		this.status = status;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "attendanceListReadable [date=" + date + ", status=" + status + "]";
	}
}
