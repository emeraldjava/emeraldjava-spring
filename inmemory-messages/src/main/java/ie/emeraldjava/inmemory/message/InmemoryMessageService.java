package ie.emeraldjava.inmemory.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class InmemoryMessageService extends AbstractInmemoryMessageService implements MessageService {

//    private MessageProcessor requestProcessor;
//    private MessageProcessor responseProcessor;
//    private MessageProcessor producerControlProcessor;
//    private MessageProcessor consumerControlProcessor;

//    @Override
//    public void registerProcessorForTopic(MessageProcessor processor, Topic topic) {
//        log.info("register[{},{},{}]",topic,processor.hashCode(),processor.getClass().getName());
//        if(topic.equals(Topic.REQUEST)) {
//            this.requestProcessor=processor;
//        } else if(topic.equals(Topic.RESPONSE)) {
//            this.responseProcessor = processor;
//        } else if(topic.equals(Topic.CONTROL)) {
//            if(processor instanceof MessageProducer) {
//                this.producerControlProcessor = processor;
//                log.info("register:consumerControlProcessor[{}]",this.producerControlProcessor.hashCode());
//            } else if (processor instanceof MessageConsumer){
//                this.consumerControlProcessor = processor;
//                log.info("register:producerControlProcessor[{}]",this.consumerControlProcessor.hashCode());
//            }
//        }
//    }

    @Override
    public void publishMessage(Topic topic, Object message) {
        log.info("publishMessage[{},{},{},{}]",topic,message.hashCode(),message,(message instanceof String));
        MessageProcessor p = getMessageProcessor(topic,message);
        log.info("-->processor[{}]",p.hashCode());
        p.processMessage(topic, message);
        log.info("<--processor[{}]",p.hashCode());
    }

//    private MessageProcessor getMessageProcessor(Topic topic,Object message) {
//        MessageProcessor p = null;
//        if(topic.equals(Topic.REQUEST)) {
//            p = this.requestProcessor;
//        } else if(topic.equals(Topic.RESPONSE)) {
//            p = this.responseProcessor;
//        } else if(topic.equals(Topic.CONTROL)) {
//            if(message instanceof String) {
//                p = this.consumerControlProcessor;
//            } else {
//                p = this.producerControlProcessor;
//            }
//        }
//        return p;
//    }
}
