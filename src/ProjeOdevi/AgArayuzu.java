package ProjeOdevi;

import java.util.concurrent.TimeUnit;

public class AgArayuzu {

    public SicaklikOku sıcaklık;
    private IMerkeziIslem merkeziIslem;
    SicaklikOku ölcme = new SicaklikOku();
    Eyleyici eyleyici1 = new Eyleyici();
    private int soğutucu_durumu;


    public AgArayuzu(){
        merkeziIslem =new MerkeziIslem();
        soğutucu_durumu=1;
    }


    public int sicaklikGonder(int sıcaklık){


        System.out.println("Mevcut Sıcaklığınız: "+ sıcaklık + " Derecedir.");
        merkeziIslem.KullaniciBilgilendirmeyeGonder(sıcaklık);

        return sıcaklık;
    }

    public int SogutucuAc(int sıcaklık){

        if(soğutucu_durumu==1){
            soğutucu_durumu=2;
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Soğutucu Açıldı ...");

            ölcme.setSıcaklık(eyleyici1.SogutucuAc(sıcaklık));}

        else{
            System.out.println("Soğutucu Zaten Açık!");
            ölcme.setSıcaklık(eyleyici1.SogutucuAc(sıcaklık));
        }

        int yeni_derece = ölcme.getSıcaklık();


        ölcme.setSıcaklık(yeni_derece);

        return yeni_derece;
    }

    public void SogutucuKapat(){
        if (soğutucu_durumu==2) {



            System.out.println("Soğutucu Kapatılıyor...");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Soğutucu Kapatılıdı.");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            soğutucu_durumu--;
        }
        else{
            System.out.println("Soğutucu Zaten Kapalı...");
            System.out.println("Ana Menüye Gidiliyor...");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }




    }

