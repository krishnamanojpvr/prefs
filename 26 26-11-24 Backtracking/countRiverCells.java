// The Pandavas and Kauravas each rule different kingdoms separated by a river. 
// If the two kingdoms are connected, the land will form a square-shaped area. 
// The kingdoms are represented by cells marked with 1, and the river is 
// represented by cells marked with 0.

// The Pandavas and Kauravas have decided to build a bridge over the river to 
// improve connectivity between their kingdoms. To minimize the cost of construction, 
// they aim to reduce the length of the bridge. The bridge can only be built on 
// river cells that are connected in the four cardinal directions (up, down, left, 
// and right).

// Your task is to help the rulers minimize the number of river cells used for 
// building the bridge, and return the count of river cells occupied.

// Input Format:
// -------------
// Line-1: An integer N, size of the land.
// Next N lines: N space separated integers, either 0 or 1. 

// Output Format:
// --------------
// Print an integer result.


// Sample Input-1:
// ---------------
// 4
// 1 1 1 0
// 1 0 0 0
// 1 0 0 1
// 0 0 1 1

// Sample Output-1:
// ----------------
// 2


// Sample Input-2:
// ---------------
// 5
// 1 1 0 0 0
// 1 1 0 0 0
// 0 0 0 0 1
// 0 0 0 1 1
// 0 0 1 1 1

// Sample Output-2:
// ----------------
// 3

import java.util.*;

public class countRiverCells {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        }
        int result = getCount(grid);
        System.out.println(result);
        sc.close();
    }

    public static int getCount(int[][] grid) {
        int n = grid.length;
        int result = 0;
        boolean[][] visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && !visited[i][j]) {
                    result += dfs(grid, i, j, visited);
                }
            }
        }
        return result;
    }

    private static int dfs(int[][] grid, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 1 || visited[i][j])
            return 0;
        visited[i][j] = true;
        int result = 1;
        result += dfs(grid, i + 1, j, visited);
        result += dfs(grid, i - 1, j, visited);
        result += dfs(grid, i, j + 1, visited);
        result += dfs(grid, i, j - 1, visited);
        return result;
    }
}