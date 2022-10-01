package code.october2022.challenge;

import code.facebook.ListNode;

//https://leetcode.com/problems/delete-node-in-a-linked-list/description/
//TC - O(1)
//SC - O(1)
public class DeleteNodeInALinkedList {

    public void deleteNode(ListNode node) {

        ListNode nextNode = node.next;
        node.val = nextNode.val;
        node.next = nextNode.next;
        nextNode.next = null;
    }
}
