package cn.antsing.tree;

public class Main {
    public static void main(String[] args) {
        int[] data = new int[]{34,12,88,21,4,30};
        int m = 23;
        TrieTree trieTree = new TrieTree();
        trieTree.loadData(data);
        trieTree.printFromTopToBottom();
       // trieTree.printTrieTree();
//        int count = 0;
//        for(byte i=1;i<32;i++){
//            byte b1= Utils.getSpecialBitValueOfInt(m,i);
//           // byte b2 = Utils.getSpecialBitValueOfInt(data[0],i);
//            if(b1==0 ){
//
//            }else if(b1 ==1){
//
//            }
//        }
    }
}