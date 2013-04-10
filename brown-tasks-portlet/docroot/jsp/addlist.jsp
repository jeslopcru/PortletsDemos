<%@ include file="init.jsp" %>

<portlet:actionURL var='actionAddList'><portlet:param name='action' value='addList'/><portlet:param name='order' value='${order}'/></portlet:actionURL>
<portlet:renderURL var='urlCancel'><portlet:param name='action' value='view'/><portlet:param name='order' value='${order}'/><portlet:param name='list' value='${list}'/></portlet:renderURL>

<portlet:actionURL var='actionDeleteList'>
	<portlet:param name='action' value='addList'/>
	<portlet:param name='delete' value='1'/>
	<portlet:param name='id' value='${item.id}'/>
	<portlet:param name='order' value='${order}'/>
</portlet:actionURL>

<liferay-ui:header title="list-title"	backURL="${urlCancel}" />

<form method="post" action="<%= actionAddList %>" onSubmit = "<%= "javascript: return "+renderResponse.getNamespace()+"validate(this);" %>" >
	
	<div style="float: left; margin-right: 4px; height: 43px;" >
		<aui:input type='text' name='description' label="list-name" value='${item.description}' />
	</div>

	<div style="float: left; margin-right: 4px; height: 43px;" >
		<aui:select label="weight" name="weight">
			<c:set value="${item.weight}" var="sval"/>
			<c:if test="${item.id==null}">
				<c:set value="0" var="sval"/>
			</c:if>		
	
			<c:forEach var="i" begin="0" end="10">
				<aui:option value="${i-5}" selected="${sval==i-5}">${i-5}</aui:option>
			</c:forEach>
		</aui:select>
	</div>

	<div style="clear: both; overflow: hidden; height: 1px;" >
		&nbsp;
	</div>

	<p>
		&nbsp;
	</p>

	<p>
		<c:if test="${item.id!=null}">		
			<aui:input type='hidden' name='id' value='${item.id}' />
			<input type='submit' value='<liferay-ui:message key="save" />'/>
			<input type='button' onclick='<%=renderResponse.getNamespace()+"toDelete();" %>' value='<liferay-ui:message key="action.DELETE" />'/>
		</c:if>		
		<c:if test="${item.id==null}">		
			<aui:input type='hidden' name='id' value='-1' />
			<input type='submit' value='<liferay-ui:message key="add" />'/>
		</c:if>	
		&nbsp;&nbsp;&nbsp;&nbsp;
		<input type='button' onclick="javascript: window.location.href='${urlCancel}';" value='<liferay-ui:message key="cancel" />'/>
	</p>

</form>


<aui:script use="aui-node">
	<portlet:namespace />validate=function() {
		if ( AUI().one("#<portlet:namespace />description").val().trim()=="" ) {
			alert( '<liferay-ui:message key="this-field-is-mandatory" />' );
			AUI().one("#<portlet:namespace />description").focus();

			return false;
			}

		return true;
		}

	<portlet:namespace />toDelete=function() {
		if ( confirm("<liferay-ui:message key="attention-delete" />") )
			window.location.href='${actionDeleteList}';
		}
</aui:script>
