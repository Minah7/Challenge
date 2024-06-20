// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/17686

// 소스 파일 저장소에 저장된 파일명은 100 글자 이내로, 영문 대소문자, 숫자, 공백(" "), 마침표("."), 빼기 부호("-")만으로 이루어져 있다. 
// 파일명은 영문자로 시작하며, 숫자를 하나 이상 포함하고 있다.

// 파일명은 크게 HEAD, NUMBER, TAIL의 세 부분으로 구성된다.

// HEAD는 숫자가 아닌 문자로 이루어져 있으며, 최소한 한 글자 이상이다.
// NUMBER는 한 글자에서 최대 다섯 글자 사이의 연속된 숫자로 이루어져 있으며, 앞쪽에 0이 올 수 있다. 
// 0부터 99999 사이의 숫자로, 00000이나 0101 등도 가능하다.
// TAIL은 그 나머지 부분으로, 여기에는 숫자가 다시 나타날 수도 있으며, 아무 글자도 없을 수 있다.

// 파일명은 우선 HEAD 부분을 기준으로 사전 순으로 정렬한다. 이때, 문자열 비교 시 대소문자 구분을 하지 않는다.
// 파일명의 HEAD 부분이 대소문자 차이 외에는 같을 경우, NUMBER의 숫자 순으로 정렬한다. 
// 9 < 10 < 0011 < 012 < 13 < 014 순으로 정렬된다. 숫자 앞의 0은 무시되며, 012와 12는 정렬 시에 같은 같은 값으로 처리된다.
// 두 파일의 HEAD 부분과, NUMBER의 숫자도 같을 경우, 원래 입력에 주어진 순서를 유지한다.

// 실패. 테케는 맞지만 런타임 에러 뜸..

import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        int f = files.length;
        String[] answer = new String[f];
        
        String[][] div = new String[f][3];
        for(int i = 0; i < f; i++) {
            int s = 0;
            int e = 0;
            for(int c = 0; c < files[i].length(); c++) {
                if((Character.isDigit(files[i].charAt(c)) && s == 0)) {
                    s = c;
                }
                if(s != 0 && !Character.isDigit(files[i].charAt(c))) {
                    e = c;
                    break;
                }
            }
            div[i][0] = files[i].substring(0, s);
            div[i][1] = files[i].substring(s, e);
            div[i][2] = files[i].substring(e);
        }
        
        Arrays.sort(div, (o1, o2) -> {
			if(o1[0].toLowerCase().compareTo(o2[0].toLowerCase(Locale.ROOT)) > 0) {
                return 1;
            } else if(o1[0].toLowerCase().compareTo(o2[0].toLowerCase(Locale.ROOT)) < 0) {
                return -1;
            } else {
                if(Integer.parseInt(o1[1]) > Integer.parseInt(o2[1])) {
                    return 1;
                } else if(Integer.parseInt(o1[1]) < Integer.parseInt(o2[1])) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        
        for(int i = 0; i < f; i++) {
            answer[i] = div[i][0] + div[i][1] + div[i][2];
        }
        
        return answer;
    }
}