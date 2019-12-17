public class LabGraph<T> extends AbstractGraph<T> {

    @Override
    public int outDegree(T deger) {
        Vertex<T> fuzzy=verticesMap.get(deger);
        if (fuzzy==null)
            return -1;
        return fuzzy.edges.size();
    }

    @Override
    public int inDegree(T deger) {
        Vertex<T> fuzzy = verticesMap.get(deger);
        if (fuzzy == null)
            return -1;
        int sayac = 0;
        for (Vertex<T> v : vertices) {
            for (int i = 0; i < v.edges.size(); i++) {
                Edge<T> e = v.edges.get(i);
                if (e.to.value.equals(deger))
                    sayac++;
            }
        }
        return sayac;
    }
}
