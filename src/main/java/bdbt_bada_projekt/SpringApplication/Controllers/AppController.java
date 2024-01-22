package bdbt_bada_projekt.SpringApplication.Controllers;

import bdbt_bada_projekt.SpringApplication.DAO.*;
import bdbt_bada_projekt.SpringApplication.Services.UserAlreadyExistsException;
import bdbt_bada_projekt.SpringApplication.Services.UserService;
import bdbt_bada_projekt.SpringApplication.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;

@Configuration
public class AppController implements WebMvcConfigurer {


    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("login");
        registry.addViewController("/").setViewName("login");
        registry.addViewController("").setViewName("login");
        registry.addViewController("/main").setViewName("main");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/main_admin").setViewName("admin/main_admin");
        registry.addViewController("/main_user").setViewName("user/main_user");
    }

    @Controller
    public class DashboardController
    {
        @RequestMapping
                ("/main")
        public String defaultAfterLogin
                (HttpServletRequest request) {
            if
            (request.isUserInRole
                    ("ADMIN")) {
                return "redirect:/main_admin";
            }
            else if
            (request.isUserInRole
                            ("USER")) {
                return "redirect:/main_user";
            }
            else
            {
                return "redirect:/index";
            }
        }
    }

    @Controller
    public class showAdminPage{

        @Autowired
        private CarsDAO carsDAO;

        @RequestMapping(value={"/main_admin"})
        public String showAdminPage(Model model) {
            List<Cars> listCars = carsDAO.list();
            model.addAttribute("Cars", listCars);
            return "admin/main_admin";
        }

        @GetMapping("/Cars")
        public String showCarsAdminPage(Model model) {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            model.addAttribute("carsDAO", carsDAO.list());
            return "admin/Cars";
        }



    }



    @RequestMapping(value={"/main_user"})
    public String showUserPage(Model model) {
        return "user/main_user";
    }


}
