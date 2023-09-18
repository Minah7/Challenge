// 정점이 N개, 간선이 M개 있는 그래프가 주어진다. 
// 정점에는 1번에서 N번까지의 번호가 붙어 있다.
// 이 때, i번 정점과 j번 정점 사이에, j번 정점과 k번 정점 사이에, k번 정점과 i번 정점 사이에
// 모두 간선이 있는 ( i, j, k ) (단, i < j < k )를 삼각형이라고 하자.
// 삼각형의 개수를 구하는 프로그램을 작성하라.

// 두번째 성공.

import java.util.Scanner;

public class Solution {

	public static void dfs(int[][] matrix, int n, int start, int node, int cnt, int[] answer) {
        // matrix 배열과 n값 가져오기, 시작할 번호를 넣을 start, 현재 위치를 넣을 node, 몇 개의 정점을 선택했는지 셀 cnt
		// 만약 3개의 정점을 선택했고, 시작과 끝 정점도 이어져 있으면 
        if (cnt == 3 && matrix[start][node] == 1) {
			answer[0]++;
        // 3개 미만의 정점을 선택했다면
		} else if (cnt < 3) {
			for (int i = node + 1; i < n + 1; i++) {
				if (start == 0)
					dfs(matrix, n, i, i, cnt + 1, answer);
				if (matrix[node][i] == 1)
					dfs(matrix, n, start, i, cnt + 1, answer);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt(); //정점 개수
			int m = sc.nextInt(); //간선 개수
			int[][] matrix = new int[n + 1][n + 1]; //정점은 1번부터 시작하기 때문에 n+1개
			for (int i = 0; i < m; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				matrix[x][y] = matrix[y][x] = 1; // 연결되어 있는 정점에는 1 넣어주기
			}
			int[] answer = new int[1];
			dfs(matrix, n, 0, 0, 0, answer);
			System.out.println("#" + t + " " + answer[0]);
		}
		sc.close();
	}
}
