package com.logika.custom.honda.dealerapp.controller.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.logika.custom.honda.dealerapp.model.PortofoliuItem;

public class PortofoliuItemDAO {

	public PortofoliuItemDAO(Connection jdbcConnection) {
		this.jdbcConnection = jdbcConnection;
	}

	public List<String> List_Port_Tip_Auto() throws SQLException {
		List<String> ListPortTipAuto = new ArrayList<>();

		String sql = "SELECT TIP_AUTOVEHICUL FROM HND_DEALER_PORTOFOLIO_V";
		Statement statement = jdbcConnection.createStatement();

		ResultSet resultSet = statement.executeQuery(sql);

		while (resultSet.next()) {
			String TIP_AUTOVEHICUL = resultSet.getString("TIP_AUTOVEHICUL");
			ListPortTipAuto.add(TIP_AUTOVEHICUL);
		}

		resultSet.close();
		statement.close();

		return ListPortTipAuto;
	}

	public List<PortofoliuItem> ListAllPortofoliuItems(String dealerID, int start, int end) throws SQLException {
		List<PortofoliuItem> listPortofoliuItems = new ArrayList<>();
		String sql = "SELECT * FROM ( SELECT rownum rnum, a.* FROM HND_DEALER_PORTOFOLIO_V a ORDER BY HTRO_CAR_NO )WHERE RES_DEALER_ID=" + dealerID +" AND rnum BETWEEN "
				+ start + " AND " + end;
		Statement statement = jdbcConnection.createStatement();

		ResultSet resultSet = statement.executeQuery(sql);

		while (resultSet.next()) {
			int HTRO_CAR_NO = resultSet.getInt("HTRO_CAR_NO");
			String DATA_REZ_SAU_FACTURA = resultSet.getString("DATA_REZ_SAU_FACTURA");
			String DATA_EXPIRARE = resultSet.getString("DATA_EXPIRARE");
			int RES_DEALER_ID = resultSet.getInt("RES_DEALER_ID");
			String TIP_LINIE = resultSet.getString("TIP_LINIE");
			String RES_TYPE = resultSet.getString("RES_TYPE");
			String LOCATIE = resultSet.getString("LOCATIE");
			String LUNA_PRODUCTIE = resultSet.getString("LUNA_PRODUCTIE");
			String LUNA_SOSIRE_IN_TARA = resultSet.getString("LUNA_SOSIRE_IN_TARA");
			String COD_MODEL = resultSet.getString("COD_MODEL");
			String TIP_AUTOVEHICUL = resultSet.getString("TIP_AUTOVEHICUL");
			String COD_CULOARE_EXT = resultSet.getString("COD_CULOARE_EXT");
			String CULOARE_EXTERIOR = resultSet.getString("CULOARE_EXTERIOR");
			String CULOARE_INTERIOR = resultSet.getString("CULOARE_INTERIOR");
			String OBSERVATII = resultSet.getString("OBSERVATII");
			String NUME_CLIENT = resultSet.getString("NUME_CLIENT");
			String NUME_VANZATOR = resultSet.getString("NUME_VANZATOR");
			String VIN = resultSet.getString("VIN");
			String ENGINE_NO = resultSet.getString("ENGINE_NO");
			int AN_FABRICATIE_CF_CIV = resultSet.getInt("AN_FABRICATIE_CF_CIV");
			String OMOLOGARE_INDIVIDUALA = resultSet.getString("OMOLOGARE_INDIVIDUALA");
			int PRET_LISTA = resultSet.getInt("PRET_LISTA");
			int DISCOUNT_STANDARD = resultSet.getInt("DISCOUNT_STANDARD");
			int DISCOUNT_SUPLIMENTAR = resultSet.getInt("DISCOUNT_SUPLIMENTAR");
			int PRET_FINAL = resultSet.getInt("PRET_FINAL");
			int AVANS_PLATIT = resultSet.getInt("AVANS_PLATIT");
			int REST_DE_PLATA = resultSet.getInt("REST_DE_PLATA");
			int CUSTOMER_TRX_ID = resultSet.getInt("CUSTOMER_TRX_ID");

			PortofoliuItem portofoliuItem = new PortofoliuItem(HTRO_CAR_NO, DATA_REZ_SAU_FACTURA, DATA_EXPIRARE,
					RES_DEALER_ID, TIP_LINIE, RES_TYPE, LOCATIE, LUNA_PRODUCTIE, LUNA_SOSIRE_IN_TARA, COD_MODEL,
					TIP_AUTOVEHICUL, COD_CULOARE_EXT, CULOARE_EXTERIOR, CULOARE_INTERIOR, OBSERVATII, NUME_CLIENT,
					NUME_VANZATOR, VIN, ENGINE_NO, AN_FABRICATIE_CF_CIV, OMOLOGARE_INDIVIDUALA, PRET_LISTA,
					DISCOUNT_STANDARD, DISCOUNT_SUPLIMENTAR, PRET_FINAL, AVANS_PLATIT, REST_DE_PLATA, CUSTOMER_TRX_ID);

			listPortofoliuItems.add(portofoliuItem);
		}

		resultSet.close();
		statement.close();

		return listPortofoliuItems;
	}

