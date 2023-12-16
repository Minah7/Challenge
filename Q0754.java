// 문제링크: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWVl47b6DGMDFAXm
// 이러한 레이저와 쇠막대기의 배치는 다음과 같이 괄호를 이용하여 왼쪽부터 순서대로 표현할 수 있다.
// 1. 레이저는 여는 괄호와 닫는 괄호의 인접한 쌍 “()” 으로 표현된다. 또한, 모든 “()”는 반드시 레이저를 표현한다.
// 2. 쇠막대기의 왼쪽 끝은 여는 괄호 ‘(’ 로, 오른쪽 끝은 닫힌 괄호 ‘)’ 로 표현된다.
// 실패. 50%

package APS;

import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testcase = sc.nextInt();
		for (int tc = 1; tc <= 10; tc++) {
			int answer = 0;
			String s = sc.next();
			Stack<Character> bar = new Stack<>();
			for(int i = 0; i < s.length(); i++) {
				if(s.charAt(i) == '(') {
					bar.add('(');
				} else {
					if(s.charAt(i-1) == '(') {
						bar.pop();
						answer += bar.size();
					} else {
						bar.pop();
						answer++;
					}
				}
			}
			System.out.println("#"+tc+" "+answer);
		}
	}
}