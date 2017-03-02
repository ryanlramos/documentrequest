package com.document.request.webapp.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.document.request.model.DocumentRequest;
import com.document.request.model.DocumentRequestObject;
import com.document.request.service.RequestManager;


@Controller
@RequestMapping("/request*")
public class RequestController {
	
	private RequestManager requestManager;
	
	@Autowired
    public void setRequestManager(@Qualifier("requestManager") RequestManager requestManager) {
        this.requestManager = requestManager;
    }
	

	@RequestMapping(method = RequestMethod.GET)
    public ModelAndView handleRequest()
    throws Exception {
		List<DocumentRequest> rList = requestManager.getAll();
		List<DocumentRequest> cList = requestManager.findByRequestByUserId("1");
		System.out.println("By ID: " + cList.size());
		
		List<DocumentRequestObject> oList = requestManager.returnDocumentRequestObject("1");
		System.out.println("Object Count : "+ oList.size());
		for (Iterator iterator = oList.iterator(); iterator.hasNext();) {
			DocumentRequestObject documentRequestObject = (DocumentRequestObject) iterator
					.next();
			System.out.println("Obj : " + documentRequestObject.getDocName());
			
		}
		
		//List<DocumentRequest> rList2 = requestManager.findByDocumentName("test");
		System.out.println("Countsss : "+ rList.size());
        return new ModelAndView().addObject("oList",oList);
    }

}
