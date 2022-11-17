import reactor.core.publisher.Flux;

public class _1 {
    public static void main(String[] args) {
        Flux<Integer> fluxToTest = Flux.just(1, 2, 3, 4, 5);
        System.out.println(fluxToTest.next().block());
        fluxToTest.toIterable().forEach(System.out::println);
    }
}
