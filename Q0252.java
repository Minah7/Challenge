// Given a positive integer n, find the sum of all integers in the range [1, n] inclusive that are divisible by 3, 5, or 7.
// Return an integer denoting the sum of all numbers in the given range satisfying the constraint.

// Accepted

class Solution {
    public int sumOfMultiples(int n) {
        int answer = 0;
        for(int i = 1; i <= n; i++) {
            if(i%3==0 || i%5==0 || i%7==0)
            answer += i;
        }
        return answer;
    }
}