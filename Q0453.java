// 정수 n을 기준으로 n과 가까운 수부터 정렬하려고 합니다. 
// 이때 n으로부터의 거리가 같다면 더 큰 수를 앞에 오도록 배치합니다. 
// 정수가 담긴 배열 numlist와 정수 n이 주어질 때 numlist의 원소를 n으로부터 가까운 순서대로 정렬한 배열을 return하도록 solution 함수를 완성해주세요.

// 성공

import java.util.*;

class Solution {
    public int[] solution(int[] numlist, int n) {
        //거리가 같다면 큰 수부터 담아주기 때문에 정렬 필수
        Arrays.sort(numlist);
        //결과 출력할 배열
        int[] answer = new int[numlist.length];
        //가까운 값을 계산한 값을 담을 배열
        int[] near = new int[numlist.length];
        //얼마나 가까운지 값 담아주기
        for(int i = 0; i < numlist.length; i++) {
            if(numlist[i] < n) {
                near[i] = n-numlist[i];
            } else if(numlist[i] == n) {
                near[i] = 0;
            } else if(numlist[i] > n) {
                near[i] = numlist[i]-n;
            }
        }
        
        out: for(int i = 0, idx = 0; i < 10000; i++) {
            //거리가 같다면 큰 수부터 정렬하기 때문에 뒤에서부터 담기 때문에 뒤에서부터 탐색
            for(int j = near.length-1; j >= 0; j--) {
                //i의 거리라면 answer배열에 담아주기
                if(near[j] == i) {
                    answer[idx++] = numlist[j];
                }
                //answer 배열이 다 채워지면 나가기
                if(idx == numlist.length) {
                    break out;
                }
            }
        }
        return answer;
    }
}