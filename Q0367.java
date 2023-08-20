import java.util.Scanner;

public class 달팽이숫자 {
	//우, 하, 좌, 상
	public static int[] dr = {0, 1, 0, -1};
	public static int[] dc = {1, 0, -1, 0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//테스트 개수 T개
		int T = sc.nextInt();
		for(int testcase = 1; testcase <= T; testcase++) {
			//보드의 크기 N
			int N = sc.nextInt();
			//N*N크기의 배열 생성
			int[][] board = new int[N][N];
			
			int row = 0;
			int col = 0;
			int dir = 0;
			int num = 1;
			//시작 위치 (0,0)에 1 넣기
			board[row][col] = num++;
			//num의 크기가 N*N을 넘으면 안됌
			while(num <= N*N) {
				//움직일 위치의 값
				int nr = row+dr[dir];
				int nc = col+dc[dir];
				//움직이는 곳이 범위가 넘어가는지 확인하기
				if(0 > nr || nr >= N || 0 > nc || nc >= N || board[nr][nc] > 0) {
					//만약 범위가 넘어간다면 움직이는 방향 바꾸기
					dir = (dir+1)%4;
					nr = row+dr[dir];
					nc = col+dc[dir];
				}
				//row와 col값 변경해주기
				row = nr;
				col = nc;
				//변경된 board에 숫자 넣어주기
				board[row][col] = num++;
			}
			System.out.println("#"+testcase);
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					System.out.print(board[r][c]+" ");
				}
				System.out.println();
			}
		}
	}
}