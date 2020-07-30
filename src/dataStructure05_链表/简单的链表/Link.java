package dataStructure05_链表.简单的链表;


import java.util.Currency;

/**
 * 2020/3/8 21:11
 *
 * @author a1344
 * 说明：
 */
public class Link {
    protected int iData;
    protected double dData;
    protected Link next;

    public Link(int i, double d) {
        iData = i;
        dData = d;
    }
    public void disPlayLink(){
        System.out.println("{"+iData+", "+dData+"}");
    }

    @Override
    public String toString() {
        return "Link{" +
                "iData=" + iData +
                ", dData=" + dData +
                ", next=" + next +
                '}';
    }
}
class LinkList{
    private Link first;

    public LinkList(){
        first =null;
    }
    public boolean isEmpty(){
        return (first == null);
    }
    public void insertFirst(int id,double dd){
        Link newLink = new Link(id,dd);
        newLink.next =first;
        first = newLink;
    }
    public Link deleteFirst(){
        Link temp = first;
        first =first.next;
        return temp;
    }
    public void display(){
        System.out.println("List (first --> last):");
        Link current = first;
        while (current!=null){
            current.disPlayLink();
            current=current.next;
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return "LinkList{" +
                "first=" + first +
                '}';
    }
}
class demo{
    public static void main(String[] args) {
        LinkList linkList = new LinkList();
        linkList.insertFirst(12,123);


        linkList.display();
        System.out.println(linkList);
    }
}
