class Solution
{
    int prev = -1;
    int minAns = Integer.MAX_VALUE;
    public:
    int absolute_diff(Node root)
    {
        //Your code here
        helper(root);
        return minAns;
    }
    
    void helper(Node root){
        if(root == null){
            return;
        }
        
        solve(root.left);
        if(prev == -1){
            prev = root.data;
        }
        else{
            minAns = Math.min(minAns, root.data - prev);
            prev = root.data;
        }
        
        solve(root.right);
    }

};
