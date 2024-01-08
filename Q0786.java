// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/42584

// 초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때, 
// 가격이 떨어지지 않은 기간은 몇 초인지를 return

//성공.

class Solution {
    public int[] solution(int[] prices) {
        int pLen = prices.length;
        int[] answer = new int[pLen];
        
        for(int i = 0; i < pLen; i++) {
            for(int p = i+1; p < pLen; p++) {
                answer[i]++;
                if(prices[i] > prices[p]) {
                    break;
                }
            }
        }
        return answer;
    }
}