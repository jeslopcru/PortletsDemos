<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet" %>  
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>

<%@ page import="com.liferay.portal.kernel.util.StringUtil" %>
<%@ page import="com.liferay.portal.security.permission.PermissionChecker" %>

<portlet:defineObjects />  
<liferay-theme:defineObjects />

<%
         long groupId = themeDisplay.getPortletGroupId();
         String name = themeDisplay.getPortletDisplay().getRootPortletId();
         String primKey = themeDisplay.getPortletDisplay().getResourcePK();
%>
