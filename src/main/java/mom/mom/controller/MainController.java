/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mom.mom.controller;

import com.google.gson.Gson;
import mom.mom.interfaceserviceimplement.CustomerServiceImplement;
import mom.mom.interfaceserviceimplement.DistrictServiceImplement;
import mom.mom.interfaceserviceimplement.EmployeeServiceImplement;
import mom.mom.interfaceserviceimplement.MeetingServiceImplement;
import mom.mom.interfaceserviceimplement.ProvinceServiceImplement;
import mom.mom.interfaceserviceimplement.RoleServiceImplement;
import mom.mom.interfaceserviceimplement.StatusServiceImplement;
import mom.mom.interfaceserviceimplement.SubdistrictServiceImplement;
import mom.mom.interfaceserviceimplement.UrbanvillageServiceImplement;
import mom.mom.model.Customer;
import mom.mom.model.District;
import mom.mom.model.Employee;
import mom.mom.model.Province;
import mom.mom.model.Role;
import mom.mom.model.Status;
import mom.mom.model.Subdistrict;
import mom.mom.model.Urbanvillage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author HARRY-PC
 */
@Controller
public class MainController {
    
    @Autowired
    public EmployeeServiceImplement esi;
    
    @Autowired
    public CustomerServiceImplement csi;
    
    @Autowired
    public RoleServiceImplement rsi;
    
    @Autowired
    public StatusServiceImplement ssi;
    
    @Autowired
    public ProvinceServiceImplement psi;
    
    @Autowired
    public DistrictServiceImplement dsi;
    
    @Autowired
    public SubdistrictServiceImplement sdsi;
    
    @Autowired
    public UrbanvillageServiceImplement usi;
    
    @Autowired
    public MeetingServiceImplement msi;
    
    @GetMapping("/")
    public String index(){
        return "index";
    }
    
    //Start Controller Employee
    @GetMapping("/employee")
    public String employee(Model model){
        model.addAttribute("employee", esi.findAll());
        model.addAttribute("role", rsi.findAll());
        return "employee";
    }
    
    @PostMapping("/employee/save")
    public String saveEmployee(@RequestParam(value = "name") String name,
            @RequestParam(value = "lastname") String lastName,
            @RequestParam(value = "phone") String phone,
            @RequestParam(value = "email") String email,
            @RequestParam(value = "password") String password,
            @RequestParam(value = "role")int role){
        Employee employee = new Employee(name, lastName, phone, email, 
                password, new Role(role));
        esi.save(employee);
        return "redirect:/employee";
    }
    
    @PostMapping("/employee/edit")
    public String editEmployee(@RequestParam(value = "id") int id,
            @RequestParam(value = "name") String name,
            @RequestParam(value = "lastname") String lastName,
            @RequestParam(value = "phone") String phone,
            @RequestParam(value = "email") String email,
            @RequestParam(value = "password") String password,
            @RequestParam(value = "role")int role){
        Employee employee = new Employee(id, name, lastName, phone, email, 
                password, new Role(role));
        esi.save(employee);
        return "redirect:/employee";
    }
    
    @GetMapping("/employee/delete/{id}")
    public String deleteEmployee(@PathVariable(value = "id") int id){
        esi.delete(id);
        return "redirect:/employee";
    }
    //End Controller Employee
    
    //Start Controller Customer
    @GetMapping("/customer")
    public String customer(Model model){
        model.addAttribute("customer", csi.findAll());
        model.addAttribute("province", psi.findAll());
        model.addAttribute("district", dsi.findAll());
        model.addAttribute("subdistrict", sdsi.findAll());
        model.addAttribute("urbanvillage", usi.findAll());
        return "customer";
    }
    
    @GetMapping("/loadDistrict/{id}")
    public String loadDistrict(@PathVariable(value = "id") int id){
        Gson gson = new Gson();
        return gson.toJson(csi.findById(id).get().getDistrict());
    }
    
