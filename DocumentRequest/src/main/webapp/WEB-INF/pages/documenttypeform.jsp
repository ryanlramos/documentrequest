<%@ include file="/common/taglibs.jsp"%>
 
<head>
    <title><fmt:message key="documentTypeDetail.title"/></title>
    <meta name="menu" content="DocumentTypeMenu"/>
</head>
 
<div class="col-sm-3">
    <h2><fmt:message key="documentTypeDetail.heading"/></h2>
    <fmt:message key="documentTypeDetail.message"/>
</div>
<div class="col-sm-6">
    <form:errors path="*" cssClass="alert alert-danger alert-dismissable" element="div"/>
    <form:form commandName="documentType" method="post" action="documenttypeform" cssClass="well" id="personForm">
        <form:hidden path="id"/>
        <spring:bind path="documentType.documentName">
            <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
        </spring:bind>
        <appfuse:label key="documentType.documentName" styleClass="control-label"/>
        <form:input cssClass="form-control" path="documentName" id="firstName" maxlength="50"/>
        <form:errors path="documentName" cssClass="help-block"/>
        </div>
        <spring:bind path="documentType.amount">
            <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
        </spring:bind>
        <appfuse:label key="documentType.amount" styleClass="control-label"/>
        <form:input cssClass="form-control" path="amount" id="lastName" maxlength="50"/>
        <form:errors path="amount" cssClass="help-block"/>
        </div>
 
        <div class="form-group">
            <button type="submit" class="btn btn-primary" id="save" name="save">
                <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
            </button>
            <c:if test="${not empty person.id}">
                <button type="submit" class="btn btn-danger" id="delete" name="delete">
                    <i class="icon-trash icon-white"></i> <fmt:message key="button.delete"/>
                </button>
            </c:if>
 
            <button type="submit" class="btn btn-default" id="cancel" name="cancel">
                <i class="icon-remove"></i> <fmt:message key="button.cancel"/>
            </button>
        </div>
    </form:form>
</div>
 
<script type="text/javascript">
    $(document).ready(function() {
        $("input[type='text']:visible:enabled:first", document.forms['documenttypeform']).focus();
    });
</script>