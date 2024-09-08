package ie.emeraldjava.raft.config;

import ie.emeraldjava.raft.microraft.RaftEndpoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Configuration;

/**
 * Creates RaftEndpoints
 */
@Configuration
@Slf4j
public class RaftEndpointFactory implements FactoryBean<RaftEndpoint> {

    @Override
    public RaftEndpoint getObject() throws Exception {
        // Your custom logic to create and configure the bean
        RaftEndpoint myBean = RaftEndpoint.newEndpoint();
        log.info("new RaftEndpoint:{}",myBean.getId());
        return myBean;
    }

    @Override
    public Class<?> getObjectType() {
        return RaftEndpoint.class;
    }

    @Override
    public boolean isSingleton() {
        return false; // Return 'true' if you want a singleton bean, 'false' for a prototype bean
    }
}
