// Brahmi and his gang have been chased by a group of police officers and are now 
// trapped in a building with M×N rooms, arranged in a grid format. Each room is 
// connected to its adjacent rooms both horizontally and vertically, forming a 
// complex layout. Fortunately, some rooms in the building are designated as 
// "safe zones," providing a possible escape for Brahmi and his gang.

// The building's rooms are marked with the following values:
//     -1 : Danger Zone - an area that Brahmi and his gang cannot enter.
//     0 : Safe Zone - an area that provides a possible escape.
//     -2 : Occupied by a gang member.
    
// Your task is to help Brahmi and his gang reach the nearest safe zones by 
// calculating the minimum distance from each gang member's room to a safe zone, 
// avoiding danger zones. If a gang member is unable to reach any safe zone, 
// mark their room with -2.

// Input Format:
// -------------
// Line-1 -> two integers M and N, size of the grid of rooms.
// Next M Lines -> N space separated integers, from this set [-2,-1,0] only.

// Output Format:
// --------------
// Print an integer as result.


// Sample Input-1:
// ---------------
// 4 4
// -2 -1 0 -2
// -2 -2 -2 -1
// -2 -1 -2 -1
// 0 -1 -2 -2

// Sample Output-1:
// ----------------
// 3 -1 0 1
// 2 2 1 -1
// 1 -1 2 -1
// 0 -1 3 4

// NOTE: Please refer the hint.

import java.util.*;
public class safeZone{
    public static void getSafeZones(int[][] grid, int m, int n){
        int[] neighbourRow = {-1, 0, 1, 0};
        int[] neighbourCol = {0, 1, 0, -1};
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                if(grid[i][j]==0){
                    q.add(new int[]{i, j});
                }
            }
        }
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int row = curr[0];
            int col = curr[1];
            for(int i=0;i<4;++i){
                int newRow = row + neighbourRow[i];
                int newCol = col + neighbourCol[i];
                if(newRow>=0 && newRow<m && newCol>=0 && newCol<n && grid[newRow][newCol]==-2){
                    grid[newRow][newCol] = grid[row][col]+1;
                    q.add(new int[]{newRow, newCol});
                }
            }
        }
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] grid = new int[m][n];
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                grid[i][j] = sc.nextInt();
            }
        }
        getSafeZones(grid, m, n);
        sc.close();
    }
}