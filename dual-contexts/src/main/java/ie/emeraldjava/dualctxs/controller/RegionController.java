package ie.emeraldjava.dualctxs.controller;

import ie.emeraldjava.dualctxs.domain.repo.RegionRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@Component
@Slf4j
public class RegionController {

    @Autowired
    private RegionRepo repo;

    private String region;

//    public RegionController(String region) {
//        this.region = region;
//        log.info("RegionController:{}",this.region);
//    }

    @PostConstruct
    public void postC() {
        log.info("{}:{}","RegionController.postConstruct",region);
    }
}
