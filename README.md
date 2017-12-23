RocketMerger receives webhook data (via POST requests) from
[RocketMap](https://github.com/RocketMap/RocketMap) and stores it in database.
Another RocketMap instance with -os parameter can use this database to show pokemons on map.

**Currently only accepts pokemon data.**
#### Motivation and Context 
In huge maps consisting of many instances  with a large number of workers,
operations with the database are a bottle neck.

Separating frontend and backend databases reducethe impact of user's requests.
Also reduce database locks if scanning instances use separate databases.

#### Usage
RocketMap database should be created first.
##### Using prebuilded jar
1. Download latest [release](https://github.com/codename-art/RocketMerger/releases).
2. Create application.properties file with flowing fields:
```properties
spring.jpa.hibernate.ddl-auto=none
server.port=8282
spring.datasource.url=jdbc:mysql://localhost:3306/pgo
spring.datasource.username=
spring.datasource.password=
dbwriter.count=2
```
3. Change `pgo` in database url for your DB name, `username` and `password`.
4. Start with
```commandline
java -jar RocketMerger*.jar
```

##### Using latest source code
1. `git clone`
2. Create application.properties same as above.
3. Build jar:
```commandline
./gradlew build
```
4. Start with:
```commandline
java -jar build/libs/RocketMerger*.jar
```