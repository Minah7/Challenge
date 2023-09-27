// 피보나치 함수를 구현하여 5개의 입력값을 받고 그에 해당하는 피보나치 수를 구하시오.
// 즉, n번째 피보나치 수를 구하시오.

// 성공

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] memo = new int[45];
		memo[0] = 0;
		memo[1] = 1;
		for(int i = 2; i < 45; i++) {
			memo[i] = memo[i-2] + memo[i-1];
		}
		
		for(int testcase = 1; testcase <= 5; testcase++) {
			int input = sc.nextInt();
			System.out.println(memo[input]);
		}
	}
}
