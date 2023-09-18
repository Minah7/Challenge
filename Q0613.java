// N개의 정점과 M개의 간선으로 구성된 가중치가 없는 무방향 그래프에서의 최장 경로의 길이를 계산하자.
// 정점의 번호는 1번부터 N번까지 순서대로 부여되어 있다.
// 경로에는 같은 정점의 번호가 2번 이상 등장할 수 없으며, 경로 상의 인접한 점들 사이에는 반드시 두 정점을 연결하는 간선이 존재해야 한다.
// 경로의 길이는 경로 상에 등장하는 정점의 개수를 나타낸다.

// 성공

import java.util.Scanner;

public class Solution {

	public static void dfs(int[][] matrix, int n, int node, boolean[] check, int cnt, int[] answer) {
		for (int i = 1; i < n + 1; i++) {
			if ((check[i] == false && matrix[node][i] == 1) || node == 0) {
				check[i] = true;
				dfs(matrix, n, i, check, cnt + 1, answer);
				check[i] = false;
			} else {
				answer[0] = Math.max(cnt, answer[0]);
			}
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			int m = sc.nextInt();

			int[][] matrix = new int[n + 1][n + 1];
			for (int i = 0; i < m; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				matrix[x][y] = matrix[y][x] = 1;
			}
			int[] answer = new int[1];
			dfs(matrix, n, 0, new boolean[n + 1], 0, answer);
			System.out.println("#" + t + " " + answer[0]);
		}
		sc.close();
	}
}
