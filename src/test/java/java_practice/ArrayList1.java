package java_practice;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.Test;

public class ArrayList1 {

	@Test
	public void collection1() {
	
		// 3 ways of declaring arraylist
	ArrayList al1=new ArrayList();                       // to store homo hetero data
	
	ArrayList <Integer> al2= new ArrayList<Integer>();   // to store only int numeric data
	ArrayList<String> al3= new ArrayList<String>();      // to store only string data
	
	al1.add(100);
	al1.add("rahul");
	al1.add("hello");
	al1.add(5.11);
	al1.add('A');
	al1.add(true);
	
	System.out.println(al1);
	System.out.println(al1.size());   // total element
	System.out.println(al1.remove(2));  // remove element
	System.out.println("after removing element : "+al1);
	al1.add(2, "Gm");                    // inserting element at specific index
	System.out.println("after insertng new ele at index : "+ al1);
	
	al1.set(2, "gd ev");
	System.out.println("after replacing value : "+ al1);
	
	System.out.println("valuer at index: "+al1.get(3));  // retrieve value at specific index
	
	System.out.println("verify list contains akash : "+ al1.contains("akash"));   //verify data present
	System.out.println("verify contains rahul : "+ al1.contains("rahul"));    //case sensitive
	System.out.println("verify list is empty :"+ al1.isEmpty());
	
	// read data from arraylist
	// for loop
	System.out.println("reading element by using for loop");
	for(int i=0; i<=al1.size()-1; i++) {
		
		System.out.print(" "+al1.get(i));
	}
	
	// for each loop
	System.out.println("reading element by for each loop");
	for(Object dt:al1) {
		
		System.out.print(" "+dt);
		
	}
	
	// iterator method
	
	System.out.println("reading element by using iterator method");
	
	Iterator itr=al1.iterator();
	
	while(itr.hasNext()) {
		
		System.out.print(" "+itr.next());
	}
	
	
	
}
}