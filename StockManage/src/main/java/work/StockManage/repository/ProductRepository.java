package work.StockManage.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import work.StockManage.model.product.ProductEntity;

public interface ProductRepository extends MongoRepository<ProductEntity,String> {
}
