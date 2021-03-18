package datastructure;



import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class StackOperationsTest {

    @Test
    public void runBenchmarks() throws Exception {
        Options opts = new OptionsBuilder()
                .include("\\." + this.getClass().getSimpleName() + "\\.")
                .warmupIterations(3)
                .measurementIterations(3)
                .shouldDoGC(true)
                .shouldFailOnError(true)
                .build();

        new Runner(opts).run();
    }

    @Benchmark
    @Test
    public void benchmarkForDynamicArrayStackImpl(Parameters parameters) {
        int size = Integer.parseInt(parameters.batchSize);
        DynamicArrayStackImpl stack = new DynamicArrayStackImpl(size);
        for (int i = 0; i < size; i++) {
            stack.push(String.valueOf(i));
        }
        for (int i = 0; i < size; i++) {
            stack.pop();
        }
    }

    @Benchmark
    @Test
    public void benchmarkForLinkedListStackImpl(Parameters parameters) {
        int size = Integer.parseInt(parameters.batchSize);
        DynamicLinkedListStackImpl stack = new DynamicLinkedListStackImpl();
        for (int i = 0; i < size; i++) {
            stack.push(String.valueOf(i));
        }
        for (int i = 0; i < size; i++) {
            stack.pop();
        }
    }

    @State(value = Scope.Benchmark)
    public static class Parameters {
        @Param({"1", "50", "1000"})
        String batchSize;
    }
}
