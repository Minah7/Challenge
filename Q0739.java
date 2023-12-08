// 문제링크: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV139KOaABgCFAYh
// 평탄화 작업을 위해서 상자를 옮기는 작업 횟수에 제한이 걸려있을 때, 
// 제한된 횟수만큼 옮기는 작업을 한 후 최고점과 최저점의 차이를 반환하는 프로그램을 작성하시오.
// 성공

package APS;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc = 1; tc <= 10; tc++) {
			int dump = sc.nextInt();
			int[] box = new int[100];
			int[] count = new int[101]; //카운팅 정렬을 위한 배열. 최고높이는 100이기 때문에 +1해주기
			for(int i = 0; i < 100; i++) {
				box[i] = sc.nextInt();
				count[box[i]]++;
			} //여기까지 입력값
			//정렬하기
			for(int i = 1; i < 101; i++) {
				count[i] += count[i-1];
			} //누적합
			int[] sort = new int[100];
			for(int i = 100-1; i >= 0; i--) {
				sort[--count[box[i]]] = box[i];
			} //정렬 완료
//			System.out.println(Arrays.toString(sort));
			//덤프 실행
			for(int d = 0; d < dump; d++) {
				//가장 높은 상자 중 인덱스 값이 가장 작은 상자 선택해서 -1 해주기
				int idxTall = 99; //가장 큰 인덱스에서 시작. 100-1
				while(true) {
					if(sort[idxTall-1] < sort[idxTall]) {
						sort[idxTall]--;
						break;
					} else {
						idxTall--;
					}
				}
				//가장 낮은 상자 중 인덱스 값이 가장 큰 상자 선택해서 +1 해주기 
				int idxShort = 0; //가장 작은 인덱스에서 시작.
				while(true) {
					if(sort[idxShort] < sort[idxShort+1]) {
						sort[idxShort]++;
						break;
					} else {
						idxShort++;
					}
				}
			}
			int answer = sort[99]-sort[0]; // 최고점과 최저점의 차이 구하기
			System.out.println("#"+tc+" "+answer);
		}
	}
}