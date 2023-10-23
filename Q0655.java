// 알파벳으로 이루어진 문자열을 입력 받아 각 알파벳을 1부터 26까지의 숫자로 변환하여 출력하라.

// 성공

package APS;

import java.util.Scanner;

public class 알파벳을_숫자로_변환 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] letter = sc.next().toCharArray();
		for(int i: letter) {
			System.out.print((i-'A'+1)+" ");
		}
		System.out.println();
	}
}
