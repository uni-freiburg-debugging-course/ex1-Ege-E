package pa1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Fuzzer {
	
	
	
	public String[] ops = {"+","-","*","/"};
	
	Random rand = new Random();
	

	
	
	public void generator(){
		
		for ( int i = 0; i < 1000 ; i++) {
			
			String[] simps = new String[1000];
			
			String s = "Simplify ( ";
			String op = ops[rand.nextInt(0, 4)];
			
			s = s.concat(op);
			s = s.concat(" " + rand.nextInt() + " " + rand.nextInt());
			
			s = simps[i];
			
		}
		
		
	}
	
	
	
	
//(simplify (+ 345 789))
}
