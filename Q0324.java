// 위와 같은 글자 판이 주어졌을 때, 길이가 가장 긴 회문은 붉은색 테두리로 표시된 7칸짜리 회문이다.
// 예시의 경우 설명을 위해 글자판의 크기가 100 x 100이 아닌 8 x 8으로 주어졌음에 주의한다.
// [제약사항]
// 각 칸의 들어가는 글자는 c언어 char type으로 주어지며 'A', 'B', 'C' 중 하나이다.
// 글자 판은 무조건 정사각형으로 주어진다.
// ABA도 회문이며, ABBA도 회문이다. A또한 길이 1짜리 회문이다.
// 가로, 세로 각각에 대해서 직선으로만 판단한다. 즉, 아래 예에서 노란색 경로를 따라가면 길이 7짜리 회문이 되지만 직선이 아니기 때문에 인정되지 않는다. 

//첫번째 시도. 성공했지만 엄청 오래 걸림
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("input.txt"));
		int T = 10;
		for(int testcase = 1; testcase <= T; testcase++) {
			int N = sc.nextInt();
			
			char[][] map = new char[100][100];
			
			for(int r = 0; r < 100; r++) {
				String str = sc.next();
				for(int c = 0; c < 100; c++) {
					map[r][c] = str.charAt(c);
				}
			}
			
			int length = 1;
			
			for(int r = 0; r < 100; r++) {
				for(int c = 0; c < 100; c++) {
					for(int i = 100-1; i > c; i--) {
						String s = "";
						for(int j = c; j <= i; j++) {
							s += map[r][j];
						}
						String pal = "";
						for(int k = i; k >= c; k--) {
							pal += map[r][k];
						}
						if(s.equals(pal)) {
							if(s.length() > length) {
								length = s.length();
							}
						}
					}
				}
			}
			
			for(int c = 0; c < 100; c++) {
				for(int r = 0; r < 100; r++) {
					for(int i = 100-1; i > r; i--) {
						String s = "";
						for(int j = r; j <= i; j++) {
							s += map[j][c];
						}
						String pal = "";
						for(int k = i; k >= r; k--) {
							pal += map[k][c];
						}
						if(s.equals(pal)) {
							if(s.length() > length) {
								length = s.length();
							}
						}
					}
				}
			}
			System.out.println("#"+testcase+" "+length);
		}
	}
}

//두번째 시도
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("input.txt"));
		int T = 10;
		for(int testcase = 1; testcase <= T; testcase++) {
			int N = sc.nextInt();
			
			char[][] map = new char[100][100];
			
			for(int r = 0; r < 100; r++) {
				String str = sc.next();
				for(int c = 0; c < 100; c++) {
					map[r][c] = str.charAt(c);
				}
			}
			
			int length = 1;
			
			for(int r = 0; r < 100; r++) {
				for(int c = 0; c < 100; c++) {
					for(int i = 99; i >= c; i--) {
						int C = c;
						int cnt = 0;
						int I = i;
						while(c <= I) {
							if(map[r][C++] == map[r][I--]) {
								cnt++;
							} else {
								break;
							}
						}
						if(cnt > length) {
							length = cnt;
						}
					}
				}
			}
			
			for(int c = 0; c < 100; c++) {
				for(int r = 0; r < 100; r++) {
					for(int i = 99; i >= r; i--) {
						int R = r;
						int cnt = 0;
						int I = i;
						while(r <= I) {
							if(map[I--][c] == map[R++][c]) {
								cnt++;
							} else {
								break;
							}
						}
						if(cnt>length) {
							length = cnt;
						}
					}
				}
			}
			System.out.println("#"+testcase+" "+length);
		}
	}
}