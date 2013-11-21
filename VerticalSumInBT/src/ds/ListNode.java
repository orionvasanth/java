/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ds;

/**
 *
 * @author Orion
 */
public class ListNode<E> {
    private ListNode<E> prev = null;
    private ListNode<E> next = null;
    private E data = null;

    public ListNode(){

    }

    public ListNode(E data){
        this.data = data;
    }

    public E getData(){
        return data;
    }

    public void setData(E newData){
        data = newData;
    }

    public ListNode<E> getPrev(){
        return prev;
    }

    public void setPrev(ListNode<E> newPrev){
        prev = newPrev;
    }

    public ListNode<E> getNext(){
        return next;
    }

    public void setNext(ListNode<E> newNext){
        next = newNext;
    }
}
