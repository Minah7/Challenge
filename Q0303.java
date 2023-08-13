// 덧셈, 뺄셈 수식들이 'X [연산자] Y = Z' 형태로 들어있는 문자열 배열 quiz가 매개변수로 주어집니다. 
// 수식이 옳다면 "O"를 틀리다면 "X"를 순서대로 담은 배열을 return하도록 solution 함수를 완성해주세요.

// 성공

class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        int idx = 0;
        for(int i = 0; i < quiz.length; i++) {
            String[] arr = quiz[i].split(" ");
            if (arr[1].equals("+")) {
                if(Integer.valueOf(arr[0])+Integer.valueOf(arr[2]) == Integer.valueOf(arr[4])) {
                    answer[idx++] = "O";
                } else {
                    answer[idx++] = "X";
                }
            } else {
                if(Integer.valueOf(arr[0])-Integer.valueOf(arr[2]) == Integer.valueOf(arr[4])) {
                    answer[idx++] = "O";
                } else {
                    answer[idx++] = "X";
                }
            }
        }
        return answer;
    }
}