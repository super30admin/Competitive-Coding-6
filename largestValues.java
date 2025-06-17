// Time Complexity :O(n);
// Space Complexity:O(n);

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer>result=new ArrayList<>();
        if(root==null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            int Max=Integer.MIN_VALUE;
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                Max=Math.max(Max,node.val);
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
            result.add(Max);
        }
        return result;

        
    }
}