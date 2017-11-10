import java.util.ArrayList;

public class Simulation {

	public ReferenceQueue SingleCarScenario(double speed, double constructionSpeed, int normalLength,
			int constructionLength, int totalCars, int frequency) {
		ReferenceQueue nonConstruction = new ReferenceQueue((int) (50));
		ReferenceQueue Construction = new ReferenceQueue((int) (50));
		ReferenceQueue stats = new ReferenceQueue(totalCars);
		ArrayList<Car> stat = new ArrayList<Car>(); // Make link list
		nonConstruction.enqueue(new Car(nervousSpeed(nonConstruction, speed)));
		int time = 1; // in seconds
		Car temp;
		while (!stats.isFull()) {
			temp = removeFromQueue(nonConstruction, Construction, time, constructionLength, 2);
			if (temp.getSpeed() != -1) {
				temp.setTimeLeft(time);
				stats.enqueue(temp);
			}
			temp = removeFromQueue(nonConstruction, Construction, time, normalLength, 1);
			if (temp.getSpeed() != -1 && !Construction.isFull()) {
				temp.setTimeEntered(time);
				temp.setSpeed(nervousSpeed(Construction, constructionSpeed));
				Construction.enqueue(temp);
			}
			if (time % frequency == 0 && !nonConstruction.isFull()) {
				nonConstruction.enqueue(new Car(nervousSpeed(nonConstruction, speed), time));
			}
			time = time + 1;
		}
		return stats;
	}

	public Car removeFromQueue(ReferenceQueue one, ReferenceQueue two, int time, int length, int currentQueue) {
		Car temp;
		boolean goodToDequeue = false;
		switch (currentQueue) {
		case 1:
			if (!two.isFull() && !one.isEmpty())
				goodToDequeue = true;
			break;
		case 2:
			goodToDequeue = !two.isEmpty();
		}
		if (goodToDequeue) {
			if (currentQueue == 1)
				temp = one.peek();
			else
				temp = two.peek();

			if (timeToDequeue(temp, time, length)) {

				if (currentQueue == 1)
					one.dequeue();
				else
					two.dequeue();
				return temp;
			} else
				return new Car(-1);

		} else
			return new Car(-1);
	}

	public boolean timeToDequeue(Car c, int t, int l) {
		int timeTraveled = t - c.getTimeEntered();
		double distance = (c.getSpeed() * timeTraveled) / 3600;
		if (distance >= l) {
			return true;
		}
		return false;
	}

	public double nervousSpeed(ReferenceQueue q, double speed) {
		int percent = q.percentFull();
		//System.out.println(q.percentFull());
		if (percent >= 50 && percent < 75)
			return speed * .75;
		else if (percent >= 75 && percent < 90)
			return speed * .5;
		else if (percent >= 90)
			return speed * .25;
		else
			return speed;
	}

	public static void main(String[] args) {
		// Single Car
		Simulation s = new Simulation();
		ReferenceQueue stat = s.SingleCarScenario(75, 5, 15, 5, 100, 120);
		stat.printQueue();
	}
}
