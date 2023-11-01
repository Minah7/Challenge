// 정수를 저장하는 큐를 구현한 다음, 
// 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.

// 명령은 총 여섯 가지이다.

// push X: 정수 X를 큐에 넣는 연산이다.
// pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 
// 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
// size: 큐에 들어있는 정수의 개수를 출력한다.
// empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
// front: 큐의 가장 앞에 있는 정수를 출력한다. 
// 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
// back: 큐의 가장 뒤에 있는 정수를 출력한다. 
// 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.

// 성공

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		Queue<Integer> q = new LinkedList<Integer>();
		
		int n = sc.nextInt();
		for(int i = 0; i < n; i++) {
			String s = sc.next();
			switch(s) {
				case "push":
					q.add(sc.nextInt());
					break;
				case "pop":
					if(q.isEmpty()) {
						sb.append(-1).append('\n');
					} else {
						sb.append(q.poll()).append('\n');
					}
					break;
				case "size":
					sb.append(q.size()).append('\n');
					break;
				case "empty":
					if(q.isEmpty()) {
						sb.append(1).append('\n');
					} else {
						sb.append(0).append('\n');
					}
					break;
				case "front":
					if(q.isEmpty()) {
						sb.append(-1).append('\n');
					} else {
						sb.append(q.peek()).append('\n');
					}
					break;
				case "back":
					if(q.isEmpty()) {
						sb.append(-1).append('\n');
					} else {
						int b = q.size();
						for(int j = 1; j <= b-1; j++) {
							q.add(q.remove());
						}
						sb.append(q.peek()).append('\n');
						q.add(q.remove());
					}
			}
		}
		System.out.println(sb);
	}
}
