package hackerrank;

import java.util.stream.IntStream;

public class SumOfTwoList {

    private Node sum(Node first, Node second, int carry){
        if(first == null && second == null && carry == 0){
            return null;
        }
        int value = carry;
        if(first != null){
            value += first.value;
        }
        if(second != null){
            value += second.value;
        }
        Node result = new Node(value%10);
        result.next = sum((first!= null)?first.next: null,(second != null) ? second.next:null,value/10 );
        return result;
    }

    private Node sumV2(Node first, Node second){
        if(first == null && second == null){
            return null;
        }
        Node current = new Node(0);
        Node next = null;
        int carry = 0;
        if(first.next != null && second.next !=null){
            next= sumV2(first.next,second.next);
        }else if(first.next != null){
            next = sumV2(first.next,second);
        } else if(second.next != null){
            next = sumV2(first,second.next);
        }
        if(next != null) {
            carry = next.value / 10;
            next.value = next.value % 10;
        }
        current.value = carry + ((first != null) ? first.value : 0) + ((second != null) ? second.value : 0);
        current.next = next;
        return current;
    }
    private Node sumFromHead(Node first, Node second){
        Node next = sumV2(first,second);
        Node result = null;
        if(next != null) {
            int carry = next.value / 10;
            next.value = next.value % 10;
            if(carry == 1){
                result = new Node(1);
                result.next = next;
                next = result;
            }else{
                result = next;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = IntStream.of(1,1).toArray();//IntStream.of(7,1,6,5,6).toArray();
        int[] b = IntStream.of(5,6).toArray();//IntStream.of(5,9,2).toArray();
        Node first = List(a);
        Node second = List(b);
        Node result = new SumOfTwoList().sum(first,second,0);
        for(Node n = result; n != null;n = n.next){
            System.out.print(n.value + " -> ");
        }
    }
    private static Node List(int... arr){
        Node head = new Node(arr[0]);
        Node current = head;
        for(int i = 1; i < arr.length;i++){
            Node next = new Node(arr[i]);
            current.next = next;
            current = next;
        }
        return head;
    }
    private static Node evenList(){
        Node node = new Node(2);
        Node head = node;
        for(int i = 4; i <= 20 ; i+=2){
            Node next = new Node(i);
            node.next = next;
            node = next;
        }
        return head;
    }
}
