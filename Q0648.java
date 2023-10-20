// 연월일 순으로 구성된 8자리의 날짜가 입력으로 주어진다.
// 해당 날짜의 유효성을 판단한 후, 날짜가 유효하다면
// [그림1] 과 같이 ”YYYY/MM/DD”형식으로 출력하고,
// 날짜가 유효하지 않을 경우, -1 을 출력하는 프로그램을 작성하라.

// 연월일로 구성된 입력에서 월은 1~12 사이 값을 가져야 하며
// 일은 [표1] 과 같이, 1일 ~ 각각의 달에 해당하는 날짜까지의 값을 가질 수 있다.

// ※ 2월의 경우, 28일인 경우만 고려한다. (윤년은 고려하지 않는다.)

//실패. 모든 테케 출력이 안됨. 5개 중 2개만 출력.
package APS;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for(int tc = 1; tc <= testcase; tc++) {
			String date = sc.next();
			int year = Integer.parseInt(date.substring(0, 4));
			int month = Integer.parseInt(date.substring(4, 6));
			if(month < 1 || month > 12) {
				System.out.println("#"+tc+" -1");
				break;
			}
			int day = Integer.parseInt(date.substring(6));
			switch(month) {
				case 1: case 3: case 5: case 7: case 8: case 10: case 12:
					if(day < 1 || day > 31) {
						System.out.println("#"+tc+" -1");
						break;
					}
				case 2 :
					if(day < 1 || day > 28) {
						System.out.println("#"+tc+" -1");
						break;
					}
				case 4: case 6: case 9: case 11 : 
					if(day < 1 || day > 30) {
						System.out.println("#"+tc+" -1");
						break;
					}
			}
			String answer = date.substring(0, 4) + "/" + date.substring(4, 6) + "/" + date.substring(6);
			System.out.println("#"+tc+" "+answer);
		}
	}
}
