import java.util.Scanner;
class heap {
 static void display(int arr[],int n) {
for (int i = 0; i <n; i++)
System.out.print(arr[i] + " ");
System.out.println();
}
static void heapSort(int arr[], int n) {
for (int i = n - 1; i > 0; i--) {
System.out.println("Removed element: "+arr[0]);
System.out.print(arr[0] + " ");
int temp = arr[0];
arr[0] = arr[i];
arr[i] = temp;
display(arr, i);
heapify(arr, i, 0);
System.out.print("Reheap: ");
display(arr,i);
System.out.println("\n");
}
}
static void heapify(int arr[], int n, int i) {
int max = i;
int left = 2 * i + 1;
int right = 2 * i + 2;
if (left < n && arr[left] > arr[max])
max = left;
if (right < n && arr[right] > arr[max])
max = right;
if (max != i) {
System.out.print("Shift Up " +arr[max]+": ");
int swap = arr[i];
arr[i] = arr[max];
arr[max] = swap;
display(arr,n);
heapify(arr, n, max);
}
}
public static void main(String args[]) {
Scanner sc = new Scanner(System.in);
System.out.print("Enter n: ");
int n = sc.nextInt();
int arr[] = new int[n];
for(int i = 0;i<n;i++) {
arr[i] = sc.nextInt();
}

System.out.println();
int heap[] = new int[n];
for(int i = 0; i < n;i++) {
System.out.println("Element: "+arr[i]);
heap[i] = arr[i];
System.out.println();
System.out.println("Heapify: ");
for (int j = (i+1)/ 2 - 1; j >= 0; j--)
heapify(heap, (i+1), j);
System.out.println();
System.out.print("Final Tree: ");
System.out.println();
display(heap,(i+1));
}
System.out.print("Heap: ");
display(heap,n);
System.out.println();
heapSort(heap, n);
System.out.print("Sorted array is: ");
display(heap,n);
}
}
