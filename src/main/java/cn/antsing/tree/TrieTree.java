package cn.antsing.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 字段树，也称前缀树
 *      当前是用来存储Int型数据的二进制，一个int占4字节，二进制位数是4*8=32，由于树最高节点属于空节点，
 *      所以树总高度为32+1=33.
 */
public class TrieTree {
    private TreeNode topNode;
    /**
     * 存储数据个数
     */
    private long numCount;

    public TrieTree() {
        this.topNode = new TreeNode();
    }

    public void loadData(int[] data){
        if(data == null || data.length == 0){
            System.err.println("no data to load!!");
            return;
        }
        int len = data.length;
        int tmp;
        List<TreeNode> list = new ArrayList<>();
        list.add(topNode);
        for(int i=0;i<len;i++){
            tmp = data[i];
            for(byte j=1;j<=32;j++){
                byte bitValue = Utils.getSpecialBitValueOfInt(tmp,j);
               // System.out.println("bitValue:"+bitValue);
                TreeNode currentParentNode = list.get(j-1);
                if(bitValue == 0){
                    TreeNode leftNode = currentParentNode.getLeftNode();
                    if(leftNode == null){
                        leftNode = new TreeNode(bitValue,currentParentNode,j);
                        currentParentNode.setLeftNode(leftNode);
                    }
                    list.add(leftNode);
                }else if(bitValue == 1){
                    TreeNode rightNode = currentParentNode.getRightNode();
                    if(rightNode == null){
                        rightNode = new TreeNode(bitValue,currentParentNode,j);
                        currentParentNode.setRightNode(rightNode);
                    }
                    list.add(rightNode);
                }
            }
            list.clear();
            list.add(topNode);
        }
        numCount = len;
    }

    private TreeNode getParentNode(byte bitValue,byte depth){
        return null;
    }

    private TreeNode isExistNode(byte bitValue,byte depth){
        return null;
    }

    private TreeNode getNode(byte bitValue,byte depth,TreeNode parenNode){
       // if(parenNode.getValue() == bitValue && depth == parenNode.getDepth())
        return null;
    }
    public void printTrieTree(){
        long tabCount = 100;
        List<TreeNode> nodes = new ArrayList<>();
        List<TreeNode> child = new ArrayList<>();
        for(int j=0;j<tabCount;j++){
            System.out.print("\t");
        }
        System.out.println(topNode.getValue());
        if(topNode.getLeftNode() != null){
            child.add(topNode.getLeftNode());
        }
        if(topNode.getRightNode() != null){
            child.add(topNode.getRightNode());
        }

        tabCount--;
        for(int i=1;i<=32;i++){
            System.out.println("["+tabCount+"]");
            for(int j=0;j<tabCount;j++){
                System.out.print("\t");
            }
            for(TreeNode treeNode:child){
                System.out.print(treeNode.getValue()+"\t\t\t");
                if(treeNode.getValue() != -1){
                    if(treeNode.getLeftNode() !=null){
                        nodes.add(treeNode.getLeftNode());
                    }
                    if(treeNode.getRightNode() !=null){
                        nodes.add(treeNode.getRightNode());
                    }
                }

            }
            System.out.println();
            child.clear();
            child.addAll(nodes);
            nodes.clear();
            tabCount--;
        }
    }


    private int depth(TreeNode pTreeRoot){
        if(pTreeRoot==null){
            return 0;
        }
        int l = depth(pTreeRoot.getLeftNode());
        int r = depth(pTreeRoot.getRightNode());
        if(l > r){
            return l + 1;
        }else{
            return r + 1;
        }
    }

    private void levelOrder(TreeNode pTreeNode, int level) {
        if(pTreeNode == null || level < 1){
            return ;
        }
        if(level == 1){
            System.out.print(pTreeNode.getValue()+ " ");
            return ;
        }
        //左子树
        levelOrder(pTreeNode.getLeftNode(), level-1);
        //右子树
        levelOrder(pTreeNode.getRightNode(), level-1);
    }

    public void printFromTopToBottom(){
        if(topNode==null){
            return ;
        }
        int depth = depth(topNode);
        for (int i = 1; i <= depth; ++i) {
            levelOrder(topNode, i);
        }
    }
}
