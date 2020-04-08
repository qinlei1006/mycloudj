package com.lovo.controller;

import com.lovo.entity.InfoEntity;
import com.lovo.service.api.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    // 注入本地远程调用
    @Autowired
    private InfoService infoService;

    /**
     *字符串
     * @param tag
     * @return
     */
    @RequestMapping("getInfo/{tag}")
    public String getInfo(@PathVariable("tag") int tag){
        System.out.println(tag);
        //要访问的远程地址
        String url="http://clienttwo/infoString/"+tag;
        // 远程调用
        ResponseEntity responseEntity =
                restTemplate.getForEntity(url,String.class);
        //获得返回信息
        return responseEntity.getBody().toString();
    }

    /**
     * 对象
     * @param tag
     * @return
     */
    @RequestMapping("getInfo2")
    public String getInfo2(int tag){
        String url="http://clienttwo/infoEntity/"+tag;
        ResponseEntity responseEntity =
                restTemplate.getForEntity(url, InfoEntity.class);
        InfoEntity infoEntity = (InfoEntity) responseEntity.getBody();
        return infoEntity.getInfo();
    }

    /**
     * json
     * @param tag
     * @return
     */
    @RequestMapping("grtInfo3/{tag}")
     public String grtInfo3(@PathVariable("tag") int tag){
        //要访问的远程地址
        String url="http://clienttwo/infoEntityJson/"+tag;
        // 远程调用
        ResponseEntity responseEntity =
                restTemplate.getForEntity(url,String.class);
        //获得返回信息
        return responseEntity.getBody().toString();
     }


     @RequestMapping("getInfoPost1")
     public String getInfoPost1(){
        String url ="http://clienttwo/infoEntityPost/";
        InfoEntity infoEntity = new InfoEntity();
        infoEntity.setInfo("我是前端");
         //url-请求的地址，tag请求的参数，InfoEntity.class返回的类型
        ResponseEntity responseEntity =
                restTemplate.postForEntity(url,infoEntity,InfoEntity.class);
        infoEntity = (InfoEntity) responseEntity.getBody();
        return infoEntity.getInfo();
     }

     @RequestMapping("getInfoPost2")
     public String getInfoPost2(int tag){
        String url = "http://clienttwo/infoEntityPost2/";
         Map<String,Integer> map = new HashMap<>();
         map.put("tag",tag);
         ResponseEntity responseEntity =
                 restTemplate.postForEntity(url,map,InfoEntity.class);
         return ((InfoEntity)responseEntity.getBody()).getInfo();

     }

//      调用本地远程方法
     @RequestMapping("getFeignString")
     public String getFeignString(int tag){
       String str = infoService.infoString(tag);
        return str;
     }

     @RequestMapping("infoEntityPost")
     public String infoEntityPost(){
        InfoEntity infoEntity = new InfoEntity("赵云");
         return  infoService.infoEntityPost(infoEntity).getInfo();

     }

     @RequestMapping("feignInfoEntityJson")
     public String infoEntityJson(int tag){
       return infoService.infoEntityJson(tag).getInfo();
     }

}
