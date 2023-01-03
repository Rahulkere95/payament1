package java_practice;

import java.util.ArrayList;
import java.util.Arrays;

import org.testng.annotations.Test;

public class ArrayList_3 {

	@Test
	public void array_to_arraylist() {
		
		String arry[]= {"rahul", "shivaji", "padma", "kere"};
		
		System.out.println("Arrays value : "+ arry);
		for(Object e :arry) {
			
			System.out.print(e);
		}
		System.out.println();
		// convert array into arraylist
		
		ArrayList al=new ArrayList(Arrays.asList(arry));
		System.out.println("after converting array into arrayList : ");
		//System.out.println(al);
		
		for(Object dt:al) {
			
			System.out.print(dt);
		}
		
	}
}
