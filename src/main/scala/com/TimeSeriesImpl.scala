package com


import tools.pgconn.{insert, statement}
import org.apache.spark.sql.DataFrame
import tools.SparkCore.spark
import tools.TechTools.SelectTb



object TimeSeriesImpl extends App {


 private val mocktable = "mock_data"
 private val mocktableenri ="enriched_mock_data"



 try {

  SelectTb(mocktable).toDF().join(SelectTb(mocktableenri).toDF())

  println("Joined")

 } catch {
  case e: Exception => println(s"Error occurred: ${e.getMessage}")
 }finally {println("End of block")}


 println("here")


 Seq

}
