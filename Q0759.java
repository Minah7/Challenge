// 문제링크: https://www.acmicpc.net/problem/11720
// N개의 숫자가 공백 없이 쓰여있다. 이 숫자를 모두 합해서 출력하는 프로그램을 작성하시오.
// 성공

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //숫자의 개수
        // 공백없이 주어진 숫자를 나눠서 담기
		char[] nums = sc.next().toCharArray(); 
		int answer = 0;
		
		for(int i = 0; i < n; i++) {
			answer += nums[i]-'0';
		}
		System.out.println(answer);
	}
}
