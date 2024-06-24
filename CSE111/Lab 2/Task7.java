import java.util.Scanner;

public class Task7A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();

		int one = 0;
		int two = 1;
		int i = 0;

		for (; two <= x; i++) {
			System.out.print(two + " ");
			int now = one + two;
			one = two;
			two = now;
		}
		sc.close();
	}
}

import java.util.Scanner;

public class Task7B {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();

		int one = 0;
		int two = 1;
		int i = 0;
		int sum = 0;

		for (; two <= x; i++) {
			System.out.print(two + " ");
			int now = one + two;
			sum += two;
			one = two;
			two = now;
		}
		System.out.println();
		System.out.println("Sum = " + sum);
		sc.close();
	}
}