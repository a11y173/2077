package com.amumu;

import org.apache.kafka.clients.producer.*;
import java.util.Properties;

public class kafkaProducer {
    public static String TOPIC = "my-example-topic";
    public static String BOOTSTRAP_SERVERS = "localhost:9092";
    public static String KEY_SERIALIZER = "org.apache.kafka.common.serialization.LongSerializer";
    public static String VALUE_SERIALIZER = "org.apache.kafka.common.serialization.StringSerializer";

    public static Producer<Long,String> createProducer(){
        Properties prop = new Properties();
        prop.put("bootstrap.servers",BOOTSTRAP_SERVERS);
        prop.put("key.serializer",KEY_SERIALIZER);
        prop.put("value.serializer",VALUE_SERIALIZER);

        return new KafkaProducer<>(prop);
    }

    public static void runProducer(final int sendMessageCoun) throws Exception{
        final Producer<Long,String> producer = createProducer();
        long time = System.currentTimeMillis();

        try{
            for (long index = time;index<time+sendMessageCoun;index++){
                final ProducerRecord<Long,String> record = new ProducerRecord<>(TOPIC,index,"master88!!"+index);

                RecordMetadata metadata = producer.send(record).get();

                long elapsedTime = System.currentTimeMillis()-time;
                System.out.printf("send record(key=%s value=%s)" + "meta(partition=%d,offset=%d,time=%d\n",record.key(),record.value(),metadata.partition(),metadata.offset(),elapsedTime);
            }
        }
        finally {
            producer.flush();
            producer.close();
        }
    }

    public static void main(String[] args) throws Exception{
        if(args.length == 0){
            runProducer(50);
        }else {
            runProducer(Integer.parseInt(args[0]));
        }
    }
}