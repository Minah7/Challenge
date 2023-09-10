// 한 개 이상의 항의 합으로 이루어진 식을 다항식이라고 합니다. 
// 다항식을 계산할 때는 동류항끼리 계산해 정리합니다. 
// 덧셈으로 이루어진 다항식 polynomial이 매개변수로 주어질 때, 
// 동류항끼리 더한 결괏값을 문자열로 return 하도록 solution 함수를 완성해보세요. 
// 같은 식이라면 가장 짧은 수식을 return 합니다.

// 성공

class Solution {
    public String solution(String polynomial) {
        String answer = "0";
        int num = 0;
        int xNum = 0;
        String[] pArr = polynomial.split(" [+] ");
        for(int i = 0; i < pArr.length; i++) {
            if(pArr[i].contains("x")) {
                pArr[i] = pArr[i].replace("x", "");
                if(pArr[i].equals("")) {
                    xNum += 1;
                } else {
                    xNum += Integer.valueOf(pArr[i]);
                }
            } else {
                num += Integer.valueOf(pArr[i]);
            }
        }
        String xNum2 = (xNum == 1) ? "" : String.valueOf(xNum);
        if(num != 0 && xNum != 0) {
            answer = xNum2+"x + "+String.valueOf(num);
        } else if(num != 0 && xNum == 0) {
            answer = String.valueOf(num);
        } else if(num == 0 && xNum != 0) {
            answer = xNum2+"x";
        }
        return answer;
    }
}