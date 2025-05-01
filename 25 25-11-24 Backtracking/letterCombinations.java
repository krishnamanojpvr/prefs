// Given a classic mobile phone, and the key pad of the phone looks like below.
// 	1		2		3
//            abc	   def
		 
// 	4		5		6
//     ghi    jkl     mno
  
// 	7		8		9
//     pqrs    tuv     wxyz
	
// 	*		0		#


// You are given a string S contains digits between [2-9] only, 
// For example: S = "2", then the possible words are "a", "b", "c".

// Now your task is to find all possible words that the string S could represent.
// and print them in a lexicographical order. 

// Input Format:
// -------------
// A string S, consist of digits [2-9]

// Output Format:
// --------------
// Print the list of words in lexicographical order.


// Sample Input-1:
// ---------------
// 2

// Sample Output-1:
// ----------------
// [a, b, c]


// Sample Input-2:
// ---------------
// 24

// Sample Output-2:
// ----------------
// [ag, ah, ai, bg, bh, bi, cg, ch, ci]

import java.util.*;

public class letterCombinations{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        List<String> res = new ArrayList<>();
        if(s.length()==0) System.out.println(res);
        else{
            String[] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
            helper(s,0,map,"",res);
            System.out.println(res);
        }
        sc.close();
    }
    
    public static void helper(String s, int index, String[] map, String curr, List<String> res){
        if(index==s.length()){
            res.add(curr);
            return;
        }
        String letters = map[s.charAt(index)-'0'];
        for(int i=0;i<letters.length();i++){
            helper(s,index+1,map,curr+letters.charAt(i),res);
        }
    }
}