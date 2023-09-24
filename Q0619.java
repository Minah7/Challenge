// 치즈를 좋아하는다혜는 한 변의 길이가 N인 정사각형 모양의 치즈를 샀다.
// 이치즈는 특이하게도 N*N개의 모든 칸의 맛있는 정도가 동일하지 않다.
// 맛있는 정도는 1부터 100 사이로 표현된다.

// 명우는 치즈를 사서냉동실에 넣어놨는데, 냉동실에는 치즈를 엄청 좋아하는 요정이 숨어있다.
// 요정은 100일동안 치즈를 갉아먹는데, X번째날에는 맛있는 정도가 X인 칸을 먹어버린다.
// 치즈 덩어리란상, 하, 좌, 우로인접한 칸들을 하나로 묶어놓은 것을 의미한다.

// 예를 들어서, 4일이 지난 치즈가 위와 같이 생겼다고 하자.
// 회색 칸들은 요정이먹어버린 칸이다. 그러면 5개의 덩어리가 남게 된다.
// 100일 중에서 치즈덩어리가 가장 많을 때의 덩어리 개수를 구하는 프로그램을 작성하라.

// 성공

package Graph;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 치즈도둑 {
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	
//	static void DFS(int[][] board, boolean[][] visited, int row, int col, int day) {
//		visited[row][col] = true;
//		for(int dir = 0; dir < 4; dir++) {
//			int nr = row+dr[dir];
//			int nc = col+dc[dir];
//			if(0 <= nr && nr < board.length && 0 <= nc && nc < board.length && board[nr][nc] > day && !visited[nr][nc]) {
//				DFS(board, visited, nr, nc, day);
//			}
//		}
//	}
	
	static void BFS(int[][] board, boolean[][] visited, int row, int col, int day) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{row, col});
		visited[row][col] = true;
		while(!queue.isEmpty()) {
			int[] p = queue.poll();
			for(int dir = 0; dir < 4; dir++) {
				int nr = p[0]+dr[dir];
				int nc = p[1]+dc[dir];
				if(0 <= nr && nr < board.length && 0 <= nc && nc < board.length && board[nr][nc] > day && !visited[nr][nc]) {
					queue.add(new int[] {nr, nc});
					visited[nr][nc] = true;
				}
			}
		}
		
		
		
//		queue.add(new Point(row, col));
//		visited[row][col] = true;
//		while(!queue.isEmpty()) {
//			Point p = queue.poll();
//			for(int dir = 0; dir < 4; dir++) {
//				int nr = p.x+dr[dir];
//				int nc = p.y+dc[dir];
//				if(0 <= nr && nr < board.length && 0 <= nc && nc < board.length && board[nr][nc] > day && !visited[nr][nc]) {
//					queue.add(new Point(nr, nc));
//					visited[nr][nc] = true;
//				}
//			}
//		}
	}	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int testcase = 1; testcase<= t; testcase++) {
			int n = sc.nextInt();
			int[][] board = new int[n][n];
			for(int row = 0; row < n; row++) {
				for(int col = 0; col < n; col++) {
					board[row][col] = sc.nextInt();
				}
			}
			int answer = 0;
			for(int day = 0; day <= 100; day++) {
				boolean[][] visited = new boolean[n][n];
				int cnt = 0;
				for(int row = 0; row < n; row++) {
					for(int col = 0; col < n; col++) {
						if(board[row][col] > day && !visited[row][col]) {
							BFS(board, visited, row, col, day);
							cnt++;
						}
					}
				}
				answer = Math.max(cnt, answer);
			}
			System.out.println("#"+testcase+" "+answer);
		}
	}
}
