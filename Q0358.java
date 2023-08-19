// 중간값은 통계 집단의 수치를 크기 순으로 배열 했을 때 전체의 중앙에 위치하는 수치를 뜻한다.
// 입력으로 N 개의 점수가 주어졌을 때, 중간값을 출력하라.

// 성공

import java.util.Scanner;

public class 중간값찾기 {
	public static void main(String[] args) {
		//스캐너 사용해 값 받아오기
		Scanner sc = new Scanner(System.in);
		//입력받을 수의 개수
		int N = sc.nextInt();
		//N개 만큼의 수를 받을 수 있는 배열 생성
		int[] nums = new int[N];
		//N개 만큼 반복문 돌려 수 받아오기
		for(int n = 0; n < N; n++) {
			nums[n] = sc.nextInt();
		}
		//버블 정렬 사용. 
		//버블정렬은 마지막 수가 맨 뒤로 가므로 반복할 때마다 뒤에서 하나씩 줄여나가며 진행
		for(int i = N-1; i >= 0; i--) {
			//0번 인덱스부터 i까지 반복문 돌며 정렬하기
			for(int j = 0; j < i; j++) {
				//만약 앞 인덱스의 값이 더 크면 바꿔주기
				if(nums[j]>nums[j+1]) {
					int tmp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = tmp;
				}
			}
		}
		//중앙값을 얻기 위해 N/2로 중간 값 찾아주기
		System.out.println(nums[N/2]);
	}
}
