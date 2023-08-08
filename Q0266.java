import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[] records = new int[1000];
			for(int i = 0; i < 1000; i++) {
				records[i] = sc.nextInt();
			}
			int[] score = new int[101];
			for(int i = 0; i < 1000; i++) {
				score[records[i]] += 1;
			}
			int maxCnt = -1;
			int answer = 0;
			for(int i = 0; i < 101; i++) {
				if(maxCnt < score[i]) {
					maxCnt = score[i];
					answer = i;
				} else if(maxCnt == score[i]) {
					answer = i;
				}
			}
			System.out.println("#"+t+" "+answer);
		}
	}
}