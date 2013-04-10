<%@ include file="init.jsp" %>

<portlet:renderURL var='urlCancel'><portlet:param name='action' value='view'/><portlet:param name='order' value='${order}'/><portlet:param name='list' value='${list}'/></portlet:renderURL>

	<liferay-ui:header title="${listObj.description} - ${item.label}" backURL="${urlCancel}" />

	
		<div style="margin-right: 4px;" >
				<portlet:renderURL var='urlEditItem'>
					<portlet:param name='action' value='addItem'/>
					<portlet:param name='list' value='${list}'/>
					<portlet:param name='itemid' value='${item.id}'/>
					<portlet:param name='order' value='${order}'/>
				</portlet:renderURL>

				<liferay-ui:icon
					cssClass="top-link"
					image="edit"
					label="<%= true %>"
					message="edit" 
					url='${urlEditItem}'
					/>
		</div>


	<aui:field-wrapper label="description">
		<% pageContext.setAttribute("newLineChar", "\n"); %>
		${fn:replace(item.description,newLineChar,"<br/>")}
	</aui:field-wrapper>

	<div style="float: left; margin-right: 4px;" >
		<aui:field-wrapper label="label">
			<c:out value='${item.label}' />
		</aui:field-wrapper>
	</div>

	<div style="float: left; margin-right: 4px;" >
		<aui:field-wrapper label="status">
	<c:if test="${statuses[ item.status ]=='Normal'}">
			<span class='status_normal'><liferay-ui:message key="normal" /></span>
	</c:if>
	<c:if test="${statuses[ item.status ]=='Waiting for'}">
			<span class='status_waiting'><liferay-ui:message key="waiting" /></span>
	</c:if>
	<c:if test="${statuses[ item.status ]=='Cancelled'}">
			<span class='status_cancelled'><liferay-ui:message key="cancelled" /></span>
	</c:if>
	<c:if test="${statuses[ item.status ]=='Finished'}">
			<span class='status_finished'><liferay-ui:message key="finished" /></span>
	</c:if>
		</aui:field-wrapper>
	</div>


	<div style="clear: both; overflow: hidden; height: 1px;" >&nbsp;</div>



