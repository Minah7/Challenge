// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/17677

// 자카드 유사도는 집합 간의 유사도를 검사하는 여러 방법 중의 하나로 알려져 있다. 
// 두 집합 A, B 사이의 자카드 유사도 J(A, B)는 두 집합의 교집합 크기를 
// 두 집합의 합집합 크기로 나눈 값으로 정의된다.
// 집합 A와 집합 B가 모두 공집합일 경우에는 나눗셈이 정의되지 않으니 따로 J(A, B) = 1로 정의한다.

// 입력으로 들어온 문자열은 두 글자씩 끊어서 다중집합의 원소로 만든다. 
// 이때 영문자로 된 글자 쌍만 유효하고, 기타 공백이나 숫자, 
// 특수 문자가 들어있는 경우는 그 글자 쌍을 버린다.

// 유사도 값은 0에서 1 사이의 실수이므로, 
// 이를 다루기 쉽도록 65536을 곱한 후에 소수점 아래를 버리고 정수부만 출력한다.

// 성공

import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int times = 65536;
		
		str1 = str1.toLowerCase(); // 대문자와 소문자의 차이는 없다.
		str2 = str2.toLowerCase();
		
		Map<String, Integer> str1Set = new HashMap<>();
		Map<String, Integer> str2Set = new HashMap<>();
		
		boolean[] checkStr1 = new boolean[str1.length()];
		boolean[] checkStr2 = new boolean[str2.length()];
		
		for(int i = 0; i < str1.length() - 1; i++) {
			if(!checkStr1[i] && !checkStr1[i + 1]) {
				int checkFirst = str1.charAt(i) - 'a';
				if(0 <= checkFirst && checkFirst <= 25) {
					int checkSecond = str1.charAt(i+1) - 'a';
					if(0 <= checkSecond && checkSecond <= 25) {
						String pass = str1.substring(i, i+2);
						str1Set.put(pass, str1Set.getOrDefault(pass, 0) + 1);
					} else {
						checkStr1[i+1] = true;
					}
				}
			}
		}
		
		for(int i = 0; i < str2.length() - 1; i++) {
			if(!checkStr2[i] && !checkStr2[i + 1]) {
				int checkFirst = str2.charAt(i) - 'a';
				if(0 <= checkFirst && checkFirst <= 25) {
					int checkSecond = str2.charAt(i+1) - 'a';
					if(0 <= checkSecond && checkSecond <= 25) {
						String pass = str2.substring(i, i+2);
						str2Set.put(pass, str2Set.getOrDefault(pass, 0) + 1);
					} else {
						checkStr2[i+1] = true;
					}
				}
			}
		}
        
		if(str1Set.size() == 0 && str2Set.size() == 0) {
			return times;
		}
		
		double intersection = 0;
		double union = 0;
        
		for(Map.Entry<String, Integer> entry : str1Set.entrySet()) {
			if(str2Set.containsKey(entry.getKey())) {
				intersection += Math.min(entry.getValue(), str2Set.get(entry.getKey()));
				union += Math.max(entry.getValue(), str2Set.get(entry.getKey()));
			} else {
				union += entry.getValue();
			}
		}
		
		for(Map.Entry<String, Integer> entry : str2Set.entrySet()) {
			if(!str1Set.containsKey(entry.getKey())) {
				union += entry.getValue();
			}
		}
		
		return (int)Math.floor((intersection/union) * times);
    }
}