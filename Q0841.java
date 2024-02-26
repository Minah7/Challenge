// 문제링크: https://www.acmicpc.net/problem/1697

// 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 
// 수빈이는 걷거나 순간이동을 할 수 있다. 
// 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 
// 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.

// 수빈이와 동생의 위치가 주어졌을 때, 
// 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.

// 성공

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		if(n >= k) {
			System.out.println(n - k);
			return;
		}
		
		int[] dp = new int[100001];

		for(int i = 1; i < n; i++) {
			dp[i] = n - i;
		}
		
		for(int i = n + 1; i <= k; i++) {
			int min;
			
			if(i % 2 == 0) {
				min = dp[i/2] + 1;
			} else {
				min = Math.min(dp[(i + 1) / 2], dp[(i - 1) / 2]) + 2;
			}
			dp[i] = Math.min(min, dp[i - 1] + 1);
		}
		System.out.println(dp[k]);
	}
}