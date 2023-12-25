// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/161989
// 두번째 시도 성공
class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        // 구역은 1번부터 시작하니 0으로 초기화.
        // 페인트 칠한 마지막 구역표시를 위한 변수.
        int paint = 0;
        for(int s = 0; s < section.length; s++) {
            if(section[s] >= paint) {
                paint = section[s]+m;
                answer++;
            }
        }
        return answer;
    }
}

// 실패. 테케 80% 성공

class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 1;
        int start = section[0]+m-1;
        for(int s = 0; s < section.length; s++) {
            if(section[s] > start) {
                start += m;
                answer++;
            }
        }
        return answer;
    }
}