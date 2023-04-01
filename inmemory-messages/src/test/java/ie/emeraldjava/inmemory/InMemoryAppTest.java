package ie.emeraldjava.inmemory;

import ie.emeraldjava.inmemory.consumer.MessageConsumer;
import ie.emeraldjava.inmemory.message.InmemoryMessageService;
import ie.emeraldjava.inmemory.producer.MessageProducer;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class InMemoryAppTest {

    InmemoryMessageService inmemoryMessageService = new InmemoryMessageService();

    MessageProducer messageProducer = new MessageProducer();

    MessageConsumer messageConsumer = new MessageConsumer();

    @BeforeEach

    void beforeEach() {
        messageProducer.setMessageService(inmemoryMessageService);
        messageConsumer.setMessageService(inmemoryMessageService);
        messageProducer.register();
        messageConsumer.register();
    }

    @Test
    public void sendSingleRequest() {
        messageProducer.sendSingleRequest();
    }

    @Test
    public void sendSingleControlEvent() {
        messageProducer.sendSingleControlEvent();
    }

    @Test
    public void sendMultipleControlEvents() {
        messageProducer.sendMultipleControlEvents();
    }

    @Test
    public void sendMultipleMixedEvents() {
        messageProducer.sendMultipleMixedEvents();
    }
}