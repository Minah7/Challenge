// 문제링크: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PrmyKAWEDFAUq

// 주어진 N 길이의 숫자열을 오름차순으로 정렬하여 출력하라.

// 성공

package Array2;

import java.util.PriorityQueue;
import java.util.Scanner;

public class 숫자를_정렬하자 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for(int tc = 1; tc <= testcase; tc++) {
			int n = sc.nextInt();
			int[] num = new int[n];

			//힙 정렬
			PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
			
			for(int i = 0; i < n; i++) {
				heap.add(sc.nextInt());
			}
			
			System.out.print("#" + tc);
			for(int i = 0; i < n; i++) {
				System.out.print(" " + heap.poll());
			}
			System.out.println();
		}
	}
}
