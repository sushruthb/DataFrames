package com.mycompany



import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.log4j._

object AddGenderType {
  
  def main(args:Array[String]){
    
    Logger.getLogger("org").setLevel(Level.ERROR)
    
    val spark=SparkSession.builder().appName("AddGender").master("local[*]").getOrCreate()
    
    val df=spark.read.option("header", "true").option("inferSchema", "true").csv("./src/main/resources/dataset.csv")
    
    df.show()
    
    import spark.implicits._
    
    val df1=df.select($"id",$"name",$"gender")
    
    val maleDf = df.withColumn("male",when(df("gender")==="Male",1).otherwise(0))
    
     val femaleDf = maleDf.withColumn("female",when(df("gender")==="Female",1).otherwise(0))
    
    femaleDf.show()
    
    spark.close()
  }
  
}