package com.plant.site.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: TODO
 * @author: yumingbin@zto.cn
 * @date: 2019-03-20 16:08
 * @version:1.0
 **/
public class ResultUtil {

    /**成功且带数据**/
    public static ResponseResult success(Object object){
        ResponseResult ResponseResult = new ResponseResult();
        ResponseResult.setCode(ResultEnum.SUCCESS.getCode());
        ResponseResult.setMsg(ResultEnum.SUCCESS.getMsg());
        ResponseResult.setData(object);
        return ResponseResult;
    }
    /**成功但不带数据**/
    public static ResponseResult success(){

        return success(null);
    }
    /**失败**/
    public static ResponseResult error(Integer code,String msg){
        ResponseResult ResponseResult = new ResponseResult();
        ResponseResult.setCode(code);
        ResponseResult.setMsg(msg);
        return ResponseResult;
    }


    public static void main(String[] args) {

       Goods goods=new Goods();
       goods.setId(1);
       goods.setPrice(new BigDecimal(13.8));

        Goods goods1=new Goods();
        goods1.setId(2);
        goods1.setPrice(new BigDecimal(3.8));


        List<Goods> goodsList=new ArrayList<>();
        goodsList.add(goods1);
        goodsList.add(goods);

        while (true){
            goodsList.add(goods1);
            goodsList.add(goods);
        }

//        BigDecimal reduce = goodsList.stream().map(Goods::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add).setScale(3,2);
//        System.out.println(reduce);
    }

}
