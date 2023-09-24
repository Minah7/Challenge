// 아래 그림과 같은 미로가 있다. 100*100 행렬의 형태로 만들어진 미로에서 흰색 바탕은 길, 노란색 바탕은 벽을 나타낸다.
// 가장 좌상단에 있는 칸을 (0, 0)의 기준으로 하여, 가로방향을 x 방향, 세로방향을 y 방향이라고 할 때, 미로의 시작점은 (1, 1)이고 도착점은 (13, 13)이다.
// 주어진 미로의 출발점으로부터 도착지점까지 갈 수 있는 길이 있는지 판단하는 프로그램을 작성하라.

// 각 테스트 케이스의 첫 번째 줄에는 테스트케이스의 번호가 주어지며, 바로 다음 줄에 테스트 케이스가 주어진다.
// 총 10개의 테스트 케이스가 주어진다.
// 테스트 케이스에서 1은 벽을 나타내며 0은 길, 2는 출발점, 3은 도착점을 나타낸다.

// 성공

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 미로2 {
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	
	static void BFS(int[][] maze, boolean[][] visited, int[] answer, int row, int col) {
		Queue<Integer[]> queue = new LinkedList<>();
		queue.add(new Integer[] {row, col});
		visited[row][col] = true;
		while(!queue.isEmpty()) {
			Integer[] rc = queue.poll();
			for(int dir = 0; dir < 4; dir++) {
				int nr = rc[0]+dr[dir];
				int nc = rc[1]+dc[dir];
				if(0 <= nr && nr < 100 && 0 <= nc && nc < 100 && maze[nr][nc] != 1 && !visited[nr][nc]) {
					queue.add(new Integer[] {nr, nc});
					visited[nr][nc] = true;
					if(maze[nr][nc] == 3) {
						answer[0] = 1;
						break;
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int testcase = 1; testcase <= 10; testcase++) {
			sc.nextInt();
			int[][] maze = new int[100][100];
			for(int row = 0; row < 100; row++) {
				String r = sc.next();
				for(int col = 0; col < 100; col++) {
					maze[row][col] = r.charAt(col)-'0';
				}
			}
			int[] answer = new int[1];
			boolean[][] visited = new boolean[100][100];
			out: for(int row = 0; row < 100; row++) {
				for(int col = 0; col < 100; col++) {
					if(maze[row][col] == 2) {
						BFS(maze, visited, answer, row, col);
						if(answer[0] == 1) break out;
					}
				}
			}
			System.out.println("#"+testcase+" "+answer[0]);
		}
	}
}
