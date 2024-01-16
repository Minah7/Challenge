// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/64065

// 튜플은 다음과 같은 성질을 가지고 있습니다.

// 중복된 원소가 있을 수 있습니다. ex : (2, 3, 1, 2)
// 원소에 정해진 순서가 있으며, 원소의 순서가 다르면 서로 다른 튜플입니다. ex : (1, 2, 3) ≠ (1, 3, 2)
// 튜플의 원소 개수는 유한합니다.

// 원소의 개수가 n개이고, 중복되는 원소가 없는 튜플 제공

// 성공

import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        ArrayList<String> num = new ArrayList<>();
        int start = 1;
        int end = 0;
        for(int i = 1; i < s.length()-1; i++) {
            if(s.charAt(i) == '{') {
                start = i;
            } else if(s.charAt(i) == '}') {
                num.add(s.substring(start+1, i));    
            } 
        } //괄호 나누기
        
        Comparator<String> c = new Comparator<String>() {
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        };
        
        Collections.sort(num, c); // 길이로 정렬 
        
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i = 0; i < num.size(); i++) {
            String[] tmp = num.get(i).split(",");
            for(int j = 0; j < tmp.length; j++) {
                int n = Integer.valueOf(tmp[j]);
                if(!answer.contains(n)) {
                    answer.add(n);
                }
            }
        } //튜플 구하기
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}