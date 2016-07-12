# SearchExample
Quick example of Hibernate Search

##There are two ways how to use this repo:
  1. Clone or download repo, change some properties in `application.properties` like database root or user/password;
  2. Read code and quick guide which is written below.

##Create project.
I used [Spring Boot](http://start.spring.io/) because it's easy and fast way to start spring project. We need just two dependencies:
* JPA
* Hibernate Search

The first one we can include right at start at spring boot. Search dependency we are including after, it looks like this:
```
    <dependency>
      <groupId>org.hibernate</groupId>
      <artifactId>hibernate-search-orm</artifactId>
      <version>4.5.1.Final</version>
    </dependency>
```

##Configure application properties.
Set your own database url, username and password.

##Create your entities and repostiories.
Simple POJOs with @Entity and @Table annotations is all you need. Don't forget to put there getters and setters!

##Add Search annotations on your classes:
Mark the table you want to search with annotation `@Indexed`, and on the fields `@Field`. You can also parametrise those annotations with bunch of properties (checkout this [community documentation](https://docs.jboss.org/hibernate/stable/search/reference/en-US/html_single/#_defining_fields_for_indexing)).
If you want to index the associated columns you have to mark them at parent class by `@InexedEmbedded` and in the associated class the same as common field by `@Field`.

### At `User` 
```java
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @IndexedEmbedded
    private Set<Study> studies;
```

### At `Study`
```java
    @Column(nullable = false)
    @Field
    private String name;
```

##Create search service class.
Actually if you want to just find by keywords - here's a simple method `search()`, which fields you already annotated. You can create lucene query from hibernate query which is created from fulltext search entity manager.

##That's it! 
I've put few tests in this project. You have to add new data only after you annotated and configured hibernate search. If you already have some data you should reindex your database. Also you can purge (delete) indexed rows. Those methods are not really difficult check out [this documentation](https://docs.jboss.org/hibernate/search/3.2/reference/en/html/manual-index-changes.html). 

##Tips and exceptions.
If you are encoutering with troubles about lists or fetchting type - there're three ways to solve it:
  1. Make a [StringBridge](https://docs.jboss.org/hibernate/search/4.1/api/org/hibernate/search/bridge/builtin/StringBridge.html) (if just only string you need to index);
  2. Change List to Set (if it's possible for you);
  3. If you can't manage your entity without EAGER fetch type, you can put here SELECT fetch Mode `@Fetch(FetchMode.SELECT)`.
Not just onestringenum Enums creating with the same way by [EnumBridge](https://docs.jboss.org/hibernate/search/4.1/api/org/hibernate/search/bridge/builtin/EnumBridge.html)

##That's all I'd like to tell you. Wish you good luck and hard effort!
