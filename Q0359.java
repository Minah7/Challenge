import java.util.Scanner;

public class 숫자를_정렬하자 {
	public static void main(String[] args) {
		//스캐너로 값 받아오기
		Scanner sc = new Scanner(System.in);
		//테스트 개수 T
		int T = sc.nextInt();
		//테스트 개수만큼 반복문 돌려 실행
		for(int testcase = 1; testcase <= T; testcase++) {
			//N은 주어지는 숫자의 길이
			int N = sc. nextInt();
			//숫자를 넣을 배열 만들기
			int[] nums = new int[N];
			//최대값을 얻기 위한 변수
			int max = Integer.MIN_VALUE;
			//N개만큼 반복하며 숫자 받아오기
			for(int n = 0; n < N; n++) {
				nums[n] = sc.nextInt();
				//max값 갱신해가며 구하기
				if(nums[n]> max) max = nums[n];
			}
			//인덱스는 0부터 시작하므로 max+1개의 배열 생성
			int[] cntSort = new int[max+1];
			//nums배열을 돌아가며 값에 맞는 cntSort 인덱스에 하나씩 넣기
			for(int i = 0; i < N; i++) {
				cntSort[nums[i]]++;
			}
			//cntSort배열의 누적합을 구하기 위한 반복문
			for(int j = 1; j < cntSort.length; j++) {
				cntSort[j] = cntSort[j-1]+cntSort[j];
			}
			//정렬된 배열을 만들기 위한 배열 생성
			int[] Sort = new int[N];
			//안정정렬을 위해 nums배열의 뒤에서부터 시작. 
			for(int i = N-1; i >= 0; i--) {
				Sort[--cntSort[nums[i]]] = nums[i];
			}
			System.out.print("#"+testcase);
			for(int i = 0; i < Sort.length; i++) {
				System.out.print(" "+Sort[i]);
			}
			System.out.println();
		}
	}
}
