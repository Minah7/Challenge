// 하나의 자연수를 입력 받아 각 자릿수의 합을 계산하는 프로그램을 작성하라.

// 성공

import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		String num = sc.next();
		int answer = 0;
		for(int i = 0; i < num.length(); i++) {
			answer += num.charAt(i) - '0';
		}
		System.out.println(answer);
	}
}