// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/131127
// 실패. 런타임 에러. 75점

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        int[] numberCopy = new int[5];
        for(int i = 0; i < 10; i++) {
            for(int w = 0; w < want.length; w++) {
                if(discount[i].equals(want[w])) {
                    numberCopy[w]++;
                    break;
                }
            }
        }
        boolean check = true;
        for(int n = 0; n < number.length; n++) {
            if(number[n] != numberCopy[n]) {
                check = false;
                break;
            }
        }
        
        if(check) answer++;
        
        for(int i = 0; i < discount.length-10; i++) {
            check = true;
            for(int w = 0; w < want.length; w++) {
                if(discount[i].equals(want[w])) {
                    numberCopy[w]--;
                } //매일 하루씩 옮겨지기 때문에 첫날 아이템 빼기
                if(discount[i+10].equals(want[w])) {
                    numberCopy[w]++;
                } //가장 마지막에 넣은 날의 다음날 아이템 넣기
            } 
            for(int n = 0; n < number.length; n++) {
                if(number[n] != numberCopy[n]) {
                    check = false;
                    break;
                }
            }
            if(check) answer++;
        }
        return answer;
    }
}