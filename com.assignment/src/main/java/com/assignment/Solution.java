package com.assignment;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.broadcast.Broadcast;
import org.apache.spark.util.LongAccumulator;


public class Solution {

	public static void main(String args[])throws Exception
	{

		SparkConf sparkConf = new SparkConf().setAppName("test").setMaster(
				"local");
		JavaSparkContext jsc = new JavaSparkContext(sparkConf);
		JavaRDD<String> custs = jsc
				.textFile("C:\\BigData\\custs");
		JavaRDD<String> txns = jsc
				.textFile("C:\\BigData\\txns");
System.out.println("hello");

		JavaRDD<String> custs1 = custs.flatMap(s -> Arrays.asList(s.split("/n")).iterator());
		JavaRDD<String> txns1 = txns.flatMap(s -> Arrays.asList(s.split("/n")).iterator());

		for(String c:custs1.collect())
		{
			System.out.println(c);
		}

		for(String t:txns.collect())
		{
			System.out.println(t);
		}

	}
}
