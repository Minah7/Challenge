// 피보나치 함수를 구현하여 5개의 입력값을 받고 그에 해당하는 피보나치 수를 구하시오.
// 즉, n번째 피보나치 수를 구하시오.

// 성공

import java.util.Scanner;

public class 피보나치_수열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] fibo = new int[50];
		for(int i = 1; i < 50; i++) {
			if(i <= 2) {
				fibo[i] = 1;
			} else {
				fibo[i] = fibo[i-1]+fibo[i-2];
			}
		}
		for(int testcase = 1; testcase <= 5; testcase++) {
			System.out.println(fibo[sc.nextInt()]);
		}
	}
}
