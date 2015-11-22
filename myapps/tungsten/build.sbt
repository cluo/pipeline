val globalSettings = Seq(
  version := "1.0",
  scalaVersion := sys.env("SCALA_VERSION") 
)

addSbtPlugin("com.eed3si9n" % "sbt-assembly" % sys.env("SBT_ASSEMBLY_PLUGIN_VERSION"))

lazy val tungsten = (project in file("tungsten"))
                    .settings(name := "tungsten")
                    .settings(globalSettings:_*)
                    .settings(libraryDependencies ++= tungstenDeps)

val akkaVersion = sys.env("AKKA_VERSION") // 2.3.11
val sparkVersion = sys.env("SPARK_VERSION") // 1.5.1
val sparkCassandraConnectorVersion = sys.env("SPARK_CASSANDRA_CONNECTOR_VERSION") // 1.4.0
val sparkElasticSearchConnectorVersion = sys.env("SPARK_ELASTICSEARCH_CONNECTOR_VERSION") // 2.1.2
val kafkaVersion = sys.env("KAFKA_CLIENT_VERSION") // 0.8.2.2
val scalaTestVersion = sys.env("SCALATEST_VERSION") // 2.2.4
val jedisVersion = sys.env("JEDIS_VERSION") // 2.7.3 
val sparkCsvVersion = sys.env("SPARK_CSV_CONNECTOR_VERSION") // 1.2.0
val sparkAvroVersion = sys.env("SPARK_AVRO_CONNECTOR_VERSION") // 2.0.1
val algebirdVersion = sys.env("ALGEBIRD_VERSION") // 0.11.0
val coreNlpVersion = sys.env("STANFORD_CORENLP_VERSION") //3.5.2

lazy val tungstenDeps = Seq(
  "org.scalatest" %% "scalatest" % scalaTestVersion % "test",
  "org.apache.spark"  %% "spark-core" % sparkVersion
    exclude("commons-collections", "commons-collections")
    exclude("commons-beanutils", "commons-beanutils")
    exclude("org.apache.hadoop", "hadoop-yarn-api")
    exclude("org.apache.hadoop", "hadoop-yarn-common")
    exclude("com.google.guava", "guava")
    exclude("com.esotericsoftware.kryo", "kryo")
    exclude("com.esotericsoftware.kryo", "minlog")
    exclude("org.apache.spark", "spark-launcher-2.10")
    exclude("org.spark-project.spark", "unused")
    exclude("org.apache.spark", "spark-network-common_2.10")
    exclude("org.apache.spark", "spark-network-shuffle_2.10")
    exclude("org.apache.spark", "spark-unsafe_2.10")
)

