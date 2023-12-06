package com.judipoja.prime.endpoint.rest.controller;

import com.judipoja.prime.PojaGenerated;
import com.judipoja.prime.endpoint.event.EventProducer;
import com.judipoja.prime.endpoint.event.gen.UuidCreated;
import com.judipoja.prime.repository.DummyRepository;
import com.judipoja.prime.repository.DummyUuidRepository;
import com.judipoja.prime.repository.model.Dummy;
import com.judipoja.prime.repository.model.DummyUuid;
import com.judipoja.prime.service.event.PrimeNumberService;
import lombok.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.UUID.randomUUID;

@PojaGenerated
@RestController
@Value
public class HealthController {

  DummyRepository dummyRepository;
  DummyUuidRepository dummyUuidRepository;
  EventProducer eventProducer;

  PrimeNumberService primeNumberService;

  @GetMapping("/ping")
  public String ping() {
    return "pong";
  }

  @GetMapping("/dummy-table")
  public List<Dummy> dummyTable() {
    return dummyRepository.findAll();
  }

  @GetMapping(value = "/uuid-created")
  public String uuidCreated() throws InterruptedException {
    var randomUuid = randomUUID().toString();
    var event = new UuidCreated().toBuilder().uuid(randomUuid).build();

    eventProducer.accept(List.of(event));

    Thread.sleep(20_000);
    return dummyUuidRepository.findById(randomUuid).map(DummyUuid::getId).orElseThrow();
  }

  @GetMapping("/new-prime")
  public String getPrimeNumber() {
    return primeNumberService.generatePrimeNumber();
  }

}
