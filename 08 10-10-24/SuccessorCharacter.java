// Vishal is a software engineer working on the development of a new text-based game. 
// In the game, players are given a set of clues based on specific letters of the 
// alphabet, and their task is to identify the "next" letter in the sequence. To 
// enhance the game, Vishal wants to implement a feature where the next letter 
// follows the cyclic order of the alphabet, meaning after "z", the next letter 
// loops back to "a."

// He has a list of sorted letters from 'a' to 'z' that represent available clues,
// and his task is to find the next valid letter, or "successor," for a given clue. 

// For example, if the clue is "f," and the sorted list of letters is "adghijl", 
// the successor should be the smallest letter greater than "f," which is "g."

// The letters are guaranteed to be sorted in non-decreasing order, and Vishal 
// needs to solve this problem efficiently in logarithmic time.

// Your task is to help Vishal by implementing the functionality to find the successor 
// for a given letter in the sorted list of clues. If no valid successor is found, 
// the answer should wrap around cyclically to the first letter in the list.

// Input Format:
// -------------
// Line-1:A string str[]
// Line-2: a character represents an alphabet.
 
// Output Format:
// --------------
// Print a character which is the successor.
 
// Constraints:
// ------------
// 2 <= str.length<= 10^4
// 'alp' is a lowercase letter.

 
// Sample Input-1:
// ---------------
// adghijl
// f 
// Sample Output-1:
// ----------------
// g

// Sample Input-2:
// ---------------
// abcdefghi
// j

// Sample Output-2:
// ----------------
// a

import java.util.*;

public class SuccessorCharacter{
    public static char binarySearch(String s, char letter){
        int left = 0;
        int right = s.length()-1;
        char[] str = s.toCharArray();
        char res = str[0];
        while(left<=right){
            int mid = (left+right)/2;
            if(str[mid]<=letter){
                left = mid+1;
            }
            else{
                res = str[mid];
                right = mid-1;
            }
        }
        return res;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String letter = sc.next();
        System.out.println(binarySearch(s,letter.charAt(0)));
        sc.close();
    }
}