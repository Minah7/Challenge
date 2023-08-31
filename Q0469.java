// 두 명의 손님에게 음식을 제공하려고 한다.
// 두 명의 손님은 식성이 비슷하기 때문에, 최대한 비슷한 맛의 음식을 만들어 내야 한다.

// N개의 식재료가 있다.
// 식재료들을 각각 N / 2개씩 나누어 두 개의 요리를 하려고 한다. (N은 짝수이다.)
// 이때, 각각의 음식을 A음식, B음식이라고 하자.
// 비슷한 맛의 음식을 만들기 위해서는 A음식과 B음식의 맛의 차이가 최소가 되도록 재료를 배분해야 한다.
// 음식의 맛은 음식을 구성하는 식재료들의 조합에 따라 다르게 된다.

// 식재료 i는 식재료 j와 같이 요리하게 되면 궁합이 잘 맞아 시너지 Sij가 발생한다. (1 ≤ i ≤ N, 1 ≤ j ≤ N, i ≠ j)
// 각 음식의 맛은 음식을 구성하는 식재료들로부터 발생하는 시너지 Sij들의 합이다.

// 식재료 i를 식재료 j와 같이 요리하게 되면 발생하는 시너지 Sij의 정보가 주어지고, 가지고 있는 식재료를 이용해 A음식과 B음식을 만들 때, 두 음식 간의 맛의 차이가 최소가 되는 경우를 찾고 그 최솟값을 정답으로 출력하는 프로그램을 작성하라.

// 성공

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
    public static int sumSynergy(int n, int[][] synergy, List<Integer> Food) {
		int sum = 0;
		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < n / 2; j++) {
				sum += synergy[Food.get(i)][Food.get(j)];
			}
		}
		return sum;
	}

	public static void groupIngredientes(int n, int idx, int[][] synergy, List<Integer> FoodA, int[] answer) {
		if (FoodA.size() == n / 2) {
			List<Integer> FoodB = new ArrayList<Integer>();
			for (int i = 0; i < n; i++) {
				if (!FoodA.contains(i)) {
					FoodB.add(i);
				}
			}
			int sumA = sumSynergy(n, synergy, FoodA);
			int sumB = sumSynergy(n, synergy, FoodB);
			answer[0] = Math.min(answer[0], Math.abs(sumA - sumB));
		} else {
			for (int i = idx; i < n; i++) {
				FoodA.add(i);
				groupIngredientes(n, i + 1, synergy, FoodA, answer);
				FoodA.remove(FoodA.size() - 1);
			}
		}
	}
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int testcase = 1; testcase <= t; testcase++) {
			int n = sc.nextInt();
			int[][] synergy = new int[n][n];
			for (int row = 0; row < n; row++) {
				for (int col = 0; col < n; col++) {
					synergy[row][col] = sc.nextInt();
				}
			}
			int[] answer = { Integer.MAX_VALUE };
			groupIngredientes(n, 0, synergy, new ArrayList<>(), answer);
			System.out.println("#" + testcase + " " + answer[0]);
		}
		sc.close();
	}
}