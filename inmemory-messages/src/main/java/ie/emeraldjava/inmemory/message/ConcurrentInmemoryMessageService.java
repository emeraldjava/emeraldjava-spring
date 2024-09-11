package ie.emeraldjava.inmemory.message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Slf4j
@Component
public class ConcurrentInmemoryMessageService extends AbstractInmemoryMessageService implements MessageService {

    @Value("${threadPoolSize:4")
    private int threadPoolSize = 4;

    private Executor executor = Executors.newFixedThreadPool(threadPoolSize);

    @PostConstruct
    public void setup() {
        log.info("ConcurrentInmemoryMessageService");
    }

    @Override
    public void publishMessage(Topic topic, Object message) {
        executor.execute(new MyRunnable(topic,message));
    }

    @Getter
    @Setter
    @AllArgsConstructor
    class MyRunnable implements Runnable {

        Topic topic;
        Object message;

        public void run() {
            log.info("publishMessage[{},{},{},{}]",topic,message.hashCode(),message,(message instanceof String));
            MessageProcessor p = getMessageProcessor(topic,message);
            log.info("-->processor[{}]",p.hashCode());
            p.processMessage(topic, message);
            log.info("<--processor[{}]",p.hashCode());
        }
    }


}
