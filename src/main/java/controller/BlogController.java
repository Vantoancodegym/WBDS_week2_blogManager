package controller;

import model.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.IBlogService;

import java.util.List;

@Controller
@RequestMapping("blogs")
public class BlogController {
    @Autowired
    private IBlogService iBlogService;
    @GetMapping("")
    public ModelAndView showAll(){
        List<Blog> list=iBlogService.findALl();
        return new ModelAndView("home","list",list);
    }
    @GetMapping("detail")
    public ModelAndView detail(@RequestParam int id){
        Blog blog= iBlogService.findById(id);
        return new ModelAndView("detail","blog",blog);
    }
    @GetMapping("delete")
    public ModelAndView delete(@RequestParam int id){
        Blog blog=iBlogService.findById(id);
        iBlogService.remove(blog);
        return new ModelAndView("redirect:/blogs");
    }
    @GetMapping("create")
    public ModelAndView showFormCreate(){
        return new ModelAndView("create","blog",new Blog());
    }
    @PostMapping("create")
    public ModelAndView create(@ModelAttribute Blog blog){
        iBlogService.save(blog);
        return new ModelAndView("redirect:/blogs");
    }
    @GetMapping("edit")
    public ModelAndView showFormEdit(@RequestParam int id ){
        Blog blog=iBlogService.findById(id);
        return new ModelAndView("edit","blog",blog);
    }
    @PostMapping("edit")
    public ModelAndView edit(@RequestParam int id,@ModelAttribute Blog blog )    {
       blog.setId(id);
       iBlogService.update(blog);
       return new ModelAndView("redirect:/blogs");

    }


}
