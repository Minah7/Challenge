// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/42628

// 이중 우선순위 큐가 할 연산 operations가 매개변수로 주어질 때, 
// 모든 연산을 처리한 후 큐가 비어있으면 [0,0] 비어있지 않으면 [최댓값, 최솟값]을 return 하도록 solution 함수를 구현해주세요.

// 성공

import java.util.*;

class Solution {
    
    static class DblEndedPQ { 
        Set<Integer> s; 
        DblEndedPQ()
        {
            s= new HashSet<Integer>();
        }
        // Returns size of the queue. Works in 
        // O(1) time 
        int size() 
        { 
        return s.size(); 
        } 

        // Returns true if queue is empty. Works 
        // in O(1) time 
        boolean isEmpty() 
        { 
        return (s.size() == 0); 
        } 

        // Inserts an element. Works in O(Log n) 
        // time 
        void insert(int x) 
        { 
            s.add(x); 

        } 

        // Returns minimum element. Works in O(1) 
        // time 
        int getMin() 
        { 
            return Collections.min(s,null); 
        } 

        // Returns maximum element. Works in O(1) 
        // time 
        int getMax() 
        { 
            return Collections.max(s,null); 
        } 

        // Deletes minimum element. Works in O(Log n) 
        // time 
        void deleteMin() 
        { 
            if (s.size() == 0) 
                return ; 
            s.remove(Collections.min(s,null)); 

        } 

        // Deletes maximum element. Works in O(Log n) 
        // time 
        void deleteMax() 
        { 
            if (s.size() == 0) 
                return ; 
            s.remove(Collections.max(s,null));

        } 
    }; 
    
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        DblEndedPQ d = new DblEndedPQ();
        
        for(int i = 0; i < operations.length; i++) {
            String[] s = operations[i].split(" ");
            if(s[0].equals("I")) {
                d.insert(Integer.valueOf(s[1]));
            } else if(s[1].equals("1")) {
                d.deleteMax();
            } else {
                d.deleteMin();
            }
        }
        if(d.size() != 0) {
            answer[0] = d.getMax();
            answer[1] = d.getMin();
        }
        return answer;
    }
}