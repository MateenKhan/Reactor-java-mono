import reactor.core.publisher.Mono;

public class _8 {
    public static void main(String[] args) {

        System.out.println(asdf());

    }

    public static String asdf(){
        return Mono.zip(
                        Mono.fromCallable(() -> _8.getString1())
                        .doOnError(System.out::println),
                        Mono.fromCallable(() -> _8.getString2())
                                .doOnError(System.out::println),
                        Mono.fromCallable(() -> _8.getString3())
                                .onErrorResume(e->Mono.error( new RuntimeException(e.getCause()+"_5.getString3()")))
                                .map(i->i.toUpperCase()),
                        Mono.fromCallable(() -> _8.getString4())
                                .doOnError(System.out::println)
                )

                .map(res->res.getT1()+" "+ res.getT4()+" "+ res.getT3()+" "+
                        res.size())

//                .onErrorReturn("test444444444")
                .switchIfEmpty(Mono.just("test5555555"))

//                .onErrorResume(e->Mono.error(new RuntimeException("test2")))
                .onErrorContinue((e,res)->Mono.error(new RuntimeException("test3")))
                .block();

    }

    private static String getString1(){
        return "1";
    }
    private static String getString2(){
        return "2";
    }
    private static String getString3(){
//        return "a3";
        throw new RuntimeException("asdfasdfasdf");
    }
    private static String getString4(){
        return "4";
    }


}
