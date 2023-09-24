// 주어진 미로의 출발점으로부터 도착지점까지 갈 수 있는 길이 있는지 판단하는 프로그램을 작성하라.
// 각 테스트 케이스의 첫 번째 줄에는 테스트 케이스의 번호가 주어지며, 바로 다음 줄에 테스트 케이스가 주어진다.
// 총 10개의 테스트케이스가 주어진다.
// 테스트 케이스에서 1은 벽을 나타내며 0은 길, 2는 출발점, 3은 도착점을 나타낸다.

// 성공

package Topological_Sort;

import java.util.Arrays;
import java.util.Scanner;

public class 미로1 {
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	
	static void DFS(int[][] maze, boolean[][] visited, int[] answer, int row, int col) {
		if(maze[row][col] == 3) {
			answer[0] = 1;
		} else {
			visited[row][col] = true;
			for(int dir = 0; dir < 4; dir++) {
				int nr = row+dr[dir];
				int nc = col+dc[dir];
				if(0 <= nr && nr < 16 && 0 <= nc && nc < 16 && maze[nr][nc] != 1 && !visited[nr][nc]) {
					DFS(maze, visited, answer, nr, nc);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int testcase = 1; testcase <= 10; testcase++) {
			sc.nextInt();
			int[][] maze = new int[16][16];
			for(int row = 0; row < 16; row++) {
				String r = sc.next();
				for(int col = 0; col < 16; col++) {
					maze[row][col] = r.charAt(col)-'0';
				}
			}
			int[] answer = new int[1];
			boolean[][] visited = new boolean[16][16];
			out: for(int row = 0; row < 16; row++) {
				for(int col = 0; col < 16; col++) {
					if(maze[row][col] == 2) {
						DFS(maze, visited, answer, row, col);
						if(answer[0] == 1) break out;
					}
				}
			}
			System.out.println("#"+testcase+" "+answer[0]);
		}
	}
}
