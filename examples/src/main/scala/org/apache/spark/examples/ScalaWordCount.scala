package org.apache.spark.examples

import org.apache.spark.{SparkConf, SparkContext}
/**
  *
  * Created by fanwt on 2018/5/4
  *
  */

  object ScalaWordCount{

    def main(args: Array[String]) {
//      if (args.length == 0) {
//        System.err.println("Usage: SparkWordCount <inputfile> <outputfile>")
//        System.exit(1)
//      }

      val conf = new SparkConf().setAppName("SparkWordCount").setMaster("local")
      val sc = new SparkContext(conf)

      val file=sc.textFile("spark-2.2.1/examples/src/main/resources/people.txt")
      val counts=file.flatMap(line=>line.split(" "))
        .map(word=>(word,1))
        .reduceByKey(_+_)

      counts.saveAsTextFile("spark-2.2.1/examples/src/main/resources/wordcount_result")
      counts.foreach(print(_))
    }
}
