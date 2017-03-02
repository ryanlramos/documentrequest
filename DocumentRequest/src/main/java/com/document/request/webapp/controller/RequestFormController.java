package com.document.request.webapp.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.appfuse.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.document.request.model.DocumentRequest;
import com.document.request.service.RequestManager;

@Controller
@RequestMapping("/requestform*")
public class RequestFormController extends BaseFormController {
	
	private RequestManager requestManager = null;
	
	@Autowired
    public void setDocumentTypeManager(@Qualifier("requestManager") RequestManager requestManager) {
        this.requestManager = requestManager;
    }
 
    public RequestFormController() {
        setCancelView("redirect:request");
        setSuccessView("redirect:request");
    }
 
    @ModelAttribute
    @RequestMapping(method = RequestMethod.GET)
    protected ModelAndView showForm(HttpServletRequest request)
    throws Exception {
        String id = request.getParameter("id");
        ModelAndView mView = new ModelAndView();
        mView.addObject("docList", requestManager.getAllDocumentTypes());
        if (!StringUtils.isBlank(id)) {
            return mView.addObject("documentRequest", requestManager.get(new Long(id)));
        }
        User userObj = getUserManager().getUserByUsername(
                request.getRemoteUser());
        
        DocumentRequest dRequest = new DocumentRequest();
        dRequest.setStudentId(userObj.getId());
        dRequest.setStatus("Received");
        
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();
       
        
        dRequest.setDateRequest(dateFormat.format(date));
        
        return mView.addObject("documentRequest", dRequest);
    }
 
    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(DocumentRequest docType, BindingResult errors, HttpServletRequest request)
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
        	requestManager.remove(docType.getId());
            saveMessage(request, getText("documentrequest.deleted", locale));
        } else {
        	requestManager.save(docType);
            String key = (isNew) ? "documentrequest.added" : "documentrequest.updated";
            saveMessage(request, getText(key, locale));
 
            if (!isNew) {
                success = "redirect:requestform?id=" + docType.getId();
            }
        }
 
        return success;
    }

}
