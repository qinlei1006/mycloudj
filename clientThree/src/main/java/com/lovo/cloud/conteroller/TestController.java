package com.lovo.cloud.conteroller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 所有方法 不做视图渲染，值返回数据
public class TestController {

    //返回字符串
    @RequestMapping("infoString/{tag}")
    public String infoString(@PathVariable("tag") int tag){


        switch (tag){
            case 1:
                return "hello cloud 2-1";
            case 2:
                return "hello cloud 2-2";
            default:
                return "eror";
        }
    }

}
