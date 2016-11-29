# task-gemfire-server
A GemFire server module needed to run the sample. Starts Gemfire for dataload 

##**Run GemFire start scripts**

```
$ cd scripts
$ ./gem-locator.sh <host>
$ ./gem-server.sh <locator-host>
$ gfsh
gfsh> connect --locator=<host>:10334
gfsh> list members
gfsh> list regions
```

