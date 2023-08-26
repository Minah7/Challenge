10개의 수를 입력 받아, 평균값을 출력하는 프로그램을 작성하라.
(소수점 첫째 자리에서 반올림한 정수를 출력한다.)

import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int testcase = 1; testcase <= T; testcase++) {
            int sum = 0;
            for(int i = 0; i < 10; i++) {
                sum += sc.nextInt();
            }
            double avg = sum/10.0;
            System.out.println("#"+testcase+" "+Math.round(avg));
        }
	}
}