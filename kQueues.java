import java.util.Scanner;

public class kQueues {
    int q[];
    static int k;
    static int size;
    int rear[];

    kQueues(int size, int k){
        q = new int[size * k];
        rear = new int[k];
        for(int i = 0; i < k; i++){
            rear[i] = (i * size) - 1;
        }
    }

    public void enqueue(int x, int qn) throws Exception{
        if(isFull(qn)){
            throw new Exception("Queue no" +qn + " is full, cannot enqueue");
        }

        System.out.println("Inserting " +x +" into queue no " +qn);
        q[++rear[qn]] = x;
    }

    public void dequeue(int qn) throws Exception{
        if(isEmpty(qn)){
            throw new Exception("Queue no " +qn +" is empty");
        }
        int front = q[qn * size];
        System.out.println("Removing " +front + " from the queue");

        q[front] = 0;
        for(int i = ((qn * size) + 1); i <= rear[qn]; i++){
            q[i - 1] = q[i];
        }
        rear[qn] = rear[qn] - 1;
    }

    public boolean isFull(int qn){
        if(rear[qn] == (size * (qn + 1)) - 1){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isEmpty(int qn){
        if(rear[qn] == (size * qn) - 1){
            return true;
        }
        else{
            return false;
        }
    }

    public void displayq(int qn) throws Exception{
        if(isEmpty(qn)){
            throw new Exception("Queue no " +qn +" is empty");
        }
        else{
            for(int i = qn * size; i <= rear[qn]; i++){
                System.out.print(q[i] + "\t");
            }
            System.out.println();
        }
    } 

    public void displayAll() throws Exception{
        for(int i = 0; i < k; i++){
            if(isEmpty(i) == false){
                displayq(i);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the no of queues: ");
        k = sc.nextInt();
        System.out.print("Enter size of each queue: ");
        size = sc.nextInt();
        kQueues kq = new kQueues(size, k);

        System.out.println("---Select Choice---");
        while(true){
            System.out.println("1.Enqueue 2.Dequeue 3.displayq 4.displayAll 5.Exit : ");
            int choice = sc.nextInt();
            switch(choice){
                case 1 :
                    System.out.print("Enter Queue no: ");
                    int qn = sc.nextInt();
                    System.out.print("Enter the element: ");
                    int x = sc.nextInt();
                    kq.enqueue(x, qn);
                    break;
                case 2 :
                    System.out.println("Enter Queue no: ");
                    int qnde = sc.nextInt();
                    kq.dequeue(qnde);
                    break;
                case 3 :
                    System.out.println("Enter Queue no: ");
                    int qndi = sc.nextInt();
                    System.out.print("Queue no " +qndi +" is: ");
                    kq.displayq(qndi);
                    break;
                case 4 :
                    System.out.println("The queues are : ");
                    kq.displayAll();
                    break;
                case 5 :
                    System.exit(1);
                    break;
                default :
                    System.out.println("Please enter a valid choice");
            }
        }
    }
}
