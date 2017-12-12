<%@ include file="../init.jsp"%>
<%
	User currentUser = themeDisplay.getUser();
	String dealerID = (String) currentUser.getExpandoBridge().getAttribute("DealerId");
	String userFullName = currentUser.getFullName();
	
	String mvcPath = ParamUtil.getString(request, "mvcPath");
	ResultRow row = (ResultRow) request.getAttribute("SEARCH_CONTAINER_RESULT_ROW");
	StocItem stocItem = (StocItem) row.getObject();

	String rezervata = stocItem.getREZERVATA();
	boolean validateAction = false;
	if (rezervata.equalsIgnoreCase("N")) {
		validateAction = true;
		System.out.println("rezervata =>>>" + rezervata);
	}
%>

<c:if test="<%=validateAction%>">

	<portlet:renderURL var="rezervaURL">
		<portlet:param name="carNo" value="<%=String.valueOf(stocItem.getHTRO_CAR_NO())%>" />
		<portlet:param name="numeVanzator" value="<%=userFullName%>" />
		<portlet:param name="dealerID" value="<%=dealerID%>" />
		<%-- 	<portlet:param name="dealerID" value="<%=stocItem.getRES_DEALER_ID()%>" /> --%>
		<portlet:param name="mvcPath" value="/htro_actions/rezerva.jsp"></portlet:param>
	</portlet:renderURL>

	<aui:button-row>
		<aui:button onClick="<%=rezervaURL.toString()%>" value="Rezerva"></aui:button>
	</aui:button-row>

</c:if>