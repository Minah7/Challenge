// 문제링크: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14eWb6AAkCFAYD
// 4 종류의 괄호문자들 '()', '[]', '{}', '<>' 로 이루어진 문자열이 주어진다.
// 이 문자열에 사용된 괄호들의 짝이 모두 맞는지 판별하는 프로그램을 작성한다.
// 성공.

package APS;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
			int answer = 1;
			int n = sc.nextInt();
			char[] stack = new char[n];
			char[] openingBrkt = {'(', '[', '{', '<'};
			char[] closingBrkt = {')', ']', '}', '>'};
			
			int top = -1;
			String brackets = sc.next();
			out: for(int b = 0; b < n; b++) {
				if(brackets.charAt(b) == '(' || brackets.charAt(b) == '[' || brackets.charAt(b) == '{' || brackets.charAt(b) == '<') {
					stack[++top] = brackets.charAt(b);
				} else if(top != -1) {
					for(int i = 0; i < 4; i++) {
						if(brackets.charAt(b) == closingBrkt[i]) {
							if(stack[top] == openingBrkt[i]) {
								top--;
							} else {
								answer = 0;
								break out;
							}
						} else continue;
					}
				}
			}
			System.out.println("#"+tc+" "+answer);
		}
	}
}