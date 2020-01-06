import java.util.ArrayList;
import java.util.Collections;
public class Odev4Graph<T> extends Odev4AbstractGraph<T> {
    /**
     * Mevcut çizgenin komşuluk matrisini hesaplayıp geri döndürür
     *
     * @return Komşuluk matrisi(iki boyutlu tamsayı dizisi)
     */
    @Override
    public int[][] adjacencyMatrix() {
        int[][]  adjMatrix = new int[vertices.size()][vertices.size()];
        for (int i = 0; i <adjMatrix.length ; i++) {
            for (int j = 0; j <adjMatrix.length ; j++) {
                Vertex<T> f=vertices.get(i);
                for (int k = 0; k <f.edges.size() ; k++) {
                    if (f.edges.get(k).to==vertices.get(j))
                        adjMatrix[i][j]=1;
                } 
                
            }
        }
        return adjMatrix;
    }

        /**
         * Mevcut çizgenin parametre olarak gönderilen çizge ile eşit olup
         * olmadığını döndürür. İki çizgenin birbirine eşit olması için düğümlerin
         * (vertex) referansları farklı olsa bile değerlerinin eşit olması ve de
         * tüm kenarların her iki çizgede de aynı düğümler arasında olması gerekir
         * @param g2 Eşitlik kontrolü için gönderilen çizge parametresi
         * @return Eşit için true aksi halde false döner
         */
        @Override
    public boolean equals (Odev4AbstractGraph < T > g2) {
        int sayac=0;
        ArrayList<T> c1=new ArrayList<>();
        ArrayList<T> c2=new ArrayList<>();
        if (vertices.size()==g2.vertices.size()){
            for (Vertex<T> v:vertices)
                for (Edge<T> e:v.edges)
                    c1.add(e.to.value);
            for (Vertex<T> v:g2.vertices)
                for (Edge<T> e:v.edges)
                    c2.add(e.to.value);
            Collections.sort((ArrayList)c1);
            Collections.sort((ArrayList)c2);
            if(c1.size()==c2.size())
                for (int i = 0; i <c1.size() ; i++) {
                    if (c1.get(i)==c2.get(i))
                      sayac++;
                }
            }
        if (sayac!=0&&sayac==c1.size())
            return true;
        else return false;
            }
        }
