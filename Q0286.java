// 2개의 수를 입력 받아 크기를 비교하여 등호 또는 부등호를 출력하는 프로그램을 작성하라.

// 성공

import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();

            if (num1 > num2) {
                System.out.println("#"+tc+" >");
            } else if (num1 == num2) {
                System.out.println("#"+tc+" =");
            } else if (num1 < num2) {
                System.out.println("#"+tc+" <");
            }
		}
	}
}