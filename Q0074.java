import java.util.Scanner;

public class AppleTree {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[][] ground = new int[n][n];

		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				ground[r][c] = sc.nextInt();
			}
		}

		int maxN = 0;
		int E = 0;
		int W = 0;
		int N = 0;
		int S = 0;

		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				if (c+1 < n) {
					E = ground[r][c + 1];
				}
				if (c-1 >= 0) {
					W = ground[r][c - 1];
				}
				if (r-1 >= 0) {
					N = ground[r - 1][c];
				}
				if (r+1 < n) {
					S = ground[r + 1][c];
				}
				int sum = ground[r][c] + E + W + N + S;
				if(sum > maxN) {
					maxN = sum;
				}

			}
		}
		System.out.println(maxN);
	}
}