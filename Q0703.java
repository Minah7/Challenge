// 패턴에서 반복되는 부분을 마디라고 부른다. 
// 문자열을 입력 받아 마디의 길이를 출력하는 프로그램을 작성하라.

// [제약 사항]
// 각 문자열의 길이는 30이다. 마디의 최대 길이는 10이다.

// [입력]
// 가장 첫 줄에는 테스트 케이스의 개수 T가 주어지고, 
// 그 아래로 각 테스트 케이스가 주어진다.

// 각 테스트 케이스의 첫 번째 줄에는 길이가 30인 문자열이 주어진다.

// 성공

package APS;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for(int tc = 1; tc <= testcase; tc++) {
			String str = sc.next();
			int pattern = 0;
			for(int i = 1; i <= 10; i++) {
				if(str.substring(0, i).equals(str.substring(i, i+i))) {
					pattern = i;
					break;
				}
			}
			System.out.println("#"+tc+" "+pattern);
		}
	}
}
