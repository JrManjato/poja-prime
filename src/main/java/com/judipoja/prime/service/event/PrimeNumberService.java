package com.judipoja.prime.service.event;

import com.judipoja.prime.PojaGenerated;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.SecureRandom;

@PojaGenerated
@Service
@Slf4j
public class PrimeNumberService {
  private final SecureRandom secureRandom = new SecureRandom();
  public String generatePrimeNumber() {
    BigInteger primeNumber = new BigInteger(10, 100, secureRandom);

    return primeNumber.toString();
  }
}
