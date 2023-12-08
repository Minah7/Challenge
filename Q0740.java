// 문제링크: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV13zo1KAAACFAYh
// 최빈수를 출력하는 프로그램을 작성하여라 (단, 최빈수가 여러 개 일 때에는 가장 큰 점수를 출력하라).
// 성공

package APS;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for(int tc = 1; tc <= testcase; tc++) {
			sc.nextInt();
			int[] count = new int[101]; //점수의 개수를 샐 배열
			//학생 수 1000명의 점수 
			for(int s = 0; s < 1000; s++) {
				count[sc.nextInt()]++;
			}
			//최빈수 구하기
			int[] mode = new int[2];
			for(int i = 100; i >= 0; i--) {
				if(count[i] > mode[0]) {
					mode[0] = count[i];
					mode[1] = i;
				}
			}
			System.out.println("#"+tc+" "+mode[1]);
		}
	}
}