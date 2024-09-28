# debezium

## 15-09-2024

192.168.65.0/24

https://debezium.io/documentation/reference/stable/connectors/postgresql.html

### Set WAL Level

    ALTER SYSTEM SET wal_level = logical;

https://stackoverflow.com/questions/67490668/changing-wal-level-on-postgresql-13-via-client-session-is-not-being-respecte
https://blog.peerdb.io/exploring-versions-of-the-postgres-logical-replication-protocol
https://medium.com/@film42/getting-postgres-logical-replication-changes-using-pgoutput-plugin-b752e57bfd58


### Docker Networking

https://www.docker.com/blog/how-docker-desktop-networking-works-under-the-hood/
https://stackoverflow.com/questions/73674365/how-to-use-a-pre-existing-network-in-docker-compose


## 14-09-2024

https://www.baeldung.com/debezium-intro
https://ishansoninitj.medium.com/change-data-capture-cdc-using-debezium-in-a-springboot-application-97ddde8b991a
https://gist.github.com/tzolov/c3bfa56237f0d4ceb53a93b6c80436e3
https://github.com/tzolov/cdc-debezium/tree/master

## CDC

https://medium.com/yazilim-vip/cdc-with-debezium-kafka-spring-boot-3-and-postgres-a523d5237cca

### Avro

https://debezium.io/documentation/reference/stable/configuration/avro.html
https://debezium.io/blog/2016/09/19/Serializing-Debezium-events-with-Avro/

#### AvroConverter

https://github.com/confluentinc/schema-registry/blob/master/avro-converter/src/main/java/io/confluent/connect/avro/AvroConverter.java

https://medium.com/@rayane.gouda/making-debezium-connect-support-confluent-schema-registry-b9510ed45f4b
https://docs.ververica.com/vvc/connectors-and-formats/built-in-formats/debezium-avro-confluent
https://github.com/debezium/debezium-examples/blob/main/tutorial/register-mysql-avro.json

https://github.com/rayanegouda/medium/tree/main/step1

## postgres

https://debezium.io/documentation/reference/stable/connectors/postgresql.html

http://localhost:8080/?pgsql=db&username=postgres&db=postgres&ns=the_simpsons&sql=
https://www.postgresql.org/docs/current/logicaldecoding-walsender.html

https://stackoverflow.com/questions/64051373/way-to-configure-localhost-to-mean-only-127-0-0-1-or-turn-off-ipv6-in-mac