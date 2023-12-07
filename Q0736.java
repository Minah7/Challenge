// 문제링크: https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AYZOEkza5qMDFARc
// 가로 N 세로 100 크기의 방에 상자들이 쌓여있다. 방이 오른쪽으로 90도 회전하여 상자들이 중력의 영향을 받아 낙하한다고 할 때, 가장 큰 낙차를 구하여라
// 성공

package APS;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for(int tc = 1; tc <= testcase; tc++) {
			int n = sc.nextInt();
			int[] box = new int[n];
			for(int i = 0; i < n; i++) {
				box[i] = sc.nextInt();
			} //여기까지 입력값
			int fall = 0;
			for(int i = n-2; i >= 0; i--) {
				if(box[i] > 0) {
					int cnt = 0;
					for(int j = i; j < n-1; j++) {
						if(box[j] > box[j+1]) {
							int temp = box[j];
							box[j] = box[j+1];
							box[j+1] = temp;
							cnt++;
						} else {
							break;
						}
					}
					fall = Math.max(fall, cnt);
				}
			}
			
			System.out.println("#"+tc+" "+fall);
		}
	}
}