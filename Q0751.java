// 문제링크: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14P0c6AAUCFAYi
// 주어지는 영어 문장에서 특정한 문자열의 개수를 반환하는 프로그램을 작성하여라.
// 성공.

package APS;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			sc.next(); // tc 번호 입력값 필요 x
			
			String find = sc.next();
			String sentence = sc.next();
			
			int answer = 0;
			
			// for(int i = 0; i <= sentence.length()-find.length(); i++) {
			// 	if(sentence.charAt(i) == find.charAt(0)) {
			// 		for(int check = 0; check < find.length(); check++) {
			// 			if(sentence.charAt(i+check) != find.charAt(check)) {
			// 				break;
			// 			}
			// 			if(check == find.length()-1) answer++;
			// 		}
			// 	} //시작 문자가 같으면 탐색 시작
			// }

            // 위 주석 처리된 코드 수정
            for(int i = 0; i <= sentence.length()-find.length(); i++) {
				for(int check = 0; check < find.length(); check++) {
					if(sentence.charAt(i+check) != find.charAt(check)) {
						break;
					}
					if(check == find.length()-1) answer++;
				}
			}
			System.out.println("#"+tc+" "+answer);
		}
	}
}
