import java.util.ArrayList;
import java.util.List;

public class LabGraph2<T> extends AbstractGraph2<T> {

    @Override
    protected Object clone() throws CloneNotSupportedException {
        AbstractGraph2<T> klon=new LabGraph2<>();
        for(Vertex<T> v:vertices){
            klon.addVertex(v.value);
            for (Edge<T> e:v.edges)
                klon.addEdge(e.from.value,e.to.value,e.weight);
        }
        return klon;
    }

    @Override
    public void removeVertex(T deger) {
        Vertex<T> v=verticesMap.get(deger);
        if (v!=null){
            vertices.remove(v);
            for (Vertex<T>ve:vertices){
                List<Edge<T>> sil=new ArrayList<>();
                for (Edge<T> e:ve.edges){
                    if (e.to.value.equals(deger))
                        sil.add(e);
                }
                ve.edges.removeAll(sil);
            }
        }

    }

    @Override
    public List<T> topologicalSort() {
        ArrayList<T> liste=new ArrayList<>();
        LabGraph2<T> klon= null;
        try {
            klon = (LabGraph2<T>) clone();
            while(klon.vertices.size()>0){
                for (Vertex<T>v:vertices){
                    if (klon.inDegree(v.value)==0){
                        liste.add(v.value);
                        klon.removeVertex(v.value);
                    }
                }
            }
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return liste;
    }
}
