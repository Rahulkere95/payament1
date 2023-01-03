package java_practice;

import java.util.ArrayList;
import java.util.Collections;

import org.testng.annotations.Test;

public class ArrayList_2 {

	@Test
	public void arraylis_sort() {
		
		ArrayList al_org= new ArrayList();
		
		al_org.add('x');
		al_org.add('y');
		al_org.add('z');
		al_org.add('a');
		al_org.add('b');
		al_org.add('c');
		
		System.out.println(al_org);
		
		// adding elements from one collection to another collection
		
		ArrayList al_dup= new ArrayList();
		
		al_dup.addAll(al_org);
		
		System.out.println("adding colection to another "+al_dup);    // al orginal to duplicate
		
		al_dup.removeAll(al_org);
		System.out.println("after removing : "+ al_dup);
		
		// sorting using collections.sort();
		
		Collections.sort(al_org);
		System.out.println("after sorting original arraylist : "+ al_org);
		
		// reverse sorting
		
		Collections.sort(al_org,Collections.reverseOrder());
		System.out.println("after sort in REVERSE  original arraylist : "+ al_org);
		
		// shuffling
		
		Collections.shuffle(al_org);
		System.out.println("after sort in REVERSE  original arraylist : "+ al_org);
		
	}
	
	
}
