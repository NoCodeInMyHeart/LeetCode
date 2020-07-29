/**
 * 题目：两数相加
 *
 *
 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

 示例：

 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 输出：7 -> 0 -> 8
 原因：342 + 465 = 807

 解决思想，对位相加，超10进1，类似于数学的求和
 2+5=7，4+6=10，留0进1，3+4+进位的1 = 8 结果708
 * @author NoCodeInMyHeart
 * @date
 */
public class TwoAdd {

    static ListNode addTwoNumbers(ListNode node1,ListNode node2){
        //由于每位数字都应当处于 0 ~9 的范围内，两条链表之和处于0~18之间，c用来记录和超过10情况的越位，其实就是记录为1
        int c = 0;
        ListNode pre = new ListNode(0,null);
        ListNode cur = pre;
        while (node1 != null || node2 != null){
            //获取两条链表对应位置的数，不足的补0
            int a = node1 == null ? 0 : node1.getX();
            int b = node2 == null ? 0 : node2.getX();
            //求和
            int sum = a + b + c;
            //取余数，sum大于10,c=1，sum小于10，c=0
            c = sum / 10;
            //取模，sum大于10时取个位上的数
            sum = sum % 10;
            cur.setNext(new ListNode(sum,null));
            cur = cur.getNext();
            if(node1 != null){
                node1 = node1.getNext();
            }
            if (node2 != null){
                node2 =node2.getNext();
            }
            if(c == 1){
                cur.setNext(new ListNode(c,null));
            }
        }
        return pre.getNext();
    }

    public static void main(String[] args){
        ListNode node1 = new ListNode(2,new ListNode(4,new ListNode(3,null)));
        ListNode node2 = new ListNode(5,new ListNode(6,new ListNode(4,null)));
        ListNode result = addTwoNumbers(node1,node2);
    }
}
