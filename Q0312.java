import java.util.Scanner;
import java.io.FileInputStream;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int testcase = 1; testcase <= T; testcase++) {
			String a = sc.next();
			String pal = "";
			for(int i = a.length()-1; i >= 0; i--) {
				pal += a.charAt(i);
			}
			int answer = 0;
			if(a.equals(pal)) {
				answer = 1;
			} 
			System.out.println("#"+testcase+" "+answer);
		}
	}
}