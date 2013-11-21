/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ds;

/**
 *
 * @author Orion
 */
public class TreeNode<E> {
    private TreeNode<E> left = null;
    private TreeNode<E> right = null;
    private E data = null;

    public TreeNode(){}

    public TreeNode(E data){
        this.data = data;
    }

    public void setLeft(TreeNode<E> newLeft){
        left = newLeft;
    }

    public void setRight(TreeNode<E> newRight){
        right = newRight;
    }

    public TreeNode<E> getLeft(){
        return left;
    }

    public TreeNode<E> getRight(){
        return right;
    }

    public E getData(){
        return data;
    }

    public void setData(E newData){
        data = newData;
    }
}
