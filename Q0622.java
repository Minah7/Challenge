// 엔지니어링 선표는 일을 하던 도중 창고에서 특이한 자석이 놓여있는 판을 발견했다.
// 이 판에는 4개의 자석이 놓여져 있었고, 각 자석은 8개의 ‘날’(튀어나온 곳)를 가지고 있다.
// 자석의 각 날 마다 N 극 또는 S 극의 자성을 가지고 있다.
// 이 특이한 자석은 [Fig. 1] 과 같이 1 번부터 4 번까지 판에 일렬로 배치되어 있고,
// 빨간색 화살표 위치에 날 하나가 오도록 배치되어 있다.

// 심심한 선표는 이 특이한 자석을 가지고 놀아보니 신기한 규칙을 발견했다.
// 임의의 자석을 1 칸씩 K 번 회전시키려고 해보니,
// 하나의 자석이 1 칸 회전될 때, 붙어 있는 자석은 서로 붙어 있는 날의 자성과 다를 경우에만 인력에 의해 반대 방향으로 1 칸 회전된다.
// 이를 신기하게 생각한 선표는 무작위로 자석을 돌렸을 때, 모든 회전이 끝난 후, 아래와 같은 방법으로 점수를 계산을 하고자 한다.
// - 1 번 자석에서 빨간색 화살표 위치에 있는 날의 자성이 N 극이면 0 점, S 극이면 1 점을 획득한다.
// - 2 번 자석에서 빨간색 화살표 위치에 있는 날의 자성이 N 극이면 0 점, S 극이면 2 점을 획득한다.
// - 3 번 자석에서 빨간색 화살표 위치에 있는 날의 자성이 N 극이면 0 점, S 극이면 4 점을 획득한다.
// - 4 번 자석에서 빨간색 화살표 위치에 있는 날의 자성이 N 극이면 0 점, S 극이면 8 점을 획득한다.

// 4 개 자석의 자성 정보와 자석을 1 칸씩 K 번 회전시키려고 할 때,
// K 번 자석을 회전시킨 후 획득하는 점수의 총 합을 출력하는 프로그램을 작성하라.

// 성공

import java.util.Scanner;

public class 특이한자석 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for(int tc = 1; tc <= testcase; tc++) {
			int answer = 0;
			int k = sc.nextInt();
			int[][] rotate = new int[k][2];
			int[][] magnet = new int[5][8];
			for(int m = 1; m < 5; m++) {
				for(int i = 0; i < 8; i++) {
					magnet[m][i] = sc.nextInt();
				}
			}
			for(int r = 0; r < k; r++) {
				rotate[r][0] = sc.nextInt();
				rotate[r][1] = sc.nextInt();
			}
			//1-4 자석 포인트들 1 : N, W / 2 : N, E, W / 3 : N, E, W / 4 : N, W
			int[][] magnetPoint = {{}, {0, 2}, {0, 2, 6}, {0, 2, 6}, {0, 6}};
			
