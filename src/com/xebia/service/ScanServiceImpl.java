package com.xebia.service;

public class ScanServiceImpl implements ScanService{

	private String defaultPrice = "defaultPrice";
	
	@Override
	public String scanBarCode(String barCode) {
		//This will use 3rd party bar code API for now simulating positive and negative scenarios
		
		if(barCode == "badBarCode"){
			return "Scan failure";
		}
		
		return "10";
	}

}
