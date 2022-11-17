import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class _2 {
    public static void main(String[] args) {
        Mono temp = Mono.just(1);
        System.out.println(temp.block());
        Mono temp2 = Mono.just(2);
        System.out.println(temp2.block());
    }
}
