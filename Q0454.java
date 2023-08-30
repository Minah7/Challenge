// A1, A2, ... , AN의 N개의 자연수가 주어졌을 때, 최소 1개 이상의 수를 선택하여 그 합이 K가 되는 경우의 수를 구하는 프로그램을 작성하시오.

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
			int k = sc.nextInt();
			int[] nums = new int[n];
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextInt();
			}
			int[] answer = { 0 };
			checkK(nums, n, k, 0, answer, new ArrayList<Integer>());
			System.out.println("#" + testcase + " " + answer[0]);
		}
	}

	public static void checkK(int[] nums, int n, int k, int idx, int[] answer, List<Integer> tmp) {
		int sum = 0;
        for (int i = 0; i < tmp.size(); i++) {
			sum += tmp.get(i);
		}
		if (sum == k) {
			answer[0]++;
		}
		if (sum < k) {
			for (int i = idx; i < n; i++) {
				tmp.add(nums[i]);
				checkK(nums, n, k, i + 1, answer, tmp);
				tmp.remove(tmp.size() - 1);
			}
		}
	}
}