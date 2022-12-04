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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import test.inventory.dao.CategoryRepository;
import test.inventory.dao.InventoryRepository;
import test.inventory.dao.productRepository;
import test.inventory.model.Inventory;

/**
 *
 * @author Aaron
 */
@Controller
public class TransferController {
    
    @Resource
    InventoryRepository inventoryRepo;
    
    @Resource
    productRepository productRepo;
    
   @GetMapping("/transfer/{inventoryid}")
    public String view(@PathVariable("inventoryid") int inventoryid, ModelMap model) {
        model.addAttribute("result", inventoryRepo.findAll());
        
        Inventory i = inventoryRepo.findById(inventoryid).orElse(null);
       
        model.addAttribute("inventoryDetail", inventoryRepo.findById(inventoryid).orElse(null));
        model.addAttribute("product", productRepo.findById(i.getProductid()).orElse(null));
        System.out.println(inventoryRepo.findById(inventoryid));
        //model.addAttribute("result", inventoryRepo.findInventoryById(inventoryid));
        model.addAttribute("transferForm", new transferForm());
        
        //Inventory temp =inventoryRepo.findById(inventoryid).orElse(null);
        
       //System.out.println(temp.getId());    
        return "transferInventory";
    }
    
     public static class transferForm {

        private int inventoryid;
        private String location;
        private int amount;

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }        

        public int getInventoryid() {
            return inventoryid;
        }

        public void setInventoryid(int inventoryid) {
            this.inventoryid = inventoryid;
        }
    }
     
     @PostMapping("/transfer/{inventoryid}")
       public String processUpload(transferForm form, ModelMap model, HttpServletRequest request) throws IOException, ServletException {
        int fromNewAmount=0;
        int toNewAmount = 0;
        HttpSession session = request.getSession();
        Inventory temp =inventoryRepo.findById(form.getInventoryid()).orElse(null);//from
        Inventory temp2 =inventoryRepo.findByProductidAndLocation(temp.getProductid(),form.getLocation());//to
        //Inventory temp2 =inventoryRepo.findById(form.getLocation()).orElse(null);
        if (form.getAmount()==0){
            model.addAttribute("status","Amount cannot be zero");
            return "home";
            }   
        
        if (temp2!=null){
            System.out.println(temp2.getId());
            System.out.println(temp.getLocation());
            System.out.println(form.getLocation());
            System.out.println(form.getInventoryid());
            if (temp.getLocation().equals(form.getLocation())){
            model.addAttribute("status","Cannot transfer to same location");
            return "home";
            }                
           //System.out.println("1");
           if (temp.getQuantity()>=form.getAmount()){
                fromNewAmount = temp.getQuantity()-form.getAmount();     
                toNewAmount = form.getAmount()+temp2.getQuantity();
           } else {
            model.addAttribute("status","Not enough quantity for transfer");
            return "home";
           }
           
           if (fromNewAmount ==0){
               inventoryRepo.deleteById(temp.getId());
               inventoryRepo.save(new Inventory(temp2.getId(),temp2.getProductid(),temp2.getLocation(),toNewAmount));
           }
           else {
           inventoryRepo.save(new Inventory(temp.getId(),temp.getProductid(),temp.getLocation(),fromNewAmount));
           inventoryRepo.save(new Inventory(temp2.getId(),temp2.getProductid(),temp2.getLocation(),toNewAmount));
           }
        } else {            
           //System.out.println("2");
           if (temp.getQuantity()>=form.getAmount()){
                fromNewAmount = temp.getQuantity()-form.getAmount();     
                toNewAmount = form.getAmount();
           }
          
           inventoryRepo.save(new Inventory(temp.getId(),temp.getProductid(),temp.getLocation(),fromNewAmount));
           inventoryRepo.save(new Inventory(temp.getProductid(),form.getLocation(),toNewAmount));
        }
        
          
        System.out.println(form.getAmount());
        //Inventory test = new Inventory(2,1,"CWB",100);
        //inventoryRepo.save(test);
        model.addAttribute("result", inventoryRepo.findAll()); 
        return "home";
        }
     
     
     
}
