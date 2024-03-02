// 문제링크: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV2b7Yf6ABcBBASw

// [입력]
// 첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
// 각 테스트 케이스의 첫 번째 줄에는 두 정수 N, B(1 ≤ N ≤ 20, 1 ≤ B ≤ S)가 공백으로 구분되어 주어진다.
// S는 두 번째 줄에서 주어지는 점원들 키의 합이다.
// 두 번째 줄에는 N개의 정수가 공백으로 구분되어 주어지며, 각 정수는 각 점원의 키 Hi (1 ≤ Hi ≤ 10,000)을 나타낸다.

// [예제 풀이]
// 테스트 케이스의 경우 키가 3, 3, 5, 6인 점원이 탑을 만들면 높이가 17(3 + 3 + 5 + 6)이 된다.
// 높이가 16인 탑은 만들 수 없으므로 높이가 17인 탑이 문제에서 구하려는 탑의 높이이다. 따라서 17 – 16 = 1이 답이 된다.

// 성공

package APS;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int min;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt();
			int[] height = new int[n];
			int tower = sc.nextInt();
			
			min = 0;
			for(int i = 0; i < n; i++) {
				height[i] = sc.nextInt();
				min += height[i];
			}
			min++;
			dfs(height, n, tower, 0, 0);
			System.out.println("#" + tc + " " + (min - tower));
		}
	}
	
	public static void dfs(int[] height, int n, int tower, int sum, int depth) {
		if(sum > min) {
			return;
		}
		if(sum >= tower) {
			min = Math.min(min, sum);
			return;
		}
		if(depth == n) {
			if(sum >= tower) {
				min = Math.min(min, sum);
			}
			return;
		}
		dfs(height, n, tower, sum + height[depth], depth + 1);
		dfs(height, n, tower, sum, depth + 1);
	}
}