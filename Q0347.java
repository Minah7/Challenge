명함 지갑을 만드는 회사에서 지갑의 크기를 정하려고 합니다. 
다양한 모양과 크기의 명함들을 모두 수납할 수 있으면서, 작아서 들고 다니기 편한 지갑을 만들어야 합니다. 
이러한 요건을 만족하는 지갑을 만들기 위해 디자인팀은 모든 명함의 가로 길이와 세로 길이를 조사했습니다.

성공

class Solution {
    public int solution(int[][] sizes) {
        //명함의 긴 변을 구하기 위한 변수
        int longer = 0;
        //명함의 짧은 변을 구하기 위한 변수
        int shorter = 0;
        //반복문 돌려가며 명함크기 비교하기
        for(int i = 0; i < sizes.length; i++) {
            //각 명함의 가로 세로 중 어느 길이가 더 긴지 구하기 위한 조건문
            if(sizes[i][0] >= sizes[i][1]) {
                //긴 변 중 가장 긴 변 구하기 
                if(sizes[i][0]> longer) longer = sizes[i][0];
                //짧은 변 중 가장 긴 짧은 변 구하기
                if(sizes[i][1]> shorter) shorter = sizes[i][1];
            //각 명함의 가로 세로 중 어느 길이가 더 긴지 구하기 위한 조건문
            } else if(sizes[i][0] < sizes[i][1]){
                if(sizes[i][0]> shorter) shorter = sizes[i][0];
                if(sizes[i][1]> longer) longer = sizes[i][1];
            }
        }
        //지갑 크기 구하기
        int answer = longer*shorter;
        return answer;
    }
}
