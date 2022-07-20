
public class DoublyLinkedList {
    Node head;
    Node tail;
    int size;

    DoublyLinkedList() {
        this.size = 0;
    }

    class Node {
        Node next;
        Node prev;
        int value;

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
        newNode.prev = null;
        if(head != null) {
            head.prev = newNode;
        }
        head = newNode;
        System.out.println("Inserted " +head.value);
        size++;
    }

    public void insertAtIndex(int value, int index) {
        Node newNode = new Node(value);
        Node temp = head;
        if(index == 0) {
            insertAtBeginning(value);
        }
        for(int i = 1; i < index; i++) {
            temp = temp.next;
        }

        newNode.next = temp.next;
        newNode.prev = temp;
        size++;
    }

    public void sort() {
        for(int i = 0; i < size; i++) {
            Node temp = head;
            Node temp2 = head.next;
            for(int j = 0; j < size; j++) {
                if(temp.value > temp2.value) {
                    int tempNode = temp.value;
                    temp.value = temp2.value;
                    temp2.value = tempNode;
                }
                temp = temp.next;
                temp2 = temp2.next;
            }
        }
    }

    public void reverse() {
        Node temp = null;
        Node current = head;

        while(current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }

        if(temp != null) {
            head = temp.prev;
        }
    }

    public void display() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.value + "<->");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        DoublyLinkedList DLL = new DoublyLinkedList();
        DLL.insertAtBeginning(10);
        DLL.insertAtBeginning(20);
        DLL.insertAtBeginning(30);
        DLL.insertAtBeginning(40);
        DLL.insertAtIndex(35, 3);
        DLL.display();
        //DLL.sort();
        DLL.reverse();
        DLL.display();
    }
}
