// You are given a grid of bulbs, where each bulb is represented by either a 1 (ON)
// or a 0 (OFF). You are allowed to perform the following operation:

//     - Choose any row or column in the grid and toggle the bulbs. When you toggle, 
//     bulbs that are ON (1) will turn OFF (0), and bulbs that are OFF (0) will
//     turn ON (1).

// Your task is to maximize the sum of the binary values of each row after
// performing the toggle operation any number of times.

// Calculate the highest possible sum of all the binary values of each row in 
// the grid after applying the operations.

// Input Format:
// -------------
// Line-1: Two space separated integers, M and N
// Next M lines: N space separated integers, grid[][]

// Output Format:
// --------------
// Print an integer result.


// Sample Input-1:
// ---------------
// 3 5
// 0 1 1 1 1 
// 1 0 1 1 1 
// 0 0 0 0 1 

// Sample Output-1:
// ----------------
// 78

// Explanation:
// ------------
// Given grid is 
// 0 1 1 1 1
// 1 0 1 1 1
// 0 0 0 0 1

// Perform operation on row-0 and row-2
// 1 0 0 0 0
// 1 0 1 1 1
// 1 1 1 1 0

// Perform operation on col-1 and col-4
// 1 1 0 0 1 = 25
// 1 1 1 1 0 = 30
// 1 0 1 1 1 = 23
// So, now the total value of Binary Equivalent is 78


// Sample Input-2:
// ---------------
// 2 3
// 0 1 0
// 0 0 1

// Sample Output-2:
// ----------------
// 11

import java.util.*;

public class bulbs{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] matrix = new int[m][n];
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        for(int i = 0;i<m;i++){
            if(matrix[i][0] == 0){
                for(int j = 0;j<n;j++){
                    matrix[i][j] = 1 - matrix[i][j];
                }
            }
        }
        for(int i = 0;i<n;i++){
            int count1 = 0;
            int count0 = 0;
            for(int j = 0;j<m;j++){
                if(matrix[j][i] == 1){
                    count1++;
                }
                else{
                    count0++;
                }
            }
            if(count0>count1){
                for(int j = 0;j<m;j++){
                    matrix[j][i] = 1 - matrix[j][i];
                }
            }
        }
        
        int sum = 0;
        for(int i = 0;i<m;i++){
            StringBuilder temp = new StringBuilder();
            for(int j = 0;j<n;j++){
                temp.append(matrix[i][j]);
            }
            int binary = Integer.parseInt(temp.toString(),2);
            sum += binary;
        }
        System.out.println(sum);
        sc.close();
    }
}