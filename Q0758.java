// 문제링크: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWGsRbk6AQIDFAVW
// N개의 카드가 있는 덱이 주어질 때 이를 퍼펙트 셔플하면 어떤 순서가 되는지 출력하는 프로그램을 작성하라.
// 성공

package APS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testcase = sc.nextInt();
		for (int tc = 1; tc <= testcase; tc++) {
			int n = sc.nextInt();
			Queue<String> queue1 = new LinkedList<>();
			Queue<String> queue2 = new LinkedList<>();
			
			if(n%2 == 1) {
				for(int i = 0; i < n/2+1; i++) {
					queue1.add(sc.next());
				}
			} else {
				for(int i = 0; i < n/2; i++) {
					queue1.add(sc.next());
				}				
			}
			for(int i = 0; i < n/2; i++) {
				queue2.add(sc.next());
			} // 여기까지 입력값
			
			String answer = "";
			for(int i = 0; i < n; i++) {
				if(i%2 == 0) {
					answer += queue1.poll()+" ";					
				} else {
					answer += queue2.poll()+" ";
				}
			}
			System.out.println("#"+tc+" "+answer);
		}
	}
}