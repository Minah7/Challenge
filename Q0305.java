중간값은 통계 집단의 수치를 크기 순으로 배열 했을 때 전체의 중앙에 위치하는 수치를 뜻한다.
입력으로 N 개의 점수가 주어졌을 때, 중간값을 출력하라.

성공

import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for(int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

        for(int i = 0; i < N-1; i++) {
            for(int j = 0; j < N-1-i; j++) {
                if(nums[j] > nums[j+1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                }
            }
        }
        int answer = nums[N/2];
        System.out.println(answer);
	}
}