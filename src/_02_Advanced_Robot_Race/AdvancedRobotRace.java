package _02_Advanced_Robot_Race;

import java.util.Random;

import javax.swing.JOptionPane;

import org.jointheleague.graphical.robot.Robot;

public class AdvancedRobotRace {

	// 1. make a main method
	public static void main(String[] args) {

		// 2. create an array of 5 robots.
		Robot[] robots = new Robot[5];

		for (int i = 0; i < robots.length; i++) {
			robots[i] = new Robot();
			robots[i].setX(i * 100 + 80);
			robots[i].setY(500);
			robots[i].setSpeed(10000);
		}
		Thread r1 = new Thread(()->robotRace(robots[0]));
		Thread r2 = new Thread(()->robotRace(robots[1]));
		Thread r3 = new Thread(()->robotRace(robots[2]));
		Thread r4 = new Thread(()->robotRace(robots[3]));
		Thread r5 = new Thread(()->robotRace(robots[4]));
		r1.start();
		r2.start();
		r3.start();
		r4.start();
		r5.start();
		boolean top = false;
		while(!top) {
		for (int i = 0; i < robots.length; i++) {
			if (robots[i].getY() < 50) {
				top=true;
				JOptionPane.showMessageDialog(null, "ROBOT " + i + " WINS");
				robots[1].hide();
				robots[2].hide();
				robots[3].hide();
				robots[4].hide();
				party(robots[0]);
				break;
			}
		}
		}
		// 7. declare that robot the winner and throw it a party!
		
	}

	public static void robotRace(Robot r) {
		boolean top = false;
		Random rand = new Random();
		while (!top) {

			r.move(rand.nextInt(50));
			if (r.getY() < 50) {
				top = true;

			}

		}
	}
	public static void party(Robot r) {
		
		r.penDown();
		r.setX(350);
		r.setY(500);
		for (int i = 0; i < 360; i++) {
			r.setRandomPenColor();
			r.turn(1);
			r.move(2);
		}
		r.setX(465);
		r.setY(500);
		r.setAngle(0);
	}

}
