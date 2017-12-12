<%@ include file="../init.jsp"%>

<liferay-portlet:renderURL var="backURL">
	<portlet:param name="mvcPath" value="/htro_portofoliu/viewPortofoliu.jsp"></portlet:param>
</liferay-portlet:renderURL>

<liferay-portlet:actionURL name="UpdateNumeClientAction" var="updateNumeClientActionURL"></liferay-portlet:actionURL>

<%
	int carNo = ParamUtil.getInteger(request, "carNo");
%>

<aui:form action="<%=updateNumeClientActionURL%>" name="<portlet:namespace />fm">
	<aui:fieldset-group markupView="lexicon">
	<h3>Rezervare Noua - Introduceti detaliile:</h3>
		<aui:fieldset>
		
			<aui:input name="numeClient" label="Nume Client" title="Nume Client" />
			<aui:input name="carNo" label="ID Automobil" title="ID Automobil" />
			<aui:input name="tipRezervare" label="Tip Rezervare" title="Tip Rezervare" />
			
		</aui:fieldset>
	</aui:fieldset-group>
	<aui:button-row>
		<aui:button type="submit" value="Actualizati Nume Client" onClick="<%=backURL.toString()%>"/>
		<aui:button onClick="<%=backURL.toString()%>" type="cancel" />
	</aui:button-row>
</aui:form>
