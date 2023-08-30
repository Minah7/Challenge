// 평소 햄버거를 좋아하던 민기는 최근 부쩍 늘어난 살 때문에 걱정이 많다.
// 그렇다고 햄버거를 포기할 수 없었던 민기는 햄버거의 맛은 최대한 유지하면서 정해진 칼로리를 넘지 않는 햄버거를 주문하여 먹으려고 한다.
// 민기가 주로 이용하는 햄버거 가게에서는 고객이 원하는 조합으로 햄버거를 만들어서 준다.
// 하지만 재료는 미리 만들어서 준비해놓기 때문에 조합에 들어가는 재료를 잘라서 조합해주지는 않고, 재료를 선택하면 준비해놓은 재료를 그대로 사용하여 조합해준다. 
// 민기는 이 가게에서 자신이 먹었던 햄버거의 재료에 대한 맛을 자신의 오랜 경험을 통해 점수를 매겨놓았다.
// 민기의 햄버거 재료에 대한 점수와 가게에서 제공하는 재료에 대한 칼로리가 주어졌을 때,
// 민기가 좋아하는 햄버거를 먹으면서도 다이어트에 성공할 수 있도록 정해진 칼로리 이하의 조합 중에서 민기가 가장 선호하는 햄버거를 조합해주는 프로그램을 만들어보자.
// (단 여러 재료를 조합하였을 햄버거의 선호도는 조합된 재료들의 맛에 대한 점수의 합으로 결정되고, 같은 재료를 여러 번 사용할 수 없으며, 햄버거의 조합의 제한은 칼로리를 제외하고는 없다.)

// 성공

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int testcase = 1; testcase <= t; testcase++) {
			int n = sc.nextInt();
			int calLimit = sc.nextInt();
			int[][] info = new int[n][2];
			for (int r = 0; r < n; r++) {
				info[r][0] = sc.nextInt();
				info[r][1] = sc.nextInt();
			}
			int[] answer = new int[1];
			findFavorite(n, calLimit, info, new ArrayList<Integer>(), new ArrayList<Integer>(), 0, answer);
			System.out.println("#" + testcase + " " + answer[0]);
		}
	}

	public static void findFavorite(int n, int calLimit, int[][] info, List<Integer> taste, List<Integer> cal, int idx,
			int[] answer) {
		int sumCal = 0;
		for (int i = 0; i < cal.size(); i++) {
			sumCal += cal.get(i);
		}
		if (sumCal <= calLimit) {
			int sumTaste = 0;
			for (int i = 0; i < taste.size(); i++) {
				sumTaste += taste.get(i);
			}
			answer[0] = Math.max(answer[0], sumTaste);

		}
		if (sumCal < calLimit) {
			for (int i = idx; i < n; i++) {
				cal.add(info[i][1]);
				taste.add(info[i][0]);
				findFavorite(n, calLimit, info, taste, cal, i + 1, answer);
				cal.remove(cal.size() - 1);
				taste.remove(taste.size() - 1);
			}
		}

	}
}