public class LinkedList {
    Node head;
    Node tail;
    int size;

    LinkedList() {
        this.size = 0;
    }

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public void insertAtBeginning(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        System.out.println("Inserted " +head.value);

        if(tail == null) {
            tail = newNode;
        }
        size++;
    }

    public void insertAtEnd(int value) {
        if(head == tail) {
            insertAtBeginning(value);
        }
        Node newNode = new Node(value);
        tail.next = newNode;
        tail = newNode;
        System.out.println(tail.value);
        if(head == null) {
            head = newNode;
        }
        size++;
    }

    public void insertAtIndex(int value, int index) {
        if(index == 0) {
            insertAtBeginning(value);
            size++;
        }
        if(index == size) {
            insertAtEnd(value);
        }

        Node temp = head;
        for(int i = 1; i < index; i++) {
            temp = temp.next;
        }
        
        Node newNode = new Node(value, temp.next);
        temp.next = newNode;
        System.out.println("Inserted " +temp.next.value);
        size++;
    }

    public void deleteFirst() {
        int value = head.value;
        head = head.next;

        if(head == tail) {
            tail = null;
        }
        size--;
        System.out.println("Deleted " +value);
    }

    public Node reverse() {
        if(head == null || head.next == null) {
            return null;
        }

        Node prev = head;
        Node current = head.next;

        while(current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head.next = null;
        head = prev;
        return prev;
    }

    /*public Node reverseFromIndex(Node node){
        Node prev = node;
        Node current = prev.next;

        while(current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head.next = null;
        head = prev;
        return prev;
    }*/

    public Node reverse(Node temp) { 
        Node current = temp; 
        Node prev = null, next = null; 
        while(current != null) { 
            next = current.next; 
            current.next = prev; 
            prev = current; 
            current = next; 
        }
        return prev; 
    }

    public void display() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.value + "->");
            temp = temp.next;
        }
        System.out.println("NULL");
        System.out.println("Size: "+size);
    }

    public void palindrome() {
        Node current = head;
        boolean flag = true;
        int mid;

        if(size % 2 == 0) {
            mid = size / 2;
        }
        else {
            mid = (size + 1) / 2;
        }
        
        for(int i = 1; i < mid; i++) {
            current = current.next;
        }

        Node rev = reverse(current.next);
        display();
        while(head != null && rev != null) {
            if(head.value != rev.value) {
                flag = false;
                break;
            }
            rev = rev.next;
            head = head.next;
        }

        if(flag == true) {
            System.out.println("Palindrome");
        }
        else {
            System.out.println("Not Palindrome");
        }
        
    }

    public static void main(String[] args) {
        LinkedList L = new LinkedList();
        L.insertAtBeginning(1);
        L.insertAtBeginning(2);
        L.insertAtBeginning(3);
        L.insertAtBeginning(2);
        L.insertAtBeginning(1);
        L.display();
        //L.reverseFromIndex(L.head);
        //L.deleteFirst();
        L.display();
        L.palindrome();
       // L.reverse();
        //L.display();
    }
}

