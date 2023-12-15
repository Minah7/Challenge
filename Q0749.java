// 문제링크: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PyTLqAf4DFAUq
// 단어를 입력 받아 회문이면 1을 출력하고, 아니라면 0을 출력하는 프로그램을 작성하라.
// 성공.

package APS;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int testcase = sc.nextInt();
		for (int tc = 1; tc <= testcase; tc++) {
			int answer = 1;
			String word = sc.next();
			for(int i = 0; i < word.length()/2; i++) {
				if(word.charAt(i) != word.charAt(word.length()-1-i)) {
					answer = 0;
					break;
				}
			}
			System.out.println("#"+tc+" "+answer);
		}
	}
}