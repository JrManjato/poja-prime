package com.judipoja.prime.service.event;

import com.judipoja.prime.PojaGenerated;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

@PojaGenerated
@Service
@Slf4j
public class PrimeNumberService {

  private final SecureRandom secureRandom = new SecureRandom();
  private final List<String> primeNumberCache = new ArrayList<>();

  public String generatePrimeNumber() {
    BigInteger primeNumber = new BigInteger(10, 100, secureRandom);
    String primeNumberString = primeNumber.toString();

    primeNumberCache.add(primeNumberString);

    return primeNumberString;
  }

  public List<String> getPrimeNumberCache() {
    return new ArrayList<>(primeNumberCache);
  }
}