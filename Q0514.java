// 한 개 이상의 항의 합으로 이루어진 식을 다항식이라고 합니다. 
// 다항식을 계산할 때는 동류항끼리 계산해 정리합니다. 
// 덧셈으로 이루어진 다항식 polynomial이 매개변수로 주어질 때, 동류항끼리 더한 결괏값을 문자열로 return 하도록 solution 함수를 완성해보세요. 
// 같은 식이라면 가장 짧은 수식을 return 합니다.

// 성공

class Solution {
    public String solution(String polynomial) {
        String answer = "";
        int num = 0;
        int xNum = 0;
        String[] mono = polynomial.split(" ");
        for(int i = 0; i < mono.length; i++) {
            if(mono[i].equals("+")) {
                continue;
            } else if(mono[i].contains("x")) {
                mono[i] = mono[i].replace("x", "");
                if(mono[i].equals("")) {
                    xNum += 1;
                } else {
                    xNum += Integer.valueOf(mono[i]);
                }
            } else if(!mono[i].contains("x")){
                num += Integer.valueOf(mono[i]);
            }
        }
        if(num != 0 && xNum != 0) {
            answer = String.valueOf(xNum)+"x + "+String.valueOf(num);
        } else if(num != 0 && xNum == 0) {
            answer = String.valueOf(num);
        } else if(num == 0 && xNum != 0) {
            answer = String.valueOf(xNum)+"x";
        }
        return answer;
    }
}