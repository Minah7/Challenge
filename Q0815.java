// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/43165

// 사용할 수 있는 숫자가 담긴 배열 numbers, 타겟 넘버 target이 매개변수로 주어질 때 
// 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return

// 성공

class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }
    
    public void dfs(int[] numbers, int target, int depth, int sum) {
        if(depth == numbers.length) {
            if(target == sum) {
                answer++;
            }
        } else {
            dfs(numbers, target, depth + 1, sum + numbers[depth]);
            dfs(numbers, target, depth + 1, sum - numbers[depth]);
        }
    }
}