import org.reactivestreams.Subscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class MonoDemo {
    public static void mains(String[] args) {
//        Mono.zip(
//        Mono.fromCallable((a,b) -> a+b)
//                .subscribeOn(Schedulers.boundedElastic())
//                .switchIfEmpty(Mono.error(new RuntimeException("error empty")))
//                .onErrorResume(e->Mono.error(new RuntimeException("error resume")))
//        )
//                .map(res-> System.out.println(res))
//                .onErrorResume(e->Mono.error(new RuntimeException("error 2 resume")))
//                .flatMap(r->Mono.just(1))
//                .onErrorResume(e->Mono.error(new RuntimeException("error 3 resume")))
//                .block();
            Flux<String> cities = Flux.just("New York", "London", "Paris", "Amsterdam")
                        .subscribeOn(Schedulers.boundedElastic())
                        .map(String::toUpperCase)
                        .filter(cityName -> cityName.length() <= 8)
                        .map(cityName -> cityName.concat(" City"))
                        .doOnComplete(System.out::println)
                        .log();

            cities.subscribe();
            System.out.println(cities);


    }
    public static void main(String[] args) {

        Flux.just("New York", "London", "Paris", "Amsterdam")
                .subscribeOn(Schedulers.boundedElastic())
                .map(MonoDemo::stringToUpperCase)
                .map(MonoDemo::concat)
                .subscribe()
                ;
    }

    private static String stringToUpperCase(String name) {
        System.out.println("stringToUpperCase: " + Thread.currentThread().getName());
        return name.toUpperCase();
    }

    private static String concat(String name) {
        System.out.println("concat: " + Thread.currentThread().getName());
        return name.concat(" City");
    }
}
