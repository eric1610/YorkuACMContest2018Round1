import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SolutionA {
	public static void main (String [] args) {
		Scanner sc = new Scanner(System.in);
		int cost = 0;
		String []charges = sc.nextLine().split(" ");
		String []firstCar = sc.nextLine().split(" ");
		String []secondCar = sc.nextLine().split(" ");
		String []thirdCar = sc.nextLine().split(" ");
		int []chargeNum = new int [3];
		ArrayList<Integer>startCarCharge = new ArrayList<Integer>();
		ArrayList<Integer>endingCarCharge = new ArrayList<Integer>();	
		for (int x = 0; x < 3; x ++) {
			chargeNum[x] = Integer.parseInt(charges[x]);
		}
		startCarCharge.add(Integer.parseInt(firstCar[0]));
		startCarCharge.add(Integer.parseInt(secondCar[0]));
		startCarCharge.add(Integer.parseInt(thirdCar[0]));
		
		endingCarCharge.add(Integer.parseInt(firstCar[1]));
		endingCarCharge.add(Integer.parseInt(secondCar[1]));
		endingCarCharge.add(Integer.parseInt(thirdCar[1]));

		Collections.sort(startCarCharge);
		Collections.sort(endingCarCharge);

		int cars = 0;
		boolean start = true;
		int currCar = startCarCharge.remove(0);
		while (startCarCharge.size() > 0 && endingCarCharge.size() > 0) {
			if (!start || startCarCharge.get(0) < endingCarCharge.get(0)) {
				if (start) {
					cost += (cars + 1) * chargeNum[cars] * (startCarCharge.get(0) - currCar);
					cars ++;
				} else {
					start = true;
				}
				currCar = startCarCharge.remove(0);
				
			} else {
				cost += (cars + 1) * chargeNum[cars] * (endingCarCharge.get(0) - currCar);
				if (cars > 0) {
					cars --;
				} else {
					start = false;
				}
				currCar = endingCarCharge.remove(0);
			}
		}
		while (endingCarCharge.size() > 0) {
			cost += (cars + 1) * chargeNum[cars] * (endingCarCharge.get(0) - currCar);
			if (cars > 0) {
				cars --;
			}
			currCar = endingCarCharge.remove(0);
		}
		System.out.println(cost);
		sc.close();
	}
}
