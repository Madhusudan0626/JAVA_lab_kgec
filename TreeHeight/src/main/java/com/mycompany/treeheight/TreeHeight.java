/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.treeheight;

/**
 *
 * @author madhusudanxsoul
 */

class BinarySearchTree<T extends Comparable<T>>{
    private int nodecount=0;
    private Node root = null;

    private class Node{
        T data;
        Node left ,right;
        public Node(Node left,Node right,T data){
            this.data = data;
            this.left=left;
            this.right=right;
        }
    }
    
    private boolean contains(Node node , T el){
        if(node ==null) return false;
        int cmp=el.compareTo(node.data);
        
        if(cmp<0) return contains(node.left,el);
        else if (cmp > 0) return contains(node.right,el);
        else return true;      
    }
    public boolean contains(T el){
        return contains(root,el);
    }
    public boolean add(T el){
        if(contains(el))
            return false;
        else{
            root = add(root,el);
            nodecount++;
            return true;         
        }
    }
    private Node add(Node node ,T el){
        if (node ==null)
            node = new Node(null,null,el);
        else{
            if(el.compareTo(node.data)<0)
                node.left=add(node.left,el);
            else
                node.right=add(node.right,el);
        }
        return node;
    }
    public int height(){
        return height(root);
    }
    private int height(Node node){
        if (node == null) return 0;
        return Math.max(height(node.left),height(node.right))+1;
    }
    public void inorder(){
        inorder(root);
    }
    private void inorder(Node node){
        if (node == null)
            return;
        inorder(node.left);
        System.out.print(node.data+" ");
        inorder(node.right);        
    }
    public void postorder(){
        postorder(root);
    }
    private void postorder(Node node){
        if (node == null)
            return;
        postorder(node.left);
        postorder(node.right);   
        System.out.print(node.data+" ");
    }
    public void preorder(){
        preorder(root);
    }
    private void preorder(Node node){
        if (node == null)
            return;
        System.out.print(node.data+" ");
        preorder(node.left);
        preorder(node.right);        
    }
    public boolean remove(T el){
        if(contains(el)){
            root = remove(root,el);
            nodecount--;
            return true;
        }
        return false;
    }
    private Node remove(Node node , T el){
        if (node == null) return null;
        int cmp = el.compareTo(node.data);
        
        if (cmp < 0) node.left = remove(node.left,el);
        else if(cmp > 0) node.right = remove(node.right,el);
        else{
            if (node.left == null) return node.right;
            else if(node.right==null) return node.left;
            else{
                Node temp=findMin(node.right);
                node.data = temp.data;
                node.right = remove(node.right,temp.data);
            }
        }
        return node;
    }
    private Node findMin(Node node){
        while(node.left != null) node=node.left;
        return node;
    }
}

public class TreeHeight {
    public static void main(String[] args) {
        BinarySearchTree<Integer> b = new BinarySearchTree<>();
        
        b.add(43);        
        b.add(52);
        b.add(3);
        b.add(90);
        b.add(21);
        b.add(1);
        b.add(2);
        b.add(0);
        System.out.println("Inorder Travelsal");
        b.inorder();
        System.out.println("\nPreorder Travelsal");
        b.preorder();
        b.remove(3);
        System.out.println("\nInorder Travelsal");
        b.inorder();
        System.out.println("\nPreorder Travelsal");
        b.preorder();
        System.out.println("\n"+b.height());
    }
}
