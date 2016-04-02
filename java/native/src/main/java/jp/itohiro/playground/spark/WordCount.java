package jp.itohiro.playground.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class WordCount {
    public static void main(String[] args) {
        String readmeFile = "/Users/hiroshi/tools/spark-1.4.1-bin-hadoop2.6/README.md";
        SparkConf conf = new SparkConf().setAppName("Spark Application");
        JavaSparkContext sc = new JavaSparkContext(conf);
        JavaRDD<String> readmeData = sc.textFile(readmeFile).cache();

        long numAs = readmeData.filter(s -> s.contains("a")).count();
        long numBs = readmeData.filter(s -> s.contains("b")).count();

        System.out.println("Line with a: " + numAs + ", line with b: " + numBs);
    }
}
