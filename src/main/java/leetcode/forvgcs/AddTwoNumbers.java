package leetcode.forvgcs;

import java.util.stream.IntStream;

public class AddTwoNumbers {

    static class Node{
        int v= 0;
        Node next = null;
        public Node(int v){
            this.v = v;

        }
        @Override
        public String toString() {
            return String.valueOf(v);
        }
    }

    private Node prepareList(int[] values){
        Node head = null, current = null, next = null;
        if(values == null || values.length == 0){
            return null;
        }
        head = new Node(values[0]);
        current = head;
        for(int i = 1;i < values.length; i ++){
            Node prev = current;
            current = new Node(values[i]);
            prev.next = current;
        }
        return head;
    }
    private Node sum(Node first, Node second, int carry){
        if(first == null && second ==null && carry == 0){
            return null;
        }
        int temp = carry;
        if(first != null){
            temp += first.v;
        }
        if(second != null){
            temp += second.v;
        }
        Node current = new Node(temp%10);
        Node result = sum((first != null)?first.next:null,(second!=null)?second.next:null,temp/10);
        current.next =result;
        return current;
    }
    private void printNodes(Node node){
        for(Node current = node; current != null;current = current.next ){
            System.out.print(current + " -> ");
        }
    }
    public static void main(String[] args) {
        AddTwoNumbers addTwoNumberUsingList = new AddTwoNumbers();
        Node first = addTwoNumberUsingList.prepareList(IntStream.of(9,8,7).toArray());
        Node second = addTwoNumberUsingList.prepareList(IntStream.of(5,4,9).toArray());
        addTwoNumberUsingList.printNodes(first);
        System.out.println();
        addTwoNumberUsingList.printNodes(second);
        Node result = addTwoNumberUsingList.sum(first,second,0);
        System.out.println();
        System.out.println();
        System.out.println("Sum of the result = ");
        addTwoNumberUsingList.printNodes(result);
    }
}
