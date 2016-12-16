package com.joytan;

import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;

public class TuringController {
	private static int MAX_ANGLE = 45;
	
	private EV3MediumRegulatedMotor turingMotor;
	private TurningSensor turningSensor;
	private int speed = 30;
	private int currenyMotorDirection = 0;
	
	public TuringController() {
		turingMotor = new EV3MediumRegulatedMotor(MotorPort.B);
		turingMotor.setSpeed(speed);
		turningSensor = new TurningSensor();
	}
	
	public void turnVihecle(int angle) {
		int angleLeftToTurn = angle;
		turningSensor.reset();
		while (angleLeftToTurn != 0) {
			turn(angleLeftToTurn);
			sleep();
			angleLeftToTurn = (int) (angle - turningSensor.getAngle());
		}
	}
	
	private void turn(int angle) {
		if (angle >= MAX_ANGLE) {
			setTurningMotorDirection(MAX_ANGLE);
		} else {
			setTurningMotorDirection(angle);
		}
	}
	
	private void setTurningMotorDirection(int angle) {
		turingMotor.rotate(angle - currenyMotorDirection);
		currenyMotorDirection = angle;
	}
	
	private void sleep() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
