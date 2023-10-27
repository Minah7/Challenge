// 평면에 네 개의 직사각형이 놓여 있는데 그 밑변은 모두 가로축에 평행하다. 
// 이 네 개의 직사각형들은 서로 떨어져 있을 수도 있고, 겹쳐 있을 수도 있고, 
// 하나가 다른 하나를 포함할 수도 있으며, 변이나 꼭짓점이 겹칠 수도 있다.

// 이 직사각형들이 차지하는 면적을 구하는 프로그램을 작성하시오.

// 입력은 네 줄이며, 각 줄은 직사각형의 위치를 나타내는 네 개의 정수로 주어진다. 
// 첫 번째와 두 번째의 정수는 사각형의 왼쪽 아래 꼭짓점의 x좌표, y좌표이고 
// 세 번째와 네 번째의 정수는 사각형의 오른쪽 위 꼭짓점의 x좌표, y좌표이다. 
// 모든 x좌표와 y좌표는 1이상이고 100이하인 정수이다.

// 성공

package Baekjoon;

import java.util.Scanner;

public class B2669 {
	public static void main(String[] args) {
		int answer = 0;
		boolean [][] area = new boolean[101][101];
		
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < 4; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			for(int r = y1; r < y2; r++) {
				for(int c = x1; c < x2; c++) {
					area[r][c] = true;
				}
			}
		}
		for(int r = 1; r <= 100; r++) {
			for(int c = 1; c <= 100; c++) {
				if(area[r][c] == true) {
					answer++;
				}
			}
		}
		System.out.println(answer);
	}
}
