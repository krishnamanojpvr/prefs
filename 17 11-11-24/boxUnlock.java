// Mahalakshmi is participating in a treasure hunt that includes N boxes, each 
// numbered sequentially from 0 to N-1. Initially, all the boxes are locked with 
// unique passcodes, except for Box-0, which is unlocked.

// Each box in the treasure hunt contains a list of envelopes, with each envelope 
// holding the passcode to unlock a different box. The envelope is labeled with 
// the box number it can unlock.

// Mahalakshmi can open the boxes in any order, but she must start with Box-0.

// The goal of the treasure hunt is to unlock all the boxes. Your task is to 
// determine if Mahalakshmi can open every box and win the game.

// If she can unlock all the boxes, print "Win". Otherwise, print "Lost".

// Input Format:
// -------------
// Line-1: An integer, number of boxes.
// Next N lines: space separated integers, box numbers.

// Output Format:
// --------------
// Print a string value, Win or Lost


// Sample Input-1:
// ---------------
// 5
// 1
// 2
// 3
// 4
// 3

// Sample Output-1:
// ----------------
// Win

// Sample Input-2:
// ---------------
// 4
// 1 3
// 3 0 1
// 2
// 0

// Sample Output-2:
// ----------------
// Lost

import java.util.*;

public class boxUnlock {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[][] arr = new String[n][];
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextLine().split(" ");
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;
        while(!queue.isEmpty()){
            int box = queue.poll();
            for(String s : arr[box]){
                int b = Integer.parseInt(s);
                if(!visited[b]){
                    queue.add(b);
                    visited[b] = true;
                }
            }
        }
        for(boolean i : visited){
            if(!i){
                System.out.println("Lost");
                sc.close();
                return;
            }
        }
        System.out.println("Win");
        sc.close();
    }
}
