//Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/submissions/867121467/
package medium;

import java.util.HashMap;
import java.util.Map;

class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int maxLengthSubstring = 0;
        Map<Character, Integer> visitedLetters = new HashMap<>();
        int windowStart = 0; int windowFinish = 0;

        for(; windowFinish < s.length(); windowFinish++) {
            char currentLetter = s.charAt(windowFinish);

            if(visitedLetters.containsKey(currentLetter) == false){
                visitedLetters.put(currentLetter, windowFinish);

            } else if(visitedLetters.containsKey(currentLetter) == true){
                if(visitedLetters.get(currentLetter) >= windowStart) {
                    windowStart = visitedLetters.get(currentLetter) + 1;
                }
                visitedLetters.put(currentLetter, windowFinish);
            }

            maxLengthSubstring = Math.max(maxLengthSubstring, windowFinish - windowStart + 1  );
        }
        return maxLengthSubstring;
    }
}