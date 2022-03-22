/* Zoraz Haseeb
 * 11/05/2021
 * BinSearchTree.java
 * Project 5
 * 1st Semester
 * CMSC 256-001
 * */
package cmsc256;

import bridges.base.BinTreeElement;
import bridges.connect.Bridges;
import bridges.validation.RateLimitException;

import java.io.IOException;


public class BinSearchTree<E extends Comparable<E>> implements BinTreeInterface<E>{
    //This element is the elements being looked at, left and write child can be derived from it
    private BinTreeElement<E> root;
    //keeps track of the size of the Binary Tree
    private int size;

    @Override
    public BinTreeElement<E> getRoot() {
        return root;
    }


    @Override
    public boolean add(E element) {
        //Use helper method to add element to tree
        root = addToParent(root,element);
        return true;
    }
    public BinTreeElement<E> addToParent(BinTreeElement<E> root, E element){
        //IF there is no root then the element being added is the new root
        if(root == null){
            size++;
            root = new BinTreeElement<>(element);
        }
        else{
            //Element is being compared to its root to determine if it goes on the right or the left
            int comp = element.compareTo(root.getValue());

            if(comp < 0){
                //Method is called recursively until it finds a spot it can fit
                root.setLeft(addToParent(root.getLeft(),element));
            }
            else{
                root.setRight(addToParent(root.getRight(),element));
            }
        }
        return root;
    }

    @Override
    public boolean remove(E element) {
        //IF there is no root then nothing can be removed
        if(root == null){
            return false;
        }
        //helper method is called
        root = removeHelper(root, element);
        return true;
    }
    public BinTreeElement<E> removeHelper(BinTreeElement<E> root, E element){
        //If there is no root then nothing can be removed
        if(root == null){
            return null;
        }
        //The element and the root are compared
        int compare = element.compareTo(root.getValue());
        //If the element is less than the root then it goes to the left
        if(compare < 0){
            //recursive method called
            root.setLeft(removeHelper(root.getLeft(),element));
        }
        else if (compare > 0 ){
            root.setRight(removeHelper(root.getRight(),element));
        }
        else{
            if(root.getLeft() == null){
                size--;
                return root.getRight();
            }
            if(root.getRight() == null){
                size--;
                return root.getLeft();
            }
            BinTreeElement<E> temp = searchMin(root.getRight());
            root.setValue(temp.getValue());
            removeHelper(root.getRight(), temp.getValue());
        }
        return root;
    }
    public BinTreeElement<E> searchMin(BinTreeElement<E> root){
        if(root.getLeft()==null){
            return root;
        }
        return searchMin(root.getLeft());
    }

    @Override
    public int size() {
        //returns the size of the tree
        return size;
    }

    @Override
    public boolean isEmpty() {
        //checks if the tree is empty
        return root == null;
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }
    public boolean searchHelper(BinTreeElement<E> root, E target){
        //IF there  is no tree then you cannot search the tree
        if(root == null){
            return false;
        }
        //element and the root are compared
        int compare = target.compareTo(root.getValue());
        //Comes back true only if it has found the correct element
        if(compare == 0) {
            return true;
        }
        if(compare < 0 ){
            //If the target is less than the root then it moves to the left
            return searchHelper(root.getLeft(),target);
        }
            //otherwise it moves to the right
            return searchHelper(root.getRight(), target);
    }

    @Override
    public boolean search(E target) {
        //helper method called
        return searchHelper(root,target);
    }

    @Override
    public String inorder() {
        return inorderHelper(root);
    }
    public String inorderHelper(BinTreeElement<E> root){
        String traversal = "";
       if(root != null){
           traversal += inorderHelper(root.getLeft());
           traversal += root.getValue() + "  ";
           traversal += inorderHelper(root.getRight());
       }
       return traversal;
    }

    @Override
    public String postorder() {
        return postOrderHelper(root);
    }
    public String postOrderHelper(BinTreeElement<E> node){
        String traversal = "";
        if(node != null){
            traversal += postOrderHelper(node.getLeft());
            traversal += postOrderHelper(node.getRight());
            traversal += node.getValue() + "  ";
        }
        return traversal;
    }

