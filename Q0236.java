// Given a positive integer n, return the smallest positive integer that is a multiple of both 2 and n.

// Accepted

lass Solution {
    public int smallestEvenMultiple(int n) {
        int answer = 0;
        if(n%2 == 0) {
            answer = n;
        } else {
            answer = n*2;
        }
        return answer;
    }
}