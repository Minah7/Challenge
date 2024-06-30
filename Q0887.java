// 문제링크: https://www.acmicpc.net/problem/1018

//성공


package Silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static int answer = Integer.MAX_VALUE;
	
	public static void getMin(int startR, int startC, String[] chessboard) {
		int white = 0;
		int black = 0;
		
		for(int row = 0; row < 8; row++) {
			int sr = row + startR;
			for(int col = 0; col < 8; col++) {
				int sc = col + startC;
				
				if(row%2 == 0) {
					if(col%2 == 0) {
						if(chessboard[sr].charAt(sc) != 'W') white++;
						if(chessboard[sr].charAt(sc) != 'B') black++;
					} else {
						if(chessboard[sr].charAt(sc) != 'B') white++;
						if(chessboard[sr].charAt(sc) != 'W') black++;						
					}
				} else {
					if(col%2 == 0) {
						if(chessboard[sr].charAt(sc) != 'B') white++;
						if(chessboard[sr].charAt(sc) != 'W') black++;
					} else {
						if(chessboard[sr].charAt(sc) != 'W') white++;
						if(chessboard[sr].charAt(sc) != 'B') black++;						
					}
				}
			}
		}
		
		int cnt = Math.min(white, black);
		answer = Math.min(answer, cnt);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		String[] chessboard = new String[n];
		
		for(int row = 0; row < n; row++) {
			chessboard[row] = br.readLine();
		}
		
		br.close();
		
		for(int row = 0; row <= n - 8; row++) {
			for(int col = 0; col <= m - 8; col++) {
				getMin(row, col, chessboard);
			}
		}
		
		bw.write(answer + "\n");
		bw.flush();
		bw.close();
	}

}
