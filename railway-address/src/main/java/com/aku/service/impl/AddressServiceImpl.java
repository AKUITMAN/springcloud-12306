package com.aku.service.impl;

import com.aku.pojo.resp.BaseResp;
import com.aku.pojo.vo.Address;
import com.aku.dao.AddressMapper;
import com.aku.dao.AddressRepository;
import com.aku.pojo.req.AddressReq;
import com.aku.pojo.req.MapData;
import com.aku.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressRepository repository;

    @Autowired
    AddressMapper addressMapper;

    @Override
    public BaseResp findAll() {
        List all = repository.findAll();
        BaseResp baseResponse = new BaseResp();
        baseResponse.setData(all);
        baseResponse.setCode(200);
        baseResponse.setMessage("查询成功");
        return baseResponse;
    }

    @Override
    public BaseResp findById(Integer id) {
        BaseResp baseResponse = new BaseResp();
        if (id!=null){
            Optional byId = repository.findById(id);
            if (byId.isPresent()){
                baseResponse.setData(byId.get());
                baseResponse.setCode(200);
                baseResponse.setMessage("查询成功!!!");
                return baseResponse;
            }
        }
        baseResponse.setCode(201);
        baseResponse.setMessage("查询失败!!!");
        return baseResponse;
    }

    @Override
    public BaseResp deleteById(Integer id) {
        BaseResp baseResponse = new BaseResp();
        if(id!=null){
            repository.deleteById(id);
            baseResponse.setCode(200);
            baseResponse.setMessage("删除成功!!!");
            return baseResponse;
        }
        baseResponse.setCode(201);
        baseResponse.setMessage("删除失败!!!");
        return baseResponse;
    }

    @Override
    public BaseResp saveOrFlush(Address address) {
        BaseResp baseResponse = new BaseResp();
        if (address!=null){
            Address o = (Address)repository.saveAndFlush(address);
            baseResponse.setData(o);
            if (address.getId()!=null&&o!=null){
                baseResponse.setCode(200);
                baseResponse.setMessage("更新成功!!!");
                return baseResponse;
            }else if (address.getId()==null&&o!=null){
                baseResponse.setCode(200);
                baseResponse.setMessage("新增成功!!!");
                return  baseResponse;
            }
        }
        baseResponse.setCode(201);
        baseResponse.setMessage("新增或更新失败!!!");
        return baseResponse;
    }

    @Override
    public BaseResp findMap() {
        BaseResp baseResponse = new BaseResp();
        List<AddressReq> all=addressMapper.findMap();
        ArrayList<MapData> objects = new ArrayList<>();
        for (AddressReq aa:all
             ) {
            MapData mapData = new MapData();
            mapData.setName(aa.getProvince());
            mapData.setValue(aa.getHeat());
            objects.add(mapData);
        }
        if (all!=null){
            baseResponse.setData(objects);
            baseResponse.setCode(200);
            return baseResponse;
        }
        baseResponse.setCode(201);
        baseResponse.setMessage("错误");
        return baseResponse ;
    }
}
