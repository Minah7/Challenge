// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/120876
// 세 선분의 시작과 끝 좌표가 [[start, end], [start, end], [start, end]] 
// 형태로 들어있는 2차원 배열 lines가 매개변수로 주어질 때, 
// 두 개 이상의 선분이 겹치는 부분의 길이를 return 하도록 solution 함수를 완성해보세요.
// 성공.

class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        
        int[] cntLine = new int[201];
        for(int i = 0; i < lines.length; i++) {
            int start = lines[i][0];
            int end = lines[i][1];
            for(int j = start; j < end; j++) {
                cntLine[100+j]++;
            }
        } // 선분에 놓이는 선 쌓기
        
        for(int i = 0; i < 201; i++) {
            if(cntLine[i] > 1) {
                answer++;
            }
        } //겹치는 선의 길이 구하기
        return answer;
    }
}