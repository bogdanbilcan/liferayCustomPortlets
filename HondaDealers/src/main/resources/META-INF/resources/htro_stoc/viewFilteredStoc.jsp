<%@ include file="../init.jsp"%>

<%
	String keywords1 = (String) ParamUtil.getString(request, "keywords1");
	String keywords2 = (String) ParamUtil.getString(request, "keywords2");

	System.out.println("keywords1 stocFiltered==> " + keywords1);
	System.out.println("keywords2 stocFiltered==> " + keywords2);
	
	List<StocItem> stocItems1 = DBConnection.getInstance().GetFilteredStocItems(keywords1, keywords2);
	
	System.out.println("stocItems1.isEmpty() stocFiltered==> " + stocItems1.isEmpty());
	
	String noResults = "Nu s-au gasit automobile in baza de date conform filtrelor aplicate.";
%>

<liferay-portlet:renderURL varImpl="cautaURL">
	<portlet:param name="mvcPath" value="/htro_stoc/viewFilteredStoc.jsp" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL var="portofoliuURL">
	<portlet:param name="mvcPath" value="/htro_portofoliu/viewPortofoliu.jsp" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL var="rezervaURL">
	<portlet:param name="mvcPath" value="/htro_actions/rezerva.jsp" />
</liferay-portlet:renderURL>


<aui:form action="<%=cautaURL%>" method="get" name="fm">
	<liferay-ui:header title="Filtrare Lista Automobile" />
	<liferay-portlet:renderURLParams varImpl="cautaURL" />
	<div class="search-form">
		<span class="aui-search-bar"> 
		<aui:input label="Tip Auto" name="keywords1" size="30" type="text" /> 
		<aui:input label="Culoare" name="keywords2" size="30" type="text" />
		
			 <aui:button-row>
				<aui:button type="submit" value="Filtreaza" />
				<aui:button onClick="<%=portofoliuURL.toString()%>" value="Deschide Portofoliu" />
			</aui:button-row>

		</span>
	</div>
</aui:form>


<!-- <div class="container-fluid-1280"> -->
	<liferay-ui:search-container id="viewFilteredStocSearch" deltaConfigurable="true" emptyResultsMessage="<%=noResults%>" total="<%=stocItems1.size()%>">

<liferay-ui:search-container-results results="<%=stocItems1.subList(searchContainer.getStart(),((searchContainer.getEnd() < stocItems1.size()) ? searchContainer.getEnd():stocItems1.size()))%>"/>
<%-- <liferay-ui:search-container-results results="<%=DBConnection.getInstance().GetAllStocItems(searchContainer.getStart(),searchContainer.getEnd())%>"	/> --%>
		
		<liferay-ui:search-container-row className="StocItem" keyProperty="HTRO_CAR_NO" modelVar="stocItem" escapedModel="<%=true%>">
			<liferay-ui:search-container-column-jsp align="left" path="/htro_actions/butonRezerva.jsp" name="Actiuni" />
<%-- 		<liferay-ui:search-container-column-text property="HTRO_CAR_NO" /> --%>
<%-- 		<liferay-ui:search-container-column-text property="RES_DEALER_ID" /> --%>
		<liferay-ui:search-container-column-text property="AN_FABRICATIE_CIV" name="An Fabricatie CIV"/>
		<liferay-ui:search-container-column-text property="TIP_AUTOVEHICUL" name="Tip Autovehicul"/>
		<liferay-ui:search-container-column-text property="COD_CULOARE_EXTERIO" name="Cod Culoare Exterior" />
		<liferay-ui:search-container-column-text property="DESC_CULOARE_EXTERIOR" name="Culoare Exterior" />
		<liferay-ui:search-container-column-text property="VOPSEA_METALIZATA" name="Vopsea Metalizata" />
		<liferay-ui:search-container-column-text property="CULOARE_INTERIOR" name="Culoare Interior" />
		<liferay-ui:search-container-column-text property="OBSERVATII" name="Observatii" />
		<liferay-ui:search-container-column-text property="LOCATIE" name="Locatie" />
		<liferay-ui:search-container-column-text property="OMOLOGARE_IND" name="Omologare Individuala" />
		<liferay-ui:search-container-column-text property="LUNA_SOSIRE_IN_TARA" name="Luna sosire in tara" />
		<liferay-ui:search-container-column-text property="REZERVATA" name="Rezervata" />
		<liferay-ui:search-container-column-text property="DATA_EXPIRARE_REZ" name="Data expirare rezervare" />
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator displayStyle="<%="list"%>" markupView="lexicon"/>
	</liferay-ui:search-container>
<!-- </div> -->

