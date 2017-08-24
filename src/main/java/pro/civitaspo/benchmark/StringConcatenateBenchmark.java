package pro.civitaspo.benchmark;

import me.geso.nanobench.Benchmark;

import java.util.StringJoiner;

import static me.geso.nanobench.Benchmark.*;

public class StringConcatenateBenchmark
{
    public static void main(String[] args)
            throws Exception
    {
        new Benchmark(new StringConcatenateBenchmark())
                .warmup(3)
                .run(100_000_000)
                .timethese()
                .cmpthese();
    }

    private final static String str1 = "str1";
    private final static String str2 = "str2";

    @Bench
    public void Plus()
    {
        String s = str1 + str2;
    }

    @Bench
    public void StringBuilder()
    {
        String s = new StringBuilder(str1).append(str2).toString();
    }

    @Bench
    public void StringJoin()
    {
        String s = new StringJoiner(str1).add(str2).toString();
    }

    @Bench
    public void Concat()
    {
        String s = str1.concat(str2);
    }
}
