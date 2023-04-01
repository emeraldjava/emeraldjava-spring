package ie.emeraldjava.inmemory.message;

public interface MessageService extends MessagePublisher {

    /**
     * Allow clients register for topics
     * @param processor
     * @param topic
     */
    void registerProcessorForTopic(MessageProcessor processor, Topic topic);

}
