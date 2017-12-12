<%@ include file="../init.jsp"%>

<liferay-portlet:renderURL var="backURL">
	<portlet:param name="mvcPath" value="/htro_portofoliu/viewPortofoliu.jsp"></portlet:param>
</liferay-portlet:renderURL>

<liferay-portlet:actionURL name="SetareRezervareFermaAction" var="SetareRezervareFermaActionURL"></liferay-portlet:actionURL>

<%
	int carNo = ParamUtil.getInteger(request, "carNo");
%>

<aui:form action="<%=SetareRezervareFermaActionURL%>" name="<portlet:namespace />fm">
	<aui:fieldset-group markupView="lexicon">
		<h3>Setare Tip Rezervare: Definitiva</h3>
		<aui:fieldset>

			<div class="alert alert-danger">
				<strong class="lead">ATENTIE: Actiune ireversibila !!</strong>
				<p>
					Apasati <strong>Setati Rezervarea</strong> pentru a continua sau <strong> Cancel </strong> pentru
					a renunta!
				</p>
			</div>

			<aui:input name="tipRezervare" label="Tip Rezervare Actuala" title="Tip Rezervare Actuala" value="Temporara" />
			<aui:input name="carNo" label="ID Automobil" title="ID Automobil" />

		</aui:fieldset>
	</aui:fieldset-group>
	<aui:button-row>
		<aui:button type="submit" value="Setati Rezervare Ferma" onClick="<%=backURL.toString()%>" />
		<aui:button onClick="<%=backURL.toString()%>" type="cancel" />
	</aui:button-row>
</aui:form>
