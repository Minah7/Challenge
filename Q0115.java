// 알파벳 대소문자로만 이루어진 문자열 my_string이 주어질 때, 
// my_string에서 'A'의 개수, my_string에서 'B'의 개수,..., my_string에서 'Z'의 개수, 
// my_string에서 'a'의 개수, my_string에서 'b'의 개수,..., my_string에서 'z'의 개수를 
// 순서대로 담은 길이 52의 정수 배열을 return 하는 solution 함수를 작성해 주세요.

// 성공!

class Solution {
    public int[] solution(String myString) {
        int[] answer = new int[52];
        for (int i = 0; i < myString.length(); i++) {
            if (myString.charAt(i) >= 'A' && myString.charAt(i) <= 'Z') {
                answer[myString.charAt(i)- 'A']++;
            } else if (myString.charAt(i) >= 'a' && myString.charAt(i) <= 'z') {
                answer[26+myString.charAt(i)-'a']++;
            }
        }
        return answer;
    }
}