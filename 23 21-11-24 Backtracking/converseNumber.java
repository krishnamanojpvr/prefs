// Vihan is given a number N and He wants to check whether N is a converse number
// or not. The binary form of number N is said to be converse number, if it obeys 
// the following property: "every pair of adjacent digits are different". 

// Your task is to help Vihan to find N is a converse number or not.
// If yes, print 'true', otherwise print 'false'.

// Input Format:
// -------------
// An integer N, the positive number.

// Output Format:
// --------------
// Print a boolean result.

// Sample Input-1:
// ---------------
// 85

// Sample Output-1:
// ----------------
// true

// Explanation:
// ------------
// Binary Rep of 85 is 1010101 


// Sample Input-2:
// ---------------
// 87

// Sample Output-2:
// ----------------
// false

// Explanation:
// ------------
// Binary Rep of 87 is 1010111

import java.util.*;

public class converseNumber{
    public static boolean checkConverse(int n){
        String s = Integer.toBinaryString(n);
        return helper(s,1);
    }
    public static boolean helper(String s, int i){
        if(i==s.length()){
            return true;
        }
        if(s.charAt(i)==s.charAt(i-1)){
            return false;
        }
        return helper(s,i+1);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(checkConverse(n));
        sc.close();
    }
}