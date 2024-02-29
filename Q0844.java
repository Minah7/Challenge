// 문제링크: https://swexpertacademy.com/main/solvingProblem/solvingProblem.do

// 성공

package APS;

import java.util.Scanner;

public class Solution {
	static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int tc = 1; tc <= t; tc++) {
			answer = Integer.MAX_VALUE;
			int n = sc.nextInt();
			int officeX = sc.nextInt();
			int officeY = sc.nextInt();
			
			int[][] coordinate = new int[n+2][2];
			for(int i = 0; i < n; i++) {
				coordinate[i][0] = sc.nextInt();
				coordinate[i][1] = sc.nextInt();
			}
			int homeX = sc.nextInt();
			int homeY
			
			boolean[] visited = new boolean[n+2];
			
			dfs(coordinate, visited, n, 0, 0, coordinate[0][0], coordinate[0][1]);
			
			System.out.println("#" + tc + " " + answer);
		}
	}
	
	static void dfs(int[][] coordinate, boolean[] visited, int n, int depth, int distance, int x, int y) {
		if(answer <= distance) {
			return;
		}
		if(depth == n) {
			distance += Math.abs(x - coordinate[n+1][0]) + Math.abs(y - coordinate[n+1][1]);
			answer = Math.min(answer, distance);
			return;
		}
		for(int i = 1; i <= n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				int d = Math.abs(x - coordinate[i][0]) + Math.abs(y - coordinate[i][1]);
				dfs(coordinate, visited, n, depth + 1, distance + d, coordinate[i][0], coordinate[i][1]);
				visited[i] = false;
			}
		}
	}
}
