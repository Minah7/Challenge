// 문제링크: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14dUIaAAUCFAYD
// 다음과 같이 두 개의 숫자 N, M이 주어질 때, N의 M 거듭제곱 값을 구하는 프로그램을 재귀호출을 이용하여 구현해 보아라.
// 성공

package APS;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
			sc.next();
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			System.out.println("#"+tc+" "+pow(n,m));
		}
	}
	public static int pow(int n, int m) {
		if(m == 1) return n;
		return n*pow(n, m-1);
	}
}