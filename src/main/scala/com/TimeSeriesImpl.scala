package com


import tools.pgconn.statement
import org.apache.spark.sql.DataFrame
import tools.SparkCore.spark
import tools.TechTools.{DisplayTableData} //getSelectTable}



object TimeSeriesImpl extends App {



 println("v3")
 try {

  val tables = spark.sql("SELECT * FROM test")
  print(tables)

 }catch {

  case error: Exception => error.printStackTrace()
   println("An error occurred: " + error.getMessage)

 } finally {

    println("End of block")

 }


 DisplayTableData("test")

}
