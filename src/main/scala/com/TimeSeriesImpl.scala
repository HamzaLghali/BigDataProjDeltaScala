package com


import tools.pgconn.statement
import org.apache.spark.sql.DataFrame
import tools.SparkCore.spark
import tools.TechTools.{DisplayTableData} //getSelectTable}



object TimeSeriesImpl extends App {



 val tb_mock : String = "mock_data"


 //def SelectTable : DataFrame  = getSelectTable(tb_mock)
 println("v3")
 //DisplayTableData(tb_mock)
 try {
//
//    val simpleSelect = spark.sql(s"SELECT * FROM public.employees")
//    simpleSelect.show()


  val tables = spark.sql("SELECT column_name FROM information_schema.columns WHERE table_name   = 'test'")
  tables.show()

 }catch {

  case error: Exception =>
   error.printStackTrace()
   println("An error occurred: " + error.getMessage)

 } finally {

    println("v4")

 }


}