    @Override
    public String preorder() {
        return preOrderHelper(root);
    }
    public String preOrderHelper(BinTreeElement<E> node){
        String traversal = "";
        if(node!= null){
            traversal+= node.getValue() + "  ";
            traversal += preOrderHelper(node.getLeft());
            traversal += preOrderHelper(node.getRight());
        }
        return traversal;
    }
    public int heightHelper(BinTreeElement<E> root){
        //IF there is no tree then the height is -1
        if(root == null){
            return -1;
        }
        //Recursive call that adds 1 everytime it is called
        return Math.max(heightHelper(root.getLeft()),heightHelper(root.getRight())) + 1;

    }
    public int height(){
        //helper method called
        return heightHelper(root);
    }
    public boolean isFullBSTHelper(BinTreeElement<E> root){
        //If the node is empty then it is full
        if(root == null){
            return true;
        }
        //If the root has no children then it means it is full
        if(root.getLeft()==null && root.getRight()== null){
            return true;
        }
        //if the root has children then the method is called recursively until it finds a node with no children
        if(root.getLeft()!= null && root.getRight() != null){
            return isFullBSTHelper(root.getLeft()) && isFullBSTHelper(root.getRight());
        }
        return false;
    }
    public Boolean isFullBST(){
        //helper method is called
        return isFullBSTHelper(root);
    }
    public int getNumberOfLeavesHelper(BinTreeElement<E> root){
        //no leaves if the node is empty
        if(root == null){
            return 0;
        }
        //The node is a leaf if it has no children
        if(root.getLeft() == null && root.getRight() == null){
            return 1;
        }
        //called recursively for both children
        return getNumberOfLeavesHelper(root.getLeft()) + getNumberOfLeavesHelper(root.getRight());
    }

    public int getNumberOfLeaves(){
        //helper method is called
        return getNumberOfLeavesHelper(root);
    }
    public int getNumberOfNonLeavesHelper(BinTreeElement<E> root){
        //if either the root doesnt exist or it is a leaf then it does not count
        if(root == null || (root.getLeft() == null && root.getRight() == null)){
            return 0;
        }
        //Adds 1 everytime it is called recursively
        return 1 + getNumberOfNonLeavesHelper(root.getRight()) + getNumberOfNonLeavesHelper(root.getLeft());
    }
    public int getNumberOfNonLeaves(){
        //helper method is called 
        return getNumberOfNonLeavesHelper(root);
    }
    public static void main(String [] args) throws RateLimitException, IOException {
        BinSearchTree <String> names = new BinSearchTree<>();
        names.add("Frodo");

        names.add("Dori");

        names.add("Bilbo");

        names.add("Kili");

        names.add("Gandalf");

        names.add("Fili");

        names.add("Thorin");

        names.add("Nori");
        System.out.println(names.preorder());
        Bridges bridges = new Bridges(3,"haseebz","1092119066883");
        //Setting the title of bridges
        bridges.setTitle("CMSC 256 Project 5 Zoraz Haseeb");
        BinTreeElement<String> str1 = new BinTreeElement<>("Frodo");
        BinTreeElement<String> str2 = new BinTreeElement<>("Dori");
        BinTreeElement<String> str3 = new BinTreeElement<>("Bilbo");
        BinTreeElement<String> str4 = new BinTreeElement<>("Kili");
        BinTreeElement<String> str5 = new BinTreeElement<>("Gandalf");
        BinTreeElement<String> str6 = new BinTreeElement<>("Fili");
        BinTreeElement<String> str7 = new BinTreeElement<>("Thorin");
        BinTreeElement<String> str8 = new BinTreeElement<>("Nori");
        str1.setLeft(str2);
        str1.setRight(str4);
        str2.setLeft(str3);
        str2.setRight(str6);
        str4.setLeft(str5);
        str4.setRight(str7);
        str7.setLeft(str8);


        str1.setLabel("Frodo");
        str2.setLabel("Dori");
        str3.setLabel("Bilbo ");
        str4.setLabel("Kili");
        str5.setLabel("Gandalf");
        str6.setLabel("Fili");
        str7.setLabel("Thorin");
        str8.setLabel("Nori");
        bridges.setDataStructure(str1);
        bridges.visualize();
    }
}
