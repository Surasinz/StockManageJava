package work.StockManage.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import work.StockManage.model.user.UserEntity;

public interface UserRepository extends MongoRepository<UserEntity,String> {
    UserEntity findOneByUserName (String userName);
}
