// 주어지는 영어 문장에서 특정한 문자열의 개수를 반환하는 프로그램을 작성하여라.
// Starteatingwellwiththeseeighttipsforhealthyeating,whichcoverthebasicsofahealthydietandgoodnutrition.
// 위 문장에서 ti 를 검색하면, 답은 4이다.

// [제약 사항]
// 총 10개의 테스트 케이스가 주어진다.
// 문장의 길이는 1000자를 넘어가지 않는다.
// 한 문장에서 검색하는 문자열의 길이는 최대 10을 넘지 않는다.
// 한 문장에서는 하나의 문자열만 검색한다. 

// [입력]
// 각 테스트 케이스의 첫 줄에는 테스트 케이스의 번호가 주어지고 그 다음 줄에는 찾을 문자열, 그 다음 줄에는 검색할 문장이 주어진다.

// 성공

package APS;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc = 1; tc <= 10; tc++) {
			sc.nextInt();
			String check = sc.next();
			String word = sc.next();
			int checkN = check.length();
			int cnt = 0;
			for(int i = 0; i < word.length()-checkN+1; i++) {
				if(word.substring(i, i+checkN).equals(check)) {
					System.out.println(i);
					cnt++;
				}
			}
			System.out.println("#"+tc+" "+cnt);
		}
	}
}
