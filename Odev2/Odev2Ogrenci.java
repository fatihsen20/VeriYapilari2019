public class Odev2Ogrenci {
    /**
     * isBST metodu kökü verilen herhangi bir ağacın ikili arama ağacı olup
     * olmadığını hesaplar
     *
     * @param node Kök düğüm
     * @param <T>  karşılaştırılabilir generic tür
     * @return ikili arama ağacı mı değil mi
     */
    public static <T extends Comparable<T>> boolean isBST(BTNode<T> node) {
        if (node==null)
            return true;
        //düğümün solu düğümden daha büyükse false döndür.
        if (node.left!=null && node.value.compareTo(node.left.value) <= 0)
            return false;
        //düğümün sağı düğümden daha küçükse false döndür.
        if (node.right != null && node.value.compareTo(node.right.value) >= 0)
            return false;
        //fazladan while ve if kullanmamak için recursive method kullandım.
        if (!isBST(node.left) || !isBST(node.right))
            return false;
        return true;
    }
}
