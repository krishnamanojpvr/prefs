// ABC Township has acquired a plot of land that contains both lakes and usable land. 
// The layout of the land is represented by a 2D grid, gridLand[][], of size M * N, 
// where each cell is marked as either land (0) or water (1).

// Before HMDA can approve the layout, engineers need to design the number of floors 
// for each building according to the guidelines below:
//     - Buildings can only be constructed on land cells (0).
//     - The number of floors in each building must be non-negative.
//     - Construction is not allowed on lake cells (1), so the floor count for 
//       those cells must be 0.
//     - The absolute difference in the number of floors between any two adjacent 
//       buildings should not exceed 1. Two buildings are considered adjacent 
//       if they share a side (north, east, south, or west).

// Your task is to assign floor counts for each building cell to maximize the 
// tallest building (i.e., the building with the most floors). Print the maximum 
// number of floors in any building within the grid.

// Input Format:
// -------------
// Line 1: Two space-separated integers, M and N, representing the dimensions of the land.
// Next M lines: N space-separated integers, each either 0 or 1, 
//               representing land and lake cells.

// Output Format:
// --------------
// Print a single integer representing the maximum number of floors in any building.


// Sample Input-1:
// ---------------
// 3 3
// 1 0 0
// 1 1 0
// 1 1 1

// Sample Output-1:
// ----------------
// 2

// Explanation:
// ------------
// One of the possibility of layout of the buildings is:
// 0 1 2
// 0 0 1
// 0 0 0
// So, the maximum number of floors of a building is 2.


// Sample Input-2:
// ---------------
// 3 4
// 1 0 0 0
// 1 0 0 0
// 1 1 0 0

// Sample Output-2:
// ----------------
// 3

// Explanation:
// ------------
// One of the possibility of layout of the buildings is:
// 0 1 2 3
// 0 1 2 3
// 0 0 1 2
// So, the maximum number of floors of a building is 3.

import java.util.*;
public class maxFloors{
    public static int floors(int[][] grid, Queue<int[]> queue, int n, int m){
        int[] neighbourRow = {-1,0,1,0};
        int[] neighbourCol = {0,1,0,-1};
        int max = 0;
        while(!queue.isEmpty()){
            int[] top = queue.poll();
            int r = top[0];
            int c = top[1];
            for(int i = 0;i<4;i++){
                int nx = r+neighbourRow[i];
                int ny = c+neighbourCol[i];
                if(nx>=0 && nx<n && ny>=0 && ny<m && grid[nx][ny]==-1){
                    grid[nx][ny] = grid[r][c]+1;
                    max = Math.max(max,grid[nx][ny]);
                    queue.add(new int[]{nx,ny});
                }
            }
        }
        return max;
    }
    public static int getMaxFloors(int[][] grid, int n, int m){
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                if(grid[i][j]==1){
                    queue.add(new int[]{i,j});
                    grid[i][j] = 0;
                }
                else{
                    grid[i][j] = -1;
                }
            }
        }
        return floors(grid,queue,n,m);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];
        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                grid[i][j] = sc.nextInt();
            }
        }
        System.out.println(getMaxFloors(grid,n,m));
        sc.close();
    }
}