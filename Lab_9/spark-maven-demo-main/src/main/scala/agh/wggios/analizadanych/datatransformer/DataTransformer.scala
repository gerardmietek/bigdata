package agh.wggios.analizadanych.datatransformer

import agh.wggios.analizadanych
import org.apache.spark.sql.DataFrame
import agh.wggios.analizadanych.{LoggingUtils, SparkSessionProvider}
import org.apache.spark.sql.DataFrame

import java.nio.file.{Files, Paths}
import org.apache.spark.sql.functions._

class DataTransformer extends SparkSessionProvider {

  def transform(df: DataFrame): DataFrame = {
    logInfo("data transformation")

    df.filter(col("some_column").isNotNull)
      .withColumn("length_column", length(col("some_column")))
      .filter(col("length_column") > 5)
      .select("some_column", "length_column")
  }
}