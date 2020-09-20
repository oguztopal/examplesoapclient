package com.webservices.examplesoapclient.controller;

import com.webservices.examplesoapclient.client.SoapClient;
import com.webservices.examplesoapclient.stub.DetailsType;
import com.webservices.examplesoapclient.stub.GetBankResponseType;
import com.webservices.examplesoapclient.stub.GetBankType;
import com.webservices.examplesoapclient.stub.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/ws")
public class BlzController{

  @Autowired
  private SoapClient soapClient;

  @GetMapping
  public DetailsType detailsType(@RequestParam String code){
    ObjectFactory objectFactory = new ObjectFactory();
    GetBankType type = new GetBankType();
    type.setBlz(code);

    GetBankResponseType responseType = soapClient.getBank("http://www.thomas-bayer.com/axis2/services/BLZService",objectFactory.createGetBank(type));
    return responseType.getDetails();
  }
}
