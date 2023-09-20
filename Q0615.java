// 초기에 {1}, {2}, ... {n} 이 각각 n개의 집합을 이루고 있다.
// 여기에 합집합 연산과, 두 원소가 같은 집합에 포함되어 있는지를 확인하는 연산을 수행하려고 한다.
// 연산을 수행하는 프로그램을 작성하시오.

// [입력]
// 첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
// 각 테스트 케이스의 첫째 줄에 n(1≤n≤1,000,000), m(1≤m≤100,000)이 주어진다.
// m은 입력으로 주어지는 연산의 개수이다. 다음 m개의 줄에는 각각의 연산이 주어진다.
// 합집합은 0 a b의 형태로 입력이 주어진다.
// 이는 a가 포함되어 있는 집합과, b가 포함되어 있는 집합을 합친다는 의미이다.
// 두 원소가 같은 집합에 포함되어 있는지를 확인하는 연산은 1 a b의 형태로 입력이 주어진다.
// 이는 a와 b가 같은 집합에 포함되어 있는지를 확인하는 연산이다.
// a와 b는 n 이하의 자연수이며 같을 수도 있다.

// 성공

import java.util.Scanner;

public class Solution {
	static int[] p;
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int testcase = 1; testcase <= t; testcase++) {
			System.out.print("#"+testcase+" ");
			int n = sc.nextInt();
			int m = sc.nextInt();
			p = new int[n+1];
			for(int i = 0; i < n+1; i++) {
				p[i] = i;
			}
			int[][] mArr = new int[m][3];
			for(int input = 0; input < m; input++) {
				mArr[input][0] = sc.nextInt(); //0인지 1인지
				mArr[input][1] = sc.nextInt(); //시작정점
				mArr[input][2] = sc.nextInt(); //끝정점
				if(mArr[input][0] == 0) {
					int x = mArr[input][1];
					int y = mArr[input][2];
					union(p, x, y);
				} else {
					int a = findset(p, mArr[input][1]);
					int b = findset(p, mArr[input][2]);
					if(a == b) {
						System.out.print("1");
					} else {
						System.out.print("0");
					}
				}
			} //여기까지 입력값 받기
			System.out.println();
		}
	}
	public static int findset(int[] p, int x) {
		if(x == p[x]) {
			return x;
		} else {
			return p[x] = findset(p, p[x]);
		}
	}
	public static void union(int[] p, int x, int y) {
		p[findset(p, y)] = findset(p, x);
	}
}
