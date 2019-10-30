public class LabDoublyLinkedList<T> extends DoublyLinkedList<T> {
    /**
     * Çift bağlı listenin istenilen konumuna eleman ekler
     * @param index konum
     * @param value eklenecek eleman
     */
    @Override
    public void insertAt(int index, T value) {
        if(index==0)
            addFirst(value);
        else if(index==size())
            addLast(value);
        else{
            Node<T> node=getHead();
            int i=0;
            for(T deger:this){
                node=node.next;
                if (++i==index)
                    break;
            }
            Node<T> newNode=new Node<T>(value,node,node.previous);
            node.previous.next=newNode;
            if (node.next!=null)
                node.next.previous=newNode;
            setSize(size()+1);
            
        }

    }

    /**
     * Verilen konumdaki elemanı siler
     * @param index silinecek elemanın konumu
     * @return silinen değer
     */
    @Override
    public T removeAt(int index) {
        if (index==0)
            return removeFirst();
        else if (index==size()-1)
            return removeLast();
        else{
            Node<T> node=getHead();
            int i=0;
            for (T deger:this){
                node=node.next;
                if (++i==index)
                    break;
            }
            T sDeger=node.value;
            node.previous.next=node.next;
            if (node.next!=null)
                node.next.previous=node.previous;
            setSize(size()-1);
            return sDeger;
            
        }
        
    }
}

