<%@ include file="../init.jsp"%>

<%
	User currentUser = themeDisplay.getUser();
	String dealerIdValue = (String) currentUser.getExpandoBridge().getAttribute("DealerId");
	String tipAuto = (String) ParamUtil.getString(request, "tipAuto");

	System.out.println("keywords1 portofoliuFiltered page==> " + tipAuto);
	System.out.println("dealerID portofoliuFiltered page==> " + dealerIdValue);

	String noResults = "Nu s-au gasit automobile in baza de date conform filtrelor aplicate.";

	List<PortofoliuItem> portofoliuItems1 = DBConnection.getInstance().GetFilteredPortofoliuItems(tipAuto,
			dealerIdValue);
	int listSize = portofoliuItems1.size();

	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setParameter("jspPage", "/htro_portofoliu/viewFilteredPortofoliu.jsp");
%>

<liferay-portlet:renderURL varImpl="cautaPortfURL">
<%-- 	<portlet:param name="tipAuto" value="<%=tipAuto%>" /> --%>
	<portlet:param name="mvcPath" value="/htro_portofoliu/viewFilteredPortofoliu.jsp"></portlet:param>
</liferay-portlet:renderURL>

<liferay-portlet:renderURL var="stocURL">
	<portlet:param name="mvcPath" value="/htro_stoc/viewStoc.jsp"></portlet:param>
</liferay-portlet:renderURL>

<aui:form action="<%=cautaPortfURL%>" method="get" name="fm">
	<liferay-portlet:renderURLParams varImpl="cautaPortfURL" />
	<liferay-ui:header title="<%="Filtrare Lista Automobile"%>" />
	<div class="search-form">
		<span class="aui-search-bar"> <aui:input label="<%="Tip Autovehicul"%>" name="tipAuto" size="30" type="text" />
			<aui:button-row>
				<aui:button type="submit" value="<%="Filtreaza"%>" />
				<aui:button onClick="<%=stocURL.toString()%>" value="<%="Inapoi la Stoc"%>"></aui:button>
			</aui:button-row>
		</span>
	</div>
</aui:form>

<liferay-ui:search-container id="<%="viewPortofoliuFilteredSearch"%>" iteratorURL="<%=portletURL%>"
	deltaConfigurable="<%=true%>" emptyResultsMessage="<%=noResults%>"
>

	<%--  iteratorURL="<%=portletURL%>"  --%>
	<%-- 	<liferay-ui:search-container-results results="<%=DBConnection.getInstance().GetAllPortofoliuItems(dealerIdValue, searchContainer.getStart(),searchContainer.getEnd())%>"/> --%>

	<liferay-ui:search-container-results>
		<%
			results = ListUtil.subList(portofoliuItems1, searchContainer.getStart(),
							(searchContainer.getEnd() < listSize) ? searchContainer.getEnd() : listSize);
					total = listSize;
					pageContext.setAttribute("results", results);
					pageContext.setAttribute("total", total);
					portletURL.setParameter("cur", searchContainer.getCurParam());
					System.out.println("portofoliuFiltered - Cur PRINT:" + searchContainer.getCur());
		%>
	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row className="PortofoliuItem" modelVar="portofoliuItem" keyProperty="HTRO_CAR_NO">

		<liferay-ui:search-container-column-jsp align="left" path="/htro_actions/butonActions.jsp" name="Actiuni" />
		<liferay-ui:search-container-column-text property="HTRO_CAR_NO" name="HTRO Number" />
		<liferay-ui:search-container-column-text property="RES_TYPE" name="Tip rezervare" />
		<liferay-ui:search-container-column-text property="DATA_REZ_SAU_FACTURA" name="Data rezervare/factura" />
		<liferay-ui:search-container-column-text property="DATA_EXPIRARE" name="Data expirare" />
		<%-- 		<liferay-ui:search-container-column-text property="RES_DEALER_ID" name=""/> --%>
		<%-- 		<liferay-ui:search-container-column-text property="TIP_LINIE" name=""/> --%>
		<liferay-ui:search-container-column-text property="LOCATIE" name="Locatie" />
		<%-- 		<liferay-ui:search-container-column-text property="LUNA_PRODUCTIE" name=""/> --%>
		<liferay-ui:search-container-column-text property="LUNA_SOSIRE_IN_TARA" name="Luna sosire in tara" />
		<liferay-ui:search-container-column-text property="COD_MODEL" name="Cod model" />
		<liferay-ui:search-container-column-text property="TIP_AUTOVEHICUL" name="Tip Autovehicul" />
		<liferay-ui:search-container-column-text property="COD_CULOARE_EXT" name="Cod Culoare" />
		<liferay-ui:search-container-column-text property="CULOARE_EXTERIOR" name="Culoare exterior" />
		<liferay-ui:search-container-column-text property="CULOARE_INTERIOR" name="Culoare interior" />
		<liferay-ui:search-container-column-text property="OBSERVATII" name="Observatii" />
		<liferay-ui:search-container-column-text property="NUME_CLIENT" name="Nume client" />
		<liferay-ui:search-container-column-text property="NUME_VANZATOR" name="Nume vanzator" />
		<liferay-ui:search-container-column-text property="VIN" name="VIN no" />
		<liferay-ui:search-container-column-text property="ENGINE_NO" name="Engine no" />
		<liferay-ui:search-container-column-text property="AN_FABRICATIE_CF_CIV" name="An de Fabricatie CIV" />
		<liferay-ui:search-container-column-text property="OMOLOGARE_INDIVIDUALA" name="Omologare individuala" />
		<liferay-ui:search-container-column-text property="PRET_LISTA" name="Pret lista" />
		<liferay-ui:search-container-column-text property="DISCOUNT_STANDARD" name="Discount standard" />
		<liferay-ui:search-container-column-text property="DISCOUNT_SUPLIMENTAR" name="Discount suplimentar" />
		<liferay-ui:search-container-column-text property="PRET_FINAL" name="Pret final" />
		<liferay-ui:search-container-column-text property="AVANS_PLATIT" name="Avans platit" />
		<liferay-ui:search-container-column-text property="REST_DE_PLATA" name="Rest de plata" />
		<%-- 		<liferay-ui:search-container-column-text property="CUSTOMER_TRX_ID" name=""/> --%>

	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator displayStyle="<%="list"%>" markupView="lexicon" />
</liferay-ui:search-container>
