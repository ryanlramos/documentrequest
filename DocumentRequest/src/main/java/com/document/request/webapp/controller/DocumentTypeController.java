package com.document.request.webapp.controller;

import java.util.List;

import org.appfuse.service.GenericManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.document.request.model.DocumentType;


@Controller
@RequestMapping("/documenttype*")
public class DocumentTypeController {
	
	private GenericManager<DocumentType, Long> documentTypeManager;
	
	@Autowired
    public void setDocumentTypeManager(@Qualifier("documentTypeManager") GenericManager<DocumentType, Long> documentTypeManager) {
        this.documentTypeManager = documentTypeManager;
    }
	

	@RequestMapping(method = RequestMethod.GET)
    public ModelAndView handleRequest()
    throws Exception {
		List<DocumentType> docList = documentTypeManager.getAll();
		
        return new ModelAndView().addObject("dList",docList);
    }

}
