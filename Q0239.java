A sentence is a list of words that are separated by a single space with no leading or trailing spaces.
You are given an array of strings sentences, where each sentences[i] represents a single sentence.
Return the maximum number of words that appear in a single sentence.

Accepted

class Solution {
    public int mostWordsFound(String[] sentences) {
        int[] words = new int[sentences.length];
        for(int i = 0; i < sentences.length; i++) {
            int space = 0;
            for(int j = 0; j < sentences[i].length(); j++) {
                if(sentences[i].charAt(j) == ' ') {
                    space++;
                    words[i] = space;
                }
            }
        }
        Arrays.sort(words);
        int answer = words[words.length-1]+1;;
        return answer;
    }
}