package com.lovo.cloud.controller;

import com.lovo.cloud.entity.InfoEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController // 所有方法 不做视图渲染，值返回数据
public class InfoController {

    //返回字符串
    @RequestMapping("infoString/{tag}")
    public String infoString(@PathVariable("tag") int tag){
        switch (tag){
            case 1:
                return "hello cloud 1-1";
            case 2:
                return "hello cloud 1-2";
            default:
                return "eror";
        }
    }

    /**
     * 对象
     * @param tag
     * @return
     */
    @RequestMapping("infoEntity/{tag}")
    public InfoEntity infoEntity(@PathVariable("tag") int tag){
        InfoEntity infoEntity = new InfoEntity();
        switch (tag){
            case 1:
                infoEntity.setInfo("hello cloud 1-1");
                break;
            case 2:
                infoEntity.setInfo("hello cloud 1-2");
                break;
        }
        return infoEntity;
    }

    /**
     * 将对象转为json
     * @param tag
     * @return
     */
    @RequestMapping(value = "infoEntityJson/{tag}",produces = "application/json;charset=utf-8")
    public InfoEntity infoEntityJson(@PathVariable("tag") int tag){
        InfoEntity infoEntity = new InfoEntity();
        switch (tag){
            case 1:
                infoEntity.setInfo("hello cloud json 1-1");
                break;
            case 2:
                infoEntity.setInfo("hello cloud json 1-2");
                break;
        }
        return infoEntity;
    }

    @RequestMapping("infoEntityPost")
    public InfoEntity infoEntityPost(@RequestBody  InfoEntity infoEntity){
        System.out.println(infoEntity.getInfo());
        infoEntity.setInfo("我是后端服务器");
        return infoEntity;
    }

    @RequestMapping("infoEntityPost2")
    public InfoEntity infoEntityPost(@RequestBody Map<String,Integer> map){
        InfoEntity infoEntity = new InfoEntity();
        switch (map.get("tag")){
            case 1:
                infoEntity.setInfo("hello cloud json 1-1");
                break;
            case 2:
                infoEntity.setInfo("hello cloud json 1-2");
                break;
        }
        return infoEntity;
    }
}
