package ProjeOdevi;

import java.util.Random;

public class SicaklikOku {


    private Random random = new Random();
    private int sıcaklık;
    private static SicaklikOku instance;

    public SicaklikOku() {

        this.sıcaklık = sıcaklık;
    }

    public static SicaklikOku getInstance() {
        if (instance == null)
            instance = new SicaklikOku();
        return instance;
    }

    public int getSıcaklık() {
        return sıcaklık;
    }



    public void setSıcaklık(int sıcaklık) {
        this.sıcaklık = sıcaklık;
    }


    public int derece() {


        Random derece=new Random();
        this.sıcaklık = derece.nextInt(40);
        return this.sıcaklık;
    }






}