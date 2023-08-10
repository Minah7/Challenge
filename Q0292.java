// 2개의 수 a, b를 입력 받아, a를 b로 나눈 몫과 나머지를 출력하는 프로그램을 작성하라.

// 성공

import java.util.Scanner;
import java.io.FileInputStream;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			int quotient = a/b;
			int remainder = a%b;
			
			System.out.println("#"+tc+" "+quotient+" "+remainder);
		}
	}
}