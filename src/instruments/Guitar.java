package instruments;

public class Guitar implements Playable {
    @Override
    public void play() {
        System.out.println("Strum strum strum");
        System.out.println("I'm on the highway to hell");
    }
}
