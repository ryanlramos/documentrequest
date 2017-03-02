package com.document.request.dao;

import java.util.List;

import org.appfuse.dao.GenericDao;

import com.document.request.model.DocumentType;

public interface DocumentTypeDAO extends GenericDao<DocumentType, Long> {

	public List<DocumentType> findByDocumentName(String doc_name);
}
