import java.util.List;

public class Test {
    public static void main(String[] args) {
        Node root1=new Node(1);
        Node root2=new Node(2);
        Node root3=new Node(3);
        Node root4=new Node(4);
        Node root5=new Node(5);
        root1.left=root2;root1.right=root3;
        root2.left=root4;root3.right=root5;
        Next_116 next_116=new Next_116();
        Node connect = next_116.connect(root1);
        System.out.println(" ");

    }

}
