package com.example.demo.feign;

import com.example.demo.domain.ProductPo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@FeignClient(value = "Goods" )
/**
 * @author
 */
@RequestMapping("/goodsService")
public interface GoodsServiceApi {


    /**
     * 根据货品id获取货品信息
     * @param id
     * @return ProductPo
     */
    @GetMapping("/products/in/{id}")
     ProductPo getProductById(@PathVariable("id") Integer id);
}
