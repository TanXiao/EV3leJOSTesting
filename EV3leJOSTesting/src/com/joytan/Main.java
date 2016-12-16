package com.joytan;

import lejos.hardware.BrickFinder;
import lejos.hardware.Keys;
import lejos.hardware.ev3.EV3;
import lejos.hardware.lcd.LCD;

public class Main {

//	static EV3LargeRegulatedMotor LEFT_MOTOR = new EV3LargeRegulatedMotor(
//			MotorPort.A);

	public static void main(String[] args) throws Exception {

		EV3 ev3brick = (EV3) BrickFinder.getLocal();
		Keys buttons = ev3brick.getKeys();
		
		TurningSensor turningSensor = new TurningSensor();

		LCD.drawString("Ready", 0, 0);
		LCD.drawString(String.valueOf(turningSensor.getAngle()), 0, 1);
		buttons.waitForAnyPress();
		LCD.drawString(String.valueOf(turningSensor.getAngle()), 0, 2);	
		buttons.waitForAnyPress();
	}

	
}
