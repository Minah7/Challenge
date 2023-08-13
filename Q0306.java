// 주어진 N 길이의 숫자열을 오름차순으로 정렬하여 출력하라.
// 실패

import java.util.*;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            for(int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }

            for(int i = 0; i < N-1; i++) {
                int min = 0;
                for(int j = i+1; j < N; j++) {
                    if(arr[i] > arr[j]) {
                        min = j;
                    }
                }
                int tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }
            System.out.print("#"+tc+" ");
            for(int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }
	}
}

