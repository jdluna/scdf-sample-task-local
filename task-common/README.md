# task-common
A common module needed to run the sample. SQL files are provided for DDL and Data load. 

##**Run SQL Load**

```
$ cd src/sql
$ psql -d <test database>
psql> \i create-pubs-postgres-tables.sql
psql> \i insert-pubs-postgres-tables.sql
psql> \dt
```

