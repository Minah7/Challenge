// You are given an array of strings names, and an array heights that consists of distinct positive integers. Both arrays are of length n.
// For each index i, names[i] and heights[i] denote the name and height of the ith person.
// Return names sorted in descending order by the people's heights.

// 미완성. 내일 다시 풀어보기 

class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        String[] answer = new String[names.length];
        int max = 0
        for(int i = 0; i < names.length; i++) {
            if(heights[i]>max) {
                max = heights[i];
                answer[0] = names[i];
            }
            int next = 0;
            for(int j = 0; j < heights.length; j++) {
                if(height[j] < heights && height[j] > next){
                    answer[i] = names[j];
                }
            }
        }
        for(int i = 1; i < names.length; i++) {
            int next = 0;
            for(int j = 0; j < heights.length; j++) {
                if(height[j] < heights && height[j] > next){
                    answer[i] = names[j];
                }
            }
        }
        return answer;
    }
}