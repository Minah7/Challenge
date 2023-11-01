// 정수를 저장하는 덱(Deque)를 구현한 다음, 
// 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.

// 명령은 총 여덟 가지이다.

// push_front X: 정수 X를 덱의 앞에 넣는다.
// push_back X: 정수 X를 덱의 뒤에 넣는다.
// pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 
// 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
// pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 
// 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
// size: 덱에 들어있는 정수의 개수를 출력한다.
// empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
// front: 덱의 가장 앞에 있는 정수를 출력한다. 
// 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
// back: 덱의 가장 뒤에 있는 정수를 출력한다. 
// 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.

// 성공

package Baekjoon;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		Deque<Integer> deq = new ArrayDeque<>();
		
		int n = sc.nextInt();
		for(int i = 0; i < n; i++) {
			String s = sc.next();
			switch(s) {
				case "push_front":
					deq.addFirst(sc.nextInt());
					break;
				case "push_back":
					deq.addLast(sc.nextInt());
					break;
				case "pop_front":
					if(deq.isEmpty()) {
						sb.append(-1).append('\n');
					} else {
						sb.append(deq.pollFirst()).append('\n');
					}
					break;
				case "pop_back":
					if(deq.isEmpty()) {
						sb.append(-1).append('\n');
					} else {
						sb.append(deq.pollLast()).append('\n');
					}
					break;
				case "size":
					sb.append(deq.size()).append('\n');
					break;
				case "empty":
					if(deq.isEmpty()) {
						sb.append(1).append('\n');
					} else {
						sb.append(0).append('\n');
					}
					break;
				case "front":
					if(deq.isEmpty()) {
						sb.append(-1).append('\n');
					} else {
						sb.append(deq.peekFirst()).append('\n');
					}
					break;
				case "back":
					if(deq.isEmpty()) {
						sb.append(-1).append('\n');
					} else {
						sb.append(deq.peekLast()).append('\n');
					}
					break;
			}
		}
		System.out.println(sb);
	}
}
