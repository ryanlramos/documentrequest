<%@ include file="/common/taglibs.jsp"%>
 
<head>
    <title><fmt:message key="documenttypeList.title"/></title>
    <meta name="menu" content="DocumentTypeMenu"/>
</head>
 
<h2><fmt:message key="documenttypeList.heading"/></h2>
 
<div id="actions" class="btn-group">
    <a href='<c:url value="/documenttypeform"/>' class="btn btn-primary">
        <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/></a>
    <a href='<c:url value="/home"/>' class="btn btn-default"><i class="icon-ok"></i> <fmt:message key="button.done"/></a>
</div>
 
<display:table name="dList" class="table table-condensed table-striped table-hover" requestURI=""
               id="dList" export="true" pagesize="25">
    <display:column property="id" sortable="true" href="documenttypeform" media="html"
        paramId="id" paramProperty="id" titleKey="documenttype.id"/>
    <display:column property="id" media="csv excel xml pdf" titleKey="documenttype.id"/>
    <display:column property="documentName" sortable="true" titleKey="documenttype.documentName"/>
    <display:column property="amount" sortable="true" titleKey="documenttype.amount"/>
 
    <display:setProperty name="paging.banner.item_name"><fmt:message key="documenttypeList.document"/></display:setProperty>
    <display:setProperty name="paging.banner.items_name"><fmt:message key="documenttypeList.documents"/></display:setProperty>
 
    <display:setProperty name="export.excel.filename"><fmt:message key="documenttypeList.title"/>.xls</display:setProperty>
    <display:setProperty name="export.csv.filename"><fmt:message key="documenttypeList.title"/>.csv</display:setProperty>
    <display:setProperty name="export.pdf.filename"><fmt:message key="documenttypeList.title"/>.pdf</display:setProperty>
</display:table>