// 배열을 정렬하는 것은 쉽다. 
// 수가 주어지면, 그 수의 각 자리수를 내림차순으로 정렬해보자.

// 성공

package Baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n = sc.next();
		int[] digit = new int[10];
		for(int i = 0; i < n.length(); i++) {
			digit[n.charAt(i)-'0']++;
		}
		String answer = "";
		for(int i = 9; i >= 0; i--) {
			if(digit[i] == 0) continue;
			for(int c = 0; c < digit[i]; c++) {
				answer += String.valueOf(i);
			}
		}
		System.out.println(answer);
	}
}
