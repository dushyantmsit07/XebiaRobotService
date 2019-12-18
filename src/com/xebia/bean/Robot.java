package com.xebia.bean;

import com.xebia.service.RobotService;
import com.xebia.service.ScanService;

public class Robot {
	
	
	private double minmBattery;
	private double extraBatteryPerKg;
	private double remainingBattery = 100;
	private RobotService robotService;
	private ScanService scanService;
	
	public Robot(RobotService robotService, ScanService scanService) {
		this.robotService = robotService;
		this.scanService = scanService;
	}
	
	public void doWork(double distance, double weight) {
		double batteryConsumed = robotService.getBatteryConsumed(distance, weight);
		if(batteryConsumed == -1){
			return; //In this case the weight is greater than 10 kg
		}
		remainingBattery = remainingBattery - batteryConsumed;
	}
	
	public double getRemainingBattery(){
		return remainingBattery;
	}
	
	public String getDisplayMessage(){
		return robotService.getDisplayMessage();
	}
	
	public boolean isLowBattery(){
		if(remainingBattery < 15){
			return true;
		}
		return false;
	}
	
	public String getScannedPrice(String barCode){
		return scanService.scanBarCode(barCode);
	}
}
