package com.logika.custom.honda.dealerapp.controller.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.logika.custom.honda.dealerapp.controller.dao.PortofoliuItemDAO;
import com.logika.custom.honda.dealerapp.controller.dao.StocItemDAO;
import com.logika.custom.honda.dealerapp.model.PortofoliuItem;
import com.logika.custom.honda.dealerapp.model.StocItem;

public class DBConnection {

	// private String jdbcHost = "207.129.208.16";
	// private String jdbcPort = "1522";
	// private String jdbcSID = "TEST";
	// private String jdbcURL = "jdbc:oracle:thin:@" + jdbcHost + ":" + jdbcPort
	// + ":" + jdbcSID;
	// private String jdbcUsername = "apps";
	// private String jdbcPassword = "apps";
	// private String DATASOURCE_CONTEXT = "java:comp/env/jdbc/MyDataSource";
	// private Context initialContext;

	private String dsname = null;
	private DataSource dataSource;
	private Connection jdbcConnection;
	private CallableStatement statement = null;

	public static DBConnection getInstance() {
		return SingletonHolder.SINGLETON;
	}

	
	public void UpdateCustomerName(int carNo, String customerName) {

		/*
		 * create or replace package hnd_dealer_app_pkg as 
		 * procedure create_reservation(p_htro_car_no number, p_dealer_id number, p_reservation_type varchar2, p_customer_name varchar2, p_salesmen_name varchar2);
		 * procedure cancel_reservation(p_htro_car_no number); 
		 * procedure update_reservation(p_htro_car_no number);
		 * procedure update_customer_name(p_htro_car_no number, p_customer_name varchar2); 
		 * end;
		 */

		final String procedureCall = "{call apps.hnd_dealer_app_pkg.update_customer_name(?,?)}";
		try {
			statement = jdbcConnection.prepareCall(procedureCall);
			statement.setInt(1, carNo);
			statement.setString(2, customerName);
			statement.execute();

		} catch (Exception e) {
			System.out.println("Error extracting " + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if (!statement.isClosed())
					statement.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}

		}

	}
	
	public void setFirmRezervation(int carNo) {

		/*
		 * create or replace package hnd_dealer_app_pkg as 
		 * procedure create_reservation(p_htro_car_no number, p_dealer_id number, p_reservation_type varchar2, p_customer_name varchar2, p_salesmen_name varchar2);
		 * procedure cancel_reservation(p_htro_car_no number); 
		 * procedure update_reservation(p_htro_car_no number);
		 * procedure update_customer_name(p_htro_car_no number, p_customer_name varchar2); 
		 * end;
		 */

		final String procedureCall = "{call apps.hnd_dealer_app_pkg.update_reservation(?)}";
		try {
			statement = jdbcConnection.prepareCall(procedureCall);
			statement.setInt(1, carNo);
			statement.execute();

		} catch (Exception e) {
			System.out.println("Error extracting " + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if (!statement.isClosed())
					statement.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}

		}

	}
	
	public void CancelRezervation(int carNo) {

		/*
		 * create or replace package hnd_dealer_app_pkg as procedure create_reservation(p_htro_car_no number,
		 * p_dealer_id number, p_reservation_type varchar2, p_customer_name varchar2, p_salesmen_name varchar2);
		 * procedure cancel_reservation(p_htro_car_no number); procedure update_reservation(p_htro_car_no number);
		 * procedure update_customer_name(p_htro_car_no number, p_customer_name varchar2); end;
		 */

		final String procedureCall = "{call apps.hnd_dealer_app_pkg.cancel_reservation(?)}";
		try {
			statement = jdbcConnection.prepareCall(procedureCall);
			statement.setInt(1, carNo);
			statement.execute();

		} catch (Exception e) {
			System.out.println("Error extracting " + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if (!statement.isClosed())
					statement.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}

		}

	}

	public void MakeRezervation(int carNo, int dealerID, String rezervationType, String customerName,
			String salesmenName) {

		/*
		 * create or replace package hnd_dealer_app_pkg as 
		 * procedure create_reservation(p_htro_car_no number, p_dealer_id number, p_reservation_type varchar2, p_customer_name varchar2, p_salesmen_name varchar2);
		 * procedure cancel_reservation(p_htro_car_no number); procedure update_reservation(p_htro_car_no number);
		 * procedure update_customer_name(p_htro_car_no number, p_customer_name varchar2); end;
		 */

		final String procedureCall = "{call apps.hnd_dealer_app_pkg.create_reservation(?,?,?,?,?)}";
		try {
			statement = jdbcConnection.prepareCall(procedureCall);

			statement.setInt(1, carNo);
			statement.setInt(2, dealerID);
			statement.setString(3, rezervationType);
			statement.setString(4, customerName);
			statement.setString(5, salesmenName);

			statement.execute();

		} catch (Exception e) {
			System.out.println("Error extracting " + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if (!statement.isClosed())
					statement.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}

		}

	}

