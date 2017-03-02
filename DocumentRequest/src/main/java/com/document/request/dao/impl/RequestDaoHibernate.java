package com.document.request.dao.impl;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.document.request.dao.RequestDAO;
import com.document.request.model.DocumentRequest;
import com.document.request.model.DocumentType;

@Repository("requestDao")
public class RequestDaoHibernate extends GenericDaoHibernate<DocumentRequest,Long> implements
		RequestDAO {


	public RequestDaoHibernate() {
		super(DocumentRequest.class);
	}

	@Override
	public List<DocumentRequest> findByDocumentName(String doc_name) {
	
		System.out.println("Test : " + getSession().createCriteria(DocumentRequest.class).list().size());
		return getSession().createCriteria(DocumentRequest.class).add(Restrictions.eq("document_name", doc_name)).list();
		
	}

	@Override
	public List<DocumentRequest> findByRequestByUserId(String userId) {
				
		return getSession().createCriteria(DocumentRequest.class).add(Restrictions.eq("studentId", Long.parseLong(userId))).list();
	}

	@Override
	public DocumentType findDocumentById(Long docId) {
		return (DocumentType) getSession().createCriteria(DocumentType.class).add(Restrictions.eq("id", docId)).list().get(0);
	}

	@Override
	public DocumentRequest getById(Long id) {
		System.out.println("Document Request >>>>>> "+ ((DocumentRequest) getSession().createCriteria(DocumentRequest.class).add(Restrictions.eq("id", id)).list().get(0)).getPurpose());
		return (DocumentRequest) getSession().createCriteria(DocumentRequest.class).add(Restrictions.eq("id", id)).list().get(0);
	}

	@Override
	public Map<String,String> getAllDocumentTypes() {
		
		List<DocumentType> docList = (List<DocumentType>) getSession().createCriteria(DocumentType.class).list();
		
		
		Map<String,String> status = new LinkedHashMap<String,String>();
		/*
		country.put("US", "United Stated");
		country.put("CHINA", "China");
		country.put("SG", "Singapore");
		country.put("MY", "Malaysia");
		*/
		for (Iterator<DocumentType> iterator = docList.iterator(); iterator.hasNext();) {
			DocumentType documentType = iterator.next();
			
			status.put(documentType.getId().toString(), documentType.getDocumentName());
			
		}
		
		return status;
	}

}
