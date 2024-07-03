// 문제링크: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV139KOaABgCFAYh

// 평탄화 작업을 위해서 상자를 옮기는 작업 횟수에 제한이 걸려있을 때, 
// 제한된 횟수만큼 옮기는 작업을 한 후 최고점과 최저점의 차이를 반환하는 프로그램을 작성하시오.
 
// 성공

import java.util.Arrays;
import java.util.Scanner;

public class Flatten {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc = 1; tc <= 10; tc++) {
			int answer = 0;
			
			int dump = sc.nextInt();
			int[] height = new int[100];
			for(int box = 0; box < 100; box++) {
				height[box] = sc.nextInt();
			}
			
			Arrays.sort(height);
			
			while(dump > 0) {
				int min = 0;
				int max = 100;
				
				for(int i = 0; i < 100 - 1; i++) {
					if(height[i] < height[i + 1]) {
						min  = i;
						break;
					}
				}
				
				for(int i = 100 - 1; i > 0; i--) {
					if(height[i] > height[i - 1]) {
						max = i;
						break;
					}
				}
				// 모든 높이가 같을 때
				if(min == 0 && max == 100) {
					break;
				}
				// 가장 큰 낙차가 1밖에 안될 때
				if(height[max] - height[min] == 1) {
					answer = 1;
					break;
				}
				// 최고점 높이 1 내리기
				height[max] -= 1;
				
				// 최저점 높이 1 올리기
				height[min] += 1;
				
				dump--;
				
				if(dump == 0) {
					answer = height[99] - height[0];
				}
			}
			
			System.out.println("#" + tc + " " + answer);
		}
	}
}