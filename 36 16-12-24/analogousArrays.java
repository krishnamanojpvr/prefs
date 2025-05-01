// A covert agent has crucial information stored in the form of an array of integers. 
// The array contains sensitive information, and it must not be revealed to anyone. 
// However, certain properties about the array are known:
//  - The length of the array is equal to the "length of a secret array + 1".
//  - Each integer in the array lies within a specific interval [lowerBound L,
//    upperBound U ].
 
// The difference between each pair of consecutive integers in the array must be equal
// to the difference between the respective pair of integers in the secret array.

// Given a list of consecutive differences representing the secret array.
// The values of lowerBound and upperBound.

// Your task is to find the total number of arrays that satisfy the conditions to 
// be analogous to the secret array. If no such arrays exist, return 0.

// Input Format:
// -------------
// Three space sepaarted integers, N, L, U
// N space serapated inteegrs, secret array[].

// Output Format:
// --------------
// An integers, number of analogous arrays.


// Sample Input-1:
// ---------------
// 4 3 10
// -2 -1 -2 5

// Sample Output-1:
// ----------------
// 3

// Explanation:
// --------------
// There are 3 valid arrays:
//     [3, 5, 6, 8, 3]
//     [4, 6, 7, 9, 4]
//     [5, 7, 8, 10, 5]


// Sample Input-2:
// ---------------
// 3 1 6
// 1 2 1

// Sample Output-2:
// ----------------
// 2

// Explanation:
// ------------
// There are 2 valid arrays:
//     [1, 2, 4, 5]
//     [2, 3, 5, 6]

import java.util.*;

public class analogousArrays{
    public static int getAnalogousArrays(int[] secret, int n, int l, int u){
        int count = 0;
        OUTER:for(int i = l; i<=u;i++){
            int elem = i;
            for(int j = 0; j<secret.length;j++){
                if(elem - secret[j] > u || elem-secret[j] < l){
                    continue OUTER;
                }
                elem -= secret[j];
            }
            count++;
        }
        return count;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int u = sc.nextInt();
        int[] secret = new int[n];
        for(int i = 0;i<n;i++){
            secret[i] = sc.nextInt();
        }
        System.out.println(getAnalogousArrays(secret,n,l,u));
        sc.close();
    }
}