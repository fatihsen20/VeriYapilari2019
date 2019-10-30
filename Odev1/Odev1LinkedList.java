import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections;
public class Odev1LinkedList<T extends Comparable<T>> extends AbstractLinkedList<T> {
    /**
     * Bir listede elemanları uygun konuma ekler. Boş bir listeye elemanlar eklendikten
     * sonra küçükten büyüğe sıralı olur
     * @param value eklenecek değer
     */
    @Override
    public void insertInOrder(T value) {
       Node newnode = new Node<T>(value, null);
        if (head == null) {
            head = newnode;
            newnode.next = null;
            return;
        }
        Node<T> ilk = head;
        if (ilk.value.compareTo((T) newnode.value) > 0) {
            newnode.next = ilk;
            head = newnode;
            return;
        }
        if (ilk.value.compareTo((T) newnode.value) < 0 && ilk.next == null) {
            ilk.next = newnode;
            newnode.next = null;
            return;
        }

        Node<T> son = head.next;
        if (ilk.value.compareTo((T) newnode.value) < 0 && son.value.compareTo((T) newnode.value) > 0) {
            ilk.next = newnode;
            newnode.next = son;
            return;
        }
        if (son.value.compareTo((T) newnode.value) < 0) {
            while (son.value.compareTo(value) < 0 && son.next != null) {
                son = son.next;
                ilk = ilk.next;
            }
            if (son.value.compareTo(value) < 0 && son.next == null) {
                son.next = newnode;
                son = son.next;
                ilk = ilk.next;
            } else {
                ilk.next = newnode;
                newnode.next = son;
            }
        }
    }
    /**
     * Mevcut listeyi değiştirmeden, elemanların sırası ters çevrilmiş halde geri döndürür.
     * @return Ters çevrilmiş liste
     */
    @Override
    public AbstractLinkedList<T> reverse() {
        Node<T> newnode=new Node<T>(getHead().value,getHead());
        newnode=getHead();
        if (newnode==null)
            return null;
        else {
            ArrayList<T> deger = new ArrayList<T>();
            int i=0;
            while (newnode != null) {
                deger.add(i, newnode.value);
                newnode=newnode.next;
                i++;
            }
            AbstractLinkedList<T> newobj=new Odev1LinkedList<T> ();
            for (int j = 0; j <deger.size() ; j++) {
                T x=deger.get(j);
                newobj.addFirst(x);
            }

        return newobj;
        }
    }

    /**
     * Mevcut liste ile parametre olarak gelen listeyi birleştirip geriye döndürür.
     * Mevcut listede değişiklik yapılmaz.
     * @param list Mevcut listenin sonuna eklenecek liste
     * @return Birleşmiş liste
     */
    @Override
    public AbstractLinkedList<T> concatenate(AbstractLinkedList<T> list) {
        Node<T> node=new Node<T>(getHead().value,getHead());
        node=getHead();
        Node<T> node2=list.getHead();
        AbstractLinkedList<T> newlist2=new Odev1LinkedList<>();
        if (node==null && node2==null)
                return null;
        else{
            ArrayList<T> degerler1=new ArrayList<>();
            ArrayList<T> degerler2=new ArrayList<>();
            int i=0;
            while(node!=null){
                degerler1.add(i,node.value);
                node=node.next;
                i++;
            }
            
            for (int j = 0; j <degerler1.size() ; j++) {
                T x=degerler1.get(j);
                newlist2.addLast(x);
            }
            int k=0;
            while(node2!=null){
                degerler2.add(k,node2.value);
                node2=node2.next;
                k++;
            }
            
            for (int j = 0; j <degerler2.size() ; j++) {
                T x=degerler2.get(j);
                newlist2.addLast(x);
            }
        }
        return newlist2 ;
    }

}

