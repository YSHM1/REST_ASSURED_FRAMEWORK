package knowledege;

import java.util.HashSet;

public class EmployeesComparison {

	public static void main(String[] args) {
		Employees employees1 = new Employees(1, "yash");
		Employees employees2 = new Employees(1, "yash");
		
		System.out.println(employees1==employees2); //false
		
		//without overriding equals() method
		System.out.println(employees1.equals(employees2)); //false
		
		//after overriding equals() method
		System.out.println(employees1.equals(employees2)); //true
		
		//HashSet without calling hashCode() method
		HashSet hashSet = new HashSet<>();
		hashSet.add(employees1);
		hashSet.add(employees2);
		/*
		 * Even though employees1 and employees2 have same values HashSet is accepting both objects 
		 * values because HashSet is considering both employees1 and employees2 as 2 different Objects
		 */
		System.out.println(hashSet); 
		
		
		/*
		 * If 2 objects are equal according to equals(Object) method, then calling hashCode() method
		 * on wach of the 2 objects must provide the same integer result 
		 */
		
		//HashSet after calling hashCode() method
		HashSet hashSet1 = new HashSet<>();
		hashSet1.add(employees1);
		hashSet1.add(employees2);
		System.out.println(hashSet1);
	}
	
}
