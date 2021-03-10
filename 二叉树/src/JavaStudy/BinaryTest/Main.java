package JavaStudy.BinaryTest;//package JavaStudy.BinaryTest;

import java.util.LinkedList;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class Main {
    public  static void main(String args[]){
        /*BTNode<Integer>  tempF=new BTNode<>(6,null,null);
        BTNode<Integer>  tempD=new BTNode<>(4,tempF,null);
        BTNode<Integer>  tempB=new BTNode<>(2,null,tempD);
        BTNode<Integer>  tempE=new BTNode<>(5,null,null);
        BTNode<Integer>  tempC=new BTNode<>(3,null,tempE);
        BTNode<Integer>  tempA=new BTNode<>(1,tempB,tempC);

        LinkedList<String> list=tempA.findAllPaths2(tempA);
        System.out.println(list);*/
        MyQueue<Integer> temp=new MyQueue<>();
        for(int i=0;i<3;i++){
            temp.add(i);
        }
        int a1=(int)temp.remove();
        System.out.println(a1);
        //int a2=(int)temp.peek();
       // System.out.println(a2);

    }

}


