/*
You are required to build an Employee Management System that processes a list 
of Employee objects to group them by their department and calculate the average 
salary for each department. Each Employee object has the following attributes:
    - Name: (String) The name of the employee
    - Department: (String) The department in which the employee works
    - Salary: (double) The salary of the employee
    
Your task is to group employees by their department and find the average salary 
for each department using Java Streams.

Sample Input:
-------------
4                   //no of employees
Alice,IT,60000     
Bob,HR,50000
Charlie,IT,70000
David,HR,55000

Sample Output:
-------------
HR : 52500.00
IT : 65000.00

*/

/*
You are required to build an Employee Management System that processes a list 
of Employee objects to group them by their department and calculate the average 
salary for each department. Each Employee object has the following attributes:
    - Name: (String) The name of the employee
    - Department: (String) The department in which the employee works
    - Salary: (double) The salary of the employee
    
Your task is to group employees by their department and find the average salary 
for each department using Java Streams.

Sample Input:
-------------
4                   //no of employees
Alice,IT,60000      //name, department,salary
Bob,HR,50000
Charlie,IT,70000
David,HR,55000

Sample Output:
-------------
HR : 52500.00
IT : 65000.00

*/
import java.util.*;
import java.util.stream.*;


class Person{
    private double salary;
    private String job;
    private String name;
    Person(String name, double salary, String job){
        this.name = name;
        this.salary = salary;
        this.job = job;
    }
    public String getName(){
        return name;
    }
    public double getSalary(){
        return salary;
    }
    public String getJob(){
        return job;
    }
}

public class groupByAverage{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            String[] parts = input.split(",");
            String name = parts[0];
            String job = parts[1];
            double salary = Double.parseDouble(parts[2]);
            persons.add(new Person(name, salary, job));
        }

        Map<String, Double> avgSalaries = persons.stream()
            .collect(Collectors.groupingBy(Person::getJob, 
                Collectors.averagingDouble(Person::getSalary)));
        
        for(Map.Entry<String,Double> entry : avgSalaries.entrySet()){
            System.out.printf("%s : %.2f\n",entry.getKey(), entry.getValue());
        }
        sc.close();
    }
}