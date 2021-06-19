package _01_Olympic_Rings;

import java.awt.Color;
import java.util.ArrayList;

import org.jointheleague.graphical.robot.Robot;

public class OlympicRings_Threaded {
	// Make A Program that uses Threads and robots to draw the Olympic rings. One robot should draw one ring simultaneously with the other 4 robots.

	public static void main(String[] args) {
		Robot blue = new Robot(200,200);
		Robot yellow = new Robot(260,260);
		Robot black = new Robot(320,200);
		Robot green = new Robot(380,260);
		Robot red = new Robot(440,200);
		
		ArrayList<Robot> robots = new ArrayList<Robot>();
		robots.add(blue);
		robots.add(yellow);
		robots.add(black);
		robots.add(green);
		robots.add(red);
		blue.setPenColor(Color.blue);
		yellow.setPenColor(Color.yellow);
		black.setPenColor(Color.black);
		green.setPenColor(Color.green);
		red.setPenColor(Color.red);
		
		for (int i = 0; i < robots.size(); i++) {
			robots.get(i).penDown();
			robots.get(i).setSpeed(10);
			robots.get(i).hide();
		}
		
		Thread r1 = new Thread(()->drawCircle(blue));
		Thread r2 = new Thread(()->drawCircle(yellow));
		Thread r3 = new Thread(()->drawCircle(black));
		Thread r4 = new Thread(()->drawCircle(green));
		Thread r5 = new Thread(()->drawCircle(red));
		
		r1.start();
		r2.start();
		r3.start();
		r4.start();
		r5.start();
		
		
	}
	
	public static void drawCircle(Robot r) {
		for (int i = 0; i < 360; i++) {
			r.penDown();
			r.setSpeed(10);
			r.move(1);
			r.turn(1);
		}
	}
}

