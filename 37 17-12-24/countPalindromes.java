// Mr. Parandamayya is working with Strings.
// He is given a String S. He has to find the palindromes in S, 
// A palindrome can be a substring of S (Strictly substrings only, not subsequences).

// Your task is to find the count the number of palindromes can be formed from S.

// NOTE: Count each occurence of palindromes if duplicate substrings found.

// Input Format:
// -------------
// A string S

// Output Format:
// --------------
// Print an integer, number of palindromes.


// Sample Input-1:
// ---------------
// divider

// Sample Output-1:
// ----------------
// 9

// Explanation:
// -------------
// Palindromes are d, i, v, i, d, e, r, ivi, divid


// Sample Input-2:
// ---------------
// abcdef

// Sample Output-2:
// ----------------
// 6

// Explanation:
// -------------
// Palindromes are a, b, c, d, e, f.

import java.util.*;

public class countPalindromes{
    public static int getPalindromes(String s){
        int count = 0;
        for(int i = 0;i<s.length();i++){
            for(int j = i+1;j<=s.length();j++){
                if(isPalindrome(s.substring(i,j))){
                    count++;
                }
            }
        }
        return count;
    }
    public static boolean isPalindrome(String s){
        int left = 0;
        int right = s.length()-1;
        while(left<right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(getPalindromes(s));
        sc.close();
    }
}
