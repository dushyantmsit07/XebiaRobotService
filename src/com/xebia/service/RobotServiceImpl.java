package com.xebia.service;

import java.text.DecimalFormat;

public class RobotServiceImpl implements RobotService {

	private double batteryPerKm = 20;
	private double extraWeightPercentage = 0.02;
	private double maxWeight = 10;
	private String displayMessage;

	@Override
	public double getBatteryConsumed(double distance, double weight) {
		displayMessage = "";
		double batteryConsumed = 0;
		if (weight > maxWeight) {
			displayMessage = "Weight can not be greater than 10 kg";
			batteryConsumed = -1;
		} else {
			batteryConsumed = distance * batteryPerKm;
			if (weight > 0) {
				batteryConsumed = batteryConsumed * (1 + weight * extraWeightPercentage);
				DecimalFormat df = new DecimalFormat("####0.00");
				batteryConsumed = Double.valueOf(df.format(batteryConsumed));
				return batteryConsumed;
			}
		}
		return batteryConsumed;
	}
	
	public String getDisplayMessage(){
		return displayMessage;
	}
}
