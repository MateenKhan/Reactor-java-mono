import reactor.core.publisher.Mono;

public class _3 {
    public static void main(String[] args) {

        Object m = Mono.fromCallable(() -> "Mateen").block();

        System.out.println(m);
    }


}
