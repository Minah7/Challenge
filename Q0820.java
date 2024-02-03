// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/172927

// 마인이 갖고 있는 곡괭이의 개수를 나타내는 정수 배열 picks와 
// 광물들의 순서를 나타내는 문자열 배열 minerals가 매개변수로 주어질 때, 
// 마인이 작업을 끝내기까지 필요한 최소한의 피로도를 return

// 성공

import java.util.Comparator;
import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int box = Math.min(((int)Math.ceil(minerals.length / 5.0)), (picks[0] + picks[1] + picks[2]));
        int[][] countM = new int[box][3];
        
        int b = 0;
        for(int i = 0; i < minerals.length; i++) {
            if(b == box) {
                break;
            }
            if(minerals[i].equals("diamond")) {
                countM[b][0] += 1;
                countM[b][1] += 5;
                countM[b][2] += 25;
            } else if(minerals[i].equals("iron")) {
                countM[b][0] += 1;
                countM[b][1] += 1;
                countM[b][2] += 5;
            } else if(minerals[i].equals("stone")) {
                countM[b][0] += 1;
                countM[b][1] += 1;
                countM[b][2] += 1;
            }
            if(i%5 == 4) {
                b++;
            }
        }
        
        Arrays.sort(countM, (o1, o2) -> (o2[2] - o1[2]));
        boolean[] check = new boolean[box];
        
        for(int i = 0; i < box; i++) {
            if(picks[0] != 0) {
                answer += countM[i][0];
                check[i] = true;
                picks[0]--;
            } else if(picks[1] != 0) {
                answer += countM[i][1];
                picks[1]--;
            } else if(picks[2] != 0) {
                answer += countM[i][2];
                picks[2]--;
            }
        }
        
        return answer;
    }
}