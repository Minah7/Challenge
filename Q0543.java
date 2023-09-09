// 등차수열 혹은 등비수열 common이 매개변수로 주어질 때, 
// 마지막 원소 다음으로 올 숫자를 return 하도록 solution 함수를 완성해보세요.

// 성공

class Solution {
    public int solution(int[] common) {
        int answer = 0;
        int[] subtract = new int[common.length-1];
        //차이 구하기
        for(int i = 1, idx = 0; i < common.length; i++) {
            subtract[idx++] = common[i]-common[i-1];
        }
        //등차수열인지 등비수열인지 확인
        if(subtract[0] == subtract[1]) {
            answer = common[common.length-1]+subtract[0];
        } else {
            answer = (common[common.length-1]/common[common.length-2])*common[common.length-1];
        }
        return answer;
    }
}