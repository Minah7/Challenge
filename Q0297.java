import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int testCase = 1; testCase <= T; testCase++) {

            int sum = 0;
            for(int i = 0; i < 10; i++) {
                sum += sc.nextInt();
            }
            
            int answer = Math.round(sum/10);
            System.out.println("#"+testcase+" "+answer);
        }
    }
}