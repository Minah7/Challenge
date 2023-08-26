10개의 수를 입력 받아, 그 중에서 가장 큰 수를 출력하는 프로그램을 작성하라.

import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int testcase = 1; testcase <= T; testcase++) {
            int max = 0;
            for(int i = 0; i < 10; i++) {
                int n = sc.nextInt();
                if(max < n) max = n;
            }
            System.out.println("#"+testcase+" "+max);
        }
	}
}
