// Link: https://leetcode.com/problems/palindrome-number/

class Solution {
    public boolean isPalindrome(int x) {
        String xString = Integer.toString(x);

        //Base cases
        if(xString.charAt(0) == '-') {
            return false;
        }
        if(xString.length() == 1 || xString.isEmpty()) {
            return true;
        }

        for(int i=0 ; i<xString.length()/2; i++){
            if(xString.charAt(i) != xString.charAt(xString.length() - 1 - i))  {
                return false;
            }
        }
        return true;
    }
}