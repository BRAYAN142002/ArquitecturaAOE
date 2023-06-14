
package com.unicauca.openmarketConsumer.domain;

import com.unicauca.openmarket.domain.entity.Product;
import java.util.List;

/**
 *
 * @author brayan
 */
public interface IProductService {
    public List<Product>findAll();
    public Product find(Long Id);
    public Product create(Product product);
    public Product update(Long id,Product product);
    public void delete(Long id);
}
