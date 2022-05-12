package ProjeOdevi;

public class MerkeziIslem implements IMerkeziIslem {

    private Kullanicibilgilendirme kullanicibilgilendirme;

    public MerkeziIslem(){
        kullanicibilgilendirme=Kullanicibilgilendirme.getInstance(new Publisher());
        kullanicibilgilendirme.aboneEkle(new Abone1());
        kullanicibilgilendirme.aboneEkle(new Abone2());
    }

    public void KullaniciBilgilendirmeyeGonder(int sicaklik) {kullanicibilgilendirme.sicaklikOku(sicaklik);
    }

}
