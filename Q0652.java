// N×M의 행렬로 표현되는 맵이 있다. 
// 맵에서 0은 이동할 수 있는 곳을 나타내고, 
// 1은 이동할 수 없는 벽이 있는 곳을 나타낸다. 
// 당신은 (1, 1)에서 (N, M)의 위치까지 이동하려 하는데, 
// 이때 최단 경로로 이동하려 한다. 
// 최단경로는 맵에서 가장 적은 개수의 칸을 지나는 경로를 말하는데, 
// 이때 시작하는 칸과 끝나는 칸도 포함해서 센다.

// 만약에 이동하는 도중에 한 개의 벽을 부수고 이동하는 것이 좀 더 경로가 짧아진다면, 
// 벽을 한 개 까지 부수고 이동하여도 된다.

// 한 칸에서 이동할 수 있는 칸은 상하좌우로 인접한 칸이다.
// 맵이 주어졌을 때, 최단 경로를 구해 내는 프로그램을 작성하시오.

// 다시 풀어볼 문제. 이해가 안돼서 블로그 참고함.

package Baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 벽_부수고_이동하기 {
	
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int n, m;
	static int[][] board;
	static boolean[][][] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		sc.nextLine();
		
		board = new int[n][m];
		for(int i = 0; i < n; i++) {
			String str = sc.nextLine();
			for(int j = 0; j < m; j++) {
				board[i][j] = Integer.valueOf(str.charAt(j))-'0';
			}
		}
		visited = new boolean[n][m][2];
		System.out.println(bfs(0,0));
	}
	
	private static int bfs(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x, y, 1, 0));
		visited[x][y][0] = true;
		visited[x][y][1] = true;
		
		while(!q.isEmpty()) {
			Node current = q.poll();
			
			if(current.x == n-1 && current.y == m-1) return current.count;
			
			for(int i = 0; i < 4; i++) {
				int nx = current.x + dx[i];
				int ny = current.y + dy[i];
				
				if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
					if(board[nx][ny] == 0) {
						if(visited[nx][ny][current.wall] == false) {
							q.add(new Node(nx, ny, current.count+1, current.wall));
							visited[nx][ny][current.wall] = true;
						}
					}
					else if(board[nx][ny] == 1) {
						if(current.wall == 0 && visited[nx][ny][1] == false) {
							q.add(new Node(nx, ny, current.count+1, 1));
							visited[nx][ny][1] = true;
						}
					}
				}
			}
		}
		return -1;
	}
	private static class Node {
		private int x;
		private int y;
		private int count;
		private int wall;
		
		public Node(int x, int y, int count, int wall) {
			this.x = x;
			this.y = y;
			this.count = count;
			this.wall = wall;
		}
	}
}
