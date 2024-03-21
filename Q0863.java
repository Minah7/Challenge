// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/258712

// 두 사람이 선물을 주고받은 기록이 있다면, 이번 달까지 두 사람 사이에 더 많은 선물을 준 사람이 다음 달에 선물을 하나 받습니다.
// 예를 들어 A가 B에게 선물을 5번 줬고, B가 A에게 선물을 3번 줬다면 다음 달엔 A가 B에게 선물을 하나 받습니다.
// 두 사람이 선물을 주고받은 기록이 하나도 없거나 주고받은 수가 같다면, 선물 지수가 더 큰 사람이 선물 지수가 더 작은 사람에게 선물을 하나 받습니다.
// 선물 지수는 이번 달까지 자신이 친구들에게 준 선물의 수에서 받은 선물의 수를 뺀 값입니다.
// 예를 들어 A가 친구들에게 준 선물이 3개고 받은 선물이 10개라면 A의 선물 지수는 -7입니다. B가 친구들에게 준 선물이 3개고 받은 선물이 2개라면 B의 선물 지수는 1입니다. 만약 A와 B가 선물을 주고받은 적이 없거나 정확히 같은 수로 선물을 주고받았다면, 다음 달엔 B가 A에게 선물을 하나 받습니다.
// 만약 두 사람의 선물 지수도 같다면 다음 달에 선물을 주고받지 않습니다.
// 위에서 설명한 규칙대로 다음 달에 선물을 주고받을 때, 당신은 선물을 가장 많이 받을 친구가 받을 선물의 수를 알고 싶습니다.

// 실패

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
        // for(int i = 0; i < p; i++) {
        //     box[i] = friends[i];
        //     map.put(friends[i], i);
        //     for(int j = 0; j < p; j++) {
        //         if(j != i) {
        //             box[i][j] = friends[j];
        //             box[i][j][0] = "0";
        //         }
        //     }
        // }
        
        for(int i = 0; i < gifts.length; i++) {
            String[] s = gifts[i].split(" ");
            int x = map.get(s[0]);
            int y = map.get(s[1]);
            box[x][y][0]++;
        }
        
        int[] get = new int[p];
        boolean[][] visited = new boolean[p][p];
        for(int i = 0; i < p; i++) {
            for(int j = 0; j < p - 1; j++) {
                if(i != j && !visited[i][j]) {
                    visited[i][j] = true;
                    visited[j][i] = true;
                    
                    int a = box[i][j][0];
                    int b = box[j][i][0];
                    if((a == 0 && b == 0) || a == b) {
                        int aSent = 0;
                        for(int f = 0; f < p; f++) {
                            aSent += box[i][f][0];
                        }
                        int aReceived = 0;
                        for(int f = 0; f < p; f++) {
                            aReceived += box[f][i][0];
                        }
                        boolean flagA = false;
                        if(aSent == 0 && aReceived == 0) {
                            flagA = true;
                        }
                        
                        int bSent = 0;
                        for(int f = 0; f < p; f++) {
                            bSent += box[j][f][0];
                        }
                        int bReceived = 0;
                        for(int f = 0; f < p; f++) {
                            bReceived += box[f][j][0];
                        }
                        boolean flagB = false;
                        if(bSent == 0 && bReceived == 0) {
                            flagB = true;
                        }
                        
                        int ar = aSent - aReceived;
                        int br = bSent = bReceived;
                        if(ar > br) {
                            get[i]++;
                            continue;
                        }
                        if(br > ar) {
                            get[j]++;
                            continue;
                        }
                        if(flagA && flagB) {
                            get[j]++;
                            continue;
                        }
                        if(aSent == bSent && aReceived == bReceived) {
                            get[j]++;
                            continue;
                        }
                        
                        int ax = aSent - aReceived;
                        int bx = bSent = bReceived;
                        
                    } else if(a > b) {
                        get[i]++;
                    } else if(b < a) {
                        get[j]++;
                    }
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