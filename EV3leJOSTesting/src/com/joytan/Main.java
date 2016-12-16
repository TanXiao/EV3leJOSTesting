package com.joytan;

import lejos.hardware.BrickFinder;
import lejos.hardware.Keys;
import lejos.hardware.ev3.EV3;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;

public class Main {

	static EV3LargeRegulatedMotor motor = new EV3LargeRegulatedMotor(MotorPort.A);
	
	public static void main(String[] args) throws Exception {

		EV3 ev3brick = (EV3) BrickFinder.getLocal();
		Keys buttons = ev3brick.getKeys();

		TuringController turingController = new TuringController();
		LCD.drawString("Ready", 0, 0);
		buttons.waitForAnyPress();
		motor.forward();
		turingController.turnVihecle(90);
		buttons.waitForAnyPress();
	}

	
}
