package ie.emeraldjava.raft.service;

import ie.emeraldjava.raft.microraft.RaftEndpoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Component
@Slf4j
public class RaftService {

    @Resource
    private RaftEndpoint raftEndpoint;

    @Resource
    private RaftEndpoint raftEndpoint2;

    @PostConstruct
    public void xx() {
        log.info("Raft service started");
        log.info("raftEndpoint {}",raftEndpoint.toString());
        log.info("raftEndpoint2 {}",raftEndpoint2.toString());
    }
}
