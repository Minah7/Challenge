// N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

// 성공

package Baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Integer> num = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			num.add(sc.nextInt());
		}
		Collections.sort(num);
		for(int i = 0; i < n; i++) {
			System.out.println(num.get(i));
		}
	}
}
