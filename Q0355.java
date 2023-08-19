// 강변에 빌딩들이 옆으로 빽빽하게 밀집한 지역이 있다.
// 이곳에서는 빌딩들이 너무 좌우로 밀집하여, 강에 대한 조망은 모든 세대에서 좋지만 왼쪽 또는 오른쪽 창문을 열었을 때 바로 앞에 옆 건물이 보이는 경우가 허다하였다.
// 그래서 이 지역에서는 왼쪽과 오른쪽으로 창문을 열었을 때, 양쪽 모두 거리 2 이상의 공간이 확보될 때 조망권이 확보된다고 말한다.
// 빌딩들에 대한 정보가 주어질 때, 조망권이 확보된 세대의 수를 반환하는 프로그램을 작성하시오.

// 아래와 같이 강변에 8채의 빌딩이 있을 때, 연두색으로 색칠된 여섯 세대에서는 좌우로 2칸 이상의 공백이 존재하므로 조망권이 확보된다. 따라서 답은 6이 된다.

// 성공

import java.util.Scanner;

public class View {
	public static void main(String[] args) {
		//스캐너 사용해 값 받아오기
		Scanner sc = new Scanner(System.in);
		//테스트케이스 10개 돌리기
		for(int testcase = 1; testcase <= 10; testcase++) {
			//빌딩 개수 N개
			int N = sc.nextInt();
			//빌딩 받을 배열 생성
			int[] building = new int[N];
			//빌딩 값 받기 위해 반복문 돌리기 
			for(int i = 0; i < N; i++) {
				building[i] = sc.nextInt();
			}
			//전망권 카운트 할 변수 
			int view = 0;
			//시작과 끝 2개는 0이니 2부터 시작하고 N-2까지만 확인하기
			for(int b = 2; b < N-2; b++) {
				//각 빌딩의 양옆 2개씩 총 4개의 빌딩 중 가장 높은 빌딩 
				int maxV = 0;
				//양옆 4개의 빌딩 중 만약 현재 빌딩보다 높거나 같은 빌딩이 없도록 조건문 달아주기
				if(building[b-2] < building[b] && building[b-1] < building[b] && building[b+1] < building[b] && building[b+2] < building[b]) {
					//4개의 빌딩을 확인하기 위한 반복문
					for(int v = b-2; v <= b+2; v++) {
						//현재 빌딩은 빼고 구하기 위한 조건
						if(v != b) {
							//maxV값을 얻기 위한 조건문 
							if(building[v]>maxV) maxV = building[v];
						}
					}
					//총 조망권 개수 얻기 위해 각 빌딩마다 조망권 개수 더해주기
					view += building[b]-maxV;
				}
			}
			System.out.println("#"+testcase+" "+view);
		}
	}
}
