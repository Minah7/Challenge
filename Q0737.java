// 문제링크: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV134DPqAA8CFAYh
// 왼쪽과 오른쪽으로 창문을 열었을 때, 양쪽 모두 거리 2 이상의 공간이 확보될 때 조망권이 확보된다고 말한다.
// 빌딩들에 대한 정보가 주어질 때, 조망권이 확보된 세대의 수를 반환하는 프로그램을 작성하시오.
// 성공

package APS;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc = 1; tc <= 10; tc++) {
			int n = sc.nextInt();
			int[] building = new int[n];
			for(int i = 0; i < n; i++) {
				building[i] = sc.nextInt();
			} //여기까지 입력값
			int view = 0;
			//왼쪽 오른쪽 2칸씩 현재 건물보다 낮은지 확인
			for(int i = 2; i < n-2; i++) {
				int tallest = 0;
				boolean flag = true;
				for(int j = i-2; j <= i+2; j++) {
					if(j != i && building[j] < building[i]) {
						tallest = Math.max(tallest, building[j]);
					} else if(j != i && building[j] >= building[i]){
						flag = false;
						break;
					}
				}
				if(flag) {
					view += building[i]-tallest;
				}
			}
			System.out.println("#"+tc+" "+view);
		}
	}
}