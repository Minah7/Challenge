// 규영이와 인영이는 1에서 18까지의 수가 적힌 18장의 카드로 게임을 하고 있다.
// 한 번의 게임에 둘은 카드를 잘 섞어 9장씩 카드를 나눈다. 그리고 아홉 라운드에 걸쳐 게임을 진행한다.
// 한 라운드에는 한 장씩 카드를 낸 다음 두 사람이 낸 카드에 적힌 수를 비교해서 점수를 계산한다.
// 높은 수가 적힌 카드를 낸 사람은 두 카드에 적힌 수의 합만큼 점수를 얻고,
// 낮은 수가 적힌 카드를 낸 사람은 아무런 점수도 얻을 수 없다.
// 이렇게 아홉 라운드를 끝내고 총점을 따졌을 때, 총점이 더 높은 사람이 이 게임의 승자가 된다.
// 두 사람의 총점이 같으면 무승부이다.
// 이번 게임에 규영이가 받은 9장의 카드에 적힌 수가 주어진다.
// 규영이가 내는 카드의 순서를 고정하면, 인영이가 어떻게 카드를 내는지에 따른 9!가지 순서에 따라
// 규영이의 승패가 정해질 것이다.
// 이 때, 규영이가 이기는 경우와 지는 경우가 총 몇 가지 인지 구하는 프로그램을 작성하라.

// 성공

package 백트래킹;

import java.util.Scanner;

public class 카드게임2 {
	public static void cardsYoung(int[] cardsGyu, int[] cardsYoung) {
		for (int n = 1, id = 0; n <= 18; n++) {
			int cnt = 0;
			for (int i = 0; i < 9; i++) {
				if (n == cardsGyu[i])
					cnt++;
			}
			if (cnt == 0)
				cardsYoung[id++] = n;
		}
	}

	public static void backtrack(int[] cardsGyu, int[] cardsYoung, int idx, int[] tmp, boolean[] check, int[] winK,
			int[] winY) {
		if (idx == 9) {
			getScore(cardsGyu, tmp, winK, winY);
		} else {
			for (int i = 0; i < 9; i++) {
				if (check[i]) {
					continue;
				}
				tmp[idx] = cardsYoung[i];
				check[i] = true;
				backtrack(cardsGyu, cardsYoung, idx + 1, tmp, check, winK, winY);
				check[i] = false;
			}
		}
	}

	public static void getScore(int[] cardsGyu, int[] cardsYoung, int[] winK, int[] winY) {
		int tmpK = 0;
		int tmpY = 0;
		for (int i = 0; i < 9; i++) {
			if (cardsGyu[i] > cardsYoung[i]) {
				tmpK += cardsGyu[i] + cardsYoung[i];
			} else if (cardsGyu[i] < cardsYoung[i]) {
				tmpY += cardsGyu[i] + cardsYoung[i];
			}
		}
		if (tmpK > tmpY)
			winK[0]++;
		if (tmpK < tmpY)
			winY[0]++;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int testcase = 1; testcase <= t; testcase++) {
			int[] cardsGyu = new int[9];
			for (int i = 0; i < 9; i++) {
				cardsGyu[i] = sc.nextInt();
			}
			int[] cardsYoung = new int[9];
			cardsYoung(cardsGyu, cardsYoung);

			int[] tmp = new int[9];
			boolean[] check = new boolean[9];
			int[] winK = new int[1];
			int[] winY = new int[1];
			backtrack(cardsGyu, cardsYoung, 0, tmp, check, winK, winY);
			System.out.println("#" + testcase + " " + winK[0] + " " + winY[0]);
		}
	}
}
