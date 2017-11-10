
public class Car {

	private double speed;
	private int timeStart;
	private int timeEntered;
	private int timeLeft;
	
	public Car(double s) {
		speed = s;
		timeStart = 0;
		timeEntered = 0;
	}
	
	public Car(double s, int t) {
		speed = s;
		timeStart = t;
		timeEntered = t;
	}
	public int getTimeEntered() {
		return timeEntered;
	}
	
	public void setTimeEntered(int t) {
		timeEntered = t;
	}
	
	public void changeSpeed(int s) {
		speed = s;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	public void setTimeLeft(int t) {
		timeLeft = t;
	}
	
	public int getTimeStart() {
		return timeStart;
	}
	
	public int getTimeLeft() {
		return timeLeft;
	}
	
	public double getTimeTraveled() {
		return timeLeft - timeStart;
	}


}
