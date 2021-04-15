package implementation;
//suppose we hava a class name as mydata and it contains variable of integer type as we define inside a class
//and if we want to assign the varible as string we have to make a new class to overcome this we use the method
//of generic class at the time of declaration of the class we define any constant in angular bracket and to
//assign the type we define at the time of making object of that class within angular bracket so here we make
//Node class as generic (we make it by ourself here we work with int type) so
// <E extends Comparable<E>> so this means at the time of insertion of binary search tree we check after the
//first value is entered as root value second vlaue to be entered  is going to the left subtree or right
//sub tree so to check this we use the operation (<=) which is not accepted in generic class so we use
//compareTo method so our generic class extend the comparabe method at the time of declaration
public class Node {
    private int data;
    private Node left;
    private Node right;
    //to make constructor click left alt+insert
    public Node(int data) {
        this.data = data;
        //this might not be necessary to initialise the left and right as null as it is a instance variable
        //it automatically initialise to null
        left = null;
        right = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
//now our Node class is ready next we have to make our binary search tree Node class is simply the root class
