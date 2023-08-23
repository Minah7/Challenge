// 문자열 배열 strArr이 주어집니다. 
// strArr의 원소들을 길이가 같은 문자열들끼리 그룹으로 묶었을 때 가장 개수가 많은 그룹의 크기를 return 하는 solution 함수를 완성해 주세요.

// 성공

class Solution {
    public int solution(String[] strArr) {
        int[] cnt = new int[31];
        int answer = 0;
        for(int i = 0; i < strArr.length; i++) {
            cnt[strArr[i].length()]++;
        }
        for(int i = 0; i < cnt.length; i++) {
            if(cnt[i]>answer) answer = cnt[i];
        }
        return answer;
    }
}