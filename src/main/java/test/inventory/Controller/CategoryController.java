/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.inventory.Controller;

import test.inventory.dao.CategoryRepository;
import test.inventory.model.category;
import java.io.IOException;
import java.util.List;
import java.util.Vector;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
/**
 *
 * @author Aaron
 * 
 */
@Controller
public class CategoryController {
    @Resource
    private CategoryRepository CategoryRepo;
    
    @GetMapping(value={"/category","/categories"})
    public ModelAndView categoryform() {
        return new ModelAndView("category_form", "CategoryForm", new categoryform());
    }

    public static class categoryform {

        private String categoryName;
        private String description;

        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        
    }

    @PostMapping(value={"/category","/categories"})
    public String categoryresult(categoryform categoryform, ModelMap model, HttpServletRequest request) throws IOException {
        
        model.addAttribute("categoryName", categoryform.getCategoryName());
        model.addAttribute("description", categoryform.getDescription());
        
        
        HttpSession session = request.getSession();
        //Vector<String> v = new Vector<String>();
        // if (session.getAttribute("result")==null){
        //    session.setAttribute("result", v);
        //} 
        //else {
        //    v = (Vector<String>) session.getAttribute("result");
        //}
        
        //String resultstring = multiplyform.getArg1() +" x "+ multiplyform.getArg2() + " = "+ sum;
        //v.add(resultstring);
        
        //session.setAttribute("result",v);
        //System.out.println(v);
        category newInventory = new category(categoryform.getCategoryName().toString(),categoryform.getDescription().toString());
        CategoryRepo.save(newInventory);
        session.setAttribute("result",CategoryRepo.findAll());
        return "categorylist";
    }
    
    @GetMapping("/categorylist")
       public ModelAndView categorylist(HttpServletRequest request, ModelMap model) throws ServletException, IOException{
           HttpSession session = request.getSession();
           model.addAttribute("result", CategoryRepo.findAll());
           //Vector<String> result=(Vector<String>) session.getAttribute("result");     
        return new ModelAndView("categorylist");
        //return "categorylist";
    }
}
