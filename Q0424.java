// 가로 N 세로 100 크기의 방에 상자들이 쌓여있다. 
// 방이 오른쪽으로 90도 회전하여 상자들이 중력의 영향을 받아 낙하한다고 할 때, 가장 큰 낙차를 구하여라

// 성공

import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int testcase = 1; testcase <= T; testcase++) {
            int N = sc.nextInt();
            int[] box = new int[N];
            for(int i = 0; i < N; i++) {
                box[i] = sc.nextInt();
            }
            int fall = 0;
            for(int b = N-2; b >= 0; b--) {
                int cnt = 0;
                for(int i = b; i < N-1; i++) {
                    if(box[i] > box[i+1]) {
                    cnt++;
                    int tmp = box[i];
                    box[i] = box[i+1];
                    box[i+1] = tmp;
                    }
                }
                if(fall < cnt) fall = cnt;
            }
            System.out.println("#"+testcase+" "+fall);
        }
	}
}