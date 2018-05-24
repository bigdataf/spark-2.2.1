package org.apache.spark.examples.streaming

/**
  *
  * Created by fanwt on 2018/5/4
  *
  */
object ScalaWordCount {

  import org.apache.spark.{SparkConf, SparkContext}

  object SparkWordCount{
    def main(args: Array[String]) {
      if (args.length == 0) {
        System.err.println("Usage: SparkWordCount <inputfile> <outputfile>")
        System.exit(1)
      }

      val conf = new SparkConf().setAppName("SparkWordCount")
      val sc = new SparkContext(conf)

      val file=sc.textFile("file:///hadoopLearning/spark-1.5.1-bin-hadoop2.4/README.md")
      val counts=file.flatMap(line=>line.split(" "))
        .map(word=>(word,1))
        .reduceByKey(_+_)
      counts.saveAsTextFile("file:///hadoopLearning/spark-1.5.1-bin-hadoop2.4/countReslut.txt")

    }
  }

}
