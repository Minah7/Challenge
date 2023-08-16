재현이는 재민이를 도와서 동아리 장부를 관리하고 있다.


재현이는 영수증을 모아서 동아리의 지출 금액을 세고 있고, 재민이는 재현이가 부르는 액수를 순서대로 적고 있다.


재현이는 가끔 잘못된 수를 부르는 실수를 하는데, 이 때마다 0을 외쳐서, 가장 최근에 재민이가 쓰고 지우지 않았던 수를 지우게 시킨다.


재현이가 모든 수를 부른 후 재민이가 받아 적은 수의 합은 무엇일까?

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static int top = -1;
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int testcase = 1; testcase <= T; testcase++) {
			int K = sc.nextInt();
			
			int[] stack = new int[K];
			for(int i = 0; i < K; i++) {
				stack[i] = sc.nextInt();
			}
			
			Stack<Integer> answer = new Stack<>();
			
			int i = 0;
			while(i < K) {
				if(stack[i] != 0) {
					answer.push(stack[i]);
				} else if(stack[i] == 0) {
					answer.pop(); 
				}
				i++;
			}
			
			int sum = 0;
			while(!answer.isEmpty()) {
				sum += answer.pop();
			}
			
			System.out.println("#"+testcase+" "+sum);
		}
	}
}