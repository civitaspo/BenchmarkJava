package pro.civitaspo.benchmark;

import me.geso.nanobench.Benchmark;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MapContainsKeyOrNullBenchmark
{
    public static void main(String[] args)
            throws Exception
    {
        new Benchmark(new MapContainsKeyOrNullBenchmark())
                .warmup(3)
                .runByTime(10)
                .timethese()
                .cmpthese();
    }

    private final static Map<Long, String> m = new HashMap<>();
    static {
        int i = 0;
        long range = 100_000_000;
        Random r = new Random();

        while (true) {
            i++;
            long n = (long)(r.nextDouble()*range);
            m.put(n, "test");

            if (i > 10_000_000) {
                break;
            }
        }
    }



    @Benchmark.Bench
    public void NullCheck()
    {
        int i = 0;
        while (true) {
            i++;

            if (m.get(i) == null) {
            }

            if (i > 10_000_000) {
                break;
            }
        }

    }

    @Benchmark.Bench
    public void ContainsKey()
    {
        int i = 0;
        while (true) {
            i++;

            if (m.containsKey(i)) {
            }

            if (i > 10_000_000) {
                break;
            }
        }
    }
}
