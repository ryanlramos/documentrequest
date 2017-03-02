package com.document.request.service.impl;

import java.util.List;

import org.appfuse.service.impl.GenericManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.document.request.dao.DocumentTypeDAO;
import com.document.request.model.DocumentType;
import com.document.request.service.DocumentTypeManager;

@Service("documentTypeManager")
public class DocumentTypeManagerImpl extends GenericManagerImpl<DocumentType,Long> implements
		DocumentTypeManager {
	
	DocumentTypeDAO documentTypeDao;

	@Autowired
	public DocumentTypeManagerImpl(DocumentTypeDAO documentTypeDao){
		super(documentTypeDao);
		this.documentTypeDao = documentTypeDao;
	}

	@Override
	public List<DocumentType> findByDocumentName(String doc_name) {
		
		return documentTypeDao.findByDocumentName(doc_name);
	}

}
