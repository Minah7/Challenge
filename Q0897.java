// 문제링크: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV13zo1KAAACFAYh

// 어느 고등학교에서 실시한 1000명의 수학 성적을 토대로 통계 자료를 만들려고 한다.
// 이때, 이 학교에서는 최빈수를 이용하여 학생들의 평균 수준을 짐작하는데, 여기서 최빈수는 특정 자료에서 가장 여러 번 나타나는 값을 의미한다.
// 최빈수를 출력하는 프로그램을 작성하여라 (단, 최빈수가 여러 개 일 때에는 가장 큰 점수를 출력하라).

// 성공

package Array2;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class 최빈수_구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testcase = sc.nextInt();
		for(int tc = 1; tc <= testcase; tc++) {
			sc.nextInt();
			HashMap<Integer, Integer> map = new HashMap<>();
			for(int student = 1; student <= 1000; student++) {
				int grade = sc.nextInt();
				map.put(grade, map.getOrDefault(grade, 0) + 1);
			}
			
			int max = 0;
			for(int n : map.keySet()) {
				if(max == 0) {
					max = n;
				}else {
					if(map.get(max) < map.get(n)) {
						max = n;
					} else if(map.get(max) == map.get(n)) {
						if(max < n) {
							max = n;
						}
					}
				}
			}
			
			
			System.out.println("#" + tc + " " + max);
		}
	}
}
