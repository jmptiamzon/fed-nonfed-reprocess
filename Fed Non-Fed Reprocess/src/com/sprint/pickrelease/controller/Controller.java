package com.sprint.pickrelease.controller;


import com.sprint.pickrelease.model.Model;

public class Controller {
	private Model model;
	
	public Controller() {
		model = new Model();
	}
	
	public void runApp(String ordReqID) {
		String[] deliveryIds = model.getFedNonFed(ordReqID);
		String content = "";
		
		if (!deliveryIds[0].isEmpty()) {
			content = "";
		}
		
		if (!deliveryIds[1].isEmpty()) {
			content = "";
		}
		
	}
	
	
	public void writeFile(String filename, String content) {
		
	}
	
}
