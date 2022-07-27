import java.util.Scanner;

// Momen Mustafa A. Myasar 17-00273
// Mousa Ghassan 19-00337

public class assignment1 {
    public static int arr [] = new int[100];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        append(-1111);
        append(1231);
        append(1411);
        append(-1343);
        append(-1232);
        append(55555);
        append(55554);

        System.out.println("Type the number to append it:");
        int app = sc.nextInt();
        append(app);

        for (int  arr : arr) {
            System.out.print(arr+" ");   
        }

        System.out.println();
        System.out.println("Sample data is added to the previous data");
        addData();

        System.out.println("Type the index to get it's value (from 1-100):");
        
        int num = sc.nextInt();
        
        System.out.println(get(num));
        
        System.out.println("Type the number to be deleted:");
        int del =sc.nextInt();
        deleteBeginning(del);

        for (int  arr : arr) {
            System.out.print(arr+" ");   
        }
    
        System.out.println();

        DoublyLinkedList();
        System.out.printf("The smallest number is: %d",smallestNumber());

        secondLargestNum();
    }
    
// Req. 1) Create a class in Java to manage an array storing a set of integer numbers (negative and positive). 
// The class must offer three functions: append(int value), deleteBeginning(int value) and get(int index). The array size should be set to at least 100 elements.

    public static void append(int value) {
       for (int i = 0; i < arr.length; i++) {
           if (arr[i] == 0) {
               arr[i] =value;
               break;
           }
       } 
    }

    public static void deleteBeginning(int value){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == value){
                delete(i);
                break;
            }
             
        }
    }
    public static void delete(int delete){
        for (int i = delete; i < arr.length-1; i++) {
            arr[i] = arr[i+1];
        }
        arr[arr.length-1] =0;
    }

    public static int get(int index){
        return arr[index-1];
    }


    
// 2) Use the class created in Step 1 to insert a sample data.
//Your data can contain any numbers, preferably a mix of positive numbers and negative ones.

    public static void addData(){
        for (int i = 0, x=-49; i < arr.length; i++,x+=2) {
            if(arr[i] == 0)
            arr[i] = x;
        }
    }

// Req.3) Convert the array created into Doubly Linked List. Then, create the time complexity model and write the Big Oh for this operation.

    public static Node head= null;
    public static Node tail = null;



    public static void DoublyLinkedList(){ 
        for (int i = 0; i < arr.length; i++) { // 1+ 3n+3+ 3n
           
            Node a = new Node();       //n
            if (head == null) {        // 2n
                head = a;              // 2n
                tail = a;              // 2n
                a.value = arr[i];      // 2n
            } else {                            
            tail.next = a;             // 2n
            a.previous = tail;         // 2n
            tail = a;                  // 2n
            a.value = arr[i];          // 2n
            }
        }
    }
    // 1+ 3n+3+ 3n + n+ 8n -> Time Complexity = 4 + 15n
    //Big O(n)

// Req.4) Go through the doubly linked list created in Step 3 and find the smallest number. 
// Again, create the time complexity model and write the Big Oh for this operation.

    public static int smallestNumber(){
        
        Node small = head;                   //2
        int smallest = small.value;          //2 
        while (small != null) {              //n
            if (small.value < smallest) {    //3n
                smallest = small.value;      //2n
            }
            small = small.next;             //2n
        }
    return smallest;                        //1
    }
    // 2+2+n+3n+2n+2n +1-> Time Complexity = 5+7n
    //Big O(n)

// 5) Go through the doubly linked list and delete the second largest number. 
// Similar to the previous two steps, create the time complexity model and write the Big Oh for this operation.

    public static void secondLargestNum(){
        Node large =head;                      //1
        int largest =large.value;              //2
        int secondLargest =large.value;        //2
        int index=0;                           //1
        int counter=0;                         //1

        while (large != null) {                //2n
            if (large.value>secondLargest) {   //3n
                if (large.value>largest) {     //3n
                    largest = large.value;     //2n
                }
                else{
                secondLargest = large.value;   //2n
                index = counter;               //2n
                }
            }
            counter++;                         //3n
            large = large.next;                //2n
        }
        //7 +2n+3n +3n+2n +3n+2n -> Time Complexity = 7+15n


        Node delete = head;                       //2
        for (int i = 0; i < arr.length-1; i++) {  //1+ 3+3n + 3n
            
            if (index == i) {                     //3n
                Node a = delete.previous;         //2n
                Node b = delete.next;             //2n
                a.next = b;                       //2n
                b.previous = a;                   //2n
            }
            delete = delete.next;                //2n
        }
        // 2+ 4+6n + 13n -> Time Complexity = 6+ 19n
        
        // Total Time Complexity = 7+15n + 6+ 19n --> 13 + 34n
        // Big O(n)
    }
}



class Node{
    int value;
    Node next;
    Node previous;
}