package t12_Linkedlist_question;


//  Definition for singly-linked list.
  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

public class question2 {

      //detect where the cycle start
      public ListNode detectCycle2(ListNode head) {
          ListNode slow =head;
          ListNode fast = head;
          while(fast!=null && fast.next !=null){
              fast = fast.next.next;
              slow = slow.next;
              if(fast==slow ){
                  ListNode temp = slow,temp2=head;
                  while(temp!=temp2){
                      temp=temp.next;
                      temp2=temp2.next;
                  }

              }
          }
          return head;
      }
      public ListNode detectSCycle(ListNode head) {
          ListNode slow =head;
          ListNode fast = head;
          while(fast!=null && fast.next !=null){
              fast = fast.next.next;
              slow = slow.next;
              if(fast==slow ){
                  ListNode temp = head;
                  while(temp!=slow){
                      slow=slow.next;
                      if(slow==fast) temp = temp.next;
                  }
                  return temp;
              }
          }
          return head;
      }
      //if it has cycle or not
    public boolean hasCycle(ListNode head) {
        if(head==null || head.next==null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next !=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow ){
                return true;
            }
        }
        return false;
    }
    //length of the cycle
    public int LengthCycle(ListNode head) {
        if(head==null || head.next==null) return 0;
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next !=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow ){
                ListNode temp =slow;
                int count =0;
                do{
                    temp = temp.next;
                    count++;
                }
                while(temp!=slow);
                return count;
            }
        }
        return 0;


    }

}