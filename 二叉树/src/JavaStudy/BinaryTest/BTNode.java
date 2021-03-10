package JavaStudy.BinaryTest;
import  java.util.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class BTNode<T> {
    private Object data;
    private BTNode leftChild;
    private BTNode rightChild;

    public BTNode(){
        data=null;
        leftChild=null;
        rightChild=null;
    }
    public BTNode(T _data,BTNode _leftChild,BTNode _rightChild){
        this.data=_data;
        this.leftChild=_leftChild;
        this.rightChild=_rightChild;
    }
    public   BTNode(BTNode _other){
        this.data=_other.data;
        this.leftChild=_other.leftChild;
        this.rightChild=_other.rightChild;
    }

    public boolean hasLeftChild(){
        return (this.leftChild!=null);
    }

    public boolean hasRightChild(){
        return (this.rightChild!=null);
    }

    public static void preOrder(BTNode _root){
        if(null==_root){
            return;
        }
        System.out.print(_root.data);
        BTNode.preOrder(_root.leftChild);
        BTNode.preOrder(_root.rightChild);
    }

    public static void inOrder(BTNode _root){
        if(null==_root){
            return;
        }

        BTNode.preOrder(_root.leftChild);
        System.out.print(_root.data);
        BTNode.preOrder(_root.rightChild);
    }

    public static void laOrder(BTNode _root){
        if(null==_root){
            return;
        }

        BTNode.preOrder(_root.leftChild);
        BTNode.preOrder(_root.rightChild);
        System.out.print(_root.data);
    }

    public static void level(BTNode _root){
        if(null==_root){
            return;
        }
        MyQueue<BTNode> temp=new MyQueue<>();
        temp.add(_root);
        while(!temp.isEmpty()) {
            _root = temp.remove();
            System.out.print(_root.data);
            if (_root.hasLeftChild()) {
                temp.add(_root.leftChild);
            }
            if (_root.hasRightChild()) {
                temp.add(_root.rightChild);
            }
        }

    }

    public static void nuPreOrder(BTNode _root){
        if(null==_root)
            return;
        Stack<BTNode> temp=new Stack<>();
        temp.push(_root);
        while(!temp.isEmpty()){
            if(null!=_root){
                System.out.print(_root.data);
                if(_root.hasRightChild()){
                    temp.push(_root.rightChild);
                }
                _root=_root.leftChild;
            }
            else {
                _root=temp.pop();
            }
        }
    }

    public static  void nuInOrder(BTNode _root){
        if(null==_root)
            return;
        Stack<BTNode> temp=new Stack<>();
        while (!temp.isEmpty()||_root!=null){
                if(null!=_root){
                temp.push(_root);
                _root=_root.leftChild;
            }
            else {
                _root=temp.pop();
                System.out.print(_root.data);
                _root=_root.rightChild;
            }
        }
    }

    public static void nuLastOrder(BTNode _root) {
        if (null == _root)
            return;
        int flag = 0;
        Stack<BTNode> temp = new Stack<>();
        Stack<Integer> flagTemp = new Stack<>();
        BTNode  tempBT=new BTNode<>();
        while (!temp.isEmpty() || _root != null) {
            if (_root != null) {
                temp.push(_root);
                flagTemp.push(1);
                _root=_root.leftChild;
            }
            else {
                 flag=flagTemp.pop();
                 tempBT= temp.pop();
                 if(flag==1){
                     temp.push(tempBT);
                     flagTemp.push(2);
                     _root=tempBT.rightChild;
                 }
                 else if(flag==2){
                     System.out.print(tempBT.data);
                 }
            }
        }
    }

    //递归
    public static int getLeaf(BTNode _root){
        if(_root==null)
            return 0;
        if(!_root.hasLeftChild()&&!_root.hasRightChild()){
            return 1;
        }
        return getLeaf(_root.leftChild)+getLeaf(_root.rightChild);
    }

    //非递归
    public static int getLeafNumber(BTNode _root){
        if(_root==null)
            return 0;
        int number=0;
        MyQueue<BTNode> temp=new MyQueue<>();
        temp.add(_root);

        while (!temp.isEmpty()){
             _root=temp.remove();
             if(!_root.hasLeftChild()&&!_root.hasRightChild()){
                 number++;
             }
             if (_root.hasLeftChild()){
                 temp.add(_root.leftChild);
             }
             if(_root.hasRightChild()){
                 temp.add(_root.rightChild);
             }
        }
        return number;
    }

    public  static int caculateTreeHigh(BTNode _root){
        if(_root==null)
            return -1;
        int depth=0;
        int leftdepth=caculateTreeHigh(_root.leftChild);
        int rightdepth=caculateTreeHigh(_root.rightChild);
        depth=leftdepth>rightdepth?leftdepth+1:rightdepth+1;
        return depth;
    }
    public  static int caculateTreeHighBylast(BTNode _root){
        if(null==_root)
            return -1;
        int height=0;
        int maxHeight=0;
        int flag=0;
        Stack<BTNode> treeTemp=new Stack<>();
        Stack<Integer> flagTemp=new Stack<>();
        BTNode temp=new BTNode();
        while(!treeTemp.isEmpty()||_root!=null){
            if(_root!=null){
                treeTemp.push(_root);
                height++;
                if(maxHeight<=height)
                    maxHeight=height;
                flagTemp.push(1);
                _root=_root.leftChild;
            }
            else{
                temp=treeTemp.pop();
                height--;
                flag=flagTemp.pop();
                if(flag==1) {
                    treeTemp.push(temp);
                    flagTemp.push(2);
                    _root = temp.rightChild;
                }
            }

        }
        return maxHeight;

    }
    public static BTNode turnTree(BTNode _root){
       if(_root==null){
            return null;
        }
        BTNode left=turnTree(_root.leftChild);
        BTNode right=turnTree(_root.rightChild);
        BTNode root=new BTNode(_root.data,right,left);
        return root;
    }
    //递归 根到叶子
    public static LinkedList<String> findAllPath(BTNode _root){
        LinkedList<String> list=new LinkedList<>();
        if(_root==null)
            return list;
        findAllPaths(list,"",_root);
        return list;
    }

    public static LinkedList<String> findAllPaths(LinkedList list,String string,BTNode _root){
        if(_root==null)
            return list;
        string=string+_root.data;
        if(!_root.hasLeftChild()&&!_root.hasRightChild()){
            list.add(string);
        }
        else{
            findAllPaths(list,string,_root.leftChild);
            findAllPaths(list,string,_root.rightChild);
        }
        return list;
    }
    public LinkedList<String> findAllPaths2(BTNode _root) {
        LinkedList<String> list=new LinkedList<String>();
        if (_root==null)
            return list;
        //队列存放遍历过的节点
        Queue<BTNode> tempNode=new LinkedList<>();
        Queue<String> tempStr=new LinkedList<String>();

        tempNode.add(_root);
        tempStr.add("");
        while(!tempNode.isEmpty()) {
            //获取当前节点
            BTNode curNode=tempNode.remove();
            String curStr=tempStr.remove();

            if (curNode.leftChild==null && curNode.rightChild==null)
                list.add(curStr+curNode.data);
            if (curNode.leftChild!=null) {
                tempNode.add(curNode.leftChild);
                tempStr.add(curStr+curNode.data);
            }
            if (curNode.rightChild!=null) {
                tempNode.add(curNode.rightChild);
                tempStr.add(curStr+curNode.data);
            }
        }
        return list;
    }

}

