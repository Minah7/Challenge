// 문제링크: https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AYZOEkza5qMDFARc

// 가로 N 세로 100 크기의 방에 상자들이 쌓여있다. 방이 오른쪽으로 90도 회전하여 상자들이 중력의 영향을 받아 낙하한다고 할 때, 가장 큰 낙차를 구하여라

// 성공

package Array1;

import java.util.Scanner;

public class Gravity {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testcase = sc.nextInt();
		for(int tc = 1; tc <= testcase; tc++) {
			int width = sc.nextInt();
			
			int[] height = new int[width];
			for(int box = 0; box < width; box++) {
				height[box] = sc.nextInt();
			}
			
			int answer = 0;
			for(int box = width - 2; box >= 0; box--) {
				if(height[box] > 0) {
					int cnt = 0;
					for(int i = box + 1; i < width; i++) {
						if(height[box] > height[i]) {
							cnt++;
						} else {
							break;
						}
					}
					
					if(cnt > 0) {
						int temp = height[box];
						height[box] = height[box + cnt];
						height[box + cnt] = temp;
					}
					
					if(cnt > answer) {
						answer = cnt;
					}
				}
			}
			
			System.out.println("#" + tc + " " + answer);
		}
	}
}
