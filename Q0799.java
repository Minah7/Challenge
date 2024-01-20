// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/17680

// 어피치에게 시달리는 제이지를 도와, DB 캐시를 적용할 때 캐시 크기에 따른 실행시간 측정 프로그램을 작성하시오.
// 입력 형식
// 캐시 크기(cacheSize)와 도시이름 배열(cities)을 입력받는다.
// cacheSize는 정수이며, 범위는 0 ≦ cacheSize ≦ 30 이다.
// cities는 도시 이름으로 이뤄진 문자열 배열로, 최대 도시 수는 100,000개이다.
// 각 도시 이름은 공백, 숫자, 특수문자 등이 없는 영문자로 구성되며, 대소문자 구분을 하지 않는다. 
// 도시 이름은 최대 20자로 이루어져 있다.

//조건
// 캐시 교체 알고리즘은 LRU(Least Recently Used)를 사용한다.
// cache hit일 경우 실행시간은 1이다.
// cache miss일 경우 실행시간은 5이다.

// 성공. 이 문제를 통해 Queue와 LinkedList의 차이에 대해 알게되었다.

import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        LinkedList<String> cache = new LinkedList<>();
        for(int i = 0; i < cities.length; i++) {
            String c = cities[i].toLowerCase();
            if(!cache.contains(c)) {
                cache.addFirst(c);
                answer += 5;
            } else {
                cache.remove(c);
                cache.addFirst(c);
                answer ++;
            }
            if(cache.size() > cacheSize) {
                cache.pollLast();
            }
        }
        return answer;
    }
}