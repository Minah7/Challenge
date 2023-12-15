// 문제링크: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14Rq5aABUCFAYi
// 주어진 100x100 평면 글자판에서 가로, 세로를 모두 보아 가장 긴 회문의 길이를 구하는 문제이다.
// 성공.

package APS;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			sc.next(); // tc 번호 입력값 필요 x
			char[][] board = new char[100][100];
			for(int row = 0; row < 100; row++) {
				board[row] = sc.next().toCharArray();
			}
			int answer = 1; // 길이 1의 회문은 무조건 존재함
			for(int i = 0; i < 100; i++) {
				//가로 검사 
				for(int col = 0; col < 100; col++) {
					for(int check = 100-1; col < check; check--) {
						if(board[i][col] == board[i][check]) {
							int length = check-col+1;
							for(int l = 0; l < (length-2)/2; l++) {
								if(board[i][col+1+l] != board[i][check-1-l]) {
									break;
								} // 첫번째와 마지막 글자는 확인했기 때문에 제외하고 확인
								if(l == (length-2)/2-1) {
									answer = Math.max(answer, length);
								}
							}
						} // 만일 시작 글자와 끝 글자가 같으면 회문 탐색
					} // 뒤에서 col+1까지만 확인
				} // 앞에서 뒤로 이동
				//세로 검사
				for(int row = 0; row < 100; row++) {
					for(int check = 100-1; row < check; check--) {
						if(board[row][i] == board[check][i]) {
							int length = check-row+1;
							for(int l = 0; l < (length-2)/2; l++) {
								if(board[row+1+l][i] != board[check-1-l][i]) {
									break;
								}
								if(l == (length-2)/2-1) {
									answer = Math.max(answer, length);
								}
							}
						}
					}
				}
			}
			System.out.println("#"+tc+" "+answer);
		}
	}
}
