package org.linulun;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.runner.*;
import org.openjdk.jmh.runner.options.*;

import java.io.PrintStream;
import java.util.*;
import java.io.*;
import org.openjdk.jmh.results.*;
import org.openjdk.jmh.results.format.*;

public class ExampleJMH {

    @Benchmark
    @BenchmarkMode(Mode.SingleShotTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void measureSingleShot() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(100);
    }

    @Benchmark
    @BenchmarkMode(Mode.SingleShotTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void measureSingleShot2() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(200);
    }

    public static void main(String[] args) throws Exception{

         
        Options opt = new OptionsBuilder().include(ExampleJMH.class.getSimpleName()).forks(1).verbosity(VerboseMode.SILENT).build();

        Collection<RunResult> result = new Runner(opt).run();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);

        ResultFormat resultFormat = ResultFormatFactory.getInstance(ResultFormatType.JSON, printStream);
        resultFormat.writeOut(result);

        
        String output = outputStream.toString("UTF8");
    }

}