	public List<PortofoliuItem> ListAllPortofoliuItems() throws SQLException {
		List<PortofoliuItem> listPortofoliuItems = new ArrayList<>();
		String sql = "SELECT * FROM HND_DEALER_PORTOFOLIO_V";
		Statement statement = jdbcConnection.createStatement();

		ResultSet resultSet = statement.executeQuery(sql);

		while (resultSet.next()) {
			int HTRO_CAR_NO = resultSet.getInt("HTRO_CAR_NO");
			String DATA_REZ_SAU_FACTURA = resultSet.getString("DATA_REZ_SAU_FACTURA");
			String DATA_EXPIRARE = resultSet.getString("DATA_EXPIRARE");
			int RES_DEALER_ID = resultSet.getInt("RES_DEALER_ID");
			String TIP_LINIE = resultSet.getString("TIP_LINIE");
			String RES_TYPE = resultSet.getString("RES_TYPE");
			String LOCATIE = resultSet.getString("LOCATIE");
			String LUNA_PRODUCTIE = resultSet.getString("LUNA_PRODUCTIE");
			String LUNA_SOSIRE_IN_TARA = resultSet.getString("LUNA_SOSIRE_IN_TARA");
			String COD_MODEL = resultSet.getString("COD_MODEL");
			String TIP_AUTOVEHICUL = resultSet.getString("TIP_AUTOVEHICUL");
			String COD_CULOARE_EXT = resultSet.getString("COD_CULOARE_EXT");
			String CULOARE_EXTERIOR = resultSet.getString("CULOARE_EXTERIOR");
			String CULOARE_INTERIOR = resultSet.getString("CULOARE_INTERIOR");
			String OBSERVATII = resultSet.getString("OBSERVATII");
			String NUME_CLIENT = resultSet.getString("NUME_CLIENT");
			String NUME_VANZATOR = resultSet.getString("NUME_VANZATOR");
			String VIN = resultSet.getString("VIN");
			String ENGINE_NO = resultSet.getString("ENGINE_NO");
			int AN_FABRICATIE_CF_CIV = resultSet.getInt("AN_FABRICATIE_CF_CIV");
			String OMOLOGARE_INDIVIDUALA = resultSet.getString("OMOLOGARE_INDIVIDUALA");
			int PRET_LISTA = resultSet.getInt("PRET_LISTA");
			int DISCOUNT_STANDARD = resultSet.getInt("DISCOUNT_STANDARD");
			int DISCOUNT_SUPLIMENTAR = resultSet.getInt("DISCOUNT_SUPLIMENTAR");
			int PRET_FINAL = resultSet.getInt("PRET_FINAL");
			int AVANS_PLATIT = resultSet.getInt("AVANS_PLATIT");
			int REST_DE_PLATA = resultSet.getInt("REST_DE_PLATA");
			int CUSTOMER_TRX_ID = resultSet.getInt("CUSTOMER_TRX_ID");

			PortofoliuItem portofoliuItem = new PortofoliuItem(HTRO_CAR_NO, DATA_REZ_SAU_FACTURA, DATA_EXPIRARE,
					RES_DEALER_ID, TIP_LINIE, RES_TYPE, LOCATIE, LUNA_PRODUCTIE, LUNA_SOSIRE_IN_TARA, COD_MODEL,
					TIP_AUTOVEHICUL, COD_CULOARE_EXT, CULOARE_EXTERIOR, CULOARE_INTERIOR, OBSERVATII, NUME_CLIENT,
					NUME_VANZATOR, VIN, ENGINE_NO, AN_FABRICATIE_CF_CIV, OMOLOGARE_INDIVIDUALA, PRET_LISTA,
					DISCOUNT_STANDARD, DISCOUNT_SUPLIMENTAR, PRET_FINAL, AVANS_PLATIT, REST_DE_PLATA, CUSTOMER_TRX_ID);

			listPortofoliuItems.add(portofoliuItem);
		}

		resultSet.close();
		statement.close();

		return listPortofoliuItems;
	}

