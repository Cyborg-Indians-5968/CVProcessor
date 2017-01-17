package org.usfirst.frc.team5968.driverstation;

import edu.wpi.first.wpilibj.networktables.NetworkTable;

/*
 * Interfaces with the NetworkTables. Gets whether to process an
 * image and sends the distance and angle to the goal.
 */
public class NetworkInterface {
	
	/*
	 * Whether the network tables have been initialized
	 */
	private static boolean initialized = false;
	
	/*
	 * Whether the network tables have been initialized
	 */
	private static NetworkTable table;
	
	//Initializes the network table
	public static void init(){
		table = NetworkTable.getTable("SmartDashboard");
		initialized = true;
	}
	
	//Check whether the robot is in the correct position to process an image
	public static boolean checkForUpdate(){
		return table.getBoolean("processImage", false);
	}
	
	//Sends the distance and angle to the goal to the robot
	public static void putDistanceAndAngle(double distance, double angle){
		table.putNumber("distanceToGoal", distance);
		table.putNumber("angleToGoal", angle);
	}
}
