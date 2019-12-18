
import org.junit.Test;

import com.xebia.bean.Robot;
import com.xebia.service.RobotService;
import com.xebia.service.RobotServiceImpl;
import com.xebia.service.ScanService;
import com.xebia.service.ScanServiceImpl;

import junit.framework.Assert;



public class TestRobot {
	
	@Test
	public void test_WhenRobotWalk_Then_ReturnRemainingBattery(){
	
		RobotService robotService = new RobotServiceImpl();
		ScanService scanService = new ScanServiceImpl();
		Robot robot = new Robot(robotService,scanService);
		robot.doWork(3.5, 0);
		double remainingBattery = robot.getRemainingBattery();
		Assert.assertEquals(30.0, remainingBattery);
	}
	
	@Test
	public void test_WhenRobotWalk_WithWeight_Then_ReturnRemainingBattery(){
	
		RobotService robotService = new RobotServiceImpl();
		ScanService scanService = new ScanServiceImpl();
		Robot robot = new Robot(robotService,scanService);
		robot.doWork(2, 3);
		double remainingBattery = robot.getRemainingBattery();
		Assert.assertEquals(57.60, remainingBattery);
	}
	
	@Test
	public void test_WhenRobot_OverWeight(){
	
		RobotService robotService = new RobotServiceImpl();
		ScanService scanService = new ScanServiceImpl();
		Robot robot = new Robot(robotService,scanService);
		robot.doWork(0, 12);
		double remainingBattery = robot.getRemainingBattery();
		Assert.assertEquals(100.0, remainingBattery);
		Assert.assertEquals("Weight can not be greater than 10 kg", robot.getDisplayMessage());
	}
	
	@Test
	public void test_WhenRobot_LowBattery(){
	
		RobotService robotService = new RobotServiceImpl();
		ScanService scanService = new ScanServiceImpl();
		Robot robot = new Robot(robotService,scanService);
		robot.doWork(4.8,0 );
		double remainingBattery = robot.getRemainingBattery();
		Assert.assertEquals(4.0, remainingBattery);
		Assert.assertTrue(robot.isLowBattery());
	}
	
	@Test
	public void test_When_Good_BarCode(){
		RobotService robotService = new RobotServiceImpl();
		ScanService scanService = new ScanServiceImpl();
		Robot robot = new Robot(robotService,scanService);
		String price = robot.getScannedPrice("goodBarCode");
		Assert.assertEquals("10", price);
	}
	
	@Test
	public void test_When_Bad_BarCode(){
		RobotService robotService = new RobotServiceImpl();
		ScanService scanService = new ScanServiceImpl();
		Robot robot = new Robot(robotService,scanService);
		String price = robot.getScannedPrice("badBarCode");
		Assert.assertEquals("Scan failure", price);
	}
	
	
	
}
