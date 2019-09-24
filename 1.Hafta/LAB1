public class Araba implements Comparable<Araba> {
    public int modelYili;
    public double motorHacmi;
    public String marka;
    public String plaka;

    public Araba(int modelYili, double motorHacmi, String marka, String plaka) {
        this.modelYili = modelYili;
        this.motorHacmi = motorHacmi;
        this.marka = marka;
        this.plaka = plaka;
    }

    @Override
    public int compareTo(Araba o) {
        if (this.modelYili - o.modelYili > 0)
            return -1;
        else if (this.modelYili - o.modelYili == 0)
            return 0;
        else
            return 1;

    }
}