	public List<PortofoliuItem> GetAllPortofoliuItems() {
		PortofoliuItemDAO portofoliuItemDAO = new PortofoliuItemDAO(jdbcConnection);
		try {
			return portofoliuItemDAO.ListAllPortofoliuItems();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return new ArrayList<PortofoliuItem>();
	}
	
	public List<PortofoliuItem> GetAllPortofoliuItems(String dealerID, int start, int end) {
		PortofoliuItemDAO portofoliuItemDAO = new PortofoliuItemDAO(jdbcConnection);
		try {
			return portofoliuItemDAO.ListAllPortofoliuItems(dealerID, start, end);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return new ArrayList<PortofoliuItem>();
	}

	public List<PortofoliuItem> GetAllPortofoliuItemsOnUser(String dealerID) {
		PortofoliuItemDAO portofoliuItemDAO = new PortofoliuItemDAO(jdbcConnection);
		try {
			return portofoliuItemDAO.ListAllPortofoliuItemsOnUser(dealerID);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return new ArrayList<PortofoliuItem>();
	}

	public List<StocItem> GetAllStocItems() {
		StocItemDAO stocItemDAO = new StocItemDAO(jdbcConnection);
		try {
			return stocItemDAO.ListAllStocItems();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return new ArrayList<StocItem>();
	}
	
	public List<StocItem> GetAllStocItems(int start, int end) {
		StocItemDAO stocItemDAO = new StocItemDAO(jdbcConnection);
		try {
			return stocItemDAO.ListAllStocItems(start, end);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return new ArrayList<StocItem>();
	}

	public List<PortofoliuItem> GetFilteredPortofoliuItems(String filter1,String dealerID) {
		PortofoliuItemDAO portofoliuItemDAO = new PortofoliuItemDAO(jdbcConnection);
		try {
			return portofoliuItemDAO.ListFilterPortofoliuItems(filter1,dealerID);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return new ArrayList<PortofoliuItem>();
	}

	public List<StocItem> GetFilteredStocItems(String filter1, String filter2) {
		StocItemDAO stocItemDAO = new StocItemDAO(jdbcConnection);
		try {
			return stocItemDAO.ListFilteredStocItems(filter1, filter2);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return new ArrayList<StocItem>();
	}

	public List<String> GetPortofoliuTipAuto() {
		PortofoliuItemDAO portofoliuItemDAO = new PortofoliuItemDAO(jdbcConnection);
		try {
			return portofoliuItemDAO.List_Port_Tip_Auto();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return new ArrayList<String>();
	}

	public List<String> GetStocCuloareExt(String culoare_ext) {
		StocItemDAO stocItemDAO = new StocItemDAO(jdbcConnection);
		try {
			return stocItemDAO.List_Culoare_Ext(culoare_ext);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return new ArrayList<String>();
	}

	public List<String> GetStocTipAuto(String model_auto) {
		StocItemDAO stocItemDAO = new StocItemDAO(jdbcConnection);
		try {
			return stocItemDAO.List_Tip_Auto(model_auto);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return new ArrayList<String>();
	}

	private DBConnection() {

		Thread thread = Thread.currentThread();
		// Get the thread's class loader. You'll reinstate it after using
		// the data source you look up using JNDI
		ClassLoader origLoader = thread.getContextClassLoader();
		// Set Liferay's class loader on the thread
		thread.setContextClassLoader(PortalClassLoaderUtil.getClassLoader());
		try {
			// Retrieve the name of the JNDI Datasource from
			// portal-ext.properties
			dsname = PropsUtil.get("jdbc.external.jndi.name");
			// Look up the data source and connect to it
			InitialContext iContext = new InitialContext();
			// dataSource = (DataSource) iContext.lookup("java:comp/env/jdbc/CustomDBPoolShared");
			dataSource = (DataSource) iContext.lookup("java:comp/env/" + dsname);
			jdbcConnection = dataSource.getConnection();

		} catch (NamingException ne) {
			ne.printStackTrace();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			// Switch back to the original context class loader
			thread.setContextClassLoader(origLoader);
		}
	}

	private static final class SingletonHolder {
		private static final DBConnection SINGLETON = new DBConnection();

	}

}