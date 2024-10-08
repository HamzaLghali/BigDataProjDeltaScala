package DeltaPostgres


  import org.apache.spark.sql.{Row, SaveMode, SparkSession}
  import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}
  import io.delta.tables._

  object DeltaTb extends App {


    val spark: SparkSession = SparkSession.builder().appName("myApp").master("local[*]").getOrCreate()


    val data = Seq(Row(1, "Aloneguid"), Row(2, "Blogging"))

      val schema = StructType(Seq(
        StructField("id", IntegerType),
        StructField("subject", StringType)))

      val df = spark
        .createDataFrame(
          spark.sparkContext.parallelize(data),
          schema)

      df.write.format("delta").mode(SaveMode.Overwrite).save("D:/delta.test")

      df.show()

  }