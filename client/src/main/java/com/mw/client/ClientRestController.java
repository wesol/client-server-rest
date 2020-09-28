package com.mw.client;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@Log4j2
public class ClientRestController {

  private RestTemplate restTemplate = new RestTemplate();

  @Value("${server.url}")
  String url;

  @GetMapping("/")
  public String testResponseEntity() {

    System.out.println(url);

    ResponseEntity<SimplyDto> responseEntity = null;

    try {
      responseEntity = restTemplate.getForEntity(url, SimplyDto.class);
    } catch (HttpClientErrorException e) {
      log.error(e.getMessage());
    }

    if (responseEntity != null && responseEntity.getBody() != null) {
      return responseEntity.getBody().toString();
    } else {
      return "fail";
    }
  }

  @GetMapping("/list")
  public String testResponseEntityList() {
    List responseEntity;
    try {
      responseEntity = restTemplate.getForObject(url + "/list", List.class);
    } catch (RestClientException e) {
      e.printStackTrace();
    }
    return "ok";
  }
}
