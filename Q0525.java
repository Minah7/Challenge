// 정수 배열 arr가 주어집니다. 
// 배열 안의 2가 모두 포함된 가장 작은 연속된 부분 배열을 return 하는 solution 함수를 완성해 주세요.

// 단, arr에 2가 없는 경우 [-1]을 return 합니다.

// 성공

class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        int start = -1; 
        int end = -1;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 2) {
                start = i;
                break;
            }
        }
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 2) {
                end = i;
            }
        }
        if(start == -1) {
            answer = new int[] {-1};
        } else if(start != -1 && start == end) {
            answer = new int[] {arr[start]};
        } else if(start != -1 && start != end) {
            answer = new int[end-start+1];
            for(int i = start, idx = 0; i <= end; i++) {
                answer[idx++] = arr[i];
            }
        }
        return answer;
    }
}