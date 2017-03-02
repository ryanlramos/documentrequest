package com.document.request.model;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.appfuse.model.BaseObject;

@Entity(name="document_request")
public class DocumentRequest extends BaseObject {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Long docId;
	private Long studentId;
    private String purpose;
    private String dateRequest;
    private String dateTarget;
    private String status;
    
    
       
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="document_id")
	public Long getDocId() {
		return docId;
	}

	public void setDocId(Long docId) {
		this.docId = docId;
	}
	
	
	@Column(name="student_id")
	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	@Column(name="purpose")
	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	@Column(name="date_request")
	public String getDateRequest() {
		return dateRequest;
	}

	public void setDateRequest(String dateRequest) {
		this.dateRequest = dateRequest;
	}

	@Column(name="date_target")
	public String getDateTarget() {
		return dateTarget;
	}
	
	
	@Column(name="status")  
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setDateTarget(String dateTarget) {
		this.dateTarget = dateTarget;
	}

	@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Map statusList() throws Exception {
		
		Map<String,String> status = new LinkedHashMap<String,String>();
		status.put("Received", "Received");
		status.put("Waiting for Payment", "Waiting for Payment");
		status.put("Ready for Release", "Ready for Release");
		status.put("Released", "Released");
		
		
		return status;
	}

}
