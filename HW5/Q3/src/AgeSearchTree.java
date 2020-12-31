public class AgeSearchTree extends BinarySearchTree<AgeData>{
    private AgeData root;
    public AgeSearchTree(){
        root = null;
    }
    /**
     * Starter method add.
     * pre: The object insert must implement the Comparable interface
     * @param item The object being inserted
     * @return true if the object is inserted, false if the object already exists in the tree
     */
    @Override
    public boolean add(AgeData item) {
        root = add2(root, item);
        return addReturn;
    }
    /**
     * Recursive add method
     * post: the data field addReturn is set true if the item is added to
     * the tree, false if the item is already in the tree
     * but the number of people field of the AgeData object in that node will be increased 1.
     * @param localRoot The local root of the subtree
     * @param item The object to be inserted
     * @return The new local root that now contains the inserted item
     */
    private AgeData add2(AgeData localRoot, AgeData item){
        if(localRoot == null){
            addReturn = true;
            return new AgeData(item.getAge());
        }
        else if(item.compareTo(localRoot) == 0){
            addReturn = false;
            localRoot.setAgeNumber(localRoot.getAgeNumber()+1);
            return localRoot;
        }
        else if(item.compareTo(localRoot) < 0){
            localRoot.left = add2(localRoot.left,item);
            return localRoot;
        }
        else{
            localRoot.right = add2(localRoot.right,item);
            return localRoot;
        }
    }
    /**
     * Starter method delete
     * post: The object is not in the tree
     * @param target The object deleted from the tree
     * @return The object deleted from the tree or null
     * if the object was not in the tree
     */
    @Override
    public AgeData delete(AgeData target) {
        root = delete2(root,target);
        return deleteReturn;
    }
    /**
     * Recursive delete method
     * post: The item is not in the tree;
     * deleteReturn is equal to the deleted item as it was stored int the tree
     * or null if the item was not found.
     * If it exists and the number of people field of this node’s AgeData object is greater than 1,
     * it will decrease the number of people field 1.
     * If the number of people field is 1, it will remove the node.
     * @param localRoot The root current subtree
     * @param item The item to be deleted
     * @return The modified local root that does not contain the item
     */
    private AgeData delete2(AgeData localRoot, AgeData item){
        if(localRoot == null){
            deleteReturn = null;
            return localRoot;
        }
        int compResult = item.compareTo(localRoot);
        if(compResult < 0){
            localRoot.left = delete2(localRoot.left,item);
            return localRoot;
        }
        else if(compResult > 0){
            localRoot.right = delete2(localRoot.right,item);
            return localRoot;
        }
        else{
            if(localRoot.getAgeNumber() == 1){
                deleteReturn = localRoot;
                if(localRoot.left == null){
                    return localRoot.right;
                }
                else if(localRoot.right == null){
                    return localRoot.left;
                }
                else{
                    if(localRoot.left.right == null){
                        localRoot.setAge(localRoot.left.getAge());
                        localRoot.left = localRoot.left.left;
                        return localRoot;
                    }
                    else{
                        localRoot.setAge(findLargestChild(localRoot.left).getAge());
                        return localRoot;
                    }
                }
            }
            else{
                localRoot.setAgeNumber(localRoot.getAgeNumber()-1);
                return localRoot;
            }
        }
    }
    /**
     * Find the node that is the inorder predecessor and replace it
     * with its left child (if any)
     * post: The inorder predecessor is removed from the tree
     * @param parent The parent of possible inorder predecessor (ip)
     * @return The data in the ip
     */
    private AgeData findLargestChild(AgeData parent){
        if(parent.right.right == null){
            AgeData returnValue = parent.right;
            parent.right = parent.right.left;
            return returnValue;
        }
        else
            return findLargestChild(parent.right);
    }
    /**
     * Removes target(if found) from tree and returns true;
     * otherwise, returns false.
     */
    @Override
    public boolean remove(AgeData target) {
        AgeData control = delete(target);
        if(control == null)
            return false;
        else
            return true;
    }
    /**
     * Starter method find.
     * pre: The target object must implement the Comparable interface.
     * @param target The Comparable object being sought
     * @return The object, if found, otherwise null
     */
    @Override
    public AgeData find(AgeData target) {
        return  find2(root,target);
    }
    /**
     * Recursive find method.
     * @param localRoot The local subtree's root
     * @param target The object being sought
     * @return The object, if found, otherwise null
     */
    private AgeData find2(AgeData localRoot, AgeData target){
        if(localRoot == null)
            return null;
        int compResult = target.compareTo(localRoot);
        if(compResult == 0)
            return localRoot;
        else if(compResult < 0)
            return find2(localRoot.left,target);
        else
            return find2(localRoot.right,target);
    }
    /**
     * Perform a preOrder traversal.
     * @param node The local root
     * @param depth The depth
     * @param sb The string buffer to save the output
     */
    private void preOrderTraverse(AgeData node, int depth, StringBuilder sb){
        if(node == null)
            sb.append("null\n");
        else{
            sb.append(node.toString());
            sb.append("\n");
            preOrderTraverse(node.left, depth+1,sb);
            preOrderTraverse(node.right,depth+1,sb);
        }
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        preOrderTraverse(root,1,sb);
        return sb.toString();
    }
    public String youngerThan(int num){
        StringBuilder sb = new StringBuilder();
        younger(sb,root,num);
        return sb.toString();
    }
    /**
     * youngerThan recursive
     */
    private void younger(StringBuilder sb, AgeData node, int num){
        if(node == null)
            return;
        else{
            if(node.getAge() < num){
                sb.append(node.toString());
            }
            younger(sb,node.left,num);
            younger(sb,node.right,num);
        }
    }
    public String olderThan(int num){
        StringBuilder sb = new StringBuilder();
        older(sb,root,num);
        return sb.toString();
    }
    /**
     * olderThan recursive
     */
    private void older(StringBuilder sb, AgeData node, int num){
        if(node == null)
            return;
        else{
            if(num < node.getAge()){
                sb.append(node.toString());
            }
            older(sb,node.right,num);
            older(sb,node.left,num);
        }
    }
}
