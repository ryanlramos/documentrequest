<%@ include file="/common/taglibs.jsp"%>
 
<head>
    <title><fmt:message key="requestDetail.title"/></title>
    <meta name="menu" content="RequestMenu"/>
    
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</head>
 
<div class="col-sm-3">
    <h2><fmt:message key="requestDetail.heading"/></h2>
    <fmt:message key="requestDetail.message"/>
</div>
<div class="col-sm-6">
    <form:errors path="*" cssClass="alert alert-danger alert-dismissable" element="div"/>
    <form:form commandName="documentRequest" method="post" action="requestform" cssClass="well" id="requestForm">
        <form:hidden path="id"/>
        <form:hidden path="studentId"/>
       
       <spring:bind path="documentRequest.docId">
            <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
        </spring:bind>
        <appfuse:label key="documentRequest.docId" styleClass="control-label"/>
        <form:select class="form-control" path="docId" items="${docList}" />
        <form:errors path="docId" cssClass="help-block"/>
        </div>
        
        
        <spring:bind path="documentRequest.purpose">
            <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
        </spring:bind>
        <appfuse:label key="documentRequest.purpose" styleClass="control-label"/>
        <form:input cssClass="form-control" path="purpose" id="purpose" maxlength="50"/>
        <form:errors path="purpose" cssClass="help-block"/>
        </div>
        <spring:bind path="documentRequest.dateTarget">
            <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
        </spring:bind>
        <appfuse:label key="documentRequest.dateTarget" styleClass="control-label"/>
        <form:input cssClass="form-control" path="dateTarget" id="dateTarget" maxlength="50"/>
        <form:errors path="dateTarget" cssClass="help-block"/>
        </div>
 		
 		<c:if test="${not empty documentRequest.id}">
 		<spring:bind path="documentRequest.dateRequest">
            <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
        </spring:bind>
        <appfuse:label key="documentRequest.dateRequest" styleClass="control-label"/>
        <form:input cssClass="form-control" path="dateRequest" id="dateRequest" maxlength="50"/>
        <form:errors path="dateRequest" cssClass="help-block"/>
        </div>
        
        
        <spring:bind path="documentRequest.status">
            <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
        </spring:bind>
        <appfuse:label key="documentRequest.status" styleClass="control-label"/>
        <!--form:input cssClass="form-control" path="status" id="dateRequest" maxlength="50"/-->
        <!--form:select path="status" items="${statusList}" /-->
        <c:if test = "${documentRequest.status == 'Received'}"><select class="form-control" id="status" name="Status"><option value="Received" selected>Received</option><option value="Waiting for Payment" >Waiting for Payment</option><option value="Ready for release" >Ready for release</option><option value="Released">Released</option></select></c:if>
        <c:if test = "${documentRequest.status == 'Waiting for Payment'}"><select class="form-control" id="status" name="Status"><option value="Received">Received</option><option value="Waiting for Payment" selected>Waiting for Payment</option><option value="Ready for release" >Ready for release</option><option value="Released">Released</option></select></c:if>
        <c:if test = "${documentRequest.status == 'Ready for release'}"><select class="form-control" id="status" name="Status"><option value="Received">Received</option><option value="Waiting for Payment" >Waiting for Payment</option><option value="Ready for release" selected>Ready for release</option><option value="Released">Released</option></select></c:if>
        <c:if test = "${documentRequest.status == 'Released'}"><select class="form-control" id="status" name="Status"><option value="Received">Received</option><option value="Waiting for Payment" >Waiting for Payment</option><option value="Ready for release" >Ready for release</option><option value="Released" selected>Released</option></select></c:if>
		
		        

        <form:errors path="status" cssClass="help-block"/>
        </div>
        </c:if>
 		<c:if test="${empty documentRequest.id}">
 			<!--input type="hidden" id="status" name="status" value="Received" /-->
 			<form:hidden path="status"/>
 			<form:hidden path="dateRequest"/>
 		</c:if>
 		
        <div class="form-group">
            <button type="submit" class="btn btn-primary" id="save" name="save">
                <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
            </button>
           <c:if test="${not empty documentRequest.id}">
                <a href="paymentform?reqId=${documentRequest.id}"
                <button type="button" class="btn btn-primary" id="payment" name="payment">
                    <i class="icon-trash icon-white"></i> <fmt:message key="button.payment"/>
                </button>
                </a>
            </c:if>
            <button type="submit" class="btn btn-default" id="cancel" name="cancel">
                <i class="icon-remove"></i> <fmt:message key="button.cancel"/>
            </button>
        </div>
    </form:form>
</div>
 
<script type="text/javascript">
    $(document).ready(function() {
        $("input[type='text']:visible:enabled:first", document.forms['requestform']).focus();
      jQuery("#dateRequest").datepicker();
      jQuery("#dateTarget").datepicker();
       
    });
</script>