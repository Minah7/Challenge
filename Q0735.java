// 문제링크: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5QQhbqA4QDFAUq
// 10개의 수를 입력 받아, 그 중에서 가장 큰 수를 출력하는 프로그램을 작성하라.
// 성공

package APS;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for(int tc = 1; tc <= testcase; tc++) {
			int answer = 0;
			for(int i = 0; i < 10; i++) {
				answer = Math.max(answer, sc.nextInt());
			}
			System.out.println("#"+tc+" "+answer);
		}
	}
}