// 10개의 수를 입력 받아, 
// 최대 수와 최소 수를 제외한 나머지의 평균값을 출력하는 프로그램을 작성하라.
// (소수점 첫째 자리에서 반올림한 정수를 출력한다.)

// 성공

package SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for(int tc = 1; tc <= testcase; tc++) {
			int[] num = new int[10];
			int sum = 0;
			for(int i = 0; i < 10; i++) {
				num[i] = sc.nextInt();
				sum += num[i];
			}
			Arrays.sort(num);
			sum -= (num[0]+num[9]);
			System.out.println("#"+tc+" "+Math.round(sum/8.0));
		}
	}
}
