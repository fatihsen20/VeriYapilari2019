import java.util.*;

public class LabGraph3<T extends Comparable<T>> extends AbstractGraph3<T> {
    @Override
    public List<T> dfs(T baslangic) {
        List<T> doner =new ArrayList<>();
        Stack<T> s=new Stack<>();
        HashSet<T> visited =new HashSet<>();
        s.push(baslangic);
        while(!s.isEmpty()){
            T eleman=s.pop();
            if (visited.contains(eleman))
                continue;
            doner.add(eleman);
            visited.add(eleman);
            List<Edge<T>> v=verticesMap.get(eleman).edges;
            List<T> komsular=new ArrayList<>();
            for (Edge<T> a:v){
                if (!visited.contains(a))
                    komsular.add(a.to.value);
            }
            Collections.sort(komsular);
            Collections.reverse(komsular);
            for (T c:komsular)
                s.push(c);

        }
        return doner;
    }
    
    @Override
    public List<T> bfs(T baslangic) {
        List<T> doner=new ArrayList<>();
        ArrayDeque<T> f=new ArrayDeque<>();
        HashSet<T> visited =new HashSet<>();
        f.add(baslangic);
        while(!(f.isEmpty())){
            T eleman=f.remove();
            if (visited.contains(eleman))
                continue;
            visited.add(eleman);
            doner.add(eleman);
            List<Edge<T>> v=verticesMap.get(eleman).edges;
            List<T> komsular=new ArrayList<>();

            for(Edge<T> a:v){
                if (!visited.contains(a))
                    komsular.add(a.to.value);

            }
            Collections.sort(komsular);
            for (T c:komsular)
                f.add(c);
        }
        return doner;

    }
}
