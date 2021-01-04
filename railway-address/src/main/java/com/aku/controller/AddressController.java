package com.aku.controller;

import com.aku.pojo.resp.BaseResp;
import com.aku.pojo.vo.Address;
import com.aku.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    AddressService service;
    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    public BaseResp findAll(){
        return service.findAll();
    }
    @RequestMapping(value = "/findById",method = RequestMethod.POST)
    public BaseResp findById(@RequestBody Map map){
        return service.findById((Integer)map.get("id"));
    }
    @RequestMapping(value = "deleteById",method = RequestMethod.POST)
    public BaseResp deleteById(@RequestBody Map map){
        return service.deleteById((Integer)map.get("id"));
    }
    @RequestMapping(value = "/saveOrFlush",method = RequestMethod.POST)
    public BaseResp saveOrFlush(@RequestBody Address address){
        return service.saveOrFlush(address);
    }
    @RequestMapping(value = "/findMap",method = RequestMethod.GET)
    public BaseResp findMap(){
        return service.findMap();
    }
}
