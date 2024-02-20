// 문제링크: https://swexpertacademy.com/main/solvingProblem/solvingProblem.do

// 점원들이 쌓는 탑은 점원 1명 이상으로 이루어져 있다.
// 탑의 높이는 점원이 1명일 경우 그 점원의 키와 같고, 2명 이상일 경우 탑을 만든 모든 점원의 키의 합과 같다.
// 탑의 높이가 B 이상인 경우 선반 위의 물건을 사용할 수 있는데 탑의 높이가 높을수록 더 위험하므로 
// 높이가 B 이상인 탑 중에서 높이가 가장 낮은 탑을 알아내려고 한다.

// [입력]
// 첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
// 각 테스트 케이스의 첫 번째 줄에는 두 정수 N, B(1 ≤ N ≤ 20, 1 ≤ B ≤ S)가 공백으로 구분되어 주어진다.
// S는 두 번째 줄에서 주어지는 점원들 키의 합이다.
// 두 번째 줄에는 N개의 정수가 공백으로 구분되어 주어지며, 각 정수는 각 점원의 키 Hi (1 ≤ Hi ≤ 10,000)을 나타낸다.

// [출력]
// 각 테스트 케이스마다 첫 번째 줄에는 ‘#t’(t는 테스트 케이스 번호를 의미하며 1부터 시작한다)를 출력하고, 만들 수 있는 높이가 B 이상인 탑 중에서 탑의 높이와 B의 차이가 가장 작은 것을 출력한다.

// 실패.

package APS;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt();
			int b = sc.nextInt();
			
			int min = 0;
			int[] height = new int[n];
			for(int h = 0; h < n; h++) {
				height[h] = sc.nextInt();
				min += height[h];
			}
			min++;
			dfs(height, b, n, min, 0, 0);
			
			System.out.println("#" + tc + " " + (min - b));
		}
		
	}
	
	static void dfs(int[] height, int b, int n, int min, int sum, int depth) {
		if(sum >= b) {
			min = Math.min(min, sum);
			return;
		} 
		if(depth == n) {
			if(sum >= b) {
				min = Math.min(min, sum);
			}
			return;
		}
		dfs(height, b, n, min, sum + height[depth], depth + 1);
		dfs(height, b, n, min, sum, depth + 1);
	}
}
