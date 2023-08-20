// 월 일로 이루어진 날짜를 2개 입력 받아, 두 번째 날짜가 첫 번째 날짜의 며칠째인지 출력하는 프로그램을 작성하라.

// 성공

import java.util.Scanner;

public class 날짜계산기 {
	public static int datePerMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public static void main(String[] args) {
		//datePerMonth의 누적합 구하기
		for(int m = 2; m < datePerMonth.length; m++) {
			datePerMonth[m] = datePerMonth[m]+datePerMonth[m-1];
		}
		Scanner sc = new Scanner(System.in);
		//테스트케이스 개수 T 받기
		int T = sc.nextInt();
		for(int testcase =1 ; testcase <= T; testcase++) {
			int month1 = sc.nextInt();
			int day1 = sc.nextInt();
			int month2 = sc.nextInt();
			int day2 = sc.nextInt();
			//1/1부터 첫번째 날짜의 누적합 구하기
			int days1 = datePerMonth[month1-1] + day1;
            //1/1부터 두번째 날짜의 누적합 구하기
			int days2 = datePerMonth[month2-1] + day2;
			//두번째 날짜 누적합과 첫번째 날짜 누적합을 뺀 뒤 1 더해줘서 날짜 구하기
			System.out.println("#"+testcase+" "+(days2-days1+1));
		}
	}
}
