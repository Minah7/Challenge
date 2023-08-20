// 월 일로 이루어진 날짜를 2개 입력 받아, 두 번째 날짜가 첫 번째 날짜의 며칠째인지 출력하는 프로그램을 작성하라.

// 성공

import java.util.Scanner;

public class 날짜계산기1 {
	public static int[] datePerMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	public static void main(String[] args) {
		for(int i = 2; i < datePerMonth.length; i++) {
			datePerMonth[i] = datePerMonth[i-1]+datePerMonth[i];
		}
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int testcase = 1; testcase <= T; testcase++) {
			int month1 = sc.nextInt();
			int day1 = sc.nextInt();
			int month2 = sc.nextInt();
			int day2 = sc.nextInt();
			
			int days1 = datePerMonth[month1-1]+day1;
			int days2 = datePerMonth[month2-1]+day2;
			
			System.out.println("#"+testcase+" "+(days2-days1+1));
		}
	}
}
