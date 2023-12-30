// 문제링크: https://www.acmicpc.net/problem/1181
// 알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.
// 1. 길이가 짧은 것부터
// 2. 길이가 같으면 사전 순으로
// 단, 중복된 단어는 하나만 남기고 제거해야 한다.

// 성공.

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		String[] words = new String[num];
		for(int i = 0; i < num; i++) {
			words[i] = sc.next();
		} // 입력
		
		Arrays.sort(words, new Comparator<String>() {
			public int compare(String s1, String s2) {
				if(s1.length() == s2.length()) {
					return s1.compareTo(s2);
				} else {
					return s1.length() - s2.length();
				}
			}
		}); // 정렬
		
		System.out.println(words[0]);
		
		for(int i = 1; i < num; i++) {
			if(!words[i].equals(words[i-1])) {
				System.out.println(words[i]);
			}
		} // 츨력. 중복 단어 제거
		
		System.out.println();
	}
}