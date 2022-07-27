// Momen Mustafa A. Myasar 17-00273
// Mousa Ghassan 19-00337
import java.util.Scanner;

public class Assignment2 {

    public static void main(String[] args) {
       
        Scanner sc = new Scanner(System.in);
        String scan;
        DoublyLinkedList list = new DoublyLinkedList();
        
        do{
            System.out.println("write a word, else write 'no': ");
            scan = sc.nextLine();
            if (!scan.equals("no")) {
                list.append(scan);
            }
        }while (!scan.equals("no"));
        
        System.out.println();
        
        System.err.println("List before sorting:");
        list.print();

        System.out.println();
        System.out.println();
        
        System.err.println("Doubly Linked List after sorting:");
        list.sort();
        list.print();
    }
}
class DoublyLinkedList{
    Node head;
    Node tail;

    public void append(String value){
        Node node = new Node();
        if (head == null) {
            head = node;
            tail = node;
            node.value = value;
        } else {
          tail.next = node;
          node.previous = tail;
          tail = node; 
          node.value = value; 
        }

    } 
    public void print(){
        Node current = head;
        while (current != null) {
            System.out.print(current.value+" ");
            current = current.next;
        }
    } 
    public void sort(){

        Node current = head;
        int counter =0;
        while (current!= null) {
            counter++;
            current = current.next;
        }
        MergeSort merge = new MergeSort(head, counter);
        merge.makeSorting();
        head = merge.returnSorted();
    } 
}

class MergeSort{
    private Node head;
    String [] word;

    MergeSort(Node head, int counter){
        this.head = head;
        word = new String[counter];
    }

    public void makeSorting(){
        Node current = head;
        int num=0;
        while (current!= null) {
            word[num] = current.value;
            num++;
            current = current.next;
        }
        mergeSort(word);
    }

    public Node returnSorted(){
        DoublyLinkedList list = new DoublyLinkedList();
        for (int i = 0; i < word.length; i++) {
            list.append(word[i]);
        }
        return list.head;
    }

    public static void mergeSort(String[] main) {
        if (main.length >= 2) {
            String[] left = new String[main.length / 2];
            String[] right = new String[main.length-main.length / 2];

            for (int i = 0; i < left.length; i++)
            {
                left[i] = main[i];
            }
            for (int i = 0; i < right.length; i++)
            {
                right[i] = main[i + main.length / 2];
            }

            mergeSort(left);
            mergeSort(right);

            merge(main, left, right);
        }
    }

    public static void merge(String[] main, String[] left, String[] right) {
        int countLeft = 0;
        int countRight = 0;
        for (int i = 0; i < main.length; i++) {
            if (countRight >= right.length || (countLeft < left.length && left[countLeft].toUpperCase().charAt(0)<right[countRight].toUpperCase().charAt(0))) {
                main[i] = left[countLeft];     
                countLeft++;
            } else {
                main[i] = right[countRight];
                countRight++;
            }
        }
    }

}

class Node{
    String value;
    Node next;
    Node previous;
}
