// 어느 고등학교에서 실시한 1000명의 수학 성적을 토대로 통계 자료를 만들려고 한다.
// 이때, 이 학교에서는 최빈수를 이용하여 학생들의 평균 수준을 짐작하는데, 여기서 최빈수는 특정 자료에서 가장 여러 번 나타나는 값을 의미한다.
// 최빈수를 출력하는 프로그램을 작성하여라 (단, 최빈수가 여러 개 일 때에는 가장 큰 점수를 출력하라).

// 성공

import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[] records = new int[1000];
			for(int i = 0; i < 1000; i++) {
				records[i] = sc.nextInt();
			}
			int[] score = new int[101];
			for(int i = 0; i < 1000; i++) {
				score[records[i]] += 1;
			}
			int maxCnt = -1;
			int answer = 0;
			for(int i = 0; i < 101; i++) {
				if(maxCnt < score[i]) {
					maxCnt = score[i];
					answer = i;
				} else if(maxCnt == score[i]) {
					answer = i;
				}
			}
			System.out.println("#"+t+" "+answer);
		}
	}
}