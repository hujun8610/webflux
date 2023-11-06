package com.cmcc.coc.gw.web;


import com.cmcc.coc.gw.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/health")
@Slf4j
public class HealthController {

    @RequestMapping("/check")
    @GetMapping
    @ResponseBody
    public String check() {
        return "ok";
    }

    @RequestMapping("/add")
    @PostMapping
    @ResponseBody
    public Mono<String> add(@RequestBody Person person) {
        log.info("the person is:{}", person);
        return Mono.just("ok");
    }

}
