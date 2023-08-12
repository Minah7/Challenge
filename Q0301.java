import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int testcase = 1; testcase <= T; testcase++) {
            int[][] sudoku = new int[9][9];
            for(int row = 0; row < 9; row++) {
                for(int col = 0; col < 9; col++) {
                    sudoku[row][col] = sc.nextInt();
                }
            }

            int answer = 1;
            for(int r = 0; r < 9; r++) {
                int check = new int[10];
                for(int c = 0; c < 9; c++){
                    check[sudoku[r][c]] += 1;
                }
                for(int i = 1; i < 10; i++) {
                    if(check[i]>1) {
                        answer = 0;
                        break;
                    }
                }
            }

            for(int c = 0; c < 9; c++) {
                int check = new int[10];
                for(int r = 0; r < 9; r++){
                    check[sudoku[r][c]] += 1;
                }
                for(int i = 1; i < 10; i++) {
                    if(check[i]>1) {
                        answer = 0;
                        break;
                    }
                }
            }

            dr = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
            dc = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
            for (int r = 1; r <= 7; r += 3) {
                for(int c = 1; c <= 7; c += 3) {
                    int check = new int[10];
                    for(int i = 0; i < 9; i++) {
                        check[sudoku[r+dr[i]][c+dc[i]]] += 1;
                    }
                    for(int i = 1; i < 10; i++) {
                        if(check[i]>1) {
                            answer = 0;
                            break;
                        }
                    }
                }
            }
            System.out.println("#"+testcase+" "+answer);
        }
    }
}