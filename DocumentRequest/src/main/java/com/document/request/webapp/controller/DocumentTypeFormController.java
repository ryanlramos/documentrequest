package com.document.request.webapp.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.appfuse.service.GenericManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.document.request.model.DocumentType;

@Controller
@RequestMapping("/documenttypeform*")
public class DocumentTypeFormController extends BaseFormController {
	
	private GenericManager<DocumentType, Long> documentTypeManager = null;
	
	@Autowired
    public void setDocumentTypeManager(@Qualifier("documentTypeManager") GenericManager<DocumentType, Long> documentTypeManager) {
        this.documentTypeManager = documentTypeManager;
    }
 
    public DocumentTypeFormController() {
        setCancelView("redirect:documenttype");
        setSuccessView("redirect:documenttype");
    }
 
    @ModelAttribute
    @RequestMapping(method = RequestMethod.GET)
    protected DocumentType showForm(HttpServletRequest request)
    throws Exception {
        String id = request.getParameter("id");
 
        if (!StringUtils.isBlank(id)) {
            return documentTypeManager.get(new Long(id));
        }
 
        return new DocumentType();
    }
 
    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(DocumentType docType, BindingResult errors, HttpServletRequest request)
    throws Exception {
        if (request.getParameter("cancel") != null) {
            return getCancelView();
        }
 
        if (validator != null) { // validator is null during testing
            validator.validate(docType, errors);
 
            if (errors.hasErrors() && request.getParameter("delete") == null) { // don't validate when deleting
                return "personform";
            }
        }
 
        log.debug("entering 'onSubmit' method...");
 
        boolean isNew = (docType.getId() == null);
        String success = getSuccessView();
        Locale locale = request.getLocale();
 
        if (request.getParameter("delete") != null) {
        	documentTypeManager.remove(docType.getId());
            saveMessage(request, getText("documenttype.deleted", locale));
        } else {
        	documentTypeManager.save(docType);
            String key = (isNew) ? "documenttype.added" : "documenttype.updated";
            saveMessage(request, getText(key, locale));
 
            if (!isNew) {
                success = "redirect:documenttypeform?id=" + docType.getId();
            }
        }
 
        return success;
    }

}
