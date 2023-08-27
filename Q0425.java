// 강변에 빌딩들이 옆으로 빽빽하게 밀집한 지역이 있다.
// 이곳에서는 빌딩들이 너무 좌우로 밀집하여, 강에 대한 조망은 모든 세대에서 좋지만 왼쪽 또는 오른쪽 창문을 열었을 때 바로 앞에 옆 건물이 보이는 경우가 허다하였다.
// 그래서 이 지역에서는 왼쪽과 오른쪽으로 창문을 열었을 때, 양쪽 모두 거리 2 이상의 공간이 확보될 때 조망권이 확보된다고 말한다.
// 빌딩들에 대한 정보가 주어질 때, 조망권이 확보된 세대의 수를 반환하는 프로그램을 작성하시오.

// 성공

import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
        for(int testcase = 1; testcase <= 10; testcase++) {
            int N = sc.nextInt();
            int[] building = new int[N];
            for(int i = 0; i < N; i++) {
                building[i] = sc.nextInt();
            }

            int answer = 0;
            for(int i = 2; i < N-2; i++) {
                int cnt = 0;
                int max = 0;
                for(int l = i-2; l <= i+2; l++) {
                    if(l != i && building[l] >= building[i]) break;
                    if(l != i && building[l] > max) {
                        max = building[l];
                    }
                    cnt++;
                }
                if(cnt == 5) answer += building[i] - max;
            }
            System.out.println("#"+testcase+" "+answer);
        }
	}
}