// 정수를 저장하는 스택을 구현한 다음, 
// 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.

// 명령은 총 다섯 가지이다.

// push X: 정수 X를 스택에 넣는 연산이다.
// pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 
// 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
// size: 스택에 들어있는 정수의 개수를 출력한다.
// empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
// top: 스택의 가장 위에 있는 정수를 출력한다. 
// 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.

// 실패. 시간 초과.

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i = 0; i < n; i++) {
			String s = sc.next();
			if(s.contains("push")) {
				stack.push(sc.nextInt());
				continue;
			}
			if(s.contains("pop")) {
				if(stack.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(stack.pop());
				}
				continue;
			}
			if(s.contains("size")) {
				System.out.println(stack.size());
				continue;
			}
			if(s.contains("empty")) {
				if(stack.isEmpty()) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
				continue;
			}
			if(s.contains("top")) {
				if(stack.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(stack.peek());
				}
				continue;
			}
		}
	}
}
