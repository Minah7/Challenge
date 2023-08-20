오목게임

성공

import java.util.Scanner;

public class 오목판정 {
	//방향을 위한 배열 우, 우하, 하, 좌하
	public static int[] dr = {0, 1, 1, 1};
	public static int[] dc = {1, 1, 0, -1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//테스트케이스 수 T값 받기
		int T = sc.nextInt();
		//T개 만큼 문제 실행
		for(int testcase = 1; testcase <= T; testcase++) {
			//판 크기 N값 받기
			int N = sc.nextInt();
			//NxN 크기의 보드 만들기
			char[][] board = new char[N][N];
			//행 값을 받기 위한 반복문
			for(int row = 0; row < N; row++) {
				//문자열을 받고 각 행의 열에 문자 하나씩 담아주기
				board[row] = sc.next().toCharArray();
			}
			//답 출력할 변수. 찾으면 "YES"로 변경하고 기본값은 "NO"로 설정 
			String answer = "NO";
			
			for(int row = 0; row < N; row++) {
				for(int col = 0; col < N; col++) {
					//'o'를 찾으면 시작
					if(board[row][col] == 'o') {
						//방향을 돌아가며 개수 세기
						for(int d = 0; d < 4; d++) {
							//방향에 따라 움직이면서 위치가 변경되기 때문에
							//새로운 변수에 현재위치 값 담아주기
							int nr = row;
							int nc = col;
							//현재 위치가 'o'이니 카운트 1담아주기.
							int cnt = 1;
							
							while(true) {
								//현재 위치값에서 방향값 더해서 업데이트 해주기
								nr += dr[d];
								nc += dc[d];
								//현재 보드에서 벗어나지 않도록 제한 걸어주기
								if(0 <= nr && nr < N && 0 <= nc && nc < N) {
									//움직인 위치의 값도 'o'이면 카운트 올려주고 아니면 나가기
									if(board[nr][nc] == 'o') {
										cnt++;
									} else break;
								} else break;
							}
							//반대쪽 실행
							//다시 현재위치값 담아주고 새로 시작
							nr = row;
							nc = col;
							
							while(true) {
								//현재 위치에서 반대쪽 방향값 더해서 업데이트
								nr -= dr[d];
								nc -= dc[d];
								if(0 <= nr && nr < N && 0 <= nc && nc < N) {
									if(board[nr][nc] == 'o') {
										cnt++;
									} else break;
								} else break;
							}
							//만약 연속된 'o'가 5개이면 YES
							if(cnt == 5) {
								answer = "YES"
							}
						}
					}
				}
			}
			System.out.println("#"+testcase+" "+answer);
		}
	}
}
