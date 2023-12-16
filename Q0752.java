// 문제링크: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AW5jBWLq7jwDFATQ
// 재민이는 재현이가 부르는 액수를 순서대로 적고 있다. 재현이는 가끔 잘못된 수를 부르는 실수를 하는데, 
// 이 때마다 0을 외쳐서, 가장 최근에 재민이가 쓰고 지우지 않았던 수를 지우게 시킨다.
// 재현이가 모든 수를 부른 후 재민이가 받아 적은 수의 합은 무엇일까?
// 성공.

package SWEA;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for(int tc = 1; tc <= testcase; tc++) {
			int k = sc.nextInt();
			int[] stack = new int[k];
			int top = -1;
			for(int num = 0; num < k; num++) {
				int n = sc.nextInt();
				if(n == 0) {
					if(top != -1) {
						top--;
					} else if(top == -1){
						continue;
					}
				} else {
					stack[++top] = n;
				}
			}
			int answer = 0;
			if(top != -1) {
				for(int i = top; i >= 0; i--) {
					answer += stack[i];
				}
			}
			System.out.println("#"+tc+" "+answer);
		}
	}
}