	public List<PortofoliuItem> ListAllPortofoliuItemsOnUser(String dealerID) throws SQLException {

		List<PortofoliuItem> listPortofoliuItems = new ArrayList<PortofoliuItem>();
		String sql = "SELECT * FROM HND_DEALER_PORTOFOLIO_V WHERE RES_DEALER_ID=" + dealerID;
		Statement statement = jdbcConnection.createStatement();

		ResultSet resultSet = statement.executeQuery(sql);

		while (resultSet.next()) {
			int HTRO_CAR_NO = resultSet.getInt("HTRO_CAR_NO");
			String DATA_REZ_SAU_FACTURA = resultSet.getString("DATA_REZ_SAU_FACTURA");
			String DATA_EXPIRARE = resultSet.getString("DATA_EXPIRARE");
			int RES_DEALER_ID = resultSet.getInt("RES_DEALER_ID");
			String TIP_LINIE = resultSet.getString("TIP_LINIE");
			String RES_TYPE = resultSet.getString("RES_TYPE");
			String LOCATIE = resultSet.getString("LOCATIE");
			String LUNA_PRODUCTIE = resultSet.getString("LUNA_PRODUCTIE");
			String LUNA_SOSIRE_IN_TARA = resultSet.getString("LUNA_SOSIRE_IN_TARA");
			String COD_MODEL = resultSet.getString("COD_MODEL");
			String TIP_AUTOVEHICUL = resultSet.getString("TIP_AUTOVEHICUL");
			String COD_CULOARE_EXT = resultSet.getString("COD_CULOARE_EXT");
			String CULOARE_EXTERIOR = resultSet.getString("CULOARE_EXTERIOR");
			String CULOARE_INTERIOR = resultSet.getString("CULOARE_INTERIOR");
			String OBSERVATII = resultSet.getString("OBSERVATII");
			String NUME_CLIENT = resultSet.getString("NUME_CLIENT");
			String NUME_VANZATOR = resultSet.getString("NUME_VANZATOR");
			String VIN = resultSet.getString("VIN");
			String ENGINE_NO = resultSet.getString("ENGINE_NO");
			int AN_FABRICATIE_CF_CIV = resultSet.getInt("AN_FABRICATIE_CF_CIV");
			String OMOLOGARE_INDIVIDUALA = resultSet.getString("OMOLOGARE_INDIVIDUALA");
			int PRET_LISTA = resultSet.getInt("PRET_LISTA");
			int DISCOUNT_STANDARD = resultSet.getInt("DISCOUNT_STANDARD");
			int DISCOUNT_SUPLIMENTAR = resultSet.getInt("DISCOUNT_SUPLIMENTAR");
			int PRET_FINAL = resultSet.getInt("PRET_FINAL");
			int AVANS_PLATIT = resultSet.getInt("AVANS_PLATIT");
			int REST_DE_PLATA = resultSet.getInt("REST_DE_PLATA");
			int CUSTOMER_TRX_ID = resultSet.getInt("CUSTOMER_TRX_ID");

			PortofoliuItem portofoliuItem = new PortofoliuItem(HTRO_CAR_NO, DATA_REZ_SAU_FACTURA, DATA_EXPIRARE,
					RES_DEALER_ID, TIP_LINIE, RES_TYPE, LOCATIE, LUNA_PRODUCTIE, LUNA_SOSIRE_IN_TARA, COD_MODEL,
					TIP_AUTOVEHICUL, COD_CULOARE_EXT, CULOARE_EXTERIOR, CULOARE_INTERIOR, OBSERVATII, NUME_CLIENT,
					NUME_VANZATOR, VIN, ENGINE_NO, AN_FABRICATIE_CF_CIV, OMOLOGARE_INDIVIDUALA, PRET_LISTA,
					DISCOUNT_STANDARD, DISCOUNT_SUPLIMENTAR, PRET_FINAL, AVANS_PLATIT, REST_DE_PLATA, CUSTOMER_TRX_ID);

			listPortofoliuItems.add(portofoliuItem);
		}

		resultSet.close();
		statement.close();

		return listPortofoliuItems;
	}

