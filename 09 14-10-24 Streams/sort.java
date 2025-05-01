/*
You are tasked with building a Student Score Management System that sorts 
students based on their scores. Each student has multiple test scores: 
a coding test score, MCQ test score, and a total score.

The students should be sorted according to the following rules:
	- Primary Sorting: By total score in descending order.
	- Secondary Sorting: If two students have the same total score, 
	  sort them by coding test score in descending order.
	- Tertiary Sorting: If the coding test scores are also the same, 
	  sort them by MCQ test score in descending order.
	
You must use Java Streams to perform the sorting operation.

Sample Input:
-------------
3               //no of students
Alice,80,70 
Bob,85,60
Charlie,90,60

Sample Output:
--------------
Charlie: 90, 60, 150
Alice: 80, 70, 150
Bob: 85, 60, 145

*/

import java.util.*;
import java.util.stream.*;
class PersonClass{
    private int coding;
    private int mcq;
    private String name;
    PersonClass(String name, int coding, int mcq){
        this.name = name;
        this.coding = coding;
        this.mcq = mcq;
    }
    public String getName(){
        return name;
    }
    public int getCoding(){
        return coding;
    }
    public int getMcq(){
        return mcq;
    }
    public int getTotalScore(){
        return coding+mcq;
    }
    public String toString(){
        return getName() + ": " + getCoding() + ", " + getMcq() + ", " + getTotalScore();
    }
}
public class sort{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        List<PersonClass> persons = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            String[] parts = input.split(",");
            String name = parts[0];
            int coding = Integer.parseInt(parts[1]);
            int mcq = Integer.parseInt(parts[2].trim());
            persons.add(new PersonClass(name, coding,mcq));
        }

        List<PersonClass> res = persons.stream()
            .sorted(Comparator.comparingInt(PersonClass::getTotalScore).reversed()
            .thenComparing(Comparator.comparingInt(PersonClass::getCoding).reversed())
            .thenComparing(Comparator.comparingInt(PersonClass::getMcq).reversed()))
            .collect(Collectors.toList());
        
        for(PersonClass p : res){
            System.out.println(p);
        }
        sc.close();
	}
}