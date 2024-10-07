import org.apache.spark.sql.SparkSession

object Demo extends App{


  val spark: SparkSession = SparkSession.builder().appName("myApp").master("local[*]").getOrCreate()



  val df = spark.read.json("D:/Scala/MOCK_DATA.json")//.option("header", "true")
    //.load("D:/Scala/MOCK_DATA.json")

  val cleanDf = df.filter(df("_corrupt_record").isNull)


    cleanDf.show()


  //println("hey")

  spark.stop()


}
