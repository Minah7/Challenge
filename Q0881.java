// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/42842

// Leo가 본 카펫에서 갈색 격자의 수 brown, 노란색 격자의 수 yellow가 매개변수로 주어질 때 
// 카펫의 가로, 세로 크기를 순서대로 배열에 담아 return 하도록 solution 함수를 작성해주세요.

// 성공

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        for(int i = yellow; i > 0; i--) {
            if(yellow % i == 0) {
                int width = i * 2;
                int height = (yellow / i) * 2;
                if(brown == width + height + 4) {
                    answer[0] = height / 2 + 2;
                    answer[1] = width / 2 + 2;
                }
            }
        }
        return answer;
    }
}