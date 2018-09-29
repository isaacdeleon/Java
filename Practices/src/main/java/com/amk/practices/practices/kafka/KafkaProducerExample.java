/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amk.practices.practices.kafka;

import java.util.Properties;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.LongSerializer;
import org.apache.kafka.common.serialization.StringSerializer;

/**
 *
 * @author amk-ec-017
 */
public class KafkaProducerExample {
    
    private final static String TOPIC = "my-topic";
    
    private final static String BOOTSTRAP_SERVERS = "localhost:9092,localhost:9093,localhost:9094";
    
    public static void main(String[]args) throws Exception{
            //runProducerOneMessage();
            runProducer(10);
            //runProducerAsynchronous(10);
    }
    
    private static final  Producer<Long, String> createProducer() {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
        props.put(ProducerConfig.CLIENT_ID_CONFIG, "KafkaExampleProducer");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, LongSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        
        return new KafkaProducer<>(props);
    }
    
    private static void runProducerOneMessage() throws Exception {
        
        final Producer<Long, String> producer = createProducer();
        
        try {
            final ProducerRecord<Long, String> record = new ProducerRecord<>(TOPIC, "Hello World one");

            RecordMetadata metadata = producer.send(record).get();

            System.out.printf("sent record(key=%s value=%s) " + "meta(partition=%d, offset=%d)",
                                    record.key(), record.value(), metadata.partition(),metadata.offset());

        } finally {
            producer.flush();
            producer.close();
        }
    }
    
    private static void runProducer(final int sendMessageCount) throws Exception {
        
        final Producer<Long, String> producer = createProducer();
        long time = System.currentTimeMillis();
        
        try {  
            for (long index = time; index < time  + sendMessageCount; index++) {
                final ProducerRecord<Long, String> record = new ProducerRecord<>(TOPIC, index, "Hello World " + index);
                
                RecordMetadata metadata = producer.send(record).get();
                
                long elapsedTime = System.currentTimeMillis() - time;
                System.out.printf("sent record(key=%s value=%s) " + "meta(partition=%d, offset=%d) time=%d\n",
                                        record.key(), record.value(), metadata.partition(),metadata.offset(), elapsedTime);
            }
        } finally {
            producer.flush();
            producer.close();
        }
    }
    
    private static void runProducerAsynchronous(final int sendMessageCount) throws Exception{
        final Producer<Long, String> producer = createProducer();
        long time = System.currentTimeMillis();
        final CountDownLatch countDownLatch = new CountDownLatch(sendMessageCount);
        
        try {
            for(long index = time; index < time + sendMessageCount; index++) {
                final ProducerRecord<Long, String> record = new ProducerRecord<>(TOPIC, index, "Hello Mom " + index);
                
                producer.send(record, (metadata, exception) -> {
                    long elapsedTime = System.currentTimeMillis() - time;
                    if(metadata != null) {
                        System.out.printf("sent record(key=%s value=%s) " +
                            "meta(partition=%d, offset=%d) time=%d\n",
                            record.key(), record.value(), metadata.partition(),
                            metadata.offset(), elapsedTime);
                    } else {
                        exception.printStackTrace();
                    }
                    countDownLatch.countDown();
                });  
            }
            countDownLatch.await(25, TimeUnit.SECONDS);
        } finally {
            producer.flush();
            producer.close();
        }
    }
}
