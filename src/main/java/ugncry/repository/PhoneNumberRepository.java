package ugncry.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ugncry.entity.PhoneNumber;

/**
 * Created by ugncry on 11.07.2016.
 */
@Repository
@Transactional
public interface PhoneNumberRepository extends BaseRepository <PhoneNumber> {
}
