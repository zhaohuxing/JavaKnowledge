## 题目描述

输入一个链表，输出该链表中倒数第k个结点。<br />

```
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
import java.util.ArrayList;
import java.util.List;
public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
		if (head == null) {
            return null;
        }
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        if (list.size() < k || k <= 0 )
            return null;
        return list.get(list.size() - k);
    }
}
```
