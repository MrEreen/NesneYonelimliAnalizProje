package ProjeOdevi;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Eyleyici{


    public int SogutucuAc(int sicaklik) {
        int mevcut_sicaklik = sicaklik;
        while(true) {
            int istek;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Mevcut Sıcaklık: " + sicaklik + " Derece");
            System.out.print("Kaç Derece Olmasını İstersiniz?: ");
            istek = scanner.nextInt();

            if (sicaklik < istek) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Mevcut Sıcaklık İstenilen Sıcaklığın Zaten Altında...");
                continue;
            }
            else{
                mevcut_sicaklik=istek;
                System.out.println("Sıcaklık İstenilen Dereceye Düşürülüyor...");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Yeni Sıcaklık Derecesi:" + mevcut_sicaklik);


                sicaklik=mevcut_sicaklik;
                break;
            }

        }

        return sicaklik;
    }

}

