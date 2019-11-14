public class Rotator {
    public static <T> BTNode<T> solaDondur(BTNode<T> k1){
        BTNode<T> f=k1.right;
        k1.right=f.left;
        f.left=k1;
        return f;
    }
    public static <T> BTNode<T> sagaDondur(BTNode<T> k2){
        BTNode<T> f=k2.left;
        k2.left=f.right;
        f.right=k2;
        return f;
    }
    public static <T> BTNode<T> solaSagaDondur(BTNode<T> k3){
        k3.left=solaDondur(k3.left);
        BTNode<T> f=sagaDondur(k3);
        return f;
    }
    public static <T> BTNode<T> sagaSolaDondur(BTNode<T> k1){
        k1.right=sagaDondur(k1.right);
        BTNode<T> f= solaDondur(k1);
        return f;
    }
}