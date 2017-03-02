package com.document.request.dao.impl;

import java.util.List;

import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.document.request.dao.DocumentTypeDAO;
import com.document.request.model.DocumentType;

@Repository("documentTypeDao")
public class DocumentTypeDaoHibernate extends GenericDaoHibernate<DocumentType,Long> implements
		DocumentTypeDAO {


	public DocumentTypeDaoHibernate() {
		super(DocumentType.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<DocumentType> findByDocumentName(String doc_name) {
		return getSession().createCriteria(DocumentType.class).add(Restrictions.eq("document_name", doc_name)).list();
	}

}
