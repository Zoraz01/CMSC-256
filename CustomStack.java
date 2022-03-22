/* Zoraz Haseeb
 * 08/22/2021
 * CustomStack.java
 * Project 4
 * 1st Semester
 * CMSC 256-001
 * This program is a custom implementation of the stack data structure
 * */
package cmsc256;

import bridges.base.SLelement;
import bridges.connect.Bridges;
import bridges.validation.RateLimitException;

import java.io.IOException;

public class CustomStack<E> implements StackInterface<E> {
    //This element is the top of the stack
    private SLelement<E> topOfStack;
    //keeps track of the size of the stack
    private int sizeOfStack;

    public static void main(String[] args) throws RateLimitException, IOException {
        //making new stack object
        CustomStack stack = new CustomStack();
        //pushing values to stack object
        stack.push(256);
        stack.push(10);
        stack.push(18);
        stack.push(20);
        stack.push(2018);
        stack.display();
        stack.pop();
        stack.pop();
        stack.display();
        stack.peek();
        stack.display();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.display();
        //initializing bridges
        Bridges bridges = new Bridges(3,"haseebz","1092119066883");
        //Setting the title of bridges
        bridges.setTitle("CMSC 256 Project 4 Zoraz Haseeb");
        //Creating Slelement elements
        SLelement<Integer> int1 = new SLelement<Integer>(2018);
        SLelement<Integer> int2 = new SLelement<Integer>(20);
        SLelement<Integer> int3 = new SLelement<Integer>(18);
        SLelement<Integer> int4 = new SLelement<Integer>(10);
        SLelement<Integer> int5 = new SLelement<Integer>(256);

        //Linking SLelements
        int1.setNext(int2);
        int2.setNext(int3);
        int3.setNext(int4);
        int4.setNext(int5);

        //Setting the label of each element
        int1.setLabel(String.valueOf(int1.getValue()));
        int2.setLabel(String.valueOf(int2.getValue()));
        int3.setLabel(String.valueOf(int3.getValue()));
        int4.setLabel(String.valueOf(int4.getValue()));
        int5.setLabel(String.valueOf(int5.getValue()));
        //pointing towards the head of the list
        bridges.setDataStructure(int1);
        bridges.visualize();



        //checking if balanced method works
        String expression = "a {b [c (d + e)/2 - f] + 1}";

        boolean isBalancedExpression = stack.isBalanced(expression);

        if (isBalancedExpression)

            System.out.println(expression + " is balanced");

        else

            System.out.println(expression + " is not balanced");
    }


    @Override
    public void push(E newEntry) {
        //Creating a new element which is the parameter
        SLelement<E> temp = new SLelement<E>(newEntry);
        //Element is linked to the element that is currently top of the stack
        temp.setNext(topOfStack);
        //New element is set as the top of the stack
        topOfStack = temp;
        //size of the stack is increased by one
        sizeOfStack++;
    }

    @Override
    public E pop() {
        if(isEmpty()){

        }
        //Element that is about to be removed is saved
        SLelement<E> node = topOfStack;
        //The new top of the stack is the element that old top of stack pointed to
        topOfStack = topOfStack.getNext();
        //size of stack is decreased by one
        sizeOfStack--;
        //element that was popped is returned
        return node.getValue();
    }

    @Override
    public E peek() {
        //returns the value of the top stack
        return topOfStack.getValue();
    }

    @Override
    public boolean isEmpty() {
        //If the size of the stack is zero then it is empty
        return sizeOfStack ==0;
    }

    @Override
    public void clear() {
        //size of stack is set to zero
        sizeOfStack = 0;
        topOfStack = null;
    }

    public void display(){
        if(isEmpty()) {
            System.out.println("The stack is empty");
        }
        else {
            SLelement<E> current = topOfStack;

            StringBuffer output = new StringBuffer();

            output.append("Top of stack: " + current.getValue() + "\n");

            while(current.getNext() != null) {

                current = current.getNext();

                if(current.getNext() == null)
                    output.append("Stack bottom: ");
                else
                    output.append("              ");

                output.append(current.getValue() + "\n");
            }
            System.out.println(output.toString());
        }
    }
    public boolean isBalanced(String expression){
        boolean balanced = true;
        // New stack for characters is initialized
        CustomStack<Character> stack = new CustomStack<>();
        //loops through every character
        for(int i =0; i < expression.length();i++){
            char s = expression.charAt(i);
            //If the character is an open delimiter then it is pushed into the stack
            if(s== '{'|| s=='('|| s== '['){
                stack.push(s);
            }
            //If the character is a closed delimiter then previous entry into stack must be checked for pair
            else if(s=='}'||s==']'||s==')'){
                char deliminator = 0;
                //previous entry into stack is recorded
                try{
                    deliminator = stack.pop();
                } catch (NullPointerException e) {
                    balanced = false;
                }
                //checks if the delimiters are pairs. If they are not then it returns false
                 if(s=='}'){
                    if(deliminator != '{'){
                        balanced= false;
                    }
                 }
                else if(s==']'){
                    if(deliminator!='['){
                        balanced = false;
                    }
                }
                else{
                    if(deliminator!='('){
                        balanced = false;
                    }
                }
            }
            //If the stack is empty then it must be balanced
            if(stack.isEmpty()){
                balanced =true;
            }
            else{
                balanced = false;
            }
        }
        return balanced;
    }


}
