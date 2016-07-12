package ugncry;

import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ugncry.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by ugncry on 11.07.2016.
 */
@Service
@Transactional
public class UserSearchService {

  @PersistenceContext
  private EntityManager entityManager;

  public List<User> search(String parameter) {
    FullTextEntityManager fullTextEntityManager =
      org.hibernate.search.jpa.Search.getFullTextEntityManager(entityManager);

    QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory()
      .buildQueryBuilder().forEntity(User.class).get();

    org.apache.lucene.search.Query query =
      queryBuilder
        .keyword()
        .onFields("name", "description", "skill", "studies.name", "numbers.number").ignoreFieldBridge()
        .matching(parameter)
        .createQuery();

    org.hibernate.search.jpa.FullTextQuery jpaQuery =
      fullTextEntityManager.createFullTextQuery(query, User.class);

    @SuppressWarnings("unchecked")
    List<User> results = jpaQuery.getResultList();

    return results;

  }
}
