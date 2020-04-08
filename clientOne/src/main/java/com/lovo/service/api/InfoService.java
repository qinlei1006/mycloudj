package com.lovo.service.api;

import com.lovo.entity.InfoEntity;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("clienttwo")  // 被调用服务器在注册服务器中的名字
public interface InfoService {

//    与远程的方法进行对应
    @RequestMapping("/infoString/{tag}")
    public String infoString(@PathVariable("tag") int tag);

    @RequestMapping("infoEntityPost")
    public InfoEntity infoEntityPost(@RequestBody InfoEntity infoEntity);

    @RequestMapping(value = "infoEntityJson/{tag}",produces = "application/json;charset=utf-8")
    public InfoEntity infoEntityJson(@PathVariable("tag") int tag);
}
