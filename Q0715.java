// 2차원 평면 위의 점 N개가 주어진다. 
// 좌표를 x좌표가 증가하는 순으로, 
// x좌표가 같으면 y좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.

// 실패..

package Baekjoon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] dot = new int[n][2];
		for(int i = 0; i < n; i++) {
			dot[i][0] = sc.nextInt();
			dot[i][1] = sc.nextInt();
		}
		
		Arrays.sort(dot, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0])
					return o1[1] - o2[1];
				else
					return o1[0] - o2[0];
			}
		});
		
		for(int r = 0; r < n; r++) {
			System.out.println(Arrays.toString(dot[r]));
		}
	}
}
