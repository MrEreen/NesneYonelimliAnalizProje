package ProjeOdevi;

public class Kullanicibilgilendirme {

    private ISubject publisher;
    private static Kullanicibilgilendirme instance;

    private Kullanicibilgilendirme(ISubject publisher){
        this.publisher=publisher;
    }

    public static Kullanicibilgilendirme getInstance(ISubject publisher){
        if(instance==null){
            instance=new Kullanicibilgilendirme(publisher);
        }
        return instance;
    }
    public void aboneEkle(IObserver abone){
        publisher.attach(abone);
    }

    public void sicaklikOku(int sicaklik) {
        if(sicaklik<0){
            publisher.notify("Sıcaklık 0 derecenin altında!");
        }
    }
}
