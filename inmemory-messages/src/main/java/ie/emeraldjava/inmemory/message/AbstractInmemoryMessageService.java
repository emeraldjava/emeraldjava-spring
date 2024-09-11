package ie.emeraldjava.inmemory.message;

import ie.emeraldjava.inmemory.consumer.MessageConsumer;
import ie.emeraldjava.inmemory.producer.MessageProducer;
import lombok.extern.slf4j.Slf4j;

@Slf4j
abstract class AbstractInmemoryMessageService implements MessageService {

    MessageProcessor requestProcessor;
    MessageProcessor responseProcessor;
    MessageProcessor producerControlProcessor;
    protected MessageProcessor consumerControlProcessor;

    public void registerProcessorForTopic(MessageProcessor processor, Topic topic) {
        log.info("register[{},{},{}]",topic,processor.hashCode(),processor.getClass().getName());
        if(topic.equals(Topic.REQUEST)) {
            this.requestProcessor=processor;
        } else if(topic.equals(Topic.RESPONSE)) {
            this.responseProcessor = processor;
        } else if(topic.equals(Topic.CONTROL)) {
            if(processor instanceof MessageProducer) {
                this.producerControlProcessor = processor;
                log.info("register:consumerControlProcessor[{}]",this.producerControlProcessor.hashCode());
            } else if (processor instanceof MessageConsumer){
                this.consumerControlProcessor = processor;
                log.info("register:producerControlProcessor[{}]",this.consumerControlProcessor.hashCode());
            }
        }
    }

    public abstract void publishMessage(Topic topic, Object message);

    MessageProcessor getMessageProcessor(Topic topic,Object message) {
        MessageProcessor p = null;
        if(topic.equals(Topic.REQUEST)) {
            p = this.requestProcessor;
        } else if(topic.equals(Topic.RESPONSE)) {
            p = this.responseProcessor;
        } else if(topic.equals(Topic.CONTROL)) {
            if(message instanceof String) {
                p = this.consumerControlProcessor;
            } else {
                p = this.producerControlProcessor;
            }
        }
        return p;
    }
}
