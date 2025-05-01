// A dangerous virus, "Ebola," is spreading across several African countries. 
// People are positioned in a grid of size p * q, where some positions in the grid 
// are empty.

// The grid is represented with three values: 0, 1, and 2, where:
//     - 0 indicates an empty position,
//     - 1 indicates a healthy person, and
//     - 2 indicates an infected person.
//     - Each minute, any healthy person who is 4-directionally adjacent (up, down, 
//       left, or right) to an infected person becomes infected.

// Your task is to determine the minimum amount of time, in minutes, for the virus 
// to spread to all people in the grid. 
// If it is impossible to infect everyone, return -1.

// Input Format:
// -------------
// Line 1: Two integers, P and Q, representing the dimensions of the grid.
// Next P lines: Each line contains Q space-separated integers, either 0, 1, or 2, 
//               representing the grid.

// Output Format:
// --------------
// An integer, the minimum amount of time in minutes


// Sample Input-1:
// ---------------
// 3 3
// 2 1 1
// 1 1 0
// 0 1 1

// Sample Output-1:
// ----------------
// 4

// Explanation-1: (Refer the hint)
// --------------
// There is an infected person at position (0, 0).
// In the first minute: people at positions (0, 1) and (1, 0) are infected.
// In the second minute: people at positions (0, 2) and (1, 1) are infected.
// In the third minute: the person at position (1, 2) is infected.
// In the fourth minute: the person at position (2, 2) is infected.


// Sample Input-2:
// ---------------
// 3 3
// 2 1 1
// 0 1 1
// 1 0 1

// Sample Output-2:
// ----------------
// -1

// Explanation-2:
// --------------
// The healthy person at the bottom left corner (row 2, column 0) cannot be 
// infected because infection only spreads in the four primary directions.

// Sample Input-3:
// ---------------
// 1 2
// 0 2

// Sample Output-3:
// ----------------
// 0

// Explanation-3: 
// -------------
// Since there are no healthy people at minute 0, the answer is simply 0.


import java.util.*;

public class infectedPerson{
    public static int check(int[][] grid, Queue<int []> queue, int n, int m){
        int time = 0;
        int[] neighbourRow = {-1,0,1,0};
        int[] neighbourCol = {0,1,0,-1};
        while(!queue.isEmpty()){
            int[] top = queue.poll();
            int r = top[0];
            int c = top[1];
            int currTime = top[2];
            for(int i = 0;i<4;i++){
                int nr = r + neighbourRow[i];
                int nc = c + neighbourCol[i];
                if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc] == 1){
                    grid[nr][nc] = 2;
                    queue.add(new int[]{nr,nc,currTime+1});
                    time = Math.max(time,currTime+1);
                }
            }
        }
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }
        return time;
    }
    public static int getMinutes(int[][] grid, int n, int m){
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j] == 2){
                    queue.add(new int[]{i,j,0});
                    grid[i][j] = 0;
                }
            }
        }
        return check(grid,queue,n,m);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                grid[i][j] = sc.nextInt();
            }
        }
        System.out.println(getMinutes(grid,n,m));
        sc.close();
    }
}