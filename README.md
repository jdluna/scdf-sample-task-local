# scdf-sample-task
A Spring Cloud Dataflow Task application and demo that takes data from a SQL database in batch processes and writes to GemFire IMDG.

##**Modules**

* **task-common**
    * Common package used in other modules. 
    * Included is the Pojo model for the sample and the SQL files for Postgres.  
 
* **task-gemfire-server**
    * Gemfire Server code. Needs **task-common**
    * Included is **scripts** directory that has start scripts for gemfire. 
        * This creates the necessary regions to store data.
        * _**See README.md for instruction on how to run the script.**_
       
 
* **task-jdbc-task**
    * Spring Cloud Task application to be deployed via Spring Cloud Dataflow.
    * Batch process to take data from Postgres to GemFire.
        * Includes polling source, processor to Java Object, sink/write to Gemfire.
        * _**See README.md for instruction on how to run the task.**_
     
  
* **scdf-demo-task-parent**
     * Parent project to build models in order needed for execution.
 

##**Build**

```
$ cd scdf-demo-task-parent/
$ mvn clean install -DskipTests
```

