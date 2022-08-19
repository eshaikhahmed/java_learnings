import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalExample {

    public static void main(String[] args) {

         ExecutorService threadPool = Executors.newFixedThreadPool(5);

        for(int i = 1; i<=1000; i++){

            //Processing requests in a pool of 5 threads
            HashMap<String, String> values = new HashMap<>();
            threadPool.submit(() ->{
                //Only threadlocal gets created, number of threads taken , killed from threadpool
                ThreadLocal<Date> threadLocal = ThreadLocal.withInitial(Date::new);

                Date currentDate = threadLocal.get();
                String name = "Welcome "+currentDate.toString();
                System.out.println(name);

            });
        }
    }
}

//1261549383
//1261549384
//1261549400
//1261549381
//1261549382
//1261549387
//1261549388
//1261549386
//1261549392