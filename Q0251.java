// Given an integer number n, return the difference between the product of its digits and the sum of its digits.

// Accepted

class Solution {
    public int subtractProductAndSum(int n) {
        String num = String.valueOf(n);
        int product = 1;
        int sum = 0;
        for(int i = 0; i < num.length(); i++) {
            int d = Character.digit(num.charAt(i),10);
            product *= d;
            sum += d;
        }
        return product-sum;
    }
}