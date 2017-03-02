package com.document.request.dao;

import java.util.List;
import java.util.Map;

import org.appfuse.dao.GenericDao;

import com.document.request.model.DocumentRequest;
import com.document.request.model.DocumentType;

public interface RequestDAO extends GenericDao<DocumentRequest, Long> {

	public List<DocumentRequest> findByDocumentName(String doc_name);
	
	public List<DocumentRequest> findByRequestByUserId(String userId);
	
	public DocumentRequest getById(Long id);
	
	public Map<String,String> getAllDocumentTypes();
	
	public DocumentType findDocumentById(Long docId);
	
}
