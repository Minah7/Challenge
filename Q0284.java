// X=0인 출발점에서 출발하는 사례에 대해서 화살표로 표시한 바와 같이, 
// 아래 방향으로 진행하면서 좌우 방향으로 이동 가능한 통로가 나타나면 방향 전환을 하게 된다.
// 방향 전환 이후엔 다시 아래 방향으로만 이동하게 되며, 바닥에 도착하면 멈추게 된다.
// 문제의 X표시에 도착하려면 X=4인 출발점에서 출발해야 하므로 답은 4가 된다. 해당 경로는 별도로 표시하였다.

// 성공

import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt();

			int[][] ladder = new int[100][100];

			for (int r = 0; r < 100; r++) {
				for (int c = 0; c < 100; c++) {
					ladder[r][c] = sc.nextInt();
				}
			}
			
			int answer = 0;
			for (int c = 0; c < 100; c++) {
				if (ladder[99][c] == 2) {
					int x = c;
					for (int r = 99; r >= 0; r--) {
						if (r == 0) {
							answer = x;
						} else if(x != 0 && ladder[r][x - 1] == 1) {
							x--;
							while (ladder[r - 1][x] == 0) {
								x--;
							}
						} else if(x != 99 && ladder[r][x+1] == 1) {
							x++;
							while(ladder[r-1][x] == 0) {
								x++;
							}
						} else {
							continue;
						}
					}
				}
			}
			
			
			System.out.println("#" + tc + " " + answer);
		}
	}
}