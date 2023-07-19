import java.util.Scanner;

public class EvenSum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 입력 >>");
		int a =sc.nextInt();
		int sum = 0;
		for (int i=1; i<=a; i++) {
			if(i % 2 == 0) {
				sum += i;
			}
		}
		System.out.println(sum);
	}
}

//성공