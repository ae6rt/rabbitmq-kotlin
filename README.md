A PoC test project:  writing RabbitMQ producers and consumers in Kotlin

https://github.com/ae6rt/rabbitmq-kotlin

Run a consumer:

mvn clean compile exec:java -Dexec.mainClass="org.petrovic.rabbit.namespace" -Dexec.args="--consumer"

Then run a producer:

mvn compile exec:java -Dexec.mainClass="org.petrovic.rabbit.namespace" -Dexec.args="--producer"

References:  http://www.rabbitmq.com/
