package ugncry.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ugncry.entity.User;

/**
 * Created by ugncry on 11.07.2016.
 */
@Repository
@Transactional
public interface UserRepository extends BaseRepository <User>  {
}
