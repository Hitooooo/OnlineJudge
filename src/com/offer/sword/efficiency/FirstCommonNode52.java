package com.offer.sword.efficiency;

import com.leetcode.struct.ListNode;

import org.junit.Test;

/**
 * 输入两个链表，找出它们的第一个公共结点。 
 * 
 * @author hitomeng
 * @date 2020-04-30 10:51:33
 */
public class FirstCommonNode52{
    
    /**
     * 链表长度相同，同步遍历查找即可。
     * 长度不同，较长的先跑，同样长度后再比较 
     */
    public ListNode firstCommonNode(ListNode l1, ListNode l2){
        if(l1 == null || l2 == null){
            return null;
        }
        int l1Len = getLength(l1);
        int l2Len = getLength(l2);
        int forwardStep = Math.abs(l2Len - l1Len);
        if(l1Len > l2Len){
            while(forwardStep > 0){
                l1 = l1.next;
                forwardStep--;
            }
        }else if(l1Len < l2Len){
            while(forwardStep > 0){
                l2 = l2.next;
                forwardStep--;
            }
        }
        while(l1 != null && l2 != null){
            if(l1 == l2){
                return l1;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return null;
    }

    private int getLength(ListNode node){
        ListNode temp = node;
        int count = 0;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }

    @Test
    public void test(){
        // Wrong use case
        ListNode l1 = ListNode.generate(new int[]{4,1,8,4,5});
        ListNode l2 = ListNode.generate(new int[]{5,0,1,8,4,5});
        ListNode res = firstCommonNode(l1, l2);        
        System.out.println(res);
    }
}