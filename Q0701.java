// <그림 1>과 같이 정사각형 모양의 지도가 있다. 
// 1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다. 
// 철수는 이 지도를 가지고 연결된 집의 모임인 단지를 정의하고, 
// 단지에 번호를 붙이려 한다. 
// 여기서 연결되었다는 것은 어떤 집이 좌우, 
// 혹은 아래위로 다른 집이 있는 경우를 말한다. 
// 대각선상에 집이 있는 경우는 연결된 것이 아니다. 
// <그림 2>는 <그림 1>을 단지별로 번호를 붙인 것이다. 
// 지도를 입력하여 단지수를 출력하고, 
// 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오.

// 첫 번째 줄에는 총 단지수를 출력하시오. 
// 그리고 각 단지내 집의 수를 오름차순으로 정렬하여 한 줄에 하나씩 출력하시오.

// 성공

package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	
	public static void dfs(int[][] map, boolean[][] visit, int n, int[] cnt, int r, int c) {
		visit[r][c] = true;
		cnt[0] += 1;
		for(int d = 0; d < 4; d++) {
			int nr = r + dir[d][0];
			int nc = c + dir[d][1];
			if(0 <= nr && nr < n && 0 <= nc && nc < n && map[nr][nc] == 1 && !visit[nr][nc]) {
				dfs(map, visit, n, cnt, nr, nc);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];
		boolean[][] visit = new boolean[n][n];
		List<Integer> answer = new ArrayList<>();
		
		for(int r = 0; r < n; r++) {
			String str = br.readLine();
			for(int c = 0; c < n; c++){
                map[r][c] = str.charAt(c) - '0';
            }
		}
		
		for(int r = 0; r < n; r++) {
			for(int c = 0; c < n; c++) {
				int[] cnt = new int[1];
				if(map[r][c] == 1 && !visit[r][c]) {
					dfs(map, visit, n, cnt, r, c);
					answer.add(cnt[0]);
				}
			}
		}
		
		Collections.sort(answer);
		System.out.println(answer.size());
		for(int i = 0; i < answer.size(); i++) {
			System.out.println(answer.get(i));
		}
	}
}
