<%@ include file="/common/taglibs.jsp"%>
 
<head>
    <title><fmt:message key="requestList.title"/></title>
    <meta name="menu" content="RequestMenu"/>
</head>
 
<h2><fmt:message key="requestList.heading"/></h2>
 
<div id="actions" class="btn-group">
    <a href='<c:url value="/requestform"/>' class="btn btn-primary">
        <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/></a>
    <a href='<c:url value="/home"/>' class="btn btn-default"><i class="icon-ok"></i> <fmt:message key="button.done"/></a>
</div>
 
<display:table name="oList" class="table table-condensed table-striped table-hover" requestURI=""
               id="oList" export="true" pagesize="25">
    <display:column property="id" sortable="true" href="requestform" media="html"
        paramId="id" paramProperty="id" titleKey="request.id"/>
    <display:column property="id" media="csv excel xml pdf" titleKey="request.id"/>
    <display:column property="docName" sortable="true" titleKey="request.docId"/>
    <display:column property="dateRequest" sortable="true" titleKey="request.dateRequest"/>
    <display:column property="dateTarget" sortable="true" titleKey="request.dateTarget"/>
    <display:column property="amount" sortable="true" titleKey="request.amount"/>
 	<display:column property="status" sortable="true" titleKey="request.status"/>
 
    <display:setProperty name="paging.banner.item_name"><fmt:message key="requestList.document"/></display:setProperty>
    <display:setProperty name="paging.banner.items_name"><fmt:message key="requestList.documents"/></display:setProperty>
 
    <display:setProperty name="export.excel.filename"><fmt:message key="requestList.title"/>.xls</display:setProperty>
    <display:setProperty name="export.csv.filename"><fmt:message key="requestList.title"/>.csv</display:setProperty>
    <display:setProperty name="export.pdf.filename"><fmt:message key="requestList.title"/>.pdf</display:setProperty>
</display:table>