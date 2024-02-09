// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/49993

// 제한 조건

// 스킬은 알파벳 대문자로 표기하며, 모든 문자열은 알파벳 대문자로만 이루어져 있습니다.
// 스킬 순서와 스킬트리는 문자열로 표기합니다.
// 예를 들어, C → B → D 라면 "CBD"로 표기합니다
// 선행 스킬 순서 skill의 길이는 1 이상 26 이하이며, 스킬은 중복해 주어지지 않습니다.
// skill_trees는 길이 1 이상 20 이하인 배열입니다.
// skill_trees의 원소는 스킬을 나타내는 문자열입니다.
// skill_trees의 원소는 길이가 2 이상 26 이하인 문자열이며, 스킬이 중복해 주어지지 않습니다.

// 성공

import java.util.*;

class Solution {
    public int solution(String skill, String[] skillTrees) {
        int answer = 0;
        
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < skill.length(); i++) {
            map.put(skill.charAt(i), i);
        }
        
        for(int s = 0; s < skillTrees.length; s++) {
            String skills = skillTrees[s];
            int check = -1;
            for(int i = 0; i < skills.length(); i++) {
                if(map.containsKey(skills.charAt(i))) {
                    int value = map.get(skills.charAt(i));
                    if(value > check) {
                        if(value == check + 1) {
                            check = value;
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if(i == skills.length() - 1) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}