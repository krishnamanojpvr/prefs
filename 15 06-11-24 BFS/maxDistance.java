// In a township of size N×N, each 1x1 area is either a villa or a swimming pool. 
// The layout of the township is represented as a 2D matrix of size N×N, 
// filled with 0's and 1's, where:
//     - 0 represents a swimming pool,
//     - 1 represents a villa.

// Your task is to identify a swimming pool such that its distance to the nearest 
// villa(s) is maximized, and return this distance.

// If the township contains only villas or only swimming pools, return -1.

// Note: The distance used in this problem is the Manhattan distance: the distance 
// between two cells (a0, b0) and (a1, b1) is defined as |a0 - a1| + |b0 - b1|

// Input Format:
// -------------
// - The first line contains an integer N, the size of the 2D matrix
// - The next N lines each contain N space-separated integers, either 0 or 1, 
//   representing the township matrix.

// Output Format:
// --------------
// Print an integer, representing the maximum distance from any swimming pool to 
// the nearest villa.


// Sample Input-1:
// ---------------
// 4
// 1 0 1 1
// 0 0 0 0
// 1 0 1 0
// 1 0 0 1

// Sample Output-1:
// ----------------
// 2

// Explanation: 
// ------------
// The swimming pool at (1, 1) is with distance 2 from the nearest villas.


// Sample Input-2:
// ---------------
// 4
// 1 0 0 0
// 0 0 0 0
// 1 0 0 0
// 0 1 0 1

// Sample Output-2:
// ----------------
// 3

// Explanation: 
// ------------
// The swimming pool at (0,3) or (1, 2) are with distance 3 from the nearest villas.

import java.util.*;

public class maxDistance{
    public static int getMaxTime(int[][] grid, Queue<int []> queue, int n){
        int dist = 0;
        while(!queue.isEmpty()){
            int[] top = queue.poll();
            int r = top[0];
            int c = top[1];
            int currDist = top[2];
            dist = Math.max(dist,currDist);
            
            int[] neighRow = {-1,0,1,0};
            int[] neighCol = {0,1,0,-1};
            
            for(int i = 0;i<4;i++){
                int nr = r + neighRow[i];
                int nc = c + neighCol[i];
                if(nr>=0 && nr<n && nc>=0 && nc<n && grid[nr][nc]==0){
                    grid[nr][nc] = 1;
                    queue.offer(new int[]{nr,nc,currDist+1});
                }
            }
        }
        return dist;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<int []> queue = new LinkedList<>();
        int[][] grid = new int[n][n];
        boolean villa = false;
        boolean pool = false;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                grid[i][j] = sc.nextInt();
                if(grid[i][j] == 1){
                    queue.offer(new int[]{i,j,0});
                    villa = true;
                }
                else{
                    pool = true;
                }
            }
        }
        if(villa == false || pool == false){
            System.out.println(-1);
            sc.close();
            return;
        }
        System.out.println(getMaxTime(grid,queue,n));
        sc.close();
    }
}