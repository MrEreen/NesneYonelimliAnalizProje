package ProjeOdevi;

public class Abone2 implements IObserver {

    @Override
    public void update(String message) {
        System.out.println("Abone2'e gelen mesaj = "+message);
    }
}
