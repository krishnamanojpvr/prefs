// You are given a set of N integers, and a value to find F. Initially a variable, 
// 'total' is set to 0. You can perform either addition(+) or subtraction(-)
// of every integer from the set to the 'total'. The resultant total should be
// equal to the value F.

// Your task is to find out the number of ways, you can make the 'total' equal to
// the value F.

// Input Format:
// -------------
// Line-1: Two integers N and F.
// Line-2: N space separated integers 

// Output Format:
// --------------
// Print an integer, number of ways.


// Sample Input:
// ---------------
// 5 3
// 1 1 1 1 1

// Sample Output:
// ----------------
// 5

// Explanation:
// ------------
// total = -1+1+1+1+1 = 3 -> total=value-F
// total = +1-1+1+1+1 = 3 -> total=value-F
// total = +1+1-1+1+1 = 3 -> total=value-F
// total = +1+1+1-1+1 = 3 -> total=value-F
// total = +1+1+1+1-1 = 3 -> total=value-F

// NOTE: + means addition, - means subtraction

import java.util.*;

public class countWays{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int f = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;++i){
            nums[i] = sc.nextInt();
        }
        System.out.println(getCount(nums, f, 0, 0));
        sc.close();
    }
    
    public static int getCount(int[] nums, int f, int i, int total){
        if(i==nums.length){
            if(total==f){
                return 1;
            }
            return 0;
        }
        return getCount(nums, f, i+1, total+nums[i]) + getCount(nums, f, i+1, total-nums[i]);
    }
}