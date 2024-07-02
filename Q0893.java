// 문제링크: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV134DPqAA8CFAYh

// 이곳에서는 빌딩들이 너무 좌우로 밀집하여, 강에 대한 조망은 모든 세대에서 좋지만 왼쪽 또는 오른쪽 창문을 열었을 때 바로 앞에 옆 건물이 보이는 경우가 허다하였다.
// 그래서 이 지역에서는 왼쪽과 오른쪽으로 창문을 열었을 때, 양쪽 모두 거리 2 이상의 공간이 확보될 때 조망권이 확보된다고 말한다.
// 빌딩들에 대한 정보가 주어질 때, 조망권이 확보된 세대의 수를 반환하는 프로그램을 작성하시오.

// 성공

package Array1;

import java.util.Scanner;

public class View {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc = 1; tc <= 10; tc++) {
			int answer = 0;
			
			int n = sc.nextInt();
			int[] height = new int[n];
			for(int building = 0; building < n; building++) {
				height[building] = sc.nextInt();
			}
			
			for(int building = 2; building < n - 2; building++) {
				int max = 0;
				boolean flag = true;
				for(int b = building - 2; b <= building + 2; b++) {
					if(b == building) {
						continue;
					}
					
					if(height[b] >= height[building]) {
						flag = false;
						break;
					}
					max = Math.max(max, height[b]);
				}
				
				if(flag) {
					answer += height[building] - max;
				}
			}
			System.out.println("#" + tc + " " + answer);
		}
	}
}
