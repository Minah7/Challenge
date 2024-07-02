// 문제링크: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5QRnJqA5cDFAUq

// 10개의 수를 입력 받아, 평균값을 출력하는 프로그램을 작성하라.
// (소수점 첫째 자리에서 반올림한 정수를 출력한다.)

// 성공

package Array1;

import java.util.Scanner;

public class 평균값_구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testcase = sc.nextInt();
		for(int tc = 1; tc <= testcase; tc++) {
			double sum = 0;
			for(int i = 0; i < 10; i++) {
				sum += sc.nextDouble();
			}
			
			System.out.println("#" + tc + " " + Math.round(sum / 10));
		}
	}
}
