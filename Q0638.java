// 오늘은 스타트링크에 다니는 사람들이 모여서 축구를 해보려고 한다. 
// 축구는 평일 오후에 하고 의무 참석도 아니다. 
// 축구를 하기 위해 모인 사람은 총 N명이고 신기하게도 N은 짝수이다. 
// 이제 N/2명으로 이루어진 스타트 팀과 링크 팀으로 사람들을 나눠야 한다.

// BOJ를 운영하는 회사 답게 사람에게 번호를 1부터 N까지로 배정했고, 아래와 같은 능력치를 조사했다. 
// 능력치 Sij는 i번 사람과 j번 사람이 같은 팀에 속했을 때, 팀에 더해지는 능력치이다. 
// 팀의 능력치는 팀에 속한 모든 쌍의 능력치 Sij의 합이다. 
// Sij는 Sji와 다를 수도 있으며, i번 사람과 j번 사람이 같은 팀에 속했을 때, 팀에 더해지는 능력치는 Sij와 Sji이다.

// 실패. 시간초과

package Baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 스타트와링크_14889 {
	public static int sumAttributes(int n, int[][] attributes, List<Integer> team) {
		int sum = 0;
		for(int i = 0; i < n/2; i++) {
			for(int j = 0; j < n/2; j++) {
				sum += attributes[team.get(i)][team.get(j)] +attributes[team.get(j)][team.get(i)];
			}
		}
		return sum;
	}
	public static void makeTeams(int[][] attributes, int[] answer, int n, List<Integer> teamA, int depth) {
		if(depth == n/2) {
			List<Integer> teamB = new ArrayList<>();
			for(int i = 0; i < n; i++) {
				if(!teamA.contains(i)) {
					teamB.add(i);
				}
			}
			int sumA = sumAttributes(n, attributes, teamA);
			int sumB = sumAttributes(n, attributes, teamB);
			answer[0] = Math.min(answer[0], Math.abs(sumA - sumB));
		} else {
			for(int i = depth; i < n; i++) {
				teamA.add(i);
				makeTeams(attributes, answer, n, teamA, depth+1);
				teamA.remove(teamA.size()-1);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] attributes = new int[n][n];
		for(int row = 0; row < n; row++) {
			for(int col = 0; col < n; col++) {
				attributes[row][col] = sc.nextInt();
			}
		}
		int[] answer = {Integer.MAX_VALUE};
		makeTeams(attributes, answer, n, new ArrayList<>(), 0);
		System.out.println(answer[0]);
	}
}
