/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.inventory.Controller;

import java.io.IOException;
import java.util.Vector;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import test.inventory.dao.CategoryRepository;
import test.inventory.dao.productRepository;

/**
 *
 * @author Aaron
 */
@Controller
public class IndexController {
   
    
       @GetMapping("/")
       public ModelAndView home(HttpServletRequest request, ModelMap model) throws ServletException, IOException{
           HttpSession session = request.getSession();
          
           //Vector<String> result=(Vector<String>) session.getAttribute("result");     
        return new ModelAndView("home");
        //return "categorylist";
    }
}
