class Solution {
    public List<Integer> countSmaller(int[] nums) {
        
        LinkedList<Integer> res = new LinkedList<>();
        BST bst = new BST();
        
        for(int i = nums.length - 1; i >= 0; i--){
            res.addFirst(bst.getSmallerNumbers(nums[i]));
            bst.insert(new Node(nums[i]), bst.root);
        }
        return res;
    }   
}


class Node{
    int val;
    int leftSubtreeSize;
    Node left;
    Node right;
    
    Node(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class BST{
    Node root;
    public void insert(Node node, Node root){
        if(root == null){
            this.root = node;
            return;
        }
        
        if(node.val < root.val){
            root.leftSubtreeSize++;
            if(root.left == null)
                root.left = node;
            else
                insert(node, root.left);
        }else{
            if(root.right == null)
                root.right = node;
            else
                insert(node, root.right);
        }
    }
    
    public int getSmallerNumbers(int val){
        
        int cnt = 0;
        Node crawl = root;
        
        while(crawl != null){
            if(crawl.val == val)
                return cnt + crawl.leftSubtreeSize;
            if(crawl.val > val)
                crawl = crawl.left;
            else{
                cnt += crawl.leftSubtreeSize + 1;
                crawl = crawl.right;
            }
        }
        return cnt;
    }
}