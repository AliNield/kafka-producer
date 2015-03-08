import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

import java.util.Date;
import java.util.Properties;
import java.util.Random;

public class ProducerTest {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put("metadata.broker.list", "broker1:9092,broker2:9092");
        properties.put("serializer.class", "kafka.serializer.StringEncoder");
        properties.put("partitioner.class", "example.producer.SimplePartitioner");
        properties.put("request.required.acks", "1");

        ProducerConfig config = new ProducerConfig(properties);

        Producer<String, String> producer = new Producer<String, String>(config);

        Random random = new Random();
        long runtime = new Date().getTime();

        String ip = "192.168.2." + random.nextInt(255);

        String message = runtime + ",www.example.com," + ip;

        KeyedMessage<String, String> data = new KeyedMessage<String, String>("page_visits", ip, message);

        producer.send(data);








    }



}
