package Baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int n = sc.nextInt();
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i = 0; i < n; i++) {
			String s = sc.next();
			if(s.contains("push")) {
				stack.push(sc.nextInt());
				continue;
			} else if(s.contains("pop")) {
				if(stack.isEmpty()) {
					sb.append(-1).append('\n');
				} else {
					sb.append(stack.pop()).append('\n');
				}
				continue;
			} else if(s.contains("size")) {
				sb.append(stack.size()).append('\n');
				continue;
			} else if(s.contains("empty")) {
				if(stack.isEmpty()) {
					sb.append(1).append('\n');
				} else {
					sb.append(0).append('\n');
				}
				continue;
			} else if(s.contains("top")) {
				if(stack.isEmpty()) {
					sb.append(-1).append('\n');
				} else {
					sb.append(stack.peek()).append('\n');
				}
				continue;
			}
		}
		System.out.println(sb);
	}
}
