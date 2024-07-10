// 문제링크: https://code-challenge.elice.io/courses/95930/lectures/738999/lecturepages/20391343/

// 엘리스 토끼는 문자열을 직접 압축 해제하려고 합니다.
// 압축되지 않은 문자열 S가 주어졌을 때, 이 문자열 중 어떤 부분 문자열은 K(Q)와 같이 압축할 수 있습니다. 
// 이것은 Q라는 문자열이 K 번 반복된다는 뜻입니다. K는 한 자릿수의 정수이고, Q는 0자리 이상의 문자열입니다.

// 예를 들면, 53(8)은 다음과 같이 압축을 해제할 수 있습니다.
// 53(8) = 5 + 3(8) = 5 + 888 = 5888

// 압축된 문자열이 주어졌을 때, 이 문자열을 다시 압축을 푸는 프로그램을 작성하세요.

// 성공

import java.util.*;

class Main {
    public static String answer = "";

    public static void getAnswer (String k, String q, boolean check) {
        String temp = "";
        
        //k나 q가 0인지 검사
        if(k.equals("") || k.equals("0") || q.equals("") || q.equals("0")) {
            temp = "";
        } else {
            if(k.length() > 1) {
                temp += k.substring(0, k.length() - 1);
            }
            for(int r = 0; r < Integer.parseInt(k.substring(k.length() - 1)); r++) {
                temp += q;
            }
        }
        
        if(check) {
            answer += temp;
        } else {
            answer = temp;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String s = sc.next();

        Stack<String> stack = new Stack<>();

        int start = 0, open = 0, close = 0;

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                open++;
                stack.push(s.substring(start, i));
                start = i + 1;
            } else if(s.charAt(i) == ')') {
                close++;
                
                // int k, int q 구하기
                String k = stack.pop();
                String q = "";
                if(s.charAt(i - 1) == ')') {
                    q = answer;
                    getAnswer(k, q, false);
                } else {
                    if(s.charAt(i - 1) != '(') {
                        q = s.substring(start, i);
                    }
                    getAnswer(k, q, true);
                }
                start = i + 1;
            }
        }
        if(open == 0) {
            answer = s;
        }
        System.out.println(answer.length());
    }
}