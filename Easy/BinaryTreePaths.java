class Solution {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        dfs(root, "", paths);
        return paths;
    }
    
    private void dfs(TreeNode root, String path, List<String> paths){
        if(root == null)
            return;
        
        if(root.right == null && root.left == null){
            String newPath = path + root.val;
            paths.add(newPath);
            return;
        }
        
        dfs(root.left, path + root.val + "->", paths);
        dfs(root.right, path + root.val + "->", paths);
    }
}