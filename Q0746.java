// 문제링크: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV13_BWKACUCFAYh
// 00 x 100 크기의 2차원 배열로 주어진 사다리에 대해서, 지정된 도착점에 대응되는 출발점 X를 반환하는 코드를 작성하라
// 성공.

package APS;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc = 1; tc <= 10; tc++) {
			sc.nextInt();
			int[][] ladder = new int[100][100];
			for(int row = 0; row < 100; row++) {
				for(int col = 0; col < 100; col++) {
					ladder[row][col] = sc.nextInt();
				}
			} // 입력값
			int answer = -1;
			// column 0부터 1까지 돌면서 1이면 탐색 시작
			loop: for(int col = 0; col < 100; col++) {
				if(ladder[0][col] == 1) {
					int tmpC = col;
					// 0번째 row부터 99번째까지 이동
					for(int row = 0; row < 100; row++) {
						//99번째 줄(도착지)에 도달했을 때 2라면 시작했던 column의 값 출력
						if(row == 99 && ladder[row][tmpC] == 2) {
							answer = col;
							break loop;
						}
						//만약 좌우에 1이 있다면 그 방향의 1이 끝날 때까지 이동
						if(tmpC-1 >= 0 && ladder[row][tmpC-1] == 1) {
							while(true) {
								if(tmpC-1 < 0 || ladder[row][tmpC-1] != 1) {
									break;
								} 
								tmpC--;
							}
							continue;
						} else if(tmpC+1 < 100 && ladder[row][tmpC+1] == 1) {
							while(true) {
								if(tmpC+1 >= 100 || ladder[row][tmpC+1] != 1) {
									break;
								}
								tmpC++;
							}
						}
					} // 아래로 내려가기
				}
			}
			System.out.println("#"+tc+" "+answer);
		}
	}
}