	public List<PortofoliuItem> ListFilterPortofoliuItems(String filtru, String dealerID) throws SQLException {

		List<PortofoliuItem> listPortofoliuItems = new ArrayList<>();

		String sql = "SELECT * FROM HND_DEALER_PORTOFOLIO_V WHERE LOWER(TIP_AUTOVEHICUL) LIKE LOWER('%" + filtru
				+ "%') AND RES_DEALER_ID='" + dealerID + "'";
		Statement statement = jdbcConnection.createStatement();

		ResultSet resultSet = statement.executeQuery(sql);

		while (resultSet.next()) {
			int HTRO_CAR_NO = resultSet.getInt("HTRO_CAR_NO");
			String DATA_REZ_SAU_FACTURA = resultSet.getString("DATA_REZ_SAU_FACTURA");
			String DATA_EXPIRARE = resultSet.getString("DATA_EXPIRARE");
			int RES_DEALER_ID = resultSet.getInt("RES_DEALER_ID");
			String TIP_LINIE = resultSet.getString("TIP_LINIE");
			String RES_TYPE = resultSet.getString("RES_TYPE");
			String LOCATIE = resultSet.getString("LOCATIE");
			String LUNA_PRODUCTIE = resultSet.getString("LUNA_PRODUCTIE");
			String LUNA_SOSIRE_IN_TARA = resultSet.getString("LUNA_SOSIRE_IN_TARA");
			String COD_MODEL = resultSet.getString("COD_MODEL");
			String TIP_AUTOVEHICUL = resultSet.getString("TIP_AUTOVEHICUL");
			String COD_CULOARE_EXT = resultSet.getString("COD_CULOARE_EXT");
			String CULOARE_EXTERIOR = resultSet.getString("CULOARE_EXTERIOR");
			String CULOARE_INTERIOR = resultSet.getString("CULOARE_INTERIOR");
			String OBSERVATII = resultSet.getString("OBSERVATII");
			String NUME_CLIENT = resultSet.getString("NUME_CLIENT");
			String NUME_VANZATOR = resultSet.getString("NUME_VANZATOR");
			String VIN = resultSet.getString("VIN");
			String ENGINE_NO = resultSet.getString("ENGINE_NO");
			int AN_FABRICATIE_CF_CIV = resultSet.getInt("AN_FABRICATIE_CF_CIV");
			String OMOLOGARE_INDIVIDUALA = resultSet.getString("OMOLOGARE_INDIVIDUALA");
			int PRET_LISTA = resultSet.getInt("PRET_LISTA");
			int DISCOUNT_STANDARD = resultSet.getInt("DISCOUNT_STANDARD");
			int DISCOUNT_SUPLIMENTAR = resultSet.getInt("DISCOUNT_SUPLIMENTAR");
			int PRET_FINAL = resultSet.getInt("PRET_FINAL");
			int AVANS_PLATIT = resultSet.getInt("AVANS_PLATIT");
			int REST_DE_PLATA = resultSet.getInt("REST_DE_PLATA");
			int CUSTOMER_TRX_ID = resultSet.getInt("CUSTOMER_TRX_ID");

			PortofoliuItem portofoliuItem = new PortofoliuItem(HTRO_CAR_NO, DATA_REZ_SAU_FACTURA, DATA_EXPIRARE,
					RES_DEALER_ID, TIP_LINIE, RES_TYPE, LOCATIE, LUNA_PRODUCTIE, LUNA_SOSIRE_IN_TARA, COD_MODEL,
					TIP_AUTOVEHICUL, COD_CULOARE_EXT, CULOARE_EXTERIOR, CULOARE_INTERIOR, OBSERVATII, NUME_CLIENT,
					NUME_VANZATOR, VIN, ENGINE_NO, AN_FABRICATIE_CF_CIV, OMOLOGARE_INDIVIDUALA, PRET_LISTA,
					DISCOUNT_STANDARD, DISCOUNT_SUPLIMENTAR, PRET_FINAL, AVANS_PLATIT, REST_DE_PLATA, CUSTOMER_TRX_ID);

			listPortofoliuItems.add(portofoliuItem);
		}

		resultSet.close();
		statement.close();

		return listPortofoliuItems;
	}

	private Connection jdbcConnection;

}