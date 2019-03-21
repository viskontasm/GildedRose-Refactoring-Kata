# How to Run
**ElasticSearch enable:**<br />
    docker-compose up -d

**Build and Run program:**<br />
java - jar gilded-rose-kata-0.0.1-SNAPSHOT.jar

# How To Use
**Initial item list loads to elastic when program starts(ElasticInitialLoader class).
Later item list is updated once per day asynchronously.**

**To retrieve items:**<br />
http://localhost:8080/items

**To manualy update items once:**<br />
http://localhost:8080/update
