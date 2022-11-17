import reactor.core.publisher.Mono;

public class _5 {
    public static void main(String[] args) {

        System.out.println(asdf());

    }

    public static String asdf(){
        return Mono.zip(
                        Mono.fromCallable(() -> _5.getString1())
                        .doOnError(System.out::println),
                        Mono.fromCallable(() -> _5.getString2())
                                .doOnError(System.out::println),
                        Mono.fromCallable(() -> _5.getString3())
//                                .onErrorReturn(null)
//                                .onErrorReturn("aaaaaaaaaaaaaaaa")
                                .onErrorResume(e->Mono.error( new RuntimeException(e.getCause()+"_5.getString3()")))
                                .doOnError(System.out::println),
                        Mono.fromCallable(() -> _5.getString4())
                                .doOnError(System.out::println)
                )

                .map(res->res.getT1()+" "+ res.getT4()+" "+ res.getT3()+" "+
                        res.size())

                .onErrorReturn("test444444444")
                .switchIfEmpty(Mono.just("test5555555"))

//                .onErrorResume(e->Mono.error(new RuntimeException("test2")))
//                .onErrorContinue((e,res)->Mono.error(new RuntimeException("test3")))
                .block();

    }

    private static String getString1(){
        return "1";
    }
    private static String getString2(){
        return "2";
    }
    private static String getString3(){
        throw new RuntimeException("getString3()");
    }
    private static String getString4(){
        return "4";
    }


}
