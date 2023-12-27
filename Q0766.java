// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/118666
// 성공

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        char[] personality = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};
        int[] countP = new int[8];
        
        for(int i = 0; i < survey.length; i++) {
            if(1 <= choices[i] && choices[i] < 4) {
                for(int p = 0; p < 8; p++) {
                    if(personality[p] == survey[i].charAt(0)) {
                        countP[p] += 4-choices[i];
                    }
                }
            } else if(5 <= choices[i] && choices[i] < 8) {
                for(int p = 0; p < 8; p++) {
                    if(personality[p] == survey[i].charAt(1)) {
                        countP[p] += choices[i]-4;
                    }
                }
            }
        } //성격 유형 점수 계산
        
        for(int p = 0; p < 8; p+=2) {
            if(countP[p] == countP[p+1] || countP[p] > countP[p+1]) {
                answer += personality[p];
            } else {
                answer += personality[p+1];
            }
        } // 각 지표별 성격 유형 선택
        
        return answer;
    }
}