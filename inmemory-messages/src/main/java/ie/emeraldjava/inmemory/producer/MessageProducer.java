package ie.emeraldjava.inmemory.producer;

import ie.emeraldjava.inmemory.message.MessageProcessor;
import ie.emeraldjava.inmemory.message.MessageService;
import ie.emeraldjava.inmemory.message.Topic;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Slf4j
public class MessageProducer implements MessageProcessor {

    @Autowired
    @Setter
    private MessageService messageService;

    @PostConstruct
//    @Order(2)
    public void register() {
        // register
        messageService.registerProcessorForTopic(this, Topic.RESPONSE);
        messageService.registerProcessorForTopic(this, Topic.CONTROL);
    }

    public void sendSingleRequest() {
        messageService.publishMessage(Topic.REQUEST,new Long(System.currentTimeMillis()));
    }

    public void sendSingleControlEvent() {
        messageService.publishMessage(Topic.CONTROL,"ABC"+String.valueOf(System.currentTimeMillis()));
    }

    public void sendMultipleControlEvents() {
        messageService.publishMessage(Topic.CONTROL,"ABC"+String.valueOf(System.currentTimeMillis()));
        messageService.publishMessage(Topic.CONTROL,"BCA"+String.valueOf(System.currentTimeMillis()));
        messageService.publishMessage(Topic.CONTROL,"CAB"+String.valueOf(System.currentTimeMillis()));
    }

    public void sendMultipleMixedEvents() {
        messageService.publishMessage(Topic.CONTROL,"START"+String.valueOf(System.currentTimeMillis()));
        messageService.publishMessage(Topic.REQUEST,new Long(System.currentTimeMillis()));
        messageService.publishMessage(Topic.REQUEST,new Long(System.currentTimeMillis()));
        messageService.publishMessage(Topic.REQUEST,new Long(System.currentTimeMillis()));
        messageService.publishMessage(Topic.REQUEST,new Long(System.currentTimeMillis()));
        messageService.publishMessage(Topic.CONTROL,"COMPLETE"+String.valueOf(System.currentTimeMillis()));
    }

    @Override
    public void processMessage(Topic topic,Object message) {
        log.info("processMessage[{},{},{}]",topic,message.hashCode(),message.toString());
    }
}
