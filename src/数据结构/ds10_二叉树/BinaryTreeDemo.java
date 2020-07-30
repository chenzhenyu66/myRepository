package 从零开始的数据结构.ds10_二叉树;

/**
 * 2020/6/1 16:46
 *
 * @author a1344
 * 说明：主要是二叉树的简单实现、前序、中序、后序、遍历
 */
public class BinaryTreeDemo {


    public static void main(String[] args) {
        HeroNode node1 = new HeroNode(1,"刘备");
        HeroNode node2 = new HeroNode(2,"关羽");
        HeroNode node3 = new HeroNode(3,"张飞");
        HeroNode node4 = new HeroNode(4,"诸葛村夫");
        HeroNode node5 = new HeroNode(5,"常山赵子龙");
        HeroNode node6 = new HeroNode(6,"黄忠");
        node1.setLeft(node4);
        node1.setRight(node2);
        node4.setRight(node5);
        node2.setLeft(node3);
        node4.setLeft(node6);

        BinaryTree tree = new BinaryTree();
        tree.setRoot(node1);
//        System.out.println("前序遍历");
//        tree.preOrder();
//        System.out.println("中序遍历");
//        tree.infixOrder();
//        System.out.println("后序遍历");
//        tree.postOrder();

        //前序遍历查询
//        System.out.println(tree.preOrderSearch(3));
//        System.out.println(tree.infixOrderSearch(3));
//        System.out.println(tree.postOrderSearch(3));
        tree.preOrder();
        tree.deleteTreeNode(4);
        tree.preOrder();
    }

}

class BinaryTree {
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //前序遍历
    public void preOrder(){
        if (this.root!=null){
            this.root.preOrder();
        }else {
            System.out.println("二叉树为空！");
        }
    }

    //中序遍历
    public void infixOrder(){
        if (this.root!=null){
            this.root.infixOrder();
        }else {
            System.out.println("二叉树为空！");
        }
    }
    //后序遍历
    public void postOrder(){
        if (this.root!=null){
            this.root.postOrder();
        }else {
            System.out.println("二叉树为空！");
        }
    }

    //前序查找节点
    public HeroNode preOrderSearch(int no){
        if (this.root.preOrderSearch(no) != null)
            return this.root.preOrderSearch(no);
        else
            System.out.println("没找到指定节点，请检查！");
            return null;
    }

    //中序查找节点
    public HeroNode infixOrderSearch(int no){
        if (this.root.preOrderSearch(no) != null)
            return this.root.infixOrderSearch(no);
        else
            System.out.println("没找到指定节点，请检查！");
        return null;
    }

    //后序查找节点
    public HeroNode postOrderSearch(int no){
        if (this.root.preOrderSearch(no) != null)
            return this.root.postOrderSearch(no);
        else
            System.out.println("没找到指定节点，请检查！");
        return null;
    }

    //删除节点   要考虑的是删除某节点是直接删除子树，还是仅仅删除该节点
    //删除子树
    public void deleteTreeNode(int no){
        if (this.root.deleteTreeNode(no))
            System.out.println("删除成功");
        else
            System.out.println("删除失败");

    }

    public void deleteTreeNode2(int no){
        if (this.root.deleteTreeNode2(no))
            System.out.println("删除成功");
        else
            System.out.println("删除失败");

    }

}

class HeroNode {
    private Integer no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(Integer no, String name) {
        this.no = no;
        this.name = name;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" + "no=" + no + ", name=" + name + "}";
    }

    /**
     * 前序遍历,中左右
     */
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }

        if (this.right != null) {
            this.right.preOrder();
        }

    }

    /**
     * 中序遍历，左中右
     */
    public void infixOrder(){

        if (this.left != null) {
            this.left.infixOrder();
        }

        System.out.println(this);

        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    /**
     * 后序遍历，左右中
     */
    public void postOrder(){

        if (this.left != null) {
            this.left.postOrder();
        }

        if (this.right != null) {
            this.right.postOrder();
        }

        System.out.println(this);
    }

    //二叉前序遍历查找
    public HeroNode preOrderSearch(int no){
        if (this.no == no)
            return this;

        HeroNode node =null;
        if (this.left !=null)
            node = this.left.preOrderSearch(no);

        if (node != null)
            return node;

        if (this.right!=null)
            node = this.right.preOrderSearch(no);

        return node;

    }
    //二叉中序遍历查找
    public HeroNode infixOrderSearch(int no){

        HeroNode node =null;
        if (this.left !=null)
            node = this.left.infixOrderSearch(no);

        if (node != null)
            return node;

        if (this.no == no)
            return this;

        if (this.right!=null)
            node = this.right.infixOrderSearch(no);

        return node;
    }

    //后序后序遍历查找
    public HeroNode postOrderSearch(int no){

        HeroNode node =null;
        if (this.left !=null)
            node = this.left.postOrderSearch(no);

        if (node != null)
            return node;

        if (this.right!=null)
            node = this.right.postOrderSearch(no);


        if (this.no == no)
            return this;

        return node;
    }

    //删除节点   要考虑的是删除某节点是直接删除子树，还是仅仅删除该节点
    //删除子树
    public boolean deleteTreeNode(int no){

        if (this.left!=null && this.left.no == no){
            this.left = null;
            return true;
        }

        if (this.right!=null && this.right.no == no){
            this.right = null;
            return true;
        }

        if (this.left != null){
            if (this.left.deleteTreeNode(no))
                return true;
        }

        if (this.right != null){
            if (this.right.deleteTreeNode(no)){
                return true;
            }
        }

        return false;
    }

    //删除节点   要考虑的是删除某节点是直接删除子树，还是仅仅删除该节点
    //删除该节点，如果
    public boolean deleteTreeNode2(int no){

        if (this.left!=null && this.left.no == no){
            if (this.left.left != null){
                this.left.left.right=this.left.right;
                this.left = this.left.left;
            }else{
                this.left = this.left.right;
            }
            return true;
        }

        if (this.right!=null && this.right.no == no){
            if (this.right.left != null){
                this.right.left.right=this.right.right;
                this.right = this.right.left;
            }else{
                this.right = this.right.right;
            }
            return true;
        }

        if (this.left != null){
            if (this.left.deleteTreeNode(no))
                return true;
        }

        if (this.right != null){
            if (this.right.deleteTreeNode(no)){
                return true;
            }
        }

        return false;
    }
}