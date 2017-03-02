package com.document.request.model;



public class DocumentRequestObject {

	private static final long serialVersionUID = 12L;

	private Long id;
	private Long docId;
	private String docName;
	private Long studentId;
    private String purpose;
    private String dateRequest;
    private String dateTarget;
    private String status;
    private Long amount;
    
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getDocId() {
		return docId;
	}
	public void setDocId(Long docId) {
		this.docId = docId;
	}
	
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getDateRequest() {
		return dateRequest;
	}
	public void setDateRequest(String dateRequest) {
		this.dateRequest = dateRequest;
	}
	public String getDateTarget() {
		return dateTarget;
	}
	public void setDateTarget(String dateTarget) {
		this.dateTarget = dateTarget;
	}
	public String getDocName() {
		return docName;
	}
	public void setDocName(String docName) {
		this.docName = docName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
    
    
   

}
