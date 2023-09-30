package hackerrank;

public class Node {
    int value;
    Node next;
    Node(int val) {
        this.value = val;
    }

    @Override
    public String toString(){
        return ""+value;
    }
}
