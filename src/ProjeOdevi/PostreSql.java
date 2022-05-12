package ProjeOdevi;

import java.sql.*;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.Connection;
import java.util.concurrent.TimeUnit;

public class PostreSql {

    static boolean baslat() {
        try {
            /***** Bağlantı kurulumu *****/
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/kullanicilar", "postgres", "123456");
            if (conn == null)
                System.out.println("Bağlantı girişimi başarısız!");

            Scanner klavye = new Scanner(System.in);
            int giris_hakkı =3;
            while (giris_hakkı!=0) {
                System.out.print("Kullanıcı Adınızı Giriniz: ");
                String kullaniciAdi = klavye.nextLine();

                String sql = "SELECT *  FROM \"kullanici\" WHERE kullaniciadi='" + kullaniciAdi + "'";
                /***** Sorgu çalıştırma *****/
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                /***** Bağlantı sonlandırma *****/


                if (rs.next() == false) {
                     {
                    System.out.println("Böyle Bir Kullanıcı Adı Bulunamadı.Tekrar Deneyiniz.");

                    giris_hakkı-=1;
                         System.out.println("Kalan Giriş Hakkınız: "+ giris_hakkı);
                         if (giris_hakkı==0){
                             System.out.println("Giriş Hakkınız Kalmadı Çıkış Yapılıyor...");
                             return false;
                         }

                     }
                }

                else  {
                    System.out.print("Şifre Giriniz:");
                    String sifre = klavye.nextLine();
                    String kullaniciSifre = rs.getString("sifre");
                    if (sifre.equals(kullaniciSifre)) {
                        System.out.println("Kullanıcı Doğrulandı.");
                        System.out.println("Sisteme Giriş Yapılıyor...");
                        giris_hakkı=0;

                        try {
                            TimeUnit.SECONDS.sleep(2);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    else{
                        giris_hakkı--;
                        System.out.println("Kalan Giriş Hakkınız: "+ giris_hakkı);
                        if(giris_hakkı==0){
                            return false;
                        }
                    }
                }

            }

            conn.close();

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

}
