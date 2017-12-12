<%@ include file="../init.jsp"%>

<liferay-portlet:renderURL var="backURL">
	<portlet:param name="mvcPath" value="/htro_stoc/viewStoc.jsp"></portlet:param>
</liferay-portlet:renderURL>

<liferay-portlet:actionURL name="RezervaAction" var="rezervaActionURL"></liferay-portlet:actionURL>

<%
	int carNo = ParamUtil.getInteger(request, "carNo");
	User currentUser = themeDisplay.getUser();
	String dealerID = (String) currentUser.getExpandoBridge().getAttribute("DealerId");
	String userLogin = currentUser.getLogin();
	String userFullName = currentUser.getFullName();
	String numeVanzator=userFullName;
	System.out.println("userLogin-rezerva =>>>" + userLogin);
	System.out.println("dealerID-rezerva =>>>" + dealerID);
	System.out.println("userFullName-rezerva =>>>" + userFullName);
%>

<aui:form action="<%=rezervaActionURL%>" name="<portlet:namespace />fm">
	<aui:fieldset-group markupView="lexicon">
		<h3>Rezervare Noua - Introduceti detaliile:</h3>
		<aui:fieldset>
			<%-- 			<aui:input name="tipRezervare" label="Tip Rezervare" title="Tip Rezervare" /> --%>
			<aui:select label="Tip Rezervare" name="tipRezervare" showEmptyOption="true" required="true" showRequiredLabel="true">
				<aui:option label="Ferma" value="Ferma" />
				<aui:option label="Temporara" value="Temporara" />
			</aui:select>
			<aui:input name="numeClient" label="Nume Client" title="Nume Client">
				<aui:validator name="required" errorMessage="Nume client invalid. Introduceti numele clientului." />
			</aui:input>
			<aui:input name="numeVanzator" label="Nume Vanzator" title="Nume Vanzator">
			<aui:validator name="required" errorMessage="Nume Vanzator invalid. Introduceti numele Vanzatorului." />
			</aui:input>
			<aui:input name="carNo" label="ID Automobil" title="ID Automobil" />
			<aui:input name="dealerID" label="DealerID" title="DealerID" />

<%-- 			<aui:input name="age" value='' label="Age"> --%>
<%-- 				<aui:validator name="custom" errorMessage="You must have 18 years or more"> --%>
<!-- function (val, fieldNode, ruleValue) { -->
<!-- var result = false; -->
<!-- //alert(val); -->
<!-- if (val >=18) { -->
<!-- result = true; -->
<!-- } -->
<!-- return result; -->
<!-- } -->
<%-- </aui:validator> --%>
<%-- 			</aui:input> --%>

		</aui:fieldset>
	</aui:fieldset-group>
	<aui:button-row>
		<aui:button type="submit" value="Rezerva" />
		<aui:button onClick="<%=backURL.toString()%>" type="cancel" />
	</aui:button-row>
</aui:form>
