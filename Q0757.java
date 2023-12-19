// 문제링크: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14mbSaAEwCFAYD
// 문자열 계산식을 구성하는 연산자는 + 하나뿐이며 피연산자인 숫자는 0 ~ 9의 정수만 주어진다.
// 성공

package APS;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
			int n = sc.nextInt();
			char[] formula = sc.next().toCharArray();
			int answer = 0;
			
			for(int i = 0; i < n; i++) {
				if(formula[i] != '+') {
					answer += formula[i]-'0';
				}
			}
			System.out.println("#"+tc+" "+answer);
		}
	}
}