package ProjeOdevi;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class AkıllıCihaz {
    public SicaklikOku sıcaklık;
    SicaklikOku ölcme = new SicaklikOku();
    AgArayuzu agArayuzu= new AgArayuzu();


    public void basla () {



       ölcme.derece();


        System.out.println();


        String islem =
                "******************************************\n"
                +"Hangi işlemi yapmak istersiniz:\n"
                +"¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯\n"
                + "1 :---> Sıcaklığa Bak\n"
                + "2 :---> Soğutucuyu Aç\n"
                + "3 :---> Soğutucuyu Kapat\n"
                + "4 :---> Sistemden Çıkış Yap\n"
                +"******************************************";


        int soğutucu_durumu=1;

        while (true) {


            System.out.println(islem);
            Scanner scanner = new Scanner(System.in);
            String secim = scanner.nextLine();
            if (secim.equals("1")) {

                agArayuzu.sicaklikGonder(ölcme.getSıcaklık());
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

            else if   (secim.equals("2")) {

                ölcme.setSıcaklık(agArayuzu.SogutucuAc(ölcme.getSıcaklık()));

            }

            else if (secim.equals("3")){

                agArayuzu.SogutucuKapat();

            }
            else if(secim.equals("4")){

                System.out.println("Sistemden Çıkış Yapılıyor...");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }

            else

                System.out.println("Hatalı Sayı Girişi Tekrar Deneyiniz...");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

}