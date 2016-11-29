# task-jdbc-task
A Spring Cloud Dataflow Task for jdbc --> gemfire. 

##**Options**

The **task-jdbc-task** has the following options:

* **jdbcgemfire.locator**
       * _The Gemfire Database locator host:port_
 
* **jdbcgemfire.region**
       * _The Gemfire Region to use for write.
       
* **jdbcgemfire.commit-interval**
       * _The amount of records to poll each batch. <**DEFAULT** : 1000>_
 
* **jdbcgemfire.datasource.username**
       * _The postgres username to use in jdbc connection properties_
       
* **jdbcgemfire.datasource.password**
       * _The postgres password to use in jdbc connection properties_
       
* **jdbcgemfire.datasource.url**
       * _The JDBC URL to use for connection to postgres._
       
* **jdbcgemfire.datasource.driver-class-name**
       * _The Driver class to use to connect using jdbc. In the Demo use <org.postgresql.Driver>_
        
* **jdbcgemfire.sql**
       * _SQL to execute on postgres_

 

##**Deploy via shell**

```
$ java -jar spring-cloud-dataflow-server-local.<version>.jar
$ java -jar spring-cloud-dataflow-shell.<version>.jar

dataflow> app register —name mytask --type task --uri https://github.com/zhansen-pivotal/scdf-sample-task/raw/master/task-jdbc-task/target/task-jdbc-task-0.0.1-SNAPSHOT.jar
dataflow> app info --id task:mytask 
dataflow> app list

* Tasks can be created for any region. Example: Region={Author}

dataflow> task create --name author-task --definition 'mytask --jdbcgemfire.datasource.username=postgres --jdbcgemfire.datasource.url=jdbc:postgresql://localhost:5432/postgres --jdbcgemfire.datasource.driver-class-name=org.postgresql.Driver --jdbcgemfire.sql="select * from authors" --jdbcgemfire.locators=localhost:10334 --jdbcgemfire.region-name=Author'
dataflow> task list
dataflow> task launch author-task
```
##**Check GFSH for data from Postgres**
```
$ gfsh
gfsh> connect --locator=<host>:10334
gfsh> show metrics --region=/Author
gfsh> query --query="select * from /Author"
```