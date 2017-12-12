<%@ include file="../init.jsp"%>

<liferay-portlet:renderURL var="backURL">
	<portlet:param name="mvcPath" value="/htro_portofoliu/viewPortofoliu.jsp"></portlet:param>
</liferay-portlet:renderURL>

<liferay-portlet:actionURL name="AnulareRezervareAction" var="AnulareRezervareActionURL"></liferay-portlet:actionURL>

<%
	int carNo = ParamUtil.getInteger(request, "carNo");
	String tipRezervare = ParamUtil.getString(request, "tipRezervare");
	boolean validateAction = false;
	if (tipRezervare.equalsIgnoreCase("Temporara")) {
		validateAction = true;
		System.out.println("tipRezervare =>>>" + tipRezervare);
	}
	System.out.println("carNo =>>>" + carNo);
%>

<aui:form action="<%=AnulareRezervareActionURL%>" name="<portlet:namespace />fm">
	<aui:fieldset-group markupView="lexicon">
		<h3>Anulare Rezervare:</h3>
		<aui:fieldset>

			<div class="alert alert-danger">
				<strong class="lead">ATENTIE: Actiune ireversibila !! </strong>
				<p>
					Apasati <strong> Anulati Rezervarea </strong> pentru a continua sau <strong> Cancel </strong> pentru
					a renunta!
				</p>
			</div>

			<aui:input name="carNo" label="ID Automobil" title="ID Automobil" />
			<aui:input name="tipRezervare" label="Tip Rezervare" title="Tip Rezervare" value="Temporara" />

		</aui:fieldset>
	</aui:fieldset-group>
	<aui:button-row>
		<aui:button type="submit" value="Anulati Rezervarea" onClick="<%=backURL.toString()%>"/>
		<aui:button onClick="<%=backURL.toString()%>" type="cancel" />
	</aui:button-row>
</aui:form>
