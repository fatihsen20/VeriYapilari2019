import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;
import java.lang.*;
/**
 * FrekansKarsilastirici sınıfı Huffman ağaçlarını köklerindeki frekans değerlerine göre
 * karşılaştırır.
 */
class FrekansKarsilastirici implements Comparator<HuffmanNode> {

    @Override
    public int compare(HuffmanNode o1, HuffmanNode o2) {
        if (o1.frequency>o2.frequency)
            return 1;
        else if (o1.frequency==o2.frequency)
            return 0;
        else
            return -1;
    }
}

/**
 * AlfabetikKarsilastirici sınıfı Huffman ağaçlarını içlerinde bulunan en küçük karakterlere
 * göre karşılaştırır.
 */   
class AlfabetikKarsilastirici implements Comparator<HuffmanNode> {
    @Override
    public int compare(HuffmanNode o1, HuffmanNode o2) {
            if (travel(o1).compareTo(travel(o2))>0)
                return 1;
            else if(travel(o1).compareTo(travel(o2))==0)
                return 0;
            else
                return -1;
    }
    public Character travel(HuffmanNode o)
    {
        if (o.value!=null)
            return o.value;
        Character sol=travel(o.left);
        Character sag=travel(o.right);
            if (sol!=null&&sag!=null&&sol.compareTo(sag)>0)
                return sag;
            else
                return sol;
    }
}
