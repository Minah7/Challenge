import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;
class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		// 테스트케이스 개수를 얻기 위한 T값 받기
		int T = sc.nextInt();
		// T 개수만큼 테스트케이스 돌리기
		for (int testcase = 1; testcase <= T; testcase++) {
			// 맵 크기 N값 받기
			int N = sc.nextInt();
			// 값을 넣기 위한 배열 생성
			int[][] map = new int[N][N];
			// 끝에 닿으면 방향을 바꾸기 위한 델타 설정
			// 우, 하, 좌, 상 순서
			int[] dr = { 0, 1, 0, -1 }; // 행
			int[] dc = { 1, 0, -1, 0 }; // 열
			// 방향을 지정할 변수
			int rotate = 0;
            // 기입할 숫자
			int num = 1;
            // 행 시작 값
			int row = 0;
            // 열 시작 값. 처음에 오른쪽으로 가기 때문에 -1로 설정
			int col = -1;
            // 세트 개수 만큼의 반복문. 세트의 개수는 N개
			for (int set = 0; set < N; set++) {
                // 각 세트에서 첫번째 반복문
				for (int first = set; first < N; first++) {
                    // rotate의 수가 4를 넘어갈 수 있으므로 나머지로 설정
					int dir = rotate % 4;
                    // 움직일 곳으로 가기 위한 값 설정
					row = row + dr[dir];
					col = col + dc[dir];
					map[row][col] = num++;
				}
                //만약 기입할 숫자가 N*N이면 끝.
				if (num == N * N)
					break;
                //반복문 끝날 때마다 rotate값 올려서 방향 바꿔주기
				rotate++;
                //두번째 세트는 첫번째 세트 움직이는 값보다 한개가 적다.
				for (int second = set + 1; second < N; second++) {
					int dir = rotate % 4;
					row = row + dr[dir];
					col = col + dc[dir];
					map[row][col] = num++;
				}
				rotate++;
			}
            //출력
			System.out.println("#" + testcase);
			for (int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					System.out.print(map[r][c] + " ");
				}
				System.out.println();
            }
		}
	}
}
