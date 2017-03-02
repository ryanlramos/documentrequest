package com.document.request.webapp.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.appfuse.model.User;
import org.appfuse.service.GenericManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.document.request.model.DocumentRequest;
import com.document.request.model.DocumentType;
import com.document.request.model.Payment;
import com.document.request.service.RequestManager;

@Controller
@RequestMapping("/paymentform*")
public class PaymentFormController extends BaseFormController {
	
	private GenericManager<Payment, Long> paymentManager = null;
	
	@Autowired
    public void setPaymentManager(@Qualifier("paymentManager") GenericManager<Payment, Long> paymentManager) {
        this.paymentManager = paymentManager;
    }
 
    public PaymentFormController() {
        setCancelView("redirect:request");
        setSuccessView("redirect:request");
    }
 
    @ModelAttribute
    @RequestMapping(method = RequestMethod.GET)
    protected ModelAndView showForm(HttpServletRequest request)
    throws Exception {
        String id = request.getParameter("id");
        ModelAndView mView = new ModelAndView();
        //mView.addObject("docList", requestManager.getAllDocumentTypes());
        if (!StringUtils.isBlank(id)) {
            return mView.addObject("payment", paymentManager.get(new Long(id)));
        }
        User userObj = getUserManager().getUserByUsername(
                request.getRemoteUser());
        
        //DocumentRequest dRequest = new DocumentRequest();
        //dRequest.setStudentId(userObj.getId());
        //dRequest.setStatus("Received");
        
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();
       
        
        //dRequest.setDateRequest(dateFormat.format(date));
        
        return mView.addObject("payment", new Payment());
        //return mView.addObject("documentRequest", dRequest);
    }
 
    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(Payment docType, BindingResult errors, HttpServletRequest request)
    throws Exception {
        if (request.getParameter("cancel") != null) {
            return getCancelView();
        }
 
        if (validator != null) { // validator is null during testing
            validator.validate(docType, errors);
 
            if (errors.hasErrors() && request.getParameter("delete") == null) { // don't validate when deleting
                return "request";
            }
        }
 
        log.debug("entering 'onSubmit' method...");
 
        boolean isNew = (docType.getId() == null);
        String success = getSuccessView();
        Locale locale = request.getLocale();
 
        if (request.getParameter("delete") != null) {
        	paymentManager.remove(docType.getId());
            saveMessage(request, getText("documentrequest.deleted", locale));
        } else {
        	paymentManager.save(docType);
            String key = (isNew) ? "payment.added" : "payment.updated";
            saveMessage(request, getText(key, locale));
 
            if (!isNew) {
                success = "redirect:requestform?id=" + docType.getId();
            }
        }
 
        return success;
    }

}
