package pa1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//This is my class for expressions with the "simplify" keyword. 
	//It has 4 "mode"s, which are methods of this class to complete simple arithmetic operations.
	
	//To evaluate the numbers themselves, I have chosen to use a Queue of integers. 
	//The operators ( + - * / )will be stored in a stack, being placed within the Stack from left to right.
	
	

public class MathOperations {
    
	private Stack<String> operandStack = new Stack<>();
    private Queue<Integer> numberQueue = new LinkedList<>();

    
    public void processLine(String line) {
    
    	String[] tokens = line.replaceAll("[()]", "").split(" ");
        
    	for (String token : tokens) {
        
    		if (token.matches("[+\\-*/]")) {
                operandStack.push(token);
            
    		} else if (token.matches("\\d+")) {
                numberQueue.add(Integer.parseInt(token));
            
    		}
        
    	}
    }

 // The following are methods for evaluating addition, subtraction, multiplication and division.
    
    public void performOperations() {
   
    	while (!operandStack.isEmpty()) {
        
    		String operand = operandStack.pop();
            
    		int num1 = numberQueue.poll();
            int num2 = numberQueue.poll();
            int result = 0;

            switch (operand) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    result = num1 / num2;
                    break;
            }
            numberQueue.add(result);
        }
    }

    public int getResult() {
        return numberQueue.poll();
    }

   /* public static void main(String[] args) {
       
    	MathOperations mathOps = new MathOperations();
        
    	mathOps.processLine("(simplify (+ 345 789))");
        mathOps.processLine("(simplify (- 1000 43))");
        mathOps.processLine("(simplify (* 634 5))");
        mathOps.processLine("(simplify (+ (* 2 5) (- (+ 23 (- 4 50)) 4)))");

        mathOps.performOperations();
        System.out.println("Result: " + mathOps.getResult());
    } */
    
    // The commented section above was designed to test my algorithm in the first phase. 
    //See the tester class for a better, actual fuzzer.
}
