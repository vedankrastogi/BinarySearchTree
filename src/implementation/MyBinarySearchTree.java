package implementation;

public class MyBinarySearchTree {
    //we implement our binarysearch tree with the linked list so linked list contain the root node which
    //refers as the head.
    private Node root;//head

    // the first method we make is isEmpty method it will check whether our given tree is empty or not or it
    //contains any data or not
    public boolean isEmpty() {
        if (root == null) {
            return (true);
        }
        return (false);
    }

    //now we make method to insert our tree
    public void insert(int element) {//method name insert we pass the element inside our method as element.
        Node node = new Node(element);//here we create the node which we want to insert and call
        // it with constructor of the previous node.
        //condition 1 if our root is empty then this node will become node
        if (isEmpty()) {
            root = node;
        } else {
            //here we take a temp variable as we have to check for each node if this root is less then we
            //have to add at the left side if greater then at right side if and only if its left or right
            //is null and a parent variable which we have to initialise as  null suppose we have a element to
            //be added as 27 so we need a root which is the parent after which we have to add the element
            Node temp = root;
            //initially temp is the root and the parent of the root is null so intailly we define temp=root
            //and parent=null
            Node parent = null;
            //now we traverse in the tree by a temp variable
            while (temp != null) {//when temp is null we add the element there
                parent = temp;//as we move downwards in a tree the parent updated with temp means last
                //temp is now parent as we move downwards in a tree.
                //now we check whether the entered element will move at right subtree or left subtree
                //to check it we compare our temp with element if less so move at left side if greater so
                //move at right subtree
                if (element <= temp.getData()) {//check for the element is less than or equal tothe data store
                    // in the temp
                    temp = temp.getLeft();//if it is so temp will move left side
                } else {
                    temp = temp.getRight();//if it is not so temp will move right side
                }
            }
            //when we move outside the while loop we have the root as parent whose child
            // is the entered element so now again we have to check whether the new node is the
            // left child or right child of parent
            if (element <= parent.getData()) {//if the entered element is less than parent the it add to the
                // left side of the tree or new node is the left child.
                parent.setLeft(node);//so we set the left of the parent as the entered node if above
                // condition is satisfied.
            } else {
                parent.setRight(node);
            }
        }
    }

    //now we make method of traversal
    public void inOrder(Node node) {//inOrder initially needs a node or the root so we give the node at the time
        // of declaration of the method .
        //base condition or the terminating condition
        if (node == null) {
            return;
        } else {
            //as tree is a recursive data structure recursive means where the function calls itself
            // in a data structure according to our first step it will traverse to the left side.
            inOrder(node.getLeft());//we travel to the left side of the tree.
            //according to step 2 we have to print our data.
            System.out.print(node.getData() + ", ");//we use the comma seprated to clear output or for decoration
            //according to the step 3 we have to travel to the right side.
            inOrder(node.getRight());
        }

    }

