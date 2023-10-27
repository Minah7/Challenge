// 평면에 색깔이 서로 다른 직사각형 모양의 색종이 N장이 하나씩 차례로 놓여진다. 
// 이때 색종이가 비스듬하게 놓이는 경우는 없다. 
// 즉, 모든 색종이의 변은 서로 평행하거나, 서로 수직이거나 둘 중 하나이다. 
// 그림-1은 1번, 2번, 3번 세 장의 색종이가 순서대로 놓인 상태를 보여준다.

// 여기에 그림-2에서 보인 것처럼 4번 색종이가 하나 더 놓이면 
// 3번 색종이는 완전히 가려서 보이지 않게 된다. 
// 그리고, 1번 색종이와 2번 색종이는 부분적으로 가려 보이며, 4번 색종이는 완전히 보이게 된다.

// N장의 색종이가 주어진 위치에 차례로 놓일 경우, 
// 각 색종이가 보이는 부분의 면적을 구하는 프로그램을 작성하시오. 

// 입력의 첫 번째 줄에는 색종이의 장수를 나타내는 정수 N (1 ≤ N ≤ 100)이 주어진다. 
// 이어서 N장의 색종이에 관한 입력이 각 색종이마다 한 줄씩 차례로 주어진다. 
// 색종이가 놓이는 평면은 가로 최대 1001칸, 세로 최대 1001칸으로 구성된 격자 모양이다. 
// 격자의 각 칸은 가로, 세로 길이가 1인 면적이 1인 정사각형이다. 

// 편의상 가로 6칸, 세로 6칸으로 이루어진 격자의 예를 들어 설명하면, 
// 각 칸에 표시된 값 (a,b)는 해당 칸의 번호를 나타낸다. 
// 가장 왼쪽 아래의 칸은 (0,0) 가장 오른 쪽 위의 칸은 (5,5)이다. 

// 색종이가 놓인 상태는 가장 왼쪽 아래 칸의 번호와 너비, 높이를 나타내는 네 정수로 표현한다. 
// 예를 들어, 위 그림에서 회색으로 표시된 색종이는 (1,4)가 가장 왼쪽 아래에 있고 
// 너비 3, 높이 2이므로 1 4 3 2로 표현한다. 색종이가 격자 경계 밖으로 나가는 경우는 없다. 

// 성공

package Baekjoon;

import java.util.Scanner;

public class B10163 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] paper = new int[1001][1001];
		for(int i = 1; i <= n; i++) {
			int startRow = sc.nextInt();
			int startCol = sc.nextInt();
			int w = sc.nextInt();
			int h = sc.nextInt();
			for(int r = startRow; r < startRow+w; r++) {
				for(int c = startCol; c < startCol+h; c++) {
					paper[r][c] = i;
				}
			}
		}
		int[] cnt = new int[n+1];
		for(int r = 0; r < 1001; r++) {
			for(int c = 0; c < 1001; c++) {
				cnt[paper[r][c]]++;
			}
		}
		for(int i = 1; i <= n; i++) {
			System.out.println(cnt[i]);
		}
	}
}
