package com.document.request.service;

import java.util.List;

import org.appfuse.service.GenericManager;

import com.document.request.model.DocumentType;

public interface DocumentTypeManager extends GenericManager<DocumentType, Long> {
	
	List<DocumentType> findByDocumentName(String doc_name);

}
