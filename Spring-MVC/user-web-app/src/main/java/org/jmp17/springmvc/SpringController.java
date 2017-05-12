package org.jmp17.springmvc;

import java.util.*;

import org.jmp17.springmvc.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SpringController {

    private static int id = 0;
    private static Map<Integer, User> userMap = new HashMap<>();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        return "redirect:/table";
    }

    static {
        int id = nextId();
        userMap.put( id, new User(id, "Anton", "Savitsky", "savitsan", "antony.sawicki@gmail.com", 12000, "Brest, Belarus", "Epam Systems", "Working...", false));
        id = nextId();
        userMap.put( id, new User(id, "Andrey", "Radkovich", "radkovich", "andrey.radkovich@gmail.com", 15000, "Brest, Belarus", "Epam Systems", "Working...", true));
    }

    @RequestMapping(value = "/table", method = RequestMethod.GET)
    public ModelAndView userList() {
        ModelAndView modelAndView = new ModelAndView( "table", "userList", new ArrayList<User>(userMap.values()) );
        modelAndView.addObject( "tableListTabActive", true );
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user) {
        int id = nextId();
        user.setId( id );
        user.setModifiable( true );
        userMap.put( id, user );
        return "redirect:/table";
    }

    @RequestMapping(value = "/user/update/{id}", method = RequestMethod.POST)
    public String updateUser(@ModelAttribute("user") User user, @PathVariable int id) {
        userMap.replace( id, user );
        return "redirect:/table";
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ModelAndView user(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView( "user", "user", userMap.get( id ) );
        modelAndView.addObject( "userTabActive", true );
        return modelAndView;
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView user(){
        // kinda default admin user
        return user(1);
    }

    @RequestMapping(value = "/user/delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable int id){
        userMap.remove( id );
        return "redirect:/table";
    }

    public static int nextId(){
        return ++id;
    }

}
