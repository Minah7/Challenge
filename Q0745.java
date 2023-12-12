// 문제링크: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV13_BWKACUCFAYh
// 다음 100X100의 2차원 배열이 주어질 때, 각 행의 합, 각 열의 합, 각 대각선의 합 중 최댓값을 구하는 프로그램을 작성하여라.
// 성공.

package APS;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc = 1; tc <= 1; tc++) {
			sc.nextInt();
			int[][] arr = new int[100][100];
			for(int row = 0; row < 100; row++) {
				for(int col = 0; col < 100; col++) {
					arr[row][col] = sc.nextInt();
				}
			} // 입력값
			
			int answer = Integer.MIN_VALUE;
			// 각 행의 합 구하기
			for(int row = 0; row < 100; row++) {
				int sum = 0;
				for(int col = 0; col < 100; col++) {
					sum += arr[row][col];
				}
				answer = Math.max(answer, sum);
			}
			// 각 열의 합 구하기
			for(int col = 0; col < 100; col++) {
				int sum = 0;
				for(int row = 0; row < 100; row++) {
					sum += arr[row][col];
				}
				answer = Math.max(answer, sum);
			}
			// 각 대각선의 합 구하기
			int sumD1 = 0;
			int sumD2 = 0;
			for(int i = 0; i < 100; i++) {
				// 대각선 1 : (0,0)에서 (99,99)으로 이동
				sumD1 += arr[i][i];
				// 대각선 2 : (0,99)에서 (99, 0)으로 이동
				sumD2 += arr[i][99-i];
			}
			answer = Math.max(answer, sumD1);
			answer = Math.max(answer, sumD2);
			System.out.println("#"+tc+" "+answer);
		}
	}
}