// Given an 2D character array, Letters[][], of size r*c.
// You have to construct the word W, using the given array.

// Rules to construct the word are as follows:
// 	- All the letters of the word W, should be adjacent to each other 
// 	in the array Letters(either horizontal or vertical).
// 	- You can use each charcater in Letters[][] only once.

// If you are able to construct the word W, return 'true'
// Otherwise 'false'.

// Input Format:
// -------------
// Line-1 -> two integers R and C, array size.
// R lines -> C space separated characters.
// Last line -> a string, word W

// Output Format:
// --------------
// print the boolean result.


// Sample Input-1:
// ---------------
// 3 3
// a b c
// d e f
// g h i
// bad

// Sample Output-1:
// ----------------
// true


// Sample Input-2:
// ---------------
// 3 3
// a b c
// d e f
// g h i
// ace

// Sample Output-2:
// ----------------
// false


// Sample Input-3:
// ---------------
// 3 3
// a b c
// d e f
// g h i
// add

// Sample Output-3:
// ----------------
// false

import java.util.*;

public class checkWordConstruct{
    public static boolean dfs(char[][] arr, String s, int i, int j, boolean[][] visited, int index,int r, int c){
        if(index == s.length()){
            return true;
        }
        if(i<0 || i>=r || j<0 || j>=c || visited[i][j] || arr[i][j]!=s.charAt(index)){
            return false;
        }
        visited[i][j] = true;
        boolean found = dfs(arr,s,i+1,j,visited,index+1,r,c) || dfs(arr,s,i-1,j,visited,index+1,r,c) || dfs(arr,s,i,j+1,visited,index+1,r,c) || dfs(arr,s,i,j-1,visited,index+1,r,c);
        visited[i][j] = false;
        return found;
    }
    public static boolean constructWord(char[][] arr, int r, int c, String s){
        for(int i = 0;i<r;i++){
            for(int j = 0;j<c;j++){
                if(arr[i][j] == s.charAt(0)){
                    boolean[][] visited = new boolean[r][c];
                    if(dfs(arr,s,i,j,visited,0,r,c)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        sc.nextLine();
        char[][] arr = new char[r][c];
        for(int i = 0;i<r;i++){
            String[] row = sc.nextLine().split(" ");
            for(int j = 0;j<c;j++){
                arr[i][j] = row[j].charAt(0);
            }
        }
        String s = sc.nextLine();
        System.out.println(constructWord(arr,r,c,s));
        sc.close();
    }
}