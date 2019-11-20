package cn.antsing.tree;

/**
 * 树节点
 */
public class TreeNode {
    /**
     * 数节点存储值：0或者1, 默认为-1,-1代表头节点，头节点本身无需存任务值
     */
    private byte value = -1;
    /**
     * 父节点
     */
    private TreeNode parentNode;
    /**
     * 直接左子节点,value为0
     */
    private TreeNode leftNode;
    /**
     * 直接右子节点，value为1
     */
    private TreeNode rightNode;
    /**
     * 节点深度，越深值越大，其值范围[0-32]
     * 0代表top节点
     */
    private byte depth = 0;
    /**
     * 缩进长度
     */
    private int indent;

    public TreeNode(byte value, TreeNode parentNode,byte depth) {
        if(value !=0 && value != 1){
            throw new IllegalArgumentException("value must 0 or 1");
        }
        if(depth <1 && depth > 32){
            throw new IllegalArgumentException("depth must [1,32]");
        }
        this.value = value;
        this.parentNode = parentNode;
        this.depth = depth;
    }

    public TreeNode() {
    }

    public byte getValue() {
        return value;
    }

    public TreeNode getParentNode() {
        return parentNode;
    }

    public TreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }

    public byte getDepth() {
        return depth;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "value=" + value +
                ", parentNode.value=" + parentNode.value +
               // ", leftNode.value=" + leftNode.value +
                //", rightNode.value=" + rightNode.value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TreeNode treeNode = (TreeNode) o;

        if (value != treeNode.value) return false;
        if (depth != treeNode.depth) return false;
        if (parentNode != null ? !parentNode.equals(treeNode.parentNode) : treeNode.parentNode != null) return false;
        if (leftNode != null ? !leftNode.equals(treeNode.leftNode) : treeNode.leftNode != null) return false;
        return rightNode != null ? rightNode.equals(treeNode.rightNode) : treeNode.rightNode == null;
    }

    @Override
    public int hashCode() {
        int result = (int) value;
        result = 31 * result + (parentNode != null ? parentNode.hashCode() : 0);
        result = 31 * result + (leftNode != null ? leftNode.hashCode() : 0);
        result = 31 * result + (rightNode != null ? rightNode.hashCode() : 0);
        result = 31 * result + (int) depth;
        return result;
    }
}
