package com.epam.movie_rating.service;//package com.epam.movie_rating.service;
//
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.springframework.kafka.annotation.KafkaListener;
//
//import java.util.concurrent.CountDownLatch;
//
//public class KafkaConsumer {
//
//    private CountDownLatch latch = new CountDownLatch(1);
//
//    private String payload;
//
//    @KafkaListener(topics = "${topic}",groupId = "${spring.kafka.consumer.group.id}", containerFactory = "kafkaListenerContainerFactory")
//    public void receive(ConsumerRecord<?, ?> consumerRecord) {
//        payload = consumerRecord.toString();
//        latch.countDown();
//    }
//
//    public CountDownLatch getLatch() {
//        return latch;
//    }
//
//    public void resetLatch() {
//        latch = new CountDownLatch(1);
//    }
//
//    public String getPayload() {
//        return payload;
//    }
//
//}
