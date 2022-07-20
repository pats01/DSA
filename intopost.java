import java.util.Scanner;
import java.io.*;

class Stack{
    int arr[];
    int size;
    int top;

    Stack(int size) {
        arr = new int[size];
        top = -1;
    }

    public boolean isFull() {
        if(top == size - 1) {
            return true;
        }
        else {
            return false;
        }
    }

    public void push(int element) {
        if(isFull()) {
            System.out.println("Cannot insert as Stack is already full");
        }
        else {
            arr[++top] = element;
            System.out.println("Pushed" + element + "into the Stack");
        }
    }

    public boolean isEmpty() {
        if(top == -1) {
            return true;
        }
        else {
            return false;
        }
    }

    public int peek() {
        if(isEmpty()) {
            System.out.println("Cannot pop as Stack is empty");
            return 0;
        }
        else {
            return arr[top];
        }
    }

    public int pop() {
        if(isEmpty()) {
            System.out.println("Cannot pop as Stack is empty");
            return 0;
        }
        else {
            int popped = arr[top--];
            return popped;
        }
    }
}


public class intopost{
    static int priority(char exp) {
        switch(exp) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default :
                return -1;
        }
    }

    public static String infixToPostfix(String exp) {
        String post = new String("");
        int len = exp.length();
        Stack operator = new Stack(len);

        for(int i = 0; i < exp.length(); i++) {
            char type = exp.charAt(i);

            if(isLetterOrDigit(type)) {
                operator.push(type);
            }

            else if(type == '(') {
                operator.push(type);
            }

            else if(priority(operator.peek()) < priority(type) || operator.isEmpty() || operator.peek() == '(') {
                operator.push(type);
            }

            else if(operator.top == type) {
                post += operator.pop();
            }

            else if(type == ')') {
                while(operator.peek() != '(') {
                    post += operator.pop();
                }
            }

            else {
                while((priority(type) <= operator.peek()))
                    post += operator.pop();
            }
        }

        return post;
    }
    public static void main(String[] args) {
        String expression = "a+(b*c)/d";
        System.out.println(infixToPostfix(expression));
    }
}

