// 등차수열 혹은 등비수열 common이 매개변수로 주어질 때, 마지막 원소 다음으로 올 숫자를 return 하도록 solution 함수를 완성해보세요.

// 성공

class Solution {
    public int solution(int[] common) {
        int answer = 0;
        int[] difference = new int[common.length-1];
        //수의 차이를 구해 배열에 담아주기
        for(int i = 1, idx = 0; i < common.length; i++) {
            difference[idx++] = common[i] - common[i-1];
        }
        //등차수열인지 등비수열인지 확인하기
        for(int i = 1; i < difference.length; i++) {
            if(difference[i-1] == difference[i]) {
                answer = common[common.length-1]+difference[i];
            } else {
                //등비수열이라면 몇배수인지 확인하기
                int t = common[common.length-1] / common[common.length-2];
                answer = common[common.length-1] *t;
            }
        }
        return answer;
    }
}