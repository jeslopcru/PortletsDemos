<%@ include file="init.jsp" %>

<portlet:renderURL var='urlAddList'><portlet:param name='action' value='addList'/><portlet:param name='order' value='${order}'/><portlet:param name='list' value='${list}'/></portlet:renderURL>
<portlet:renderURL var='urlEditList'><portlet:param name='action' value='addList'/><portlet:param name='order' value='${order}'/><portlet:param name='list' value='${list}'/><portlet:param name='id' value='${list}'/></portlet:renderURL>
<portlet:renderURL var='urlAddItem'><portlet:param name='action' value='addItem'/><portlet:param name='order' value='${order}'/><portlet:param name='list' value='${list}'/></portlet:renderURL>
<portlet:renderURL var='def'><portlet:param name='action' value='view'/></portlet:renderURL>

<p>

	<aui:button name='addList' value='add-list' onclick='<%=renderResponse.getNamespace()+"toAddList()" %>' />
	<c:if test="${list!=null}">
		<aui:button name='addItem' value='add-item' onclick='<%=renderResponse.getNamespace()+"toAddItem()" %>' />
	</c:if>

</p>

<liferay-ui:tabs
	names="${formNames}"
	value="${formTab}"
	url='<%=def %>'
	refresh="<%= true %>"
	/>

<p style='text-align: right;'>
		<c:if test="${list!=null}">
			<liferay-ui:icon
				cssClass="top-link"
				image="edit"
				label="<%= true %>"
				message="editlist" 
				url='${urlEditList}'
				/>
		</c:if>
</p>



<aui:script>
	function <%=renderResponse.getNamespace() %>toAddList() {
		window.location.href='<%=urlAddList %>';
		}

	function <%=renderResponse.getNamespace() %>toAddItem() {
		window.location.href='<%=urlAddItem %>';
		}
</aui:script>

<table style='width: 100%;'>
	<tr class="portlet-section-header results-header">
		<td>
			<b>
				<a style='text-decoration: none;' href='<portlet:renderURL>
						<portlet:param name='action' value='view'/>
						<portlet:param name='list' value='${list}'/>
						<portlet:param name='order' value='label'/>
						</portlet:renderURL>'>

					<liferay-ui:message key="label" />

					<c:if test="${order=='label'}">
						&or;
					</c:if>
				</a>
			</b>
		</td>
		<td>
			<b>
				<a style='text-decoration: none;' href='<portlet:renderURL>
						<portlet:param name='action' value='view'/>
						<portlet:param name='list' value='${list}'/>
						<portlet:param name='order' value='weight'/>
						</portlet:renderURL>'>

					<liferay-ui:message key="weight" />

					<c:if test="${order=='weight'}">
						&or;
					</c:if>
				</a>
			</b>
		</td>
		<td>
			<b>
				<a style='text-decoration: none;' href='<portlet:renderURL>
						<portlet:param name='action' value='view'/>
						<portlet:param name='list' value='${list}'/>
						<portlet:param name='order' value='status'/>
						</portlet:renderURL>'>

					<liferay-ui:message key="status" />

					<c:if test="${order=='status'}">
						&or;
					</c:if>
				</a>
			</b>
		</td>
	</tr>

	<c:forEach var="item" items="${itemList}">
		<portlet:renderURL var='urlViewItem'>
			<portlet:param name='list' value='${list}'/>
			<portlet:param name='itemid' value='${item.id}'/>
			<portlet:param name='order' value='${order}'/>
		</portlet:renderURL>

		<tr>
			<td>		
				<aui:a href='${urlViewItem}'>
					${item.label}
				</aui:a>
			</td>
			<td>
				<c:choose>
					<c:when test="${item.weight>=16}">
						<span class='weight_highest'>
					</c:when>
					<c:when test="${item.weight>=4}">
						<span class='weight_high'>
					</c:when>
					<c:when test="${item.weight>=-4}">
						<span class='weight_normal'>
					</c:when>
					<c:when test="${item.weight>=-14}">
						<span class='weight_low'>
					</c:when>
					<c:otherwise>
						<span class='weight_lowest'>
					</c:otherwise>
				</c:choose>
				${item.weight}</span>
			</td>
			<td>
					<c:choose>
						<c:when test="${item.status==0}">
							<span class='status_normal'><liferay-ui:message key="normal" /></span>
						</c:when>
						<c:when test="${item.status==1}">
							<span class='status_waiting'><liferay-ui:message key="waiting" /></span>
						</c:when>
						<c:when test="${item.status==2}">
							<span class='status_cancelled'><liferay-ui:message key="cancelled" /></span>
						</c:when>
						<c:when test="${item.status==3}">
							<span class='status_finished'><liferay-ui:message key="finished" /></span>
						</c:when>
						<c:otherwise>
							${item.status}
						</c:otherwise>
					</c:choose>
			</td>
		</tr>
	</c:forEach>
</table>

