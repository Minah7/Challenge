// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/72410

// 성공

class Solution {
    public String solution(String newId) {
        String answer = "";
        // 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
        newId = newId.toLowerCase();
        // 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        for(int i = 0; i < newId.length(); i++) {
            char c = newId.charAt(i);
            if((c - 'a' >= 0 && c -'a' < 26) || Character.isDigit(c) || c == '-' || c == '_' || c == '.') {
                answer += Character.toString(c);
            }
        }
        // 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        newId = "";
        newId += Character.toString(answer.charAt(0));
        for(int i = 1, idx = 0; i < answer.length(); i++) {
            if(answer.charAt(idx) == '.' && answer.charAt(i) == '.') {
                continue;
            } else {
                newId += Character.toString(answer.charAt(i));
                idx = i;
            }
        }
        // 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        // 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        if(newId.equals(".") || newId.equals("")) {
            newId = "a";
        } else {
            if(newId.charAt(0) == '.') {
                newId = newId.substring(1);
            }
            if(newId.charAt(newId.length() - 1) == '.') {
                newId = newId.substring(0, newId.length() - 1);
            }
        }
        // 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        if(newId.length() > 15) {
            newId = newId.substring(0, 15);
            // 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
            if(newId.charAt(newId.length() - 1) == '.') {
                newId = newId.substring(0, 14);
            }
        }
        // 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        if(newId.length() <= 2) {
            char c = newId.charAt(newId.length() - 1);
            while(newId.length() < 3) {
                newId += Character.toString(c);
            }
        }
        return newId;
    }
}