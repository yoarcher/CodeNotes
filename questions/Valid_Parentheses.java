/* Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not. */

public class Solution {
	public boolean isValid(String s) {
	    // IMPORTANT: Please reset any member data you declared, as
	    // the same Solution instance will be reused for each test case.
	    if(s.length() % 2 == 1) return false;
	    int i = 0, j = 0;
	    while(true){
	        for(j = i; j < s.length() - 1; j++){
	            if(isComplement(s.charAt(j), s.charAt(j + 1))) break;
	        }
	        if(j == s.length() - 1) return false;
	        i = j;
	        j++;
	        while(i >= 0 && j < s.length()){
	            if(!isComplement(s.charAt(i), s.charAt(j))) break;
	            i--;
	            j++;
	        }
	        if(i < 0 && j >= s.length()) return true;
	        else if(j < s.length()){
	            s = s.substring(0, i + 1) + s.substring(j);
	        }
	        else return false;
	        i++;
	    }
	}
	
	public boolean isComplement(char one, char two){
	    if((one == '(' && two == ')') || (one == '[' && two == ']') || (one == '{' && two == '}')){
	        return true;
	    }
	    return false;
	}
}