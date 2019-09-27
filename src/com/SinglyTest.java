package com;
/**
 * @author hp
 */
public class SinglyList<T> extends Node{
    public Node head;
    public SinglyList() {
        this.head=new Node();
    }
    public SinglyList(String[] values) {
        this();
        Node rear=this.head;
        for(int i=0;i<values.length;i++) {
            rear.next= new Node(values[i],null);
            rear=rear.next;
        }


    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String[] values= {"A","B","C","D","E","F"};

        SinglyList list=new SinglyList (values);
        Node p =list.head;
        p=p.next;
        while (p!=null) {
            System.out.println(p.data.toString());
            p=p.next;
        }



    }
}