package 从零开始的数据结构.ds02_链表;

/**
 * 2020/4/9 21:12
 *
 * @author a1344
 * 说明：双向链表
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode2 node1 = new HeroNode2(1,"唐僧","臭和尚");
        HeroNode2 node2 = new HeroNode2(2,"孙悟空","猴哥");
        HeroNode2 node3 = new HeroNode2(3,"猪八戒","猪哥");
        HeroNode2 node4 = new HeroNode2(4,"沙悟净","沙师弟");

        DoubleLinkedList linkedList = new DoubleLinkedList();
        linkedList.add(node1);
        linkedList.add(node2);
        linkedList.add(node3);
        linkedList.add(node4);

//        HeroNode2 node5 = new HeroNode2(4,"沙悟净","卷帘大将");
//        linkedList.update(node5);

        linkedList.list();

    }
}

class DoubleLinkedList {
    private HeroNode2 head = new HeroNode2(0, "", "");

    //得到头结点
    public HeroNode2 getHead() {
        return head;
    }

    //遍历双向链表
    public void list() {
        if (head.next == null) {
            System.out.println("该链表为空");
            return;
        }

        HeroNode2 temp = head;

        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    //添加数据
    public void add(HeroNode2 node) {
        HeroNode2 temp = head;
        //找到最后的位置
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
        node.pre = temp;
    }

    //修改数据
    public void update(HeroNode2 node) {
        if (head.next == null) {
            System.out.println("列表为空");
            return;
        }

        HeroNode2 temp = head;
        boolean flag = false;

        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == node.no) {
                flag = true;
                temp = temp.next;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.name = node.name;
            temp.nickName = node.nickName;
        }else {
            System.out.println("没找到该节点");
        }
    }

    //删除该节点
    public void del(int no){
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head;
        boolean flag = false;

        while (true){
            if (temp.next == null){
                break;
            }
            if (temp.next.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            if (temp.next.next == null){
                temp.next = null;
            }else {
                temp.next = temp.next.next;
                temp.next.pre = temp;
            }
        }
    }
}

class HeroNode2 {
    protected Integer no;
    protected String name;
    protected String nickName;
    protected HeroNode2 next;
    protected HeroNode2 pre;

    public HeroNode2(Integer no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
