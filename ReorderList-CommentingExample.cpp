// Hi Shenee, this is a solution for https://leetcode.com/problems/reorder-list.
// Note the use of comments to explain what the code is doing and why.
// Honestly, your solution is more elegant and optimal than mine.  There might
// be too many comments here, but this should at least give an idea of what I'm
// talking about when I talk about comments.  I'll send more details in an email.

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    void reorderList(ListNode* head) {
        // O(n^2) solution is to walk the linked list from the beginning, moving the tail node
        // from the end to the next with each step. This is O(n^2) because finding the tail
        // is O(n) and walking the list is O(n).

        // We can make finding the tail O(1) by caching every node in an array first. This
        // raises the space complexity from O(1) to O(n). I can't think of anything better
        // so I'll do that.

        // First cache every node in an array.
        std::vector<ListNode*> node_vector;
        for (ListNode* node = head; node != nullptr; node = node->next)
        {
            node_vector.push_back(node);
        }

        // To reorder, walk the array and repeatedly insert the tail node into next. Stop
        // when the next node is the tail node, because we don't want to try to move a node
        // to be after itself.
        if (head == nullptr)
        {
            return;
        }
        ListNode* next = head->next;
        for (ListNode* node = head; (next != nullptr) && (next->next != nullptr); node = next)
        {
            // The vector cannot be empty because we remove one node per iteration, and have
            // fewer iterations than nodes in the vector.
            assert(!node_vector.empty());
            ListNode* const old_tail = node_vector.back();
            node_vector.pop_back(); // We're about to move old_tail to next

            // The vector cannot be empty for the reasons described above, and because the
            // current node is not the tail. So we must have done less iterations than the
            // number of entries in the vector.
            assert(!node_vector.empty());
            ListNode* const tail = node_vector.back();
            tail->next = nullptr; // Fix the new tail's next pointer. old_tail is now orphaned.

            // Insert the old tail as our next.
            next = node->next;
            node->next = old_tail;
            old_tail->next = next;
        }
    }
};
