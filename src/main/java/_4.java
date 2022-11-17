import reactor.core.publisher.Mono;

import java.util.Locale;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class _4 {
    public static void main(String[] args) {

        System.out.println(asdf());

    }

    public static String asdf(){
        return Mono.zip(
                        Mono.fromCallable(() -> "Mateen"),
                        Mono.fromCallable(() -> "Ahmed"),
                        Mono.fromCallable(() -> "aa"),
                        Mono.fromCallable(() -> "Khan")
                )
                .map(res->res.getT1()+" "+ res.getT4()+" "+ res.getT3()+" "+ res.getT4())
                .block();

    }


}