    public void preOrder(Node node) {
        if (node == null) {
            return;
        } else {
            System.out.print(node.getData() + ", ");
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }

    public void postOrder(Node node) {
        if (node == null) {
            return;
        } else {
            postOrder(node.getLeft());
            postOrder(node.getRight());
            System.out.print(node.getData() + ", ");
        }
    }

    //now we have to write method for the search operation we have a given element we have to traverse
    // in our tree if the element is found the we have to return true otherwise false now we are at the
    // first node or the root node and we have to now traverse in a tree if the entered node is less
    // than the root node then we have to move towards the left subtree if is greater then we have to move
    // the right side and if equal so we found the element then return true.we traverse in a tree with
    //the help of temp variable.
    public boolean search(int searchElement) {//here we make a method to search an element.
        boolean response = false;//we initialise it with response as false
        Node temp = root;//we take a node temp which is the root of the tree or the first element of the tree
        while (temp != null) {
            if (temp.getData() == searchElement) {
                response = true;
                break;
            } else {
                if (temp.getData() < searchElement) {
                    temp = temp.getLeft();
                } else {
                    temp = temp.getRight();
                }
            }
        }
        return response;
    }

    //we make a method to delete a node here it take an argument the value to element to be deleted
    public void delete(int deletingElement) {
        //so now we traverse in our tree and search whether our deleting element is
        // present or not in our tree so to traversing we take a node temp which is the root of our tree
        Node temp = root;
        Node parent = null;
        //to traverse in a tree we use while loop while temp not equal to null.
        while (temp != null) {
            if (deletingElement == temp.getData()) {
                break;
            }
            else {
                //assign value to temp to parent as temp is updated so our parent os also updated
                parent = temp;
                if (temp.getData() < deletingElement) {
                    temp = temp.getLeft();
                } else {
                    temp = temp.getRight();
                }
            }
        }
//        so when we came out of the while loop either we have the temp as null or temp holding the value
//        of the node that has to be deleted
        //so if temp equal to null we say that element is not present
        if (temp != null) {
            //if temp not equal to null so the cases possible are:-
            //case1 :- leaf case or deleting a node having no child
            //we have to check for root case whether the element we have to delete is the root or not
//            if(temp.getLeft()==null && temp.getRight()==null){
            //to this temp.geleft==null && temp.getRight()==null we make a function of it select it then
            // press the shortcut key ctrl+alt+M
            if (isLeaf(temp)) {
                //root case
                if (temp == root) {
                    root = null;
                } else {
                    //if our deleting element is less than parent element then it is defenitely the left child
                    // so we set the left child of the parent as null
                    if (deletingElement < parent.getData()) {
                        parent.setLeft(null);
                    }
                    //if element is greater than parent then it defenetely the right child so we delete or set the
                    // right as null
                    else {
                        parent.setRight(null);
                    }
                }
            }
            //case2 :- single child case here it is divided into two cases as :-
            //case2.1 :- single left child case
            else if (hasLeftChild(temp)) {//here we create a method name as hasLeftChild if we want to delete
                //a node having one child and if the child is left we pass the parameter
                // our temp which we want to delete
                //we have to check for root case
                if(parent==null){//here if our parent is null so we updated root with the left child
                    // now our new root is the left child of the root
                    root=root.getLeft();
                }
                else{//if our parent is not null so we check whether the temp is left or right of the parent
                    if(deletingElement < parent.getData()){//the elemnt we want to delete if the deleting element
                        //is less than the parent data so defenetely it is the left child so we set the left
                        // value of parent as the value in the temp
                        parent.setLeft(temp.getLeft());
                    }
                    else{
                        parent.setRight(temp.getLeft());
                    }

                }
            }
            //case2.2 :- single right child case
            else if(hasRightChild(temp)){
                //we have to check for root case
                if(parent==null){
                    root=root.getRight();
                }
                else{
                    if(deletingElement < parent.getData()){
                        parent.setLeft(temp.getRight());
                    }
                    else{
                        parent.setRight(temp.getRight());
                    }
                }
            }
            //case3 :- two child case
            else{
                Node sucessor=getSucessor(temp);//here we create a node sucessor
                // with a method get sucessor we have to find the sucessor of the temp node so we pass the
                // temp  as an argument
                //after we get sucessor so we have to delete the sucessor
                delete(sucessor.getData());
                //now we have to set the right and left values of the sucessor in our tree
                sucessor.setRight(temp.getRight());
                sucessor.setLeft(temp.getLeft());
                //check for root case
                if(parent==null){
                    root=sucessor;
                }
                else{
                    if(deletingElement < parent.getData()){
                        parent.setLeft(sucessor);
                    }
                    else{
                        parent.setRight(sucessor);
                    }
                }
            }
        }
        else {
            System.out.print("cannot delete as element is not present");
        }
    }
    //mehod of isLeaf inside the MyBinarySearchTree method
        private boolean isLeaf (Node temp){
            return temp.getLeft() == null && temp.getRight() == null;
        }

//a boolean method of hasLeftChild method here we pass our node temp in the method as a argument and
// check whether our method contain only left child or not so we apply
// temp.getLeft()!=null && temp.getRight()==null if this is true it means that our tree contain only
// left child so it return true otherwise false
        private boolean hasLeftChild (Node temp){
        if(temp.getLeft()!=null && temp.getRight()==null){
            return true;
        }
        return false;

        }
        //same for the case 2.2 if it containes the only right child
    private boolean hasRightChild(Node temp) {
        if (temp.getRight() != null && temp.getLeft() == null) {
            return true;
        }
        return false;

    }
    //so to find a sucessor we have to perform inOrder so we give the value of the right child of the node
    // to the temp as temp traverse in our tree
    private Node getSucessor(Node node) {
        Node temp=node.getRight();
        //when the leftchild of the temp is null temp=temp.getleft
        while(temp.getLeft()!=null){
            temp=temp.getLeft();
        }
        return temp;

    }



}