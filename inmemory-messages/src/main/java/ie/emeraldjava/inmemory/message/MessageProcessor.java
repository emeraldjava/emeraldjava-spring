package ie.emeraldjava.inmemory.message;

public interface MessageProcessor {

    void processMessage(Topic topic, Object message);
}
