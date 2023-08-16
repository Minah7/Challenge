// 4 종류의 괄호문자들 '()', '[]', '{}', '<>' 로 이루어진 문자열이 주어진다.
// 이 문자열에 사용된 괄호들의 짝이 모두 맞는지 판별하는 프로그램을 작성한다.
// 예를 들어 아래와 같은 문자열은 유효하다고 판단할 수 있다.

// 실패

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for(int testcase = 1; testcase <= T; testcase++) {
			//문자열 문자 수
			int K = sc.nextInt();
			//문자열 받기
			String bracket = sc.next();
			//스택 만들어주기
			Stack<Character> br = new Stack<>();
			//답을 위한 변수 생성
			int answer = 0;
			//open bracket인지 확인하기 위한 문자열
			String openB ="([{<";
			//문자열 bracket을 charAt(0)부터 문자열 수 -1 만큼 받으며 탐색
			int i = 0;
			while(i < K) {
				String b = String.valueOf(bracket.charAt(i));
				if(openB.contains(b)) {
					br.push(bracket.charAt(i));
				} else {
					if(!br.isEmpty()) {
						if(bracket.charAt(i) == ')' && br.pop() == '(') {
							br.pop();
						} else if(bracket.charAt(i) == ']' && br.pop() == '[') {
							br.pop();
						} else if(bracket.charAt(i) == '}' && br.pop() == '{') {
							br.pop();
						} else if(bracket.charAt(i) == '>' && br.pop() == '<') {
							br.pop();
						} else break;
					} else break;
				}
                i++;
			}
			if(i == K-1 && br.isEmpty()) {
				answer = 1;
			}
			System.out.println("#"+testcase+" "+answer);
		}
	}
}
