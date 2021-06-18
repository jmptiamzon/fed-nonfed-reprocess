package com.sprint.pickrelease.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Model {
	
	public String[] getFedNonFed(String ordReqID) {
		String[] deliveryIds = {"", ""};
		String concReqID = "";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = 
					DriverManager.getConnection("", "", "");
			
			PreparedStatement statement = conn.prepareStatement("SELECT CONC_REQ_ID FROM  SPRN.SPRN_WAREHOUSE_STG WHERE ORDER_REQUEST_ID = '" + ordReqID + "'");
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				concReqID = rs.getString(1);
			}
			
			if (!concReqID.isEmpty()) {
				statement = conn.prepareStatement(
						"SELECT STATUS, DELIVERY_ID, USG_ORDER " + 
						"FROM APPS.SPRN_OM_PICK_REL_HDR_OUT_INT " + 
						"WHERE CONC_REQUEST_ID ='" + concReqID +"' " + 
						"AND STATUS = 'JBOSS_ERROR' " + 
						"GROUP BY STATUS, DELIVERY_ID, USG_ORDER " + 
						"ORDER BY STATUS "
				);
				
				rs = statement.executeQuery();
				
				while (rs.next()) {
					if (rs.getString(3).equalsIgnoreCase("y")) {
						deliveryIds[0] += deliveryIds[0].isEmpty() ?
								"'" + rs.getString(2) + "'" : ",\n'" + rs.getString(2) + "'";
						
					} else {
						deliveryIds[1] += deliveryIds[1].isEmpty() ?
								"'" + rs.getString(2) + "'" : ",\n'" + rs.getString(2) + "'";
						
					}
				}
			}
				
			
			conn.close();
			
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Driver not found: " + e.getMessage());
			
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "SQL Error: " + e1.getMessage());
			
		}
		
		
		return deliveryIds;
	}
}
