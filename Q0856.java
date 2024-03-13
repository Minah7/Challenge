// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/160586

// 1번 키부터 차례대로 할당된 문자들이 순서대로 담긴 문자열배열 keymap과 
// 입력하려는 문자열들이 담긴 문자열 배열 targets가 주어질 때, 
// 각 문자열을 작성하기 위해 키를 최소 몇 번씩 눌러야 하는지 순서대로 배열에 담아 return 하는 solution 함수를 완성해 주세요.

// 단, 목표 문자열을 작성할 수 없을 때는 -1을 저장합니다.

// 성공

import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int n = targets.length;
        int[] answer = new int[n];
        
        for(int t = 0; t < n; t++) {
            int count = 0;
            for(int i = 0; i < targets[t].length(); i++) {
                char find = targets[t].charAt(i);
                List<Integer> list = new ArrayList<>();
                boolean flag = false;
                
                for(int k = 0; k < keymap.length; k++) {
                    if(keymap[k].contains("" + find)) {
                        if(keymap[k].charAt(0) == find) {
                            count++;
                            flag = true;
                            break;
                        } else {
                            list.add(k);
                        }
                    }
                }
                
                if(flag) {
                    continue;
                }
                
                if(list.size() == 0) {
                    count = -1;
                    break;
                } else {
                    int min = 100;
                    out: for(int l = 0; l < list.size(); l++) {
                        int k = list.get(l);
                        for(int j = 0; j < keymap[k].length(); j++) {
                            if(j >= min) {
                                continue;
                            }
                            if(keymap[k].charAt(j) == find) {
                                min = Math.min(min, j + 1);
                                continue;
                            }
                            if(min == 1) {
                                break out;
                            }
                        }
                    }
                    count += min;
                }
            }
            answer[t] = count;
        }
        
        return answer;
    }
}