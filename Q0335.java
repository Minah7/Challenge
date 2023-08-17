// 정수를 저장한 배열, arr 에서 가장 작은 수를 제거한 배열을 리턴하는 함수, solution을 완성해주세요. 
// 단, 리턴하려는 배열이 빈 배열인 경우엔 배열에 -1을 채워 리턴하세요. 
// 예를들어 arr이 [4,3,2,1]인 경우는 [4,3,2]를 리턴 하고, [10]면 [-1]을 리턴 합니다.

// 성공

class Solution {
    public int[] solution(int[] arr) {
        //배열이 1개일 때는 -1을 출력하므로 배열 개수 확인
        if(arr.length > 1) {
            //최소값을 제외한 값들을 담으므로 arr배열개수 -1개로 설정
            int[] answer = new int[arr.length-1];
            //최소값을 얻기 위해 최대값으로 초기화 설정
            int min = Integer.MAX_VALUE;
            // 최소값을 찾기 위한 반복문
            for(int i = 0; i < arr.length; i++) {
                if(min > arr[i]) {
                    min = arr[i];
                }
            }
            //최소값 제외한 arr배열의 값을 새 배열에 넣기 위한 반복문
            for(int i = 0, j = 0; i < arr.length; i++) {
                //만약 최소값이면 continue로 넘어가기
                if(arr[i] == min) continue;
                answer[j++] = arr[i];
            }
            return answer;
        } else {
            int[] answer = new int[1];
            answer[0] = -1;
            return answer;
        }
    }
}