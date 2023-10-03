//2원, 5원 동전을 최소한으로 사용해서 p원을 지불할 때 사용되는 동전 개수 구하기

package APS;

import java.util.Scanner;

public class 동전 {
	public static void main(String[] args) {
		int INF = 1000000;
		Scanner sc = new Scanner(System.in);
		int p = sc.nextInt();
		
		int[] dp = new int[p+1];
		
		dp[0] = 0;
		dp[1] = INF;
		dp[2] = 1;
		dp[3] = INF;
		dp[4] = 2;
		dp[5] = 1;
		
		for(int i = 6; i < p+1; i++) {
			int min = Math.min(dp[i-2], dp[i-5]);
			if(min == INF) {
				dp[i] = INF;
			} else {
				dp[i] = min+1;
			}
		}
		if(dp[p] == INF) {
			System.out.println(-1);
		} else {
			System.out.println(dp[p]);
		}
	}
}
