덧셈, 뺄셈 수식들이 'X [연산자] Y = Z' 형태로 들어있는 문자열 배열 quiz가 매개변수로 주어집니다. 
수식이 옳다면 "O"를 틀리다면 "X"를 순서대로 담은 배열을 return하도록 solution 함수를 완성해주세요.

성공

class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String [quiz.length];
        for(int i = 0; i < quiz.length; i++) {
            String[] a = quiz[i].split(" ");
            int X = Integer.parseInt(a[0]);
            int Y = Integer.parseInt(a[2]);
            int Z = Integer.parseInt(a[4]);
            if(a[1].equals("+")) {
                int add = X+Y;
                System.out.print(add);
                if(add == Z) {
                    answer[i] = "O";
                } else {
                    answer[i] = "X";
                }
            } else if(a[1].equals("-")) {
                int sub = X-Y;
                System.out.print(sub);
                if(sub == Z) {
                    answer[i] = "O";
                } else {
                    answer[i] = "X";
                }
            }
        }
        return answer;
    }
}