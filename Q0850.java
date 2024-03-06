// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/68936

// 당신이 압축하고자 하는 특정 영역을 S라고 정의합니다.
// 만약 S 내부에 있는 모든 수가 같은 값이라면, S를 해당 수 하나로 압축시킵니다.
// 그렇지 않다면, S를 정확히 4개의 균일한 정사각형 영역(입출력 예를 참고해주시기 바랍니다.)으로 쪼갠 뒤, 
// 각 정사각형 영역에 대해 같은 방식의 압축을 시도합니다.

// 해답 보고 풂. (다시 풀 것)

class Solution {
    static int zero = 0;
    static int one = 0;
    
    public boolean zip(int[][] arr, int size, int x, int y, int val) {
        for(int r = x; r < x + size; r++) {
            for(int c = y; c < y + size; c++) {
                if(arr[r][c] != val) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public void quad(int[][] arr, int size, int x, int y) {
        if(zip(arr, size, x, y, arr[x][y])) {
            if(arr[x][y] == 1) {
                one++;
            } else {
                zero++;
            }
            return;
        }
        
        quad(arr, size/2, x, y);
        quad(arr, size/2, x, y + size/2);
        quad(arr, size/2, x + size/2, y);
        quad(arr, size/2, x + size/2, y + size/2);
    }
    
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        int len = arr.length;
        
        quad(arr, len, 0, 0);
        
        answer[0] = zero;
        answer[1] = one;
        return answer;
    }
}