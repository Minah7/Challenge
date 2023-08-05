// Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it. 
// That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].
// Return the answer in an array.

// Accepted

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] answer = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            int s = 0;
            for(int j = 0; j < nums.length; j++) {
                if(j != i && nums[j] <nums[i]) {
                    s++;
                }
            }
            answer[i] = s;
        }
        return answer;
    }
}