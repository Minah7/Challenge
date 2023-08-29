// 최빈값은 주어진 값 중에서 가장 자주 나오는 값을 의미합니다. 
// 정수 배열 array가 매개변수로 주어질 때, 최빈값을 return 하도록 solution 함수를 완성해보세요. 최빈값이 여러 개면 -1을 return 합니다.

// 성공

class Solution {
    public int solution(int[] array) {
        int answer = 0;
        //개수를 카운트할 배열
        int[] cnt = new int[1001];
        for(int i = 0; i < array.length; i++) {
            cnt[array[i]]++;
        }
        //최빈값
        int max = 0;
        int duplicate = 0;
        int num = 0;
        //max 개수 변경해주고 같다면 duplicate 개수 올려주기
        for(int i = 0; i < 1001; i++) {
            if(cnt[i] > max) {
                max = cnt[i];
                num = i;
                duplicate = 0;
            } else if(cnt[i] == max) {
                duplicate++;
            }
        }
        //최빈값이 하나인지 여러 개인지에 따라 출력값 정해주기
        if(duplicate == 0) {
            answer = num;
        } else {
            answer = -1;
        }
        return answer;
    }
}