public class QuadraticProbeHashing<T> {
    public HashEntry<T>[] dizi;
    public int elemanSayisi;

    public QuadraticProbeHashing() {
        dizi=new HashEntry[23];
    }
    public QuadraticProbeHashing(int boyut){
        dizi=new HashEntry[boyut];
    }
    public int hash(T deger) {
        return deger.hashCode()%dizi.length;
    }

    public void ekle(T eleman){
        int konum=hash(eleman);
        int sayac=0;
        while(1==1){
            if (dizi[ks(konum,sayac)]==null||!dizi[ks(konum,sayac)].isActive) {
                dizi[ks(konum, sayac)] = new HashEntry<>(eleman);
                elemanSayisi++;
                break;
            }
            sayac++;
        }
    }

    public boolean sil(T eleman){
        int konum=hash(eleman);
        int sayac=0;
        while (dizi[ks(konum,sayac)]==null||!dizi[ks(konum,sayac)].isActive||dizi[ks(konum,sayac)].equals(eleman)){
            sayac++;
            if (sayac>dizi.length)
                return false;
        }
        dizi[ks(konum,sayac)].isActive=false;
        elemanSayisi--;
        return true;
    }
    public int ks(int konum,int deger){
        return(konum+(deger*deger))%dizi.length;
    }

}
