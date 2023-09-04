// JadenCase란 모든 단어의 첫 문자가 대문자이고, 그 외의 알파벳은 소문자인 문자열입니다. 
// 단, 첫 문자가 알파벳이 아닐 때에는 이어지는 알파벳은 소문자로 쓰면 됩니다. (첫 번째 입출력 예 참고)
// 문자열 s가 주어졌을 때, s를 JadenCase로 바꾼 문자열을 리턴하는 함수, solution을 완성해주세요.

// 제한 조건
// s는 길이 1 이상 200 이하인 문자열입니다.
// s는 알파벳과 숫자, 공백문자(" ")로 이루어져 있습니다.
// 숫자는 단어의 첫 문자로만 나옵니다.
// 숫자로만 이루어진 단어는 없습니다.
// 공백문자가 연속해서 나올 수 있습니다.

// 두번째 도전 성공
class Solution {
    public String solution(String s) {
        String answer = "";
        s = s.toLowerCase();
        answer += s.substring(0,1).toUpperCase();
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == ' ') {
                answer += " ";
                continue;
            } else if(s.charAt(i-1) == ' ' && Character.isAlphabetic(s.charAt(i))) {
                answer += s.substring(i, i+1).toUpperCase();
            } else {
                answer += s.charAt(i);
            }
        }
        return answer;
    }
}

//첫번째 도전 실패
class Solution {
    public String solution(String s) {
        s = s.toLowerCase();
        s = s.trim().replaceAll("\\s{2,}", " ");
        String[] arr = s.split(" ");
        String answer = "";
        for(int a = 0; a < arr.length; a++) {
            answer += arr[a].substring(0,1).toUpperCase()+arr[a].substring(1);
            if(a == arr.length-1) {
                break;
            } else {
                answer += " ";
            }
        }
        return answer;
    }
}