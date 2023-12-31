// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/42842

// 성공.
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        for(int i = 1; i <= yellow; i++) {
            if(yellow % i == 0) {
                int sum = brown + yellow;
                int width = yellow/i + 2;
                int height = i + 2;
                if(sum == width*height) {
                    answer[0] = width;
                    answer[1] = height;
                    break;
                }
            }
        } 
        return answer;
    }
}