package ink.zfei.lambda;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

@Service
public class parallelDemo {

    public void  main(String[] args) {

        List<Long> list =  Stream.iterate(1L, i->i*2).limit(10).collect(Collectors.toList());

//        long t1 = System.currentTimeMillis();
//        long result =  Stream.iterate(1L, i->i+1).limit(10000000).reduce(0L,Long::sum);
//        long result1 = LongStream.rangeClosed(1, 10000000000L).parallel().reduce(0L,Long::sum);
//        long t2 = System.currentTimeMillis();
//        System.out.println("result="+result1+",time="+(t2-t1));

//       System.out.println(list);
        long t1 = System.currentTimeMillis();
        System.out.println(sideEffectParallelSum(10000));
        long t2 = System.currentTimeMillis();
        System.out.println(t2-t1);


    }

    public static long sideEffectSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n).forEach(accumulator::add);
        return accumulator.total;
    }

    public static class Accumulator {
        public long total = 0;

        public void add(long value) {
            total += value;
        }
    }

    @Transactional
    public  long sideEffectParallelSum(long n) {

        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n).forEach(accumulator::add);
        return accumulator.total;
    }

}
