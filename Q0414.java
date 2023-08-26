// 정곤이는 자신이 엄청난 수학자임을 증명하기 위해, 어떤 규칙 만족하는 수를 찾아보기로 했다.
// 그 규칙은 단조 증가하는 수인데, 각 숫자의 자릿수가 단순하게 증가하는 수를 말한다.
// 어떤 k자리 수 X = d1d2…dk 가 d1 ≤ d2 ≤ … ≤ dk 를 만족하면 단조 증가하는 수이다.
// 예를 들어 111566, 233359는 단조 증가하는 수이고, 12343, 999888은 단조 증가하는 수가 아니다.
// 양의 정수 N 개 A1, …, AN이 주어진다.
//  1 ≤ i < j ≤ N 인 두 i, j에 대해, Ai x Aj값이 단조 증가하는 수인 것들을 구하고 그 중의 최댓값을 출력하는 프로그램을 작성하라.

// 성공

package 정곤이단조;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int testCase = 1; testCase <= T; testCase++) {
			
			int answer = 0;
			
			//값 담아주기
			int N = sc.nextInt();
			int[] A = new int[N];
			for(int i = 0; i < N; i++) {
				A[i] = sc.nextInt();
			}
            
			//Ai와 Aj를 곱한 수를 담은 배열
			ArrayList<Integer> mulij = new ArrayList<>();
			for(int i = 0; i < N-1; i++) {
				for(int j = i+1; j < N; j++) {
					if(A[i]*A[j] > 10) {
						mulij.add(A[i]*A[j]);
					}
				}
			}
			
			if(mulij.isEmpty()) {
				answer = -1; //mulij가 비어있다면 단조를 확인할 수가 없으므로 -1출력
			} else {
				//mulij에 들어있는 수가 단조이면 새 배열에 담아주기
				for(int i = mulij.size()-1; i >= 0; i--) {
					String num = String.valueOf(mulij.get(i));
					for(int d = 0; d < num.length()-1; d++) {
						if(Character.getNumericValue(num.charAt(d)) > Character.getNumericValue(num.charAt(d+1))) {
	                        mulij.remove(i);
	                        break;
						}
					}
				}
			}
			
			//남아있는 mulij 비교하며 가장 큰 수 찾기
			if(mulij.isEmpty()) {
				answer = -1;
			} else {
				int max = 0;
				for(int i = 0; i < mulij.size(); i++) {
					if(mulij.get(i) > max) max = mulij.get(i);
				}
				answer = max;
			}
			
			//출력
			System.out.println("#"+testCase+" "+answer);
		}
	}
}
