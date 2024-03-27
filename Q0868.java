// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/258712

// 선물을 직접 전하기 힘들 때 카카오톡 선물하기 기능을 이용해 축하 선물을 보낼 수 있습니다. 
// 당신의 친구들이 이번 달까지 선물을 주고받은 기록을 바탕으로 다음 달에 누가 선물을 많이 받을지 예측하려고 합니다.

// 두 사람이 선물을 주고받은 기록이 있다면, 이번 달까지 두 사람 사이에 더 많은 선물을 준 사람이 다음 달에 선물을 하나 받습니다.
// 예를 들어 A가 B에게 선물을 5번 줬고, B가 A에게 선물을 3번 줬다면 다음 달엔 A가 B에게 선물을 하나 받습니다.
// 두 사람이 선물을 주고받은 기록이 하나도 없거나 주고받은 수가 같다면, 
// 선물 지수가 더 큰 사람이 선물 지수가 더 작은 사람에게 선물을 하나 받습니다.
// 선물 지수는 이번 달까지 자신이 친구들에게 준 선물의 수에서 받은 선물의 수를 뺀 값입니다.
// 예를 들어 A가 친구들에게 준 선물이 3개고 받은 선물이 10개라면 A의 선물 지수는 -7입니다. 
// B가 친구들에게 준 선물이 3개고 받은 선물이 2개라면 B의 선물 지수는 1입니다. 
// 만약 A와 B가 선물을 주고받은 적이 없거나 정확히 같은 수로 선물을 주고받았다면, 다음 달엔 B가 A에게 선물을 하나 받습니다.
// 만약 두 사람의 선물 지수도 같다면 다음 달에 선물을 주고받지 않습니다.

// 실패.

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
        
        for(int i = 0; i < gifts.length; i++) {
            String[] s = gifts[i].split(" ");
            int x = map.get(s[0]);
            int y = map.get(s[1]);
            box[x][y][0]++;
        }
        
        int[] get = new int[p];
        int[][] giftIndex = new int[p][3];
        boolean[][] visited = new boolean[p][p];
        for(int i = 0; i < p; i++) {
            int sent = 0;
            int received = 0;
            for(int j = 0; j < p; j++) {
                if(i != j) {
                    sent += box[i][j][0];
                    received += box[j][i][0];
                }   
            }
            giftIndex[i][0] = sent;
            giftIndex[i][1] = received;
            giftIndex[i][2] = sent - received;
        }
        
        for(int i = 0; i < p - 1; i++) {
            for(int j = i + 1; j < p; j++) {
                if(giftIndex[i][2] > giftIndex[j][2]) {
                    get[i]++;
                } else if(giftIndex[i][2] < giftIndex[j][2]) {
                    get[j]++;
                }
            }
        }
        
        int max = 0;
        for(int i = 0; i < p; i++) {
            if(get[i] > max) {
                max = get[i];
            }
        }
        
        return max;
    }
}