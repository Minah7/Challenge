// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/161989
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