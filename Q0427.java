// N X N 크기의 단어 퍼즐을 만들려고 한다. 입력으로 단어 퍼즐의 모양이 주어진다.
// 주어진 퍼즐 모양에서 특정 길이 K를 갖는 단어가 들어갈 수 있는 자리의 수를 출력하는 프로그램을 작성하라.

import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int testcase = 1; testcase <= T; testcase++) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            int[][] puzzle = new int[N][N];
            for(int row = 0; row < N; row++) {
                for(int col = 0; col < N; col++) {
                    puzzle[row][col] = sc.nextInt();
                }
            }
            int answer = 0;
            int cnt = 0;
            for(int row = 0; row < N; row++) {
                for(int col = 0; col < N; col++) {
                    if(puzzle[row][col] == 1) {
                        cnt++;
                    } else {
                        if(cnt == K) {
                            answer++;
                        }
                        cnt = 0;
                    }
                }
                if(cnt == K) {
                    answer++;
                }
                cnt = 0;
            }
            for(int col = 0; col < N; col++) {
                for(int row = 0; row < N; row++) {
                    if(puzzle[row][col] == 1) {
                        cnt++;
                    } else {
                        if(cnt == K) {
                            answer++;
                        }
                        cnt = 0;
                    }
                }
                if(cnt == K) {
                    answer++;
                }
                cnt = 0;
            }
            System.out.println("#"+testcase+" "+answer);
        }
	}
}