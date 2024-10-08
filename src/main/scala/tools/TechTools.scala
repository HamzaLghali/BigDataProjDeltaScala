package tools

import org.apache.spark.sql.DataFrame
import tools.SparkCore.spark
import tools.pgconn.{statement,connection}
import java.sql.{ResultSet}






object TechTools {


  def DisplayTableData(tableName: String): Unit = {
    try {
      if (tableName == null || tableName.isEmpty) {
        throw new IllegalArgumentException("Table name cannot be null or empty")
      }

      val query = s"SELECT * FROM $tableName"
      println(s"Executing query: $query")

      val resultSet: ResultSet = statement.executeQuery(query)

      while (resultSet.next()) {
        val columnCount = resultSet.getMetaData.getColumnCount
        for (i <- 1 to columnCount) {
          print(resultSet.getString(i) + "\t")
        }
        println()
      }
    } catch {
      case error: Exception =>
        error.printStackTrace()
        println("An error occurred: " + error.getMessage)
    } finally {
      println("Finally block executed")
    }
  }




}
