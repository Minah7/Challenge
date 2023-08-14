import java.util.Scanner;
import java.io.FileInputStream;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for(int testcase = 1; testcase <= T; testcase++) {
			int N = sc.nextInt();
			String s = sc.next();
			String c = sc.next();
			
			int count = 0;
			for(int i = 0; i <= c.length()-s.length();i++) {
				for(int j = 0; j < s.length(); j++) {
					if(c.charAt(i+j) != s.charAt(j)) {
						break;
					} else if(j == s.length()-1) {
						count++;
					}
				}
			}
			System.out.println("#"+testcase+" "+count);
		}
	}
}