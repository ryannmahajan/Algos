package com.ryannm;

import java.util.*;
public class Algos{
    private LinkedList a = new LinkedList();

    private void doStuff(int[] ar){
        //your code here

        for (int i: ar) {
            if (i==-1) {
                System.out.print(a.get(a.size()-1));
                a.remove(a.size()-1);
            } else {
                a.add(i);
            }
        }
    }

    //boilerplate code
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        for(int c=0;c<t;c++){
            int n = in.nextInt();
            int[] ar = new int[n];
            for(int i=0;i<n;i++){
                ar[i]=in.nextInt();
            }
            new Algos().doStuff(ar);
        }
    }


    class LinkedList {

        Node head;
        Node tail;

        /*
         * Adds Node to end of list with given `num` as data
         * Make sure it correctly sets the head (and tail)
         * when adding the first item to the list
         */
        public void add(int num){
            if (head==null) {
                head = new Node(num);
                tail = head;
            } else {
                tail.next = new Node(num);
                tail = tail.next;
            }
            // your code here
        }

        public void add(int num, int value) {
            if (num==0) head = new Node(value, head);
            else {
                Node node = head;
                while (num > 1) {
                    node = node.next;
                    num--;
                }
                node.next = new Node (value, node.next);
            }
        }

        public void remove (int index) {
            if (index==0) {
                head = head.next;
                return;
            }
            Node node = head;
            while (index > 1) {
                node = node.next;
                index--;
            }
            node.next = node.next.next;
        }

        /*
         * Returns value of node at given index
         */
        public int get(int index){
            Node node = head;

            while (index > 0) {
                node = node.next;
                index--;
            }
            return node.data;
            /* Exception in thread "main" java.lang.NullPointerException
	            at Main$LinkedList.get(Main.java:90)
	            at Main.doStuff(Main.java:10)
	            at Main.main(Main.java:29) */
        }

        public int size() {
            int i=0;
            Node node = head;
            while (node!=null) {
                node = node.next;
                i++;
            }
            return i;
        }
    }

    class Node{
        int data;
        Node next;
        public Node(int d){
            data = d;
        }

        public Node(int d, Node n){
            data = d;
            next = n;
        }
    }

}
