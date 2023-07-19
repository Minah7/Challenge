import java.util.Scanner;

public class AppleTree {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[][] ground = new int[N][N];

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				ground[r][c] = sc.nextInt();
			}
		}

		int maxN = 0;
		int sum = 0;

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				while (c < N-1) {
					// 동쪽
					sum = ground[r][c] + ground[r][c + 1];
					if (sum > maxN) {
						maxN = sum;
					}
				}
				while (1 <= c) {
					// 서쪽
					sum = ground[r][c] + ground[r][c - 1];
					if (sum > maxN) {
						maxN = sum;
					}
				}
				while (1 <= r) {
					// 북쪽
					sum = ground[r][c] + ground[r - 1][c];
					if (sum > maxN) {
						maxN = sum;
					}
				}
				while (r < N-1) {
					// 남쪽
					sum = ground[r][c] + ground[r + 1][c];
					if (sum > maxN) {
						maxN = sum;
					}
				} 
			}
		}
		System.out.println(maxN);
	}
}