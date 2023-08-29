// 정수 N, M 이 주어질 때, M의 이진수 표현의 마지막 N 비트가 모두 1로 켜져 있는지 아닌지를 판별하여 출력하라.

// 성공

import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testcase = 1; testcase <= T; testcase++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			String answer = "ON";
            //N이하의 자릿수만큼 0인지 아닌지 확인해서 0이면 OFF로 변경
			for (int i = 0; i < N; i++) {
				if(((int)Math.pow(2, i) & M) == 0) {
					answer = "OFF";
				}
			}
			System.out.println("#"+testcase+" "+answer);
		}
	}
}