    @PostMapping("/customer/save")
    public String saveCustomer(@RequestParam(value = "name")String name,
            @RequestParam(value = "pic")String pic,
            @RequestParam(value = "phone")String phone,
            @RequestParam(value = "email")String email,
            @RequestParam(value = "address")String address,
            @RequestParam(value = "province")int province,
            @RequestParam(value = "district")int district,
            @RequestParam(value = "subdistrict")int subdistrict,
            @RequestParam(value = "urbanvillage")int urbanvillage){
        Customer customer = new Customer(name, pic, phone, email, address, 
                new Province(province), 
                new District(district), 
                new Subdistrict(subdistrict), 
                new Urbanvillage(urbanvillage));
        csi.save(customer);
        return "redirect:/customer";
    }
    
    @PostMapping("/customer/edit")
    public String editCustomer(@RequestParam(value = "id") int id,
            @RequestParam(value = "name")String name,
            @RequestParam(value = "pic")String pic,
            @RequestParam(value = "phone")String phone,
            @RequestParam(value = "email")String email,
            @RequestParam(value = "address")String address,
            @RequestParam(value = "province")int province,
            @RequestParam(value = "district")int district,
            @RequestParam(value = "subdistrict")int subdistrict,
            @RequestParam(value = "urbanvillage")int urbanvillage){
        Customer customer = new Customer(id, name, pic, phone, email, address, 
                new Province(province), 
                new District(district), 
                new Subdistrict(subdistrict), 
                new Urbanvillage(urbanvillage));
        csi.save(customer);
        return "redirect:/customer";
    }
    
    @GetMapping("/customer/delete/{id}")
    public String deleteCustomer(@PathVariable(value = "id") int id){
        csi.delete(id);
        return "redirect:/customer";
    }
    //End Controller Customer
    
    // Start Controller Role
    @GetMapping("/role")
    public String role(Model model){
        model.addAttribute("role", rsi.findAll());
        return "role";
    }
    
    @PostMapping("/role/save")
    public String saveRole(@RequestParam(value = "name") String name){
        Role role = new Role(name);
        rsi.save(role);
        return "redirect:/role";
    }
    
    @PostMapping("/role/edit")
    public String editRole(@RequestParam(value = "id") int id, 
            @RequestParam(value = "name") String name){
        Role role = new Role(id, name);
        rsi.save(role);
        return "redirect:/role";
    }
    
    @GetMapping("/role/delete/{id}")
    public String deleteRole(@PathVariable(value = "id") int id){
        rsi.delete(id);
        return "redirect:/role";
    }
    //End Controller Role
    
    //Start Controller Status
    @GetMapping("/status")
    public String status(Model model){
        model.addAttribute("status", ssi.findAll());
        return "status";
    }
    
    @PostMapping("/status/save")
    public String saveStatus(@RequestParam(value = "name") String name){
        Status status = new Status(name);
        ssi.save(status);
        return "redirect:/status";
    }
    
    @PostMapping("/status/edit")
    public String editStatus(@RequestParam(value = "id") int id, 
            @RequestParam(value = "name") String name){
        Status status = new Status(id, name);
        ssi.save(status);
        return "redirect:/status";
    }
    
    @GetMapping("/status/delete/{id}")
    public String deleteStatus(@PathVariable(value = "id") int id){
        ssi.delete(id);
        return "redirect:/status";
    }
    //End Controller Status
    
    //Start Controller Province
    @GetMapping("/province")
    public String province(Model model){
        model.addAttribute("province", psi.findAll());
        return "province";
    }
    
    @PostMapping("/province/save")
    public String saveProvince(@RequestParam(value = "name") String name){
        Province province = new Province(name);
        psi.save(province);
        return "redirect:/province";
    }
    
    @PostMapping("/province/edit")
    public String editProvince(@RequestParam(value = "id") int id, 
            @RequestParam(value = "name") String name){
        Province province = new Province(id, name);
        psi.save(province);
        return "redirect:/province";
    }
    
