package collection.list.stack;

import java.util.Stack;

/**
 * Stack extends vector and has its own method push, pop and peek
 */
public class StackPractice {

    public static void main(String[] args) {

        Stack<String> fruitsStack = new Stack<>();

        fruitsStack.push("Mango");
        fruitsStack.push("Strawberry");
        fruitsStack.push("Apple");
        fruitsStack.push("Orange");

        System.out.println("Stack Peek :: >"+fruitsStack.peek());
        System.out.println("Stack :: >"+fruitsStack);

        System.out.println("Stack pop :: >"+fruitsStack.pop());
        System.out.println("Stack :: >"+fruitsStack);

        System.out.println("Stack size :: >"+fruitsStack.size());
        System.out.println("Stack Search :: >"+fruitsStack.search("Orange")); //return -1 , since its not present
        System.out.println("Stack Search :: >"+fruitsStack.search("Apple")); //return 1 , since its topmost
        System.out.println("Stack Search :: >"+fruitsStack.search("Mango")); //return 3 , since its topmost

    }
}
