## Start the ZooKeeper service
$ bin/zookeeper-server-start.sh config/zookeeper.properties

## Start the Kafka broker service
$ bin/kafka-server-start.sh config/server.properties

## create topic
$ bin/kafka-topics.sh --create --topic quickstart-events --bootstrap-server localhost:9092

bin/kafka-console-consumer.sh --topic quickstart-events --from-beginning --bootstrap-server localhost:9092

$ bin/kafka-topics.sh --describe --topic my-example-topic --bootstrap-server localhost:9092

$ bin/kafka-console-consumer.sh --topic my-example-topic --from-beginning --bootstrap-server localhost:9092

## 关于kafka producer的close()和flush()方法：
close() 方法是用来关闭生产者连接的，它会在关闭连接前等待所有的消息完成处理并将其缓存的消息刷新到 Kafka 集群中。在生产者处理完所有消息并关闭之后，生产者将不再能够发送新的消息。
flush() 方法是用来刷新生产者缓存的消息到 Kafka 集群中的。它不会关闭生产者连接，生产者仍然可以继续发送新的消息。在消息发送到 Kafka 集群之前，生产者会缓存消息，当消息数量达到一定限制时，或者当缓存消息超过一定时限时，缓存的消息会被刷新到 Kafka 集群中。
总的来说，如果你想确保所有生产者缓存的消息已经被处理并刷新到 Kafka 集群中，你可以使用 flush() 方法。如果你想关闭生产者连接，请使用 close() 方法。

## java中的get()方法：
