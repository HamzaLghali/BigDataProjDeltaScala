package com

import tools.TechTools.SelectTb

object TimeSeriesImpl extends App {

 private val mocktable = "mock_data"
 private val mocktableenri = "enriched_mock_data"

 try {
  // Fetching DataFrames from tables
  println("Fetching mocktable DataFrame...")
  val j1 = SelectTb(mocktable).toDF()
  println("Fetching mocktableenri DataFrame...")
  val j2 = SelectTb(mocktableenri).toDF()

  // Check schemas
  println("Schema of mocktable DataFrame:")
  j1.printSchema()

  println("Schema of mocktableenri DataFrame:")
  j2.printSchema()

  // Perform the join operation
  println("Performing join on 'id' columns...")
  val JoinedDF = j1.join(j2, j1("id") === j2("id"))

  // Show result
  println("Joined DataFrame:")
  JoinedDF.show()

 } catch {
  case e: Exception =>
   println(s"Error occurred: ${e.getMessage}")
   e.printStackTrace()
 } finally {
  println("End of block")
 }

 println("here")
}
