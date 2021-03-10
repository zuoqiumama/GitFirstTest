package JavaStudy.BinaryTest;

import java.util.Arrays;

/*public class Stack<T> {

    private int maxsize;
    private int numItem=0;
    private int ptr=-1;
    private Object[] dataList;

    public Stack(){

        maxsize=100;
        this.dataList=new Object[this.maxsize];
    }

    public Stack(int _size){
        this.dataList=new Object[_size];
        this.maxsize=_size;
    }

    public void push(T _data){
            dataList[++ptr]=_data;
            this.numItem++;
            return;
    }

    public  T pop(){
        T re=null;
        if(ptr<=-1||ptr>maxsize-1){
            System.out.println("位置错误");
            return null;
        }
            re = (T) dataList[ptr];
            ptr--;
            return re;

    }
    public  boolean isEmpty(){
        if(numItem==0){
            return true;
        }
        return  false;
    }
}

 */
public class Stack<T> {

    private Object[] stack;
    private int size;

    public Stack() {
        stack = new Object[50];//初始容量为10
    }


    public boolean isEmpty() {
        return size == 0;
    }


    public T peek() {
        T t = null;
        if (size > 0)
            t = (T) stack[size - 1];
        return t;
    }

    public void push(T t) {
        expandCapacity(size + 1);
        stack[size] = t;
        size++;
    }

    //出栈
    public T pop() {
        T t = peek();
        if (size > 0) {
            stack[size - 1] = null;
            size--;
        }
        return t;
    }

    //扩大容量
    public void expandCapacity(int size) {
        int len = stack.length;
        if (size > len) {
            size = size * 3 / 2 + 1;//每次扩大50%
            stack = Arrays.copyOf(stack, size);
        }
    }
}
