package ie.emeraldjava.inmemory.message;

public interface MessagePublisher {

    void publishMessage(Topic topic, Object message);
}
