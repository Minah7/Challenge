// Given an integer x, return true if x is a 
// palindrome
// , and false otherwise.

//  Accepted

 class Solution {
    public boolean isPalindrome(int x) {
        String X = String.valueOf(x);
        String palindrome = "";
        for(int i = X.length()-1; i >= 0; i--) {
            palindrome += X.charAt(i);
        }
        boolean palin = X.equals(palindrome);
        return palin;
        
    }
}