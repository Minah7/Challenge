// 창용 마을에는 N명의 사람이 살고 있다.
// 사람은 편의상 1번부터 N번 사람까지 번호가 붙어져 있다고 가정한다.
// 두 사람은 서로를 알고 있는 관계일 수 있고, 아닐 수 있다.
// 두 사람이 서로 아는 관계이거나 몇 사람을 거쳐서 알 수 있는 관계라면,
// 이러한 사람들을 모두 다 묶어서 하나의 무리라고 한다.
// 창용 마을에 몇 개의 무리가 존재하는지 계산하는 프로그램을 작성하라.

// 성공

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	static int[] p;
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int testcase = 1; testcase <= t; testcase++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			p = new int[n+1];
			for(int i = 0; i < n+1; i++) {
				p[i] = i;
			}
			int[][] mArr = new int[m][2];
			for(int input = 0; input < m; input++) {
				mArr[input][0] = sc.nextInt();
				mArr[input][1] = sc.nextInt();
				int x = mArr[input][0];
				int y = mArr[input][1];
				union(p, x, y);
			}
			List<Integer> cntVillage = new ArrayList<>();
			for(int i = 1; i < p.length; i++) {
				if(!cntVillage.contains(findset(p, p[i]))) {
					cntVillage.add(p[i]);
				}
			}
			System.out.println("#"+testcase+" "+cntVillage.size());
		}
	}
	public static int findset(int[] p, int x) {
		if(x == p[x]) {
			return x;
		} else {
			return p[x] = findset(p, p[x]);
		}
	}
	public static void union(int[] p, int x, int y) {
		if(findset(p, y) > findset(p, x)) {
			p[findset(p, y)] = findset(p, x);
		} else {
			p[findset(p, x)] = findset(p, y);
		}
	}
}
