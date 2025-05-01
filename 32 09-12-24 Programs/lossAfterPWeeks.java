// Mr Ravi is a business man, he does business weekly Q times, 
// and records his PROFIT or LOSS every time in to data[][] array. 
// He records the LOSS as a negative value and PROFIT as a positive value.

// Your task is to help Mr Ravi to know that how many total number of times,
// he was in LOSS after P weeks.

// NOTE: The values in data[][] are in descending order both row-wise and 
// column-wise as given in sample testcases.

// Input Format:
// -------------
// Line-1: Two space separated integers, P and Q
// Next P lines: Q space separated integers, data[][].   

// Output Format:
// --------------
// Print an integer result.


// Sample Input-1:
// ---------------
// 4 4
// 5 4 2 -2
// 4 3 1 -2
// 2 2 -1 -3
// -1 -1 -2 -4

// Sample Output-1: 
// ----------------
// 8

// Explanation: 
// ------------
// 8 days in LOSS,since there are 8 negative values.

// Sample Input-2:
// ---------------
// 4 4
// 8 7 1 -2
// 7 6 2 -3
// 3 -1 -2 -4
// -2 -3 -4 -7
	 
// Sample Output-2:
// ----------------
// 9

// Explanation:
// ------------
// 9 days in LOSS,since there are 8 negative values.

// Sample Input-3:
// ---------------
// 2 2
// 9 3
// 5 0

// Sample Output-3:
// ----------------
// 0

import java.util.*;

public class lossAfterPWeeks{
    public static int binarySearch(int[] arr){
        int low = 0;
        int high = arr.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid]<0){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return arr.length-low;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        int count = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        for(int i = 0;i<n;i++){
            count += binarySearch(arr[i]);
        }
        System.out.println(count);
        sc.close();
    }
}