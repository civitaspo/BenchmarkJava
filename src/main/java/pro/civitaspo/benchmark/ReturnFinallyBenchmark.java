package pro.civitaspo.benchmark;

import me.geso.nanobench.Benchmark;
import me.geso.nanobench.Benchmark.Bench;

public class ReturnFinallyBenchmark
{
    public static void main(String[] args)
            throws Exception
    {
        new Benchmark(new ReturnFinallyBenchmark())
                .warmup(3)
                .run(100_000_000)
                .timethese()
                .cmpthese();
    }

    private final static String s = "test";

    private String getTest()
    {
        return s;
    }

    private String getFinally()
    {
        long start = System.currentTimeMillis();
        try {
            return getTest();
        }
        finally {
            long l = System.currentTimeMillis() - start;
        }
    }

    private String getUseLocalVal()
    {
        long start = System.currentTimeMillis();
        String test = getTest();
        long l = System.currentTimeMillis() - start;
        return test;
    }

    @Bench
    public void finallySpec()
    {
        getFinally();
    }

    @Bench
    public void useLocalValSpec()
    {
        getUseLocalVal();
    }
}
