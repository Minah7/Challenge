// ‘쩰리’는 점프하는 것을 좋아하는 젤리다. 
// 단순히 점프하는 것에 지루함을 느낀 ‘쩰리’는 새로운 점프 게임을 해보고 싶어 한다. 
// 새로운 점프 게임의 조건은 다음과 같다.

// ‘쩰리’는 가로와 세로의 칸 수가 같은 정사각형의 구역 내부에서만 움직일 수 있다. 
// ‘쩰리’가 정사각형 구역의 외부로 나가는 경우엔 바닥으로 떨어져 즉시 게임에서 패배하게 된다.
// ‘쩰리’의 출발점은 항상 정사각형의 가장 왼쪽, 가장 위의 칸이다. 다른 출발점에서는 출발하지 않는다.
// ‘쩰리’가 이동 가능한 방향은 오른쪽과 아래 뿐이다. 위쪽과 왼쪽으로는 이동할 수 없다.
// ‘쩰리’가 가장 오른쪽, 가장 아래 칸에 도달하는 순간, 그 즉시 ‘쩰리’의 승리로 게임은 종료된다.
// ‘쩰리’가 한 번에 이동할 수 있는 칸의 수는, 현재 밟고 있는 칸에 쓰여 있는 수 만큼이다. 
// 칸에 쓰여 있는 수 초과나 그 미만으로 이동할 수 없다.
// 새로운 게임이 맘에 든 ‘쩰리’는, 계속 게임을 진행해 마침내 최종 단계에 도달했다. 
// 하지만, 게임을 진행하는 구역이 너무 넓어져버린 나머지, 이 게임에서 이길 수 있는지 없는지 가늠할 수 없어졌다. 
// ‘쩰리’는 유능한 프로그래머인 당신에게 주어진 구역에서 승리할 수 있는 지 알아봐 달라고 부탁했다. 
// ‘쩰리’를 도와 주어진 게임 구역에서 끝 점(오른쪽 맨 아래 칸)까지 도달할 수 있는지를 알아보자!

// 성공

package Baekjoon;

import java.util.Scanner;

public class 점프왕_쩰리 {
	static int[][] dir = {{0, 1}, {1, 0}};
	
	public static void dfs(int[][] map, boolean[][] visited, int n, int r, int c) {
		if(map[r][c] == -1) {
			System.out.println("HaruHaru");
			System.exit(0);
		}
		for(int d = 0; d < 2; d++) {
			int nr = r + dir[d][0]*map[r][c];
			int nc = c + dir[d][1]*map[r][c];
			if(nr >= n || nc >= n || visited[nr][nc]) {
				continue;
			}
			visited[nr][nc] = true;
			dfs(map, visited, n, nr, nc);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] map = new int[n][n];
		for(int r = 0; r < n; r++) {
			for(int c = 0; c < n; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		boolean[][] visited = new boolean[n][n];
		dfs(map, visited, n, 0, 0);
		
		System.out.println("Hing");
	}
}
