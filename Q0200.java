오늘 해야 할 일이 담긴 문자열 배열 todo_list와 각각의 일을 지금 마쳤는지를 나타내는 boolean 배열 finished가 매개변수로 주어질 때, todo_list에서 아직 마치지 못한 일들을 순서대로 담은 문자열 배열을 return 하는 solution 함수를 작성해 주세요.

성공

class Solution {
    public String[] solution(String[] todoList, boolean[] finished) {
        int f = 0;
        for(int i = 0; i < finished.length; i++) {
            if(finished[i] != true) {
                f++;
            }
        }
        String[] answer = new String [f];
        for(int i = 0, index = 0; i < finished.length; i++) {
            if(!finished[i]) {
                answer[index++] = todoList[i];
            }
        }
        return answer;
    }
}