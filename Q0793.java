// 문제링크: https://swexpertacademy.com/main/solvingProblem/solvingProblem.do

// 이전에 셌던 번호들의 각 자리수에서 0에서 9까지의 모든 숫자를 보는 것은 최소 몇 번 양을 센 시점일까?

// 성공

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for(int tc = 1; tc <= testcase; tc++) {
			int n = sc.nextInt();
			int copyN = n;
			boolean[] num = new boolean[10];
			int cnt = 1;
			
			while(true) {
				String tmpN = Integer.toString(copyN);
				for(int i = 0; i < 10; i++) {
					if(!num[i] && tmpN.contains(Integer.toString(i))) {
						num[i] = true;
					}
				}
				boolean check = true;
				for(int i = 0; i < 10; i++) {
					if(!num[i]) {
						check = false;
					}
				}
				if(check) {
					break;
				}
				copyN += n;
			}
			System.out.println("#"+tc+" "+copyN);
		}
	}
}