			for(int r = 0; r < k; r++) {
				if(rotate[r][1] == 1) {
					if(rotate[r][0] == 1) {
						int first = magnet[1][magnetPoint[1][1]]; //magnet1 E
						for(int i = 0; i < 2; i++) {
							magnetPoint[1][i]--;
							if(magnetPoint[1][i] < 0) magnetPoint[1][i] = 7;
						}
						if(first != magnet[2][magnetPoint[2][2]]) {
							int second = magnet[2][magnetPoint[2][1]]; //magnet2 E
							for(int i = 0; i < 3; i++) {
								magnetPoint[2][i]++;
								if(magnetPoint[2][i] > 7) magnetPoint[2][i] = 0;
							}
							if(second != magnet[3][magnetPoint[3][2]]) {
								int third = magnet[3][magnetPoint[3][1]]; //magnet3 E
								for(int i = 0; i < 3; i++) {
									magnetPoint[3][i]--;
									if(magnetPoint[3][i] < 0) magnetPoint[3][i] = 7;
								}
								if(third != magnet[4][magnetPoint[4][1]]) {
									for(int i = 0; i < 2; i++) {
										magnetPoint[4][i]++;
										if(magnetPoint[4][i]> 7) magnetPoint[4][i] = 0;
									}
								}
							}
						}
					} else if(rotate[r][0] == 2) {
						int first = magnet[2][magnetPoint[2][2]]; //magnet2 W
						int second = magnet[2][magnetPoint[2][1]]; //magnet2 E
						for(int i = 0; i < 3; i++) {
							magnetPoint[2][i]--;
							if(magnetPoint[2][i] < 0) magnetPoint[2][i] = 7;
						}
						if(first != magnet[1][magnetPoint[1][1]]) {
							for(int i = 0; i < 2; i++) {
								magnetPoint[1][i]++;
								if(magnetPoint[1][i] > 7) magnetPoint[1][i] = 0;
							}
						}
						if(second != magnet[3][magnetPoint[3][2]]) {
							int third = magnet[3][magnetPoint[3][1]]; //magnet3 E
							for(int i = 0; i < 3; i++) {
								magnetPoint[3][i]++;
								if(magnetPoint[3][i] > 7) magnetPoint[3][i] = 0;
							}
							if(third != magnet[4][magnetPoint[4][1]]) {
								for(int i = 0; i < 2; i++) {
									magnetPoint[4][i]--;
									if(magnetPoint[4][i] < 0) magnetPoint[4][i] = 7;
								}
							}
						}
					} else if(rotate[r][0] == 3) {
						int first = magnet[3][magnetPoint[3][1]]; //magnet3 E
						int second = magnet[3][magnetPoint[3][2]]; //magnet3 W
						for(int i = 0; i < 3; i++) {
							magnetPoint[3][i]--;
							if(magnetPoint[3][i] < 0) magnetPoint[3][i] = 7;
						}
						if(first != magnet[4][magnetPoint[4][1]]) {
							for(int i = 0; i < 2; i++) {
								magnetPoint[4][i]++;
								if(magnetPoint[4][i] > 7) magnetPoint[4][i] = 0;
							}
						}
						if(second != magnet[2][magnetPoint[2][1]]) {
							int third = magnet[2][magnetPoint[2][2]]; //magnet2 W
							for(int i = 0; i < 3; i++) {
								magnetPoint[2][i]++;
								if(magnetPoint[2][i] > 7) magnetPoint[2][i] = 0;
							}
							if(third != magnet[1][magnetPoint[1][1]]) {
								for(int i = 0; i < 2; i++) {
									magnetPoint[1][i]--;
									if(magnetPoint[1][i] < 0) magnetPoint[1][i] = 7;
								}
							}
						}
					} else {
						int first = magnet[4][magnetPoint[4][1]]; //magnet4 W
						for(int i = 0; i < 2; i++) {
							magnetPoint[4][i]--;
							if(magnetPoint[4][i] < 0) magnetPoint[4][i] = 7;
						}
						if(first != magnet[3][magnetPoint[3][1]]) {
							int second = magnet[3][magnetPoint[3][2]]; //magnet3 W
							for(int i = 0; i < 3; i++) {
								magnetPoint[3][i]++;
								if(magnetPoint[3][i] > 7) magnetPoint[3][i] = 0;
							}
							if(second != magnet[2][magnetPoint[2][1]]) {
								int third = magnet[2][magnetPoint[2][2]]; //magnet2 W
								for(int i = 0; i < 3; i++) {
									magnetPoint[2][i]--;
									if(magnetPoint[2][i] < 0) magnetPoint[2][i] = 7;
								}
								if(third != magnet[1][magnetPoint[1][1]]) {
									for(int i = 0; i < 2; i++) {
										magnetPoint[1][i]++;
										if(magnetPoint[1][i]> 7) magnetPoint[1][i] = 0;
									}
								}
							}
						}
					}
				} else { //시계 반대방향
					if(rotate[r][0] == 1) {
						int first = magnet[1][magnetPoint[1][1]]; //magnet1 E
						for(int i = 0; i < 2; i++) {
							magnetPoint[1][i]++;
							if(magnetPoint[1][i] > 7) magnetPoint[1][i] = 0;
						}
						if(first != magnet[2][magnetPoint[2][2]]) {
							int second = magnet[2][magnetPoint[2][1]]; //magnet2 E
							for(int i = 0; i < 3; i++) {
								magnetPoint[2][i]--;
								if(magnetPoint[2][i] < 0) magnetPoint[2][i] = 7;
							}
							if(second != magnet[3][magnetPoint[3][2]]) {
								int third = magnet[3][magnetPoint[3][1]]; //magnet3 E
								for(int i = 0; i < 3; i++) {
									magnetPoint[3][i]++;
									if(magnetPoint[3][i] > 7) magnetPoint[3][i] = 0;
								}
								if(third != magnet[4][magnetPoint[4][1]]) {
									for(int i = 0; i < 2; i++) {
										magnetPoint[4][i]--;
										if(magnetPoint[4][i] < 0) magnetPoint[4][i] = 7;
									}
								}
							}
						}
					} else if(rotate[r][0] == 2) {
						int first = magnet[2][magnetPoint[2][2]]; //magnet2 W
						int second = magnet[2][magnetPoint[2][1]]; //magnet2 E
						for(int i = 0; i < 3; i++) {
							magnetPoint[2][i]++;
							if(magnetPoint[2][i] > 7) magnetPoint[2][i] = 0;
						}
						if(first != magnet[1][magnetPoint[1][1]]) {
							for(int i = 0; i < 2; i++) {
								magnetPoint[1][i]--;
								if(magnetPoint[1][i] < 0) magnetPoint[1][i] = 7;
							}
						}
						if(second != magnet[3][magnetPoint[3][2]]) {
							int third = magnet[3][magnetPoint[3][1]]; //magnet3 E
							for(int i = 0; i < 3; i++) {
								magnetPoint[3][i]--;
								if(magnetPoint[3][i] < 0) magnetPoint[3][i] = 7;
							}
							if(third != magnet[4][magnetPoint[4][1]]) {
								for(int i = 0; i < 2; i++) {
									magnetPoint[4][i]++;
									if(magnetPoint[4][i] > 7) magnetPoint[4][i] = 0;
								}
							}
						}
					} else if(rotate[r][0] == 3) {
						int first = magnet[3][magnetPoint[3][1]]; //magnet3 E
						int second = magnet[3][magnetPoint[3][2]]; //magnet3 W
						for(int i = 0; i < 3; i++) {
							magnetPoint[3][i]++;
							if(magnetPoint[3][i] > 7) magnetPoint[3][i] = 0;
						}
						if(first != magnet[4][magnetPoint[4][1]]) {
							for(int i = 0; i < 2; i++) {
								magnetPoint[4][i]--;
								if(magnetPoint[4][i] < 0) magnetPoint[4][i] = 7;
							}
						}
						if(second != magnet[2][magnetPoint[2][1]]) {
							int third = magnet[2][magnetPoint[2][2]]; //magnet2 W
							for(int i = 0; i < 3; i++) {
								magnetPoint[2][i]--;
								if(magnetPoint[2][i] < 0) magnetPoint[2][i] = 7;
							}
							if(third != magnet[1][magnetPoint[1][1]]) {
								for(int i = 0; i < 2; i++) {
									magnetPoint[1][i]++;
									if(magnetPoint[1][i] > 7) magnetPoint[1][i] = 0;
								}
							}
						}
					} else {
						int first = magnet[4][magnetPoint[4][1]]; //magnet4 W
						for(int i = 0; i < 2; i++) {
							magnetPoint[4][i]++;
							if(magnetPoint[4][i] > 7) magnetPoint[4][i] = 0;
						}
						if(first != magnet[3][magnetPoint[3][1]]) {
							int second = magnet[3][magnetPoint[3][2]]; //magnet3 W
							for(int i = 0; i < 3; i++) {
								magnetPoint[3][i]--;
								if(magnetPoint[3][i] < 0) magnetPoint[3][i] = 7;
							}
							if(second != magnet[2][magnetPoint[2][1]]) {
								int third = magnet[2][magnetPoint[2][2]]; //magnet2 W
								for(int i = 0; i < 3; i++) {
									magnetPoint[2][i]++;
									if(magnetPoint[2][i]> 7) magnetPoint[2][i] = 0;
								}
								if(third != magnet[1][magnetPoint[1][1]]) {
									for(int i = 0; i < 2; i++) {
										magnetPoint[1][i]--;
										if(magnetPoint[1][i] < 0) magnetPoint[1][i] = 7;
									}
								}
							}
						}
					}
				}
			}
			//여기까지 회전
			//값 출력하기
			for(int i = 1; i < 5; i++) {
				if(magnet[i][magnetPoint[i][0]] == 1) {
					if(i == 1) answer += 1;
					if(i == 2) answer += 2;
					if(i == 3) answer += 4;
					if(i == 4) answer += 8;
				}
			}
			System.out.println("#"+tc+" "+answer);
		}
	}
}
