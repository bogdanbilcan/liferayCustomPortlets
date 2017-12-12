package com.logika.custom.honda.dealerapp.controller.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

import com.logika.custom.honda.dealerapp.model.StocItem;

public class StocItemDAO {

	public StocItemDAO(Connection jdbcConnection) {
		this.jdbcConnection = jdbcConnection;
	}

	public List<StocItem> ListAllStocItems(int start, int end) throws SQLException {
		List<StocItem> listStocItems = new ArrayList<>();
		String sql = "SELECT * FROM ( SELECT rownum rnum, a.* FROM HND_STOC_HTRO_V a ORDER BY HTRO_CAR_NO )WHERE rnum BETWEEN "
				+ start + " AND " + end;

		Statement statement = jdbcConnection.createStatement();

		ResultSet resultSet = statement.executeQuery(sql);

		while (resultSet.next()) {
			int HTRO_CAR_NO = resultSet.getInt("HTRO_CAR_NO");
			int RES_DEALER_ID = resultSet.getInt("RES_DEALER_ID");
			int AN_FABRICATIE_CIV = resultSet.getInt("AN_FABRICATIE_CIV");
			String TIP_AUTOVEHICUL = resultSet.getString("TIP_AUTOVEHICUL");
			String COD_CULOARE_EXTERIO = resultSet.getString("COD_CULOARE_EXTERIO");
			String DESC_CULOARE_EXTERIOR = resultSet.getString("DESC_CULOARE_EXTERIOR");
			String VOPSEA_METALIZATA = resultSet.getString("VOPSEA_METALIZATA");
			String CULOARE_INTERIOR = resultSet.getString("CULOARE_INTERIOR");
			String OBSERVATII = resultSet.getString("OBSERVATII");
			String LOCATIE = resultSet.getString("LOCATIE");
			String OMOLOGARE_IND = resultSet.getString("OMOLOGARE_IND");
			String LUNA_SOSIRE_IN_TARA = resultSet.getString("LUNA_SOSIRE_IN_TARA");
			String REZERVATA = resultSet.getString("REZERVATA");
			String DATA_EXPIRARE_REZ = resultSet.getString("DATA_EXPIRARE_REZ");

			StocItem stocItem = new StocItem(HTRO_CAR_NO, RES_DEALER_ID, AN_FABRICATIE_CIV, TIP_AUTOVEHICUL,
					COD_CULOARE_EXTERIO, DESC_CULOARE_EXTERIOR, VOPSEA_METALIZATA, CULOARE_INTERIOR, OBSERVATII,
					LOCATIE, OMOLOGARE_IND, LUNA_SOSIRE_IN_TARA, REZERVATA, DATA_EXPIRARE_REZ);
			listStocItems.add(stocItem);
		}

		resultSet.close();
		statement.close();

		return listStocItems;
	}

	public List<String> List_Culoare_Ext(String model_auto) throws SQLException {
		List<String> ListCuloareExt = new ArrayList<>();
		String sql = "SELECT DISTINCT COLOR_DESCRIPTION FROM HND_MODEL_COLOR_MAPPING_V WHERE MODEL_DESCRIPTION LIKE ('%"
				+ model_auto + "%')";
		Statement statement = jdbcConnection.createStatement();

		ResultSet resultSet = statement.executeQuery(sql);

		while (resultSet.next()) {
			String COLOR_DESCRIPTION = resultSet.getString("COLOR_DESCRIPTION");
			ListCuloareExt.add(COLOR_DESCRIPTION);
		}

		resultSet.close();
		statement.close();

		return ListCuloareExt;
	}

	public List<String> List_Tip_Auto(String culoare) throws SQLException {
		List<String> ListTipAuto = new ArrayList<>();
		String sql = "SELECT DISTINCT MODEL_DESCRIPTION FROM HND_MODEL_COLOR_MAPPING_V WHERE COLOR_DESCRIPTION LIKE ('%"
				+ culoare + "%')";
		Statement statement = jdbcConnection.createStatement();

		ResultSet resultSet = statement.executeQuery(sql);

		while (resultSet.next()) {
			String MODEL_DESCRIPTION = resultSet.getString("MODEL_DESCRIPTION");
			ListTipAuto.add(MODEL_DESCRIPTION);
		}

		resultSet.close();
		statement.close();

		return ListTipAuto;
	}

