package hackerrank;

public class MergeTwoLists {

    private Node merge(Node first, Node second) {
        if (first == null) {
            return second;
        } else if (second == null) {
            return first;
        }
        Node temp = (first.value > second.value) ?second:first;
        temp.next = (first.value > second.value) ? merge(first, second.next) : merge(first.next, second);
        return temp;
    }
    public static void main(String[] args) {
        Node odd = oddList();
        Node even = evenList();
        for(Node n = odd; n != null;n = n.next){
            System.out.print(n.value + " -> ");
        }
        System.out.println();
        for(Node n = even; n != null;n = n.next){
            System.out.print(n.value + " -> ");
        }
        System.out.println();
        MergeTwoLists m = new MergeTwoLists();
        Node mergedNodes = m.merge(odd,even);
        for(Node n = mergedNodes; n != null;n = n.next){
            System.out.print(n.value + " -> ");
        }
    }
    private static Node oddList(){
        Node node = new Node(1);
        Node head = node;
        for(int i = 3; i < 20 ; i+=2){
            Node next = new Node(i);
            node.next = next;
            node = next;
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
