// You have a long flowerbed in which some of the plots are planted, and some are not. 
// However, flowers cannot be planted in adjacent plots.
// Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.

// Error : ArrayIndexOutOfBoundsException

import java.util.*;

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        boolean answer = false;
        for(int i = 0; i < flowerbed.length; i++) {
            if(flowerbed[i] != 1) {
                if(flowerbed[i-1] == 0 && flowerbed[i+n] == 0) {
                    int[] arr = Arrays.copyOfRange(flowerbed, i, i+n);
                    for(int j= 0; j < n; j++) {
                        if(arr[j] == 0) {
                            answer = true;
                        } else {
                            answer = false;
                        }
                    }
                }
            }
        }
        return answer;
    }
}