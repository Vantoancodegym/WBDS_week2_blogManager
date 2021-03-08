package service;

import model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findALl();
    Blog findById(int id);
    void save(Blog blog);
    void update(Blog blog);
    void remove(Blog blog);
}