    @GetMapping("/province/delete/{id}")
    public String deleteProvince(@PathVariable(value = "id") int id){
        psi.delete(id);
        return "redirect:/province";
    }
    //End Controller Province
    
    //Start Controller District
    @GetMapping("/district")
    public String district(Model model){
        model.addAttribute("district", dsi.findAll());
        model.addAttribute("province", psi.findAll());
        return "district";
    }
    
    @PostMapping("/district/save")
    public String saveDistrict(@RequestParam(value = "name") String name, 
            @RequestParam(value = "province") int province){
        District district = new District(name, new Province(province));
        dsi.save(district);
        return "redirect:/district";
    }
    
    @PostMapping("/district/edit")
    public String editDistrict(@RequestParam(value = "id") int id, 
            @RequestParam(value = "name") String name,
            @RequestParam(value = "province") int province){
        District district = new District(id, name, new Province(province));
        dsi.save(district);
        return "redirect:/district";
    }
    
    @GetMapping("/district/delete/{id}")
    public String deleteDistrict(@PathVariable(value = "id") int id){
        dsi.delete(id);
        return "redirect:/district";
    }
    //End Controller District
    
    //Start Controller Sub-District
    @GetMapping("/subdistrict")
    public String subdistrict(Model model){
        model.addAttribute("subdistrict", sdsi.findAll());
        model.addAttribute("district", dsi.findAll());
        return "subdistrict";
    }
    
    @PostMapping("/subdistrict/save")
    public String saveSubdistrict(@RequestParam(value = "name") String name, 
            @RequestParam(value = "district") int district){
        Subdistrict subdistrict = new Subdistrict(name, new District(district));
        sdsi.save(subdistrict);
        return "redirect:/subdistrict";
    }
    
    @PostMapping("/subdistrict/edit")
    public String editSubdistrict(@RequestParam(value = "id") int id, 
            @RequestParam(value = "name") String name,
            @RequestParam(value = "district") int district){
        Subdistrict subdistrict = new Subdistrict(id, name, new District(district));
        sdsi.save(subdistrict);
        return "redirect:/subdistrict";
    }
    
    @GetMapping("/subdistrict/delete/{id}")
    public String deleteSubdistrict(@PathVariable(value = "id") int id){
        sdsi.delete(id);
        return "redirect:/subdistrict";
    }
    //End Controller Sub-District
    
    //Start Controller Urban-Village
    @GetMapping("/urbanvillage")
    public String urbanvillage(Model model){
        model.addAttribute("urbanvillage", usi.findAll());
        model.addAttribute("subdistrict", sdsi.findAll());
        return "urbanvillage";
    }
    
    @PostMapping("/urbanvillage/save")
    public String saveUrbanvillage(@RequestParam(value = "name") String name,
            @RequestParam(value = "postalcode") String postalCode,
            @RequestParam(value = "subdistrict") int subdistrict){
        Urbanvillage urbanvillage = new Urbanvillage(name, postalCode, new Subdistrict(subdistrict));
        usi.save(urbanvillage);
        return "redirect:/urbanvillage";
    }
    
    @PostMapping("/urbanvillage/edit")
    public String editUrbanvillage(@RequestParam(value = "id") int id, 
            @RequestParam(value = "name") String name,
            @RequestParam(value = "postalcode") String postalCode,
            @RequestParam(value = "subdistrict") int subdistrict){
        Urbanvillage urbanvillage = new Urbanvillage(id, name, postalCode, new Subdistrict(subdistrict));
        usi.save(urbanvillage);
        return "redirect:/urbanvillage";
    }
    
    @GetMapping("/urbanvillage/delete/{id}")
    public String deleteUrbanvillage(@PathVariable(value = "id") int id){
        usi.delete(id);
        return "redirect:/urbanvillage";
    }
    //End Controller Urban-Village
    
}
