영어 점수와 수학 점수의 평균 점수를 기준으로 학생들의 등수를 매기려고 합니다. 
영어 점수와 수학 점수를 담은 2차원 정수 배열 score가 주어질 때, 영어 점수와 수학 점수의 평균을 기준으로 매긴 등수를 담은 배열을 return하도록 solution 함수를 완성해주세요.

미완성. 등수를 어떻게 구현해야할지 모르겠다.

class Solution {
    public int[] solution(int[][] score) {
        int[] avg = new int[score.length];
        for(int i = 0; i < score.length; i++) {
            avg[i] = (score[i][0]+score[i][1])/2;
        }
        for(int i = 0; i < avg.length; i++) {
            
        }
        return avg;
    }
}