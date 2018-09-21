import java.util.Scanner;

public class SolutionB {
	public static void main (String []args) {
		long temp;
		
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLong()) {
			long launchYear = sc.nextLong();
			temp = launchYear - 2018;
			if (temp == 0) {
				System.out.println("yes");
			} else {
				int counter = 1;
				while (temp * 12 > 26 * counter && (temp * 12 - 26 * counter > 12)) {
					counter ++;
				}
				int reduce = 0;
				if ((counter * 2 + 4) % 12 == 0) {
					reduce = -1;
				}
				if (launchYear == 2018 + (counter * 2) + (((counter * 2 + 4 + reduce)/12)))
					System.out.println("yes");
				else {
					System.out.println("no");
				}			
			}
			
		}
		sc.close();
	}
}
