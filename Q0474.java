// 공백으로 구분된 백만개의 정수가 주어진다.
// 오름차순으로 정렬한 후 배열 A에 저장하고 A[500000]을 출력하라.

// 1<=A[i]<=1000000

// 성공

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static int N;

    public static void mergeSort(int[] A, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(A, left, mid);
            mergeSort(A, mid + 1, right);
            merge(A, left, mid, right);
        }
    }

    public static void merge(int[] A, int left, int mid, int right) {
        int L = left, R = mid + 1;
        int idx = 0;
        int len = right - left + 1;
        int[] sortedA = new int[len];
        while (L <= mid && R <= right) {
            if (A[L] <= A[R]) {
                sortedA[idx++] = A[L++];
            } else {
                sortedA[idx++] = A[R++];
            }
        }
        if (L <= mid) {
            for (int i = L; i <= mid; i++) {
                sortedA[idx++] = A[i];
            }
        }
        if (R <= right) {
            for (int j = R; j <= right; j++) {
                sortedA[idx++] = A[j];
            }
        }
        for (int i = left; i <= right; i++) {
            A[i] = sortedA[i - left];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String num[] = bf.readLine().split(" ");
        N = 1000000;
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(num[i]);
        }

        mergeSort(A, 0, N - 1);
        System.out.println(A[N / 2]);
    }
}