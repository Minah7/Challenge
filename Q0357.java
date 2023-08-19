// 10개의 수를 입력 받아, 평균값을 출력하는 프로그램을 작성하라.
// (소수점 첫째 자리에서 반올림한 정수를 출력한다.)

// 성공

import java.util.Scanner;
import java.io.FileInputStream;

public class 평균값구하기 {
	public static void main(String[] args) {
		//스캐너 사용해서 값 받아오기
		Scanner sc = new Scanner(System.in);
		//테스트케이스 T값 받아오기
		int T = sc.nextInt();
		//T개수만큼 반복해서 문제풀기
		for(int testcase = 1; testcase <= T; testcase++) {
			//각 숫자의 합을 구할 변수
			int sum = 0;
			//10개의 숫자를 받아오면서 sum에 더해주기
			for(int idx = 0; idx < 10; idx++) {
				sum += sc.nextInt();
			}
			//평균 구하기 위한 변수. 반올림해야하기 때문에 실수로 10.0을 사용해 실수로 만들기
			double avg = sum/10.0;
			//Math.round()사용해 반올림값 출력
			System.out.println("#"+testcase+" "+Math.round(avg));
		}
	}
}
