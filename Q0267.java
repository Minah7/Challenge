한 쪽 벽면에 다음과 같이 노란색 상자들이 쌓여 있다.
높은 곳의 상자를 낮은 곳에 옮기는 방식으로 최고점과 최저점의 간격을 줄이는 작업을 평탄화라고 한다.
평탄화를 모두 수행하고 나면, 가장 높은 곳과 가장 낮은 곳의 차이가 최대 1 이내가 된다.
평탄화 작업을 위해서 상자를 옮기는 작업 횟수에 제한이 걸려있을 때, 제한된 횟수만큼 옮기는 작업을 한 후 최고점과 최저점의 차이를 반환하는 프로그램을 작성하시오.

성공

import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
        //문제에서 10개의 테스트케이스 제공
		for(int t = 1; t <= 10; t++) {
            //덤프 횟수
			int N = sc.nextInt();
            //박스 값 받기
			int[] box = new int[100];
			for(int i = 0; i < 100; i++) {
				box[i] = sc.nextInt();	
			}
            //높이가 같은 박스의 수 구하기 
			int[] height = new int[101];
			for(int i = 0; i < 100; i++) {
				height[box[i]] ++;
 			}
            //counting sort를 하기 위해 각 height배열의 이전 값 더해주기
			for(int i = 1; i < height.length; i++) {
				height[i] += height[i-1];
			}
			//order 배열에 박스값을 높이순으로 넣기
			int[] order = new int[100];
			for(int i = order.length-1; i >= 0; i--) {
				order[--height[box[i]]] = box[i];
			}
            //덤프 수행하기 위한 반복문. 주어진 덤프 횟수'N'만큼 반복하기 
			for(int i = 0; i < N; i++) {
                // 가장 높은 높이의 박스 값이 여러개 있으면 
                // 그 중 가장 작은 인덱스에서 부터 변경해야 
                // 마지막 인덱스가 가장 큰 값이기 때문에 이렇게 반복문 설정.
				for(int j = order.length-1; j >= 0; j--) {
					if(order[j]> order[j-1]) {
						order[j] -= 1;
						break;
					}
				}
                // 위 반복문과 마찬가지로 첫번째 인덱스값이 가장 작아야 하기 때문에 이렇게 반복문 설정.
				for(int l = 0; l < order.length; l++) {
					if(order[l] < order[l+1]) {
						order[l]++;
						break;
					}
				}
			}
            // 최고점과 최저점의 높이를 구하기 위한 변수 
			int answer = order[99] - order[0];
			System.out.println("#"+t+ " "+answer);
		}
	}
}