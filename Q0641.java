// 왕비를 피해 일곱 난쟁이들과 함께 평화롭게 생활하고 있던 백설공주에게 위기가 찾아왔다. 
// 일과를 마치고 돌아온 난쟁이가 일곱 명이 아닌 아홉 명이었던 것이다.

// 아홉 명의 난쟁이는 모두 자신이 "백설 공주와 일곱 난쟁이"의 주인공이라고 주장했다. 
// 뛰어난 수학적 직관력을 가지고 있던 백설공주는, 다행스럽게도 일곱 난쟁이의 키의 합이 100이 됨을 기억해 냈다.

// 아홉 난쟁이의 키가 주어졌을 때, 백설공주를 도와 일곱 난쟁이를 찾는 프로그램을 작성하시오.

// 아홉 개의 줄에 걸쳐 난쟁이들의 키가 주어진다. 
// 주어지는 키는 100을 넘지 않는 자연수이며, 아홉 난쟁이의 키는 모두 다르며, 
// 가능한 정답이 여러 가지인 경우에는 아무거나 출력한다.

// 일곱 난쟁이의 키를 오름차순으로 출력한다. 일곱 난쟁이를 찾을 수 없는 경우는 없다.

// 두 번째 시도 성공.
// 출력한 뒤 종료하는 법을 몰랐는데 'System.exit();'에 대해 처음 알았다.

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 9명 난쟁이의 키를 담을 배열
		int[] dwarfH = new int[9];
		for(int i = 0; i < 9; i++) {
			dwarfH[i] = sc.nextInt();
		}
		// 오름차순으로 출력해야 하기 때문에 시작 전에 정렬해주기
		Arrays.sort(dwarfH);
		//백트래킹에서 방문처리 하기 위한 배열
		boolean[] visited = new boolean[9];
		// 조합 + 백트래킹 메소드 //시작은 0번째 인덱스부터, 찾을 난쟁이 수는 7명
		combination(dwarfH, visited, 0, 7);
	}
	// 답 찾을 메소
	static void combination(int[] dwarfH, boolean[] visited, int start, int c) {
		// 만일 7명의 조합을 만들면 난쟁이 키 구하기
		if(c == 0) {
			int cnt = 0; // 난쟁이 키 구할 변수
			for(int i = 0; i < 9; i++) {
				// 만일 7명의 난쟁이 중 한명이라면
				if(visited[i]) {
					// 그 난장이의 키 더해주기
					cnt += dwarfH[i];
				}
			}
			// 만일 7명의 난쟁이 키의 합이 100이라면
			if(cnt == 100) {
				print(dwarfH, visited); //각 난쟁이 키 출력
				System.exit(0); //출력 후 끝내기
			}
		}
		for(int i = start; i < 9; i++) {
			visited[i] = true; // 방문처리
			// i는 1씩 키워주고 1명 방문처리 할 때마다 7명에서 찾아야하는 난쟁이 수 1씩 줄여주기
			combination(dwarfH, visited, i+1, c-1);
			visited[i] = false; // 백트래킹을 위한 방문처리 취소
		}
	}
	// 답 찾았을 때 출력할 메소드
	static void print(int[] dwarfH, boolean[] visited) {
		for(int i = 0; i < 9; i++) {
			if(visited[i]) {
				// 난쟁이 한명씩 호출
				System.out.println(dwarfH[i]);
			}
		}
	}
}

// 첫 번째 시도 실패. 키 합 100이 되는 난장이 조합을 찾고 종료를 해야 하는데 이 부분을 놓쳤다.
// 백트래킹을 이용하여 조합을 구현했다.

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] dwarfH = new int[9];
		for(int i = 0; i < 9; i++) {
			dwarfH[i] = sc.nextInt();
		}
		Arrays.sort(dwarfH);
		boolean[] visited = new boolean[9];
		combination(dwarfH, visited, 0, 7);
		
	}
	static void combination(int[] dwarfH, boolean[] visited, int start, int c) {
		if(c == 0) {
			int cnt = 0;
			for(int i = 0; i < 9; i++) {
				if(visited[i]) {
					cnt += dwarfH[i];
				}
			}
			if(cnt == 100) {
				print(dwarfH, visited);
			}
			
		}
		for(int i = start; i < 9; i++) {
			visited[i] = true;
			combination(dwarfH, visited, i+1, c-1);
			visited[i] = false;
		}
	}
	static void print(int[] dwarfH, boolean[] visited) {
		for(int i = 0; i < 9; i++) {
			if(visited[i]) {
				System.out.println(dwarfH[i]);
			}
		}
	}
}