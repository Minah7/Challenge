// 치즈를 좋아하는다혜는 한 변의 길이가 N인 정사각형 모양의 치즈를 샀다.
// 이치즈는 특이하게도 N*N개의 모든 칸의 맛있는 정도가 동일하지 않다.
// 맛있는 정도는 1부터 100 사이로 표현된다.
// 명우는 치즈를 사서냉동실에 넣어놨는데, 냉동실에는 치즈를 엄청 좋아하는 요정이 숨어있다.
// 요정은 100일동안 치즈를 갉아먹는데, X번째날에는 맛있는 정도가 X인 칸을 먹어버린다.
// 치즈 덩어리란상, 하, 좌, 우로인접한 칸들을 하나로 묶어놓은 것을 의미한다.

// 예를 들어서, 4일이 지난 치즈가 위와 같이 생겼다고 하자.
// 회색 칸들은 요정이먹어버린 칸이다. 그러면 5개의 덩어리가 남게 된다.
// 100일 중에서 치즈덩어리가 가장 많을 때의 덩어리 개수를 구하는 프로그램을 작성하라.

// [입력]
// 첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
// 각 테스트 케이스의 첫 번째 줄에는 치즈의 한 변의 길이 N(2 ≤ N ≤ 100)이 주어진다.
// 이어서 N개의줄에 걸쳐서 각 칸의 맛있는 정도가 1부터 100 사이의숫자로 주어진다.

// 성공

package APS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 치즈도둑_BFS {
	static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	
	static void BFS(int[][] cheese, boolean[][] visited, int n, int row, int col, int day) {
		Queue<Integer[]> queue = new LinkedList<>();
		
		queue.add(new Integer[] {row, col});
		visited[row][col] = true;
		
		while(!queue.isEmpty()) {
			Integer[] rc = queue.poll();
			int r = rc[0];
			int c = rc[1];
			for(int d = 0; d < 4; d++) {
				int nr = r+dir[d][0];
				int nc = c+dir[d][1];
				if(0 <= nr && nr < n && 0 <= nc && nc < n && cheese[nr][nc] > day && !visited[nr][nc]) {
					visited[nr][nc] = true;
					queue.add(new Integer[] {nr, nc});
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for(int tc = 1; tc <= testcase; tc++) {
			int maxDay = 0; //가장 큰 일수를 구하기 위한 변수
			int n = sc.nextInt();
			int[][] cheese = new int[n][n];
			for(int row = 0; row < n; row++) {
				for(int col = 0; col < n; col++) {
					cheese[row][col] = sc.nextInt();
					maxDay = Math.max(maxDay, cheese[row][col]);
				}
			}//여기까지 입력 받기
			int answer = 0;
			for(int day = 0; day <= maxDay; day++) {
				boolean[][] visited = new boolean[n][n];
				int cnt = 0;
				for(int row = 0; row < n; row++) {
					for(int col = 0; col < n; col++) {
						if(cheese[row][col] > day && !visited[row][col]) {
							BFS(cheese, visited, n, row, col, day);
							cnt++;
						}
					}
				}
				answer = Math.max(answer, cnt);
			}
			System.out.println("#"+tc+" "+answer);
		}
	}
}
