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
            int width = sc.nextInt();
            int[] box = new int[width];
            for(int i = 0; i < width; i++) {
                box[i] = sc.nextInt();
            }

            int fall = 0;
            for(int i = box.length-2; i >= 0; i--) {
                int cnt = 0;
                for(int j = i; j < box.length-1; j++) {
                    if(box[j]> box[j+1]) {
                        int tmp = box[j+1];
                        box[j+1] = box[j];
                        box[j] = tmp;
                        cnt++;
                    }
                }
                if(cnt > fall) {
                    fall = cnt;
                }
            }
            System.out.println("#"+testcase+" "+fall);
        }
    }
}