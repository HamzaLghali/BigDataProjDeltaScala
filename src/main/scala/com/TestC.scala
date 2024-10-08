package com

import tools.SparkCore.spark
import tools.pgconn.{connection, statement}
import org.apache.spark.sql.DataFrame
import tools.TechTools.SelectTb

object TestC extends App {


  println("nothing in TestC")


  SelectTb("test", "scala")

}
