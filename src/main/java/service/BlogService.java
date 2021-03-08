package service;

import model.Blog;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class BlogService implements IBlogService{
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<Blog> findALl() {
        String queryStr="SELECT b FROM Blog as b";
        TypedQuery<Blog> query=entityManager.createQuery(queryStr,Blog.class);
        return query.getResultList();
    }

    @Override
    public Blog findById(int id) {
        return entityManager.find(Blog.class,id);
    }

    @Override
    public void save(Blog blog) {
        entityManager.persist(blog);
    }

    @Override
    public void update(Blog blog) {
        entityManager.merge(blog);
    }

    @Override
    public void remove(Blog blog) {
        entityManager.remove(findById(blog.getId()));
    }
}
