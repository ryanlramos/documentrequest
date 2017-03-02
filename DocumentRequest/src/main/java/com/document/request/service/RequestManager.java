package com.document.request.service;

import java.util.List;
import java.util.Map;

import org.appfuse.service.GenericManager;

import com.document.request.model.DocumentRequest;
import com.document.request.model.DocumentRequestObject;

public interface RequestManager extends GenericManager<DocumentRequest, Long> {

	List<DocumentRequest> findByDocumentName(String doc_name);

	public List<DocumentRequest> findByRequestByUserId(String userId);

	public List<DocumentRequestObject> returnDocumentRequestObject(String userId);

	public DocumentRequest getById(Long id);

	public Map<String,String> getAllDocumentTypes();

}
