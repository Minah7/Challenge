// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/17684

// 성공

import java.util.*;

class Solution {
  public int[] solution(String msg) {
    ArrayList<String> dic = new ArrayList<String>();
    ArrayList<Integer> result = new ArrayList<Integer>();

    for(int i = 0 ; i < 26; i++) {
        dic.add(String.valueOf((char)('A'+i)));
    }

    for(int i = 0 ; i < msg.length() ; i++) {
        for(int j = dic.size()-1 ; j >= 0 ; j--) {
            if(msg.substring(i).startsWith(dic.get(j))) {
                i += dic.get(j).length()-1;
                result.add(j+1);
                if(i+1 < msg.length())
                    dic.add(dic.get(j)+msg.charAt(i+1));
                break;
            }
        }
    }

    int[] answer = new int[result.size()];

    for(int i = 0 ; i < result.size() ; i++) 
        answer[i] = result.get(i);

    return answer;  
  }
}