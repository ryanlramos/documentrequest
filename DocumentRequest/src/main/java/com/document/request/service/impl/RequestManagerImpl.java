package com.document.request.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.appfuse.service.impl.GenericManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.document.request.dao.RequestDAO;
import com.document.request.model.DocumentRequest;
import com.document.request.model.DocumentRequestObject;
import com.document.request.model.DocumentType;
import com.document.request.service.RequestManager;

@Service("requestManager")
public class RequestManagerImpl extends
		GenericManagerImpl<DocumentRequest, Long> implements RequestManager {

	RequestDAO requestDao;
	

	@Autowired
	public RequestManagerImpl(RequestDAO requestDao) {
		super(requestDao);
		this.requestDao = requestDao;
	}

	@Override
	public List<DocumentRequest> findByDocumentName(String doc_name) {

		return requestDao.findByDocumentName(doc_name);
	}

	@Override
	public List<DocumentRequest> findByRequestByUserId(String userId) {

		return requestDao.findByRequestByUserId(userId);
	}

	@Override
	public List<DocumentRequestObject> returnDocumentRequestObject(String userId) {

		List<DocumentRequest> dList = requestDao.findByRequestByUserId(userId);
		List<DocumentRequestObject> objList = new ArrayList<DocumentRequestObject>();
		
		System.out.println("init >> " + dList.size());
	
		for (Iterator<DocumentRequest> iterator = dList.iterator(); iterator.hasNext();) {
			DocumentRequest documentRequest = iterator.next();

			
			DocumentRequestObject obj = new DocumentRequestObject();
			
			DocumentType docType = requestDao.findDocumentById(documentRequest.getDocId());
			
			
			obj.setId(documentRequest.getId());
			
			obj.setDocName(docType.getDocumentName());
			
			obj.setDateTarget(documentRequest.getDateTarget());
			
			obj.setDateRequest(documentRequest.getDateRequest());
			
			obj.setStatus(documentRequest.getStatus());
			
			obj.setAmount(docType.getAmount());
			
			objList.add(obj);
			
		}

		return objList;
	}

	@Override
	public DocumentRequest getById(Long id) {
		return requestDao.getById(id);
	}

	@Override
	public Map<String,String> getAllDocumentTypes() {
		return requestDao.getAllDocumentTypes();
	}

}
