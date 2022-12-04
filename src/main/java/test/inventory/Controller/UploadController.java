/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.inventory.Controller;

import com.opencsv.CSVParser;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import org.apache.commons.csv.CSVFormat;
import java.util.List;
import java.util.Vector;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import test.inventory.dao.CategoryRepository;
import test.inventory.dao.InventoryRepository;
import test.inventory.dao.productRepository;
import test.inventory.model.Inventory;
import test.inventory.model.product;

/**
 *
 * @author Aaron
 */
@Controller
@RequestMapping("/upload")
public class UploadController {
     
    @Resource
    productRepository productRepo;
    
    @Resource
    InventoryRepository inventoryRepo;
    
    @GetMapping("/product")
    public ModelAndView uploadform() {
        return new ModelAndView("Upload_form", "uploadForm", new uploadform());
    }
    
    @GetMapping("/inventory")
    public ModelAndView uploadBform() {
        return new ModelAndView("Upload_form", "uploadForm", new uploadform());
    }
    
    public static class uploadform {

        private MultipartFile attachments;

        public MultipartFile getAttachments() {
            return attachments;
        }

        public void setAttachments(MultipartFile attachments) {
            this.attachments = attachments;
        }
    }

    
       
 
    
    @PostMapping("/product")
       public String processUpload(uploadform form, ModelMap model, HttpServletRequest request) throws IOException, ServletException {
      
       System.out.println(form.getAttachments().toString());
       
       
       InputStreamReader isr = null;
            BufferedReader br = null;
            
                isr = new InputStreamReader(form.getAttachments().getInputStream());
                br = new BufferedReader(isr);
                String line = null;
                List<List<String>> strs = new ArrayList<List<String>>();
                while ((line = br.readLine()) != null){
                    strs.add(Arrays.asList(line.split(",")));
                }
                
        for (int i = 1; i <= strs.size()-1; i++) {
            String productName = null ;
            String code = null;
            double weight = 0;   
            for (int v=0; v<=strs.get(i).size(); v++){
                    if (v==0){productName = strs.get(i).get(v);}
                    if (v==1){code = strs.get(i).get(v);}
                    if (v==2){weight = Double.parseDouble(strs.get(i).get(v));}
                    }
                    
            product newproduct = new product(productName,code,weight);
            productRepo.save(newproduct);
                  
            }
        HttpSession session = request.getSession();
        model.addAttribute("result",productRepo.findAll());  
        //System.out.println(strs.get(1).size());          
        //System.out.println(strs.get(1).size());       
        //System.out.println(strs.get(1).get(0));
        //System.out.println(strs.get(1).get(1));
        //System.out.println(strs.get(1).get(2));
        
        return "home";
        }
       
       @PostMapping("/inventory")
       public String processUploadB(uploadform form, ModelMap model, HttpServletRequest request) throws IOException, ServletException {
      
       System.out.println(form.getAttachments().toString());
       
       
       InputStreamReader isr = null;
            BufferedReader br = null;
            
                isr = new InputStreamReader(form.getAttachments().getInputStream());
                br = new BufferedReader(isr);
                String line = null;
                List<List<String>> strs = new ArrayList<List<String>>();
                while ((line = br.readLine()) != null){
                    strs.add(Arrays.asList(line.split(",")));
                }
                
        for (int i = 1; i <= strs.size()-1; i++) {
            int productid = 0 ;
            String location = null;
            int quantity = 0;   
            for (int v=0; v<=strs.get(i).size(); v++){
                    if (v==0){productid = Integer.parseInt(strs.get(i).get(v));}
                    if (v==1){location = strs.get(i).get(v);}
                    if (v==2){quantity = Integer.parseInt(strs.get(i).get(v));}
                    }
                    
            Inventory newinventory = new Inventory(productid,location,quantity);
            inventoryRepo.save(newinventory);
                  
            }
        HttpSession session = request.getSession();
        model.addAttribute("result",inventoryRepo.findAll());  
            
        return "home";
        }
                
                   
     
}
