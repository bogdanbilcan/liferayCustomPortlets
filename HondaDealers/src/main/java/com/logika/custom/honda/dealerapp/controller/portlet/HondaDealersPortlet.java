package com.logika.custom.honda.dealerapp.controller.portlet;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.logika.custom.honda.dealerapp.controller.constants.HondaDealersPortletKeys;
import com.logika.custom.honda.dealerapp.controller.service.DBConnection;
import com.logika.custom.honda.dealerapp.model.PortofoliuItem;
import com.logika.custom.honda.dealerapp.model.StocItem;

/**
 * @author admin
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=false", "javax.portlet.display-name=HondaDealers Application",
		"com.liferay.portlet.scopeable=true", "javax.portlet.expiration-cache=0",
		"javax.portlet.init-param.template-path=/", "javax.portlet.init-param.view-template=/htro_stoc/viewStoc.jsp",
		"javax.portlet.name=" + HondaDealersPortletKeys.HondaDealers, "javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.supports.mime-type=text/html" }, service = Portlet.class)

public class HondaDealersPortlet extends MVCPortlet {

	public void AnulareRezervareAction(ActionRequest request, ActionResponse response)
			throws IOException, PortletException {

		try {

			/*
			 * <aui:input name="Tip Rezervare" /> <aui:input name="carNo" label="ID Automobil" title="ID Automobil" />
			 * <aui:input name="HTRO_CAR_NO" type="hidden" /> <aui:input name="ExtraParam" type="hidden" />
			 */

			int carNo = ParamUtil.getInteger(request, "carNo");

			System.out.println("AnulareRezervareAction - carNO ===>" + carNo);

			System.out.println(
					"AnulareRezervareAction - Calling DB PKG --call hnd_dealer_app_pkg.CancelRezervation()-- with the above parameters.");

			DBConnection.getInstance().CancelRezervation(carNo);

		} catch (Exception ex) {
			Logger.getLogger(HondaDealersPortlet.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	public void SetareRezervareFermaAction(ActionRequest request, ActionResponse response)
			throws IOException, PortletException {

		try {

			/*
			 * <aui:input name="Tip Rezervare" /> <aui:input name="carNo" label="ID Automobil" title="ID Automobil" />
			 * <aui:input name="HTRO_CAR_NO" type="hidden" /> <aui:input name="ExtraParam" type="hidden" />
			 */

			String tipRezervare = ParamUtil.getString(request, "tipRezervare");
			int carNo = ParamUtil.getInteger(request, "carNo");

			System.out.println("SetareRezervareFermaAction - tipRezervare ===>" + tipRezervare);
			System.out.println("SetareRezervareFermaAction - carNO ===>" + carNo);

			System.out.println(
					"SetareRezervareFermaAction - Calling DB PKG --call hnd_dealer_app_pkg.setFirmRezervation()-- with the above parameters.");

			DBConnection.getInstance().setFirmRezervation(carNo);

		} catch (Exception ex) {
			Logger.getLogger(HondaDealersPortlet.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	public void UpdateNumeClientAction(ActionRequest request, ActionResponse response)
			throws IOException, PortletException {

		try {
			/*
			 * <aui:input name="Tip Rezervare" /> <aui:input name="carNo" label="ID Automobil" title="ID Automobil" />
			 * <aui:input name="HTRO_CAR_NO" type="hidden" /> <aui:input name="ExtraParam" type="hidden" />
			 */

			String tipRezervare = ParamUtil.getString(request, "tipRezervare");
			String numeClient = ParamUtil.getString(request, "numeClient");
			int carNo = ParamUtil.getInteger(request, "carNo");

			System.out.println("UpdateNumeClientAction - tipRezervare ===>" + tipRezervare);
			System.out.println("UpdateNumeClientAction - carNO ===>" + carNo);
			System.out.println("UpdateNumeClientAction - numeClient ===>" + numeClient);

			System.out.println(
					"UpdateNumeClientAction - Calling DB PKG --call hnd_dealer_app_pkg.UpdateCustomerName()-- with the above parameters.");

			DBConnection.getInstance().UpdateCustomerName(carNo, numeClient);

		} catch (Exception ex) {
			Logger.getLogger(HondaDealersPortlet.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	public void RezervaAction(ActionRequest request, ActionResponse response) throws IOException, PortletException {

		try {

			/*
			 * <aui:input name="Tip Rezervare" /> 
			 * <aui:input name="Nume Client" /> 
			 * <aui:input name="Nume Vanzator" />
			 * <aui:input name="HTRO_CAR_NO" type="hidden" /> 
			 * <aui:input name="ExtraParam" type="hidden" />
			 */

			String tipRezervare = ParamUtil.getString(request, "tipRezervare");
			String numeClient = ParamUtil.getString(request, "numeClient");
			String numeVanzator = ParamUtil.getString(request, "numeVanzator");
			int carNo = ParamUtil.getInteger(request, "carNo");
			int dealerID = ParamUtil.getInteger(request, "dealerID");

			if (tipRezervare.equalsIgnoreCase("Ferma")) {
				tipRezervare = "FIRM";
			}
			else 
				if (tipRezervare.equalsIgnoreCase("Temporara")) {
					tipRezervare="NOT FIRM";
				}

			System.out.println("RezervaAction - tipRezervare ===>" + tipRezervare);
			System.out.println("RezervaAction - numeClient ===>" + numeClient);
			System.out.println("RezervaAction - numeVanzator ===>" + numeVanzator);
			System.out.println("RezervaAction - carNO ===>" + carNo);
			System.out.println("RezervaAction - dealerID ===>" + dealerID);

			System.out.println(
					"RezervaAction - Calling DB PKG --call hnd_dealer_app_pkg.create_reservation()-- with the above parameters.");

			DBConnection.getInstance().MakeRezervation(carNo, dealerID, tipRezervare, numeClient, numeVanzator);

			// PortletPreferences prefs = request.getPreferences();
			// prefs.setValues("guestbook-entries", array);
			//
			// try {
			// prefs.store();
			// }
			// catch (IOException ex) {
			// Logger.getLogger(HondaDealersPortlet.class.getName()).log(
			// Level.SEVERE, null, ex);
			// }
			// catch (ValidatorException ex) {
			// Logger.getLogger(HondaDealersPortlet.class.getName()).log(
			// Level.SEVERE, null, ex);
			// }

		} catch (Exception ex) {
			Logger.getLogger(HondaDealersPortlet.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		try {
			// PortletPreferences prefs = renderRequest.getPreferences();

			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			User currentUser = themeDisplay.getUser();
			String dealerIDValue = (String) currentUser.getExpandoBridge().getAttribute("DealerId");

			System.out.println("dealerIDValue java===>" + dealerIDValue);

			List<StocItem> stocItems = DBConnection.getInstance().GetAllStocItems();
			// List<PortofoliuItem> portofoliuItems =
			// DBConnection.getInstance().GetAllPortofoliuItemsOnUser(dealerIDValue);

			// renderRequest.setAttribute("portofoliuItems", portofoliuItems);
			renderRequest.setAttribute("stocItems", stocItems);
			renderRequest.setAttribute("dealerIDValue", dealerIDValue);

		} catch (Exception e) {
			throw new PortletException(e);
		}
		super.render(renderRequest, renderResponse);
	}

}