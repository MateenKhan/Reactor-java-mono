import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class _9 {
    private static long delay = 10000l;
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(asdf());
        long end= System.currentTimeMillis();
        System.out.println(end-start);

    }

    public static String asdf(){
        return Mono.zip(
                        Mono.fromCallable(() -> _9.getString1())
                                .subscribeOn(Schedulers.elastic()),
                        Mono.fromCallable(() -> _9.getString2())
                                .subscribeOn(Schedulers.elastic()),
                        Mono.fromCallable(() -> _9.getString3())
                        .onErrorResume(e->Mono.error( new RuntimeException(e.getCause()+"_5.getString3()")))
                        .subscribeOn(Schedulers.elastic())
                        .map(i->i.toUpperCase()),
                        Mono.fromCallable(() -> _9.getString4())
                                .subscribeOn(Schedulers.elastic()),
                        Mono.fromCallable(() -> _9.getString1())
                                .subscribeOn(Schedulers.elastic()),
                        Mono.fromCallable(() -> _9.getString2())
                                .subscribeOn(Schedulers.elastic()),
                        Mono.fromCallable(() -> _9.getString3())
                                .onErrorResume(e->Mono.error( new RuntimeException(e.getCause()+"_5.getString3()")))
                                .subscribeOn(Schedulers.elastic())
                                .map(i->i.toUpperCase()),
                        Mono.fromCallable(() -> _9.getString4())
                                .subscribeOn(Schedulers.elastic())
                )

                .map(res->res.getT1()+" "+ res.getT4()+" "+ res.getT3()+" "+
                        res.getT4()+" "+ res.getT5()+" "+ res.getT6()+" "+
                        res.getT7()+" "+ res.getT8())
                .onErrorResume(e->Mono.error(new RuntimeException("test2")))
                .block();

    }

    private static String getString1(){
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "1";
    }
    private static String getString2(){
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }return "2";
    }
    private static String getString3(){
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "a3";
//        throw new RuntimeException("asdfasdfasdf");
    }
    private static String getString4(){
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }return "4";
    }


}
