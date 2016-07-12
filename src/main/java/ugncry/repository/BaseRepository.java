package ugncry.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import ugncry.entity.BaseEntity;

/**
 * Created by ugncry on 11.07.2016.
 */
@NoRepositoryBean
public interface BaseRepository <R extends BaseEntity> extends CrudRepository <R, Long> {
}
