// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/258712

// 성공

import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int p = friends.length;
        int[][][] box = new int[p][p][1];
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < p; i++) {
            map.put(friends[i], i);
        }
        
        int[] giftDegree = new int[p];
        for(int i = 0; i < gifts.length; i++) {
            String[] s = gifts[i].split(" ");
            int x = map.get(s[0]);
            int y = map.get(s[1]);
            giftDegree[x]++;
            giftDegree[y]--;
            box[x][y][0]++;
        }
        
        for(int i = 0; i < p; i++) {
            int count = 0;
            for(int j = 0; j < p; j++) {
                if(i != j) {
                    int x = box[i][j][0];
                    int y = box[j][i][0];
                    if(x > y || (x == y && giftDegree[i] > giftDegree[j])) {
                        count++;
                    }
                }   
            }
            
            if(answer < count) {
                answer = count;
            }
        }
        
        
        
        return answer;
    }
}