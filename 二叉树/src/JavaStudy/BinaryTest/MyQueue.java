package JavaStudy.BinaryTest;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class MyQueue<T> {
    private Object[] data;
    private  int head;
    private  int tail;
    private int size=50;
    private void extant(){
        Object[] old=new Object[size];
        for(int i=0;i<=tail;i++){
            old[i]=data[i];
        }
        this.data=new Object[2*size-1];
        for( int i=0;i<this.size;i++){
            data[i]=old[i];
        }
        size=size*2-1;
    }

    public MyQueue(){

        this.data=new Object[this.size];
        this.head=0;
        this.tail=0;
    }
    public MyQueue(MyQueue object){
        this.size= object.size;
        this.tail= object.tail;
        this.head=object.head;
        for(int i=0;i<this.size;i++){
            data[i]=object.data[i];
        }
    }
    public boolean isEmpty(){
        return (this.head==this.tail);
    }

    public boolean isFull(){
        return (tail==size);
    }

    public boolean add(T _data){
        if(this.isFull())
            extant();
        if (null != _data) {
            data[tail++] = _data;
            return true;
        }
        System.out.println("data illegal");
        return false;
    }

    public  T remove(){
        T temp=null;
        temp=(T)data[head++];
        return temp;
    }

    public void clear(){
        //size =0;
        head=0;
        tail=0;
        for(int i=0;i<size;i++){
            data[i]=null;
        }
    }
}




