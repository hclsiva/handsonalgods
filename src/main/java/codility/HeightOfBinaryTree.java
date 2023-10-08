package codility;


class Tree{
    public int x;
    public Tree l;
    public Tree r;

    public String toString(){
        return String.valueOf(x);
    }
}
public class HeightOfBinaryTree {
    public int solution(Tree T) {
        // Implement your solution here
        return height(T);

    }
    private int height(Tree tree){
        if(tree == null){
            return 0;
        }
        return Math.max(height(tree.l),height(tree.r))+1;
    }

}
