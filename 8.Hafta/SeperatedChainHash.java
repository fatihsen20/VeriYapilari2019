import java.util.LinkedList;

public class SeperatedChainHash {
    public LinkedList<Integer>[] dizi;

    public SeperatedChainHash() {
        //içerği değiştirmeyin
        dizi=new LinkedList[23];
    }
    public SeperatedChainHash(int boyut) {
        //içerği değiştirmeyin
        dizi=new LinkedList[boyut];
    }
    public int hash(int deger){
        //içerği değiştirmeyin
        return deger%dizi.length;
    }
    public void ekle(int deger){
        int konum=hash(deger);
        if (dizi[konum]==null)
            dizi[konum]=new LinkedList<>();
        dizi[konum].add(deger);

    }
    public boolean sil(int deger){
        int konum=hash(deger);
        if (dizi[konum]==null)
            return false;
        if (dizi[konum].contains(deger)){
            dizi[konum].remove(dizi[konum].indexOf(deger));
            return true;
        }

        return false;
    }
    public void yenidenOzetle() {
        int boyut=gelecek_asal(dizi.length*2);
        LinkedList<Integer>[] eskitablo=dizi;
        dizi=new LinkedList[boyut];
        for(LinkedList<Integer>x:eskitablo){
            if(x!=null)
                for (int i:x){
                    ekle(i);
                }
        }

    }
    private boolean asal(int indis){
        for (int i = 2; i <=Math.sqrt(indis)+1; i++) {
            if (indis%i==0)
                return false;
        }
        return true;
    }
    private int gelecek_asal(int indis){
        while (!asal(indis))
            indis++;
        return indis;
    }
}
