// Mr. Febin is studying numbers with unique properties and is interested in 
// finding all AD Numbers within a specified range.

// An AD Number is a number where every pair of adjacent digits has an absolute 
// difference of exactly 1.

// Given two integers, start and end, identify all AD Numbers within the inclusive 
// range [start,end] and output them in ascending order.

// Constraints:
// ------------
// 0 <= start < end <2*10^9.
 
// Input Format:
// -------------
// Two space-separated integers, start and end, representing the range.

// Output Format:
// --------------
// A list of integers showing all AD Numbers in the given range.


// Sample Input-1:
// ---------------
// 0 15

// Sample Output-1:
// ----------------
// [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12]

// Explanation:
// ------------
// All numbers in this list have adjacent digits differing by exactly 1.


// Sample Input-2:
// ---------------
// 25 65

// Sample Output-2:
// ----------------
// [32, 34, 43, 45, 54, 56, 65]

import java.util.*;
public class ADNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();
        List<Integer> result = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<=9;++i){
            q.add(i);
        }
        while(!q.isEmpty()){
            int curr = q.poll();
            if(curr>=start && curr<=end){
                result.add(curr);
            }
            if(curr>end) break;
            int lastDigit = curr%10;
            if(lastDigit>0){
                q.add(curr*10+lastDigit-1);
            }
            if(lastDigit<9){
                q.add(curr*10+lastDigit+1);
            }
        }
        System.out.println(result);
        sc.close();
    }
}
