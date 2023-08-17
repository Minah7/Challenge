// 배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.

// 예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면

// array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.
// 1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.
// 2에서 나온 배열의 3번째 숫자는 5입니다.
// 배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때, 
// commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아 return 하도록 solution 함수를 작성해주세요.

// 성공

import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        //commands개수만큼의 배열 생성
        int[] answer = new int[commands.length];
        //commands개수만큼 반복문 돌려서 값 얻기
        for(int c = 0; c < commands.length; c++) {
            int i = commands[c][0];
            int j = commands[c][1];
            int k = commands[c][2];
            //i에서 j 크기 만큼의 배열 생성
            int[] arr = new int[j-i+1];
            //array의 인덱스 i-1에서 j-1값까지 새로운 배열에 담아주기
            for(int n = i-1, idx = 0; n < j; n++) {
                arr[idx++] = array[n];
            }
            //arr배열 정렬
            Arrays.sort(arr);
            //answer배열에 arr 배열의 k번째 값을 담아주기 위해서 arr배열의 k-1인덱스값 넣기.
            answer[c] = arr[k-1];
        }
        return answer;
    }
}