// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/12977

// 주어진 숫자 중 3개의 수를 더했을 때 소수가 되는 경우의 개수를 구하려고 합니다. 
// 숫자들이 들어있는 배열 nums가 매개변수로 주어질 때, 
// nums에 있는 숫자들 중 서로 다른 3개를 골라 더했을 때 소수가 되는 경우의 개수를 return

//성공.

class Solution {
    static int answer = 0;
    
    public int solution(int[] nums) {
        int n = nums.length;
        boolean[] visited = new boolean[n];

        combination(nums, visited, 0, n, 3);
        
        return answer;
    }
    
    // 백트래킹 사용. 조합
    public void combination(int[] nums, boolean[] visited, int start, int n, int r) {
        if(r == 0) {
            isPrime(nums, visited, n);
            return;
        }
        
        for(int i = start; i < n; i++) {
            visited[i] = true;
            combination(nums, visited, i+1, n, r-1);
            visited[i] = false;
        }
        
    }
    
    // 소수 확인
    public void isPrime(int[] nums, boolean[] visited, int n) {
        int sum = 0;
        for(int i = 0; i < n; i++) {
            if(visited[i]) {
                sum += nums[i];
            }
        }

        for(int i = 2; i <= (int)Math.sqrt(sum); i++) {
            if(sum%i == 0) {
                return;
            }
        }
        answer++;
        return;
    }
}