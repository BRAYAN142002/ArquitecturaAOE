
package com.unicauca.openmarket.config;

import com.unicauca.openmarket.domain.entity.Product;


public interface IRabbitMQConfig {
    void connection(Product product,String action)throws Exception;
}
