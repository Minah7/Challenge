// 가로 N 세로 100 크기의 방에 상자들이 쌓여있다. 
// 방이 오른쪽으로 90도 회전하여 상자들이 중력의 영향을 받아 낙하한다고 할 때, 가장 큰 낙차를 구하여라

//수정해서 완성
import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); //테스트케이스 개수 T값 받기
		for(int testcase = 1; testcase <= T; testcase++) {
			int N = sc.nextInt(); //박스의 개수 N값 받기
			int[] box = new int[N]; //박스를 넣어줄 N개의 배열 생성
			for(int b = 0; b < N; b++) {
				box[b] = sc.nextInt();
			} //box배열에 박스 순서대로 넣기
			int fall = 0; //가장 큰 낙차값 얻을 변수 생성
			for(int s = N-2; s >= 0; s--) {
                int cnt = 0; //박스마다 낙차값 계산하기 위한 변수
				if(box[s] != 0) {
					for(int c = s ; c < N-1; c++) {
						if(box[c] > box[c+1]) {
							int tmp = box[c+1]; //box[s]값과 box[c]값을 바꾸기 위한 임시변수
							box[c+1] = box[c];
							box[c] = tmp;
                            cnt++;//한 번 바꿀 때마다 낙차값 올리기
						}
					} //상자의 아래와 비교해서 낙차값 계산하기 위한 조건문
				} //만약 상자가 없다면 스킵
                if(fall < cnt) fall = cnt; //가장 큰 낙차값을 얻기 위한 조건문
			} // 맨 밑에는 낙차가 없으니 바닥에서 하나 위에서 시작 
			System.out.println("#"+testcase+" "+fall);
		} //테스트케이스 수 만큼 반복문 돌리기
	}
}

//첫번째 실패
import java.util.Scanner;

public class Gravity {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); //테스트케이스 개수 T값 받기
		for(int testcase = 1; testcase <= T; testcase++) {
			int N = sc.nextInt(); //박스의 개수 N값 받기
			int[] box = new int[N]; //박스를 넣어줄 N개의 배열 생성
			for(int b = 0; b < N; b++) {
				box[b] = sc.nextInt();
			} //box배열에 박스 순서대로 넣기
			int fall = 0; //가장 큰 낙차값 얻을 변수 생성
			for(int s = N-2; s >= 0; s--) {
				int cnt = 0; //박스마다 낙차값 계산하기 위한 변수
				if(box[s] != 0) {
					for(int c = s+1; c < N; c++) {
						if(box[s] > box[c]) {
							int tmp = box[c]; //box[s]값과 box[c]값을 바꾸기 위한 임시변수
							box[c] = box[s];
							box[s] = tmp;
							cnt++;//한 번 바꿀 때마다 낙차값 올리기
						}
					} //상자의 아래와 비교해서 낙차값 계산하기 위한 조건문
					if(fall < cnt) fall = cnt; //가장 큰 낙차값을 얻기 위한 조건문
				} //만약 상자가 없다면 스킵
			} // 맨 밑에는 낙차가 없으니 바닥에서 하나 위에서 시작 
			System.out.println("#"+testcase+" "+fall);
		} //테스트케이스 수 만큼 반복문 돌리기
	}
}