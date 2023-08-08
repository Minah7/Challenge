import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[] nums = new int[N];
			for(int i = 0; i < N; i++) {
				nums[i] = sc.nextInt();
			}
			for(int i = 0; i < N; i++) {
				int minIdx = i;
				for(int j = i+1; j < N; j++) {
					if(nums[minIdx] > nums[j]) {
						minIdx = j;
					}
				}
				int tmp = nums[i];
				nums[i] = nums[minIdx];
				nums[minIdx] = tmp;
			}
			System.out.print("#"+t);
			for(int i = 0; i < N; i++) {
				System.out.print(" "+nums[i]);
			}
			System.out.println();
		}
	}
}