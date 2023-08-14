// 등차수열 혹은 등비수열 common이 매개변수로 주어질 때, 
// 마지막 원소 다음으로 올 숫자를 return 하도록 solution 함수를 완성해보세요.

// 실패

class Solution {
    public int solution(int[] common) {
        int answer = 0;
        for(int i = 0; i < common.length-1; i++) {
            if(common[i+1] == common[i]+1) {
                answer = common[common.length]+1;
            } else if(common[i+1] == common[i]*common[i]);
            for(int j = 0; j < common.length; j++) {
                answer *= 2;
            }
        }
        return answer;
    }
}