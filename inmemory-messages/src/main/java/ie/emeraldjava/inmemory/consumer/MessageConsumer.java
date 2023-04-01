package ie.emeraldjava.inmemory.consumer;

import ie.emeraldjava.inmemory.message.MessageProcessor;
import ie.emeraldjava.inmemory.message.MessageService;
import ie.emeraldjava.inmemory.message.Topic;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.ThreadLocalRandom;

@Component
@Slf4j
public class MessageConsumer implements MessageProcessor {

    @Autowired
    @Setter
    private MessageService messageService;

    @PostConstruct
    public void register() {
        // register
        messageService.registerProcessorForTopic(this, Topic.REQUEST);
        messageService.registerProcessorForTopic(this, Topic.CONTROL);
    }

    @Override
    public void processMessage(Topic topic,Object message) {
        log.info("-->processMessage[{},{},{}]",topic,message.hashCode(),message.toString());

        try{
            long x = ThreadLocalRandom.current().nextLong(200,800);
            log.info("Sleeping({})",x);
            Thread.sleep(x);
        } catch(InterruptedException e)
        {
            log.error("InterruptedException",e.getMessage());
        }
        log.info("<--processMessage[{},{},{}]",topic,message.hashCode(),message.toString());
        publishResponseMessage(topic);
    }

    void publishResponseMessage(Topic topic) {
        Topic defaultTopic = Topic.RESPONSE;
        if(topic.equals(Topic.CONTROL)){
            defaultTopic = Topic.CONTROL;
        }
        messageService.publishMessage(defaultTopic, new Long(System.currentTimeMillis()));
    }
}
