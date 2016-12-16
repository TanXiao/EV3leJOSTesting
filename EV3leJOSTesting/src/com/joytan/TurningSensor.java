package com.joytan;

import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3GyroSensor;
import lejos.robotics.SampleProvider;

public class TurningSensor 
{
	private EV3GyroSensor gyroSensor;
	private SampleProvider gProvider;
	
	private float[] gyroReader = new float[1];
	
	public TurningSensor() {
		gyroSensor = new EV3GyroSensor(SensorPort.S1);
		gProvider = gyroSensor.getAngleMode();
		
		gyroSensor.setCurrentMode("Angle");
	}
	
	public void reset() {
		gyroSensor.reset();
	}
	
	float getAngle() {
		gProvider.fetchSample(gyroReader, 0);
		return gyroReader[0];
	}
}
