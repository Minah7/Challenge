// 문제링크: https://www.acmicpc.net/problem/1546
// 세준이는 자기 점수 중에 최댓값을 골랐다. 이 값을 M이라고 한다. 그리고 나서 모든 점수를 점수/M*100으로 고쳤다.
// 세준이의 성적을 위의 방법대로 새로 계산했을 때, 새로운 평균을 구하는 프로그램을 작성하시오.
// 성공

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 과목의 개수
		double maxScore = 0; // 세준이 점수 중 최댓값을 구할 변수
		double [] score = new double[n];
		for(int i = 0; i < n; i++) {
			score[i] = sc.nextDouble();
			maxScore = Math.max(maxScore, score[i]);
		} // 여기까지 입력값

		double sum = 0; // 새 점수의 합 구하기
		double [] newScore = new double[n];
		for(int i = 0; i < n; i++) {
			newScore[i] = ((score[i]/maxScore)*100);
			sum += newScore[i];
		} // 새로운 점수 구하기
		
		System.out.println(sum/n);
	}
}