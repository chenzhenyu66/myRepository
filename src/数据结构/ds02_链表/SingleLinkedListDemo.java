package 从零开始的数据结构.ds02_链表;

/**
 * 2020/4/9 16:15
 *
 * @author a1344
 * 说明：
 * 面试题
 * 1.计算链表的长度        num 142
 * 2.计算倒数第n个节点
 * 3.将链表反转          两种方法，1.常规 2.利用栈的先进后出原则
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {

        HeroNode node2 = new HeroNode(1, "刘备", "大傻子");
        HeroNode node1 = new HeroNode(2, "关羽", "二傻子");
        HeroNode node = new HeroNode(3, "张飞", "三傻子");
        SingleLinkedList linkedList = new SingleLinkedList();
        //增加
        linkedList.add(node);
        //顺序增加
        linkedList.addByOrder(node1);
        linkedList.addByOrder(node2);
//
//        HeroNode node3 = new HeroNode(1, "刘备", "刘皇叔");
//        //修改
//        linkedList.update(node3);

        //删除
//        linkedList.remove(2);
//        System.out.println(linkedList);
//        返回单链表的长度
//        System.out.println(linkedList.getLength());
//        System.out.println(linkedList.getReverseIndex(linkedList.head, 2));
        System.out.println(node2);
        SingleLinkedList.reverseList(node2);

    }
}

class SingleLinkedList {
    //初始化一个头结点
    protected HeroNode head = new HeroNode(0, "", "");

    //在末尾增加一个节点
    public void add(HeroNode node) {
        HeroNode temp = head;

        //找到最后一个节点
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
    }

    //根据编号插入
    public void addByOrder(HeroNode node) {
        HeroNode temp = head;

        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                //说明已经到底了
                break;
            }

            if (temp.next.no > node.no) {
                //说明找到位置了
                break;
            } else if (temp.next.no == node.no) {
                //说明编号已经存在
                flag = true;
                break;
            }
            //没找到位置，后移
            temp = temp.next;
        }
        if (flag) {
            System.out.println("插入英雄的编号已经存在，请检查编号");
        } else {
            node.next = temp.next;
            temp.next = node;
        }
    }

    //修改一个节点的信息
    public void update(HeroNode node) {
        if (head.next == null) {
            System.out.println("链表为空，不能修改");
            return;
        }

        HeroNode temp = head;
        //用于判断找没找到
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                //到底了
                break;
            }
            if (temp.next.no == node.no) {
                flag = true;
                temp = temp.next;
                break;
            }
            temp = temp.next;
        }

        if (!flag) {
            System.out.println("没找到这个节点，请检查");
        } else {
            temp.name = node.name;
            temp.nikeName = node.nikeName;
        }

    }

    //删除一个节点
    public void remove(int no) {
        HeroNode temp = head;
        boolean flag = false;

        while (true) {
            if (temp.next == null) {
//                System.out.println("没找到");
                break;
            }
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (!flag) {
            System.out.println("没找到该节点");
        } else {
            temp.next = temp.next.next;
        }
    }

    //返回链表的长度
    public int getLength(HeroNode node) {
        HeroNode temp = node;
        int sum = 0;
//        while (true){
//
//            if (temp.next != null){
//                sum++;
//            }else {
//                break;
//            }
//            temp = temp.next;
//        }
        temp = temp.next;
        while (temp != null) {
            sum++;
            temp = temp.next;
        }
        return sum;
    }

    //计算倒数第n个节点
    public HeroNode getReverseIndex(HeroNode node, int n) {
        //如果node为空
        if (node == null) {
            return null;
        }

        HeroNode temp = node;
        int length = getLength(node);
        int index = length - n;

        //如果要查找的数大于长度 或者 是负数
        if (n < 0 || n > length) {
            System.out.println("检查要查找的节点！");
            return null;
        }

        while (index != 0) {
            temp = temp.next;
            index--;
        }

        return temp.next;
    }

    /**
     * 链表的反转
     *
     * @param head
     */
    public static void reverseList(HeroNode head) {
        //如果当前链表为空 或者 只有一个节点，无需反转，直接返回
        if (head.next == null || head.next.next == null) {
            return;
        }
        HeroNode cur = head.next;
        HeroNode next = null;// 指向当前节点[cur]的下一个节点
        HeroNode reverseHead = new HeroNode(0, "", "");

        while (cur != null) {
            next = cur.next;
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = next;
        }

        head.next = reverseHead.next;
        System.out.println(head.next);
    }

    @Override
    public String toString() {
        return "head=" + head;
    }
}

class HeroNode {
    protected Integer no;
    protected String name;
    protected String nikeName;
    protected HeroNode next;

    public HeroNode(Integer no, String name, String nikeName) {
        this.no = no;
        this.name = name;
        this.nikeName = nikeName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nikeName='" + nikeName + '\'' +
                ", next=" + next +
                '}';
    }
}
