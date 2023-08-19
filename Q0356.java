// 10개의 수를 입력 받아, 그 중에서 가장 큰 수를 출력하는 프로그램을 작성하라.

//성공

import java.util.Scanner;

public class 최대수구하기 {
	public static void main(String[] args) {
		//스캐너 사용해 값 받아오기
		Scanner sc = new Scanner(System.in);
		//테스트 케이스 개수 받기
		int T = sc.nextInt();
		//T개수만큼 반복문 돌리기
		for(int testcase = 1; testcase <= T; testcase++) {
			//가장 큰 수를 얻기 위해 int 최소값으로 설정
			int max = Integer.MIN_VALUE;
			//10개의 수 받아오기 위한 반복문
			for(int n = 0 ; n < 10; n++) {
				//수 num 변수에 받기
				int num = sc.nextInt();
				//받을 때마다 max와 비교해서 조건문 충족하면 바꿔주기
				if(max < num) max = num;
			}
			System.out.println("#"+testcase+" "+max);
		}
	}
}
