// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/42885
// 무인도에 갇힌 사람들을 구명보트를 이용하여 구출하려고 합니다. 
// 구명보트는 작아서 한 번에 최대 2명씩 밖에 탈 수 없고, 무게 제한도 있습니다.
// 성공.

import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people); //무게순으로 정렬
        //무게가 큰 순서부터 첫번째로 태우기
        int check = 0;
        for(int i = people.length-1; i >= 0; i--) {
            if(i < check) {
                break;
            }
            int rest = limit-people[i];
            if(people[check] <= rest) {
                check++;
            }
            answer++; 
        }
        return answer;
    }
}