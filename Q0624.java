// 민수에게는 1번부터 N번까지의 번호가 부여된 N(1≤N≤100)개의 물건과 최대 K(1≤K≤1000) 부피만큼을 넣을 수 있는 가방이 있다.
// 1번 물건부터 N번 물건 각각은 부피  Vi와 가치 Ci 를 가지고 있다. (1≤Vi, Ci≤100)
// 민수는 물건들 중 몇 개를 선택하여 가방에 넣어서 그 가치의 합을 최대화하려고 한다.
// 단, 선택한 물건들의 부피 합이 K 이하여야 한다.
// 민수가 가방에 담을 수 있는 최대 가치를 계산하자.

// 성공

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for(int tc = 1; tc <= testcase; tc++) {
			int n = sc.nextInt(); // 물건의 개수
			int k = sc.nextInt(); // 가방 최대 부피
			
			int[] volume = new int[n+1];
			int[] cost = new int[n+1];
			
			for(int i = 1; i < n+1; i++) {
				volume[i] = sc.nextInt();
				cost[i] = sc.nextInt();
			}
			int[][] dp = new int[n+1][k+1];
			
			for(int i = 1; i < n+1; i++) {
				for(int w = 0; w < k+1; w++) {
					if(volume[i] <= w) {
						dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w-volume[i]] + cost[i]);
					} else {
						dp[i][w] = dp[i-1][w];
					}
				}
			}
			System.out.println("#"+tc+" "+dp[n][k]);
		}
	}
}
