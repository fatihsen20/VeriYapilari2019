public class LabBinarySearchTree<T extends Comparable<T>> extends BinarySearchTree<T> {
    public LabBinarySearchTree(){
        //Bu metodu değiştirmeyin
    }
    public LabBinarySearchTree(BTNode<T> root) {
        //Bu metodu değiştirmeyin
        super(root);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        BTNode<T>node=getRoot();
        if (node==null)
            return new LabBinarySearchTree<T>();
        return new LabBinarySearchTree<T>(klonMethod(node));
    }
    private BTNode<T>klonMethod(BTNode<T> node){
        return new BTNode<T>(node.value,node.left!=null?klonMethod(node.left):null,node.right!=null?klonMethod(node.right):null);
    }

    @Override
    public BTNode<T> successor(T value) {
        BTNode<T> node=getRoot();
        if (find(node,value)==null)
            return null;
        if(node==null||node.right==null)
            return null;
        node=node.right;
        while(node.left!=null)
            node=node.left;
        return node;
    }

    @Override
    public BTNode<T> predecessor(T value) {
        BTNode<T> node=getRoot();
        if (find(node,value)==null)
            return null;
        if (node==null||node.left==null)
            return null;
        node=node.left;
        while(node.right!=null)
            node=node.right;
        return node;
    }

    @Override
    public BTNode<T> findParent(BTNode<T> node) {
        BTNode<T> parent=getRoot();
        while (parent!=null&&parent.left!=node&&parent.right!=node){
            if (node.value.compareTo(parent.value)<0)
                parent=parent.left;
            else
                parent=parent.right;
        }

        return parent;
    }


}

