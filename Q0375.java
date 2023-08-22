// 한 개 이상의 항의 합으로 이루어진 식을 다항식이라고 합니다. 
// 다항식을 계산할 때는 동류항끼리 계산해 정리합니다. 
// 덧셈으로 이루어진 다항식 polynomial이 매개변수로 주어질 때, 
// 동류항끼리 더한 결괏값을 문자열로 return 하도록 solution 함수를 완성해보세요. 같은 식이라면 가장 짧은 수식을 return 합니다.

// 실패

class Solution {
    public String solution(String polynomial) {
        polynomial = polynomial.replace(" ", "");
        String[] monomial = polynomial.split("+");
        int x = 0;
        int n = 0;
        for(int i = 0; i < monomial.length; i++) {
            if(monomial[i].contains("x")) {
                monomial[i] = monomial[i].replace("x", "");
                x+= Integer.valueOf(monomial[i]);
            }
            n += Integer.valueOf(monomial[i]);
        }
        String numX = String.valueOf(x)+"x";
        String num = String.valueOf(n);
        String answer = numX+" + "+num;
        return answer;
    }
}