	public List<StocItem> ListAllStocItems() throws SQLException {
		List<StocItem> listStocItems = new ArrayList<>();
		String sql = "SELECT * FROM HND_STOC_HTRO_V";
		Statement statement = jdbcConnection.createStatement();

		ResultSet resultSet = statement.executeQuery(sql);

		while (resultSet.next()) {
			int HTRO_CAR_NO = resultSet.getInt("HTRO_CAR_NO");
			int RES_DEALER_ID = resultSet.getInt("RES_DEALER_ID");
			int AN_FABRICATIE_CIV = resultSet.getInt("AN_FABRICATIE_CIV");
			String TIP_AUTOVEHICUL = resultSet.getString("TIP_AUTOVEHICUL");
			String COD_CULOARE_EXTERIO = resultSet.getString("COD_CULOARE_EXTERIO");
			String DESC_CULOARE_EXTERIOR = resultSet.getString("DESC_CULOARE_EXTERIOR");
			String VOPSEA_METALIZATA = resultSet.getString("VOPSEA_METALIZATA");
			String CULOARE_INTERIOR = resultSet.getString("CULOARE_INTERIOR");
			String OBSERVATII = resultSet.getString("OBSERVATII");
			String LOCATIE = resultSet.getString("LOCATIE");
			String OMOLOGARE_IND = resultSet.getString("OMOLOGARE_IND");
			String LUNA_SOSIRE_IN_TARA = resultSet.getString("LUNA_SOSIRE_IN_TARA");
			String REZERVATA = resultSet.getString("REZERVATA");
			String DATA_EXPIRARE_REZ = resultSet.getString("DATA_EXPIRARE_REZ");

			StocItem stocItem = new StocItem(HTRO_CAR_NO, RES_DEALER_ID, AN_FABRICATIE_CIV, TIP_AUTOVEHICUL,
					COD_CULOARE_EXTERIO, DESC_CULOARE_EXTERIOR, VOPSEA_METALIZATA, CULOARE_INTERIOR, OBSERVATII,
					LOCATIE, OMOLOGARE_IND, LUNA_SOSIRE_IN_TARA, REZERVATA, DATA_EXPIRARE_REZ);
			listStocItems.add(stocItem);
		}

		resultSet.close();
		statement.close();

		return listStocItems;
	}

	public List<StocItem> ListFilteredStocItems(String filter1, String filter2) throws SQLException {

		List<StocItem> listStocItems = new ArrayList<>();

		if ((filter1 == null) || (filter1 == "null")) {
			filter1 = "";
		}
		if ((filter2 == null) || (filter2 == "null")) {
			filter2 = "";
		}

		String sql = "SELECT * FROM HND_STOC_HTRO_V WHERE lower(TIP_AUTOVEHICUL) LIKE lower('%" + filter1
				+ "%') AND lower(DESC_CULOARE_EXTERIOR) LIKE lower('%" + filter2 + "%')";
		Statement statement = jdbcConnection.createStatement();

		ResultSet resultSet = statement.executeQuery(sql);

		while (resultSet.next()) {
			int HTRO_CAR_NO = resultSet.getInt("HTRO_CAR_NO");
			int RES_DEALER_ID = resultSet.getInt("RES_DEALER_ID");
			int AN_FABRICATIE_CIV = resultSet.getInt("AN_FABRICATIE_CIV");
			String TIP_AUTOVEHICUL = resultSet.getString("TIP_AUTOVEHICUL");
			String COD_CULOARE_EXTERIO = resultSet.getString("COD_CULOARE_EXTERIO");
			String DESC_CULOARE_EXTERIOR = resultSet.getString("DESC_CULOARE_EXTERIOR");
			String VOPSEA_METALIZATA = resultSet.getString("VOPSEA_METALIZATA");
			String CULOARE_INTERIOR = resultSet.getString("CULOARE_INTERIOR");
			String OBSERVATII = resultSet.getString("OBSERVATII");
			String LOCATIE = resultSet.getString("LOCATIE");
			String OMOLOGARE_IND = resultSet.getString("OMOLOGARE_IND");
			String LUNA_SOSIRE_IN_TARA = resultSet.getString("LUNA_SOSIRE_IN_TARA");
			String REZERVATA = resultSet.getString("REZERVATA");
			String DATA_EXPIRARE_REZ = resultSet.getString("DATA_EXPIRARE_REZ");

			StocItem stocItem = new StocItem(HTRO_CAR_NO, RES_DEALER_ID, AN_FABRICATIE_CIV, TIP_AUTOVEHICUL,
					COD_CULOARE_EXTERIO, DESC_CULOARE_EXTERIOR, VOPSEA_METALIZATA, CULOARE_INTERIOR, OBSERVATII,
					LOCATIE, OMOLOGARE_IND, LUNA_SOSIRE_IN_TARA, REZERVATA, DATA_EXPIRARE_REZ);
			listStocItems.add(stocItem);
		}

		resultSet.close();
		statement.close();

		return listStocItems;
	}

	private Connection jdbcConnection;

}