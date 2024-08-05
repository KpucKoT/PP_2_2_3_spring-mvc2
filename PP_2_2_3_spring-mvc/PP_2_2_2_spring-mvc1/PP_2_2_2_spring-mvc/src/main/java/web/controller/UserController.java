package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userServiceImpl;

    @Autowired
    public UserController(UserService userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping
    public String showAllUsers(Model model) {
        model.addAttribute("users", userServiceImpl.getUsers());
        return "users";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "new";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userServiceImpl.getUser(id));
        return "edit";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") User user) {
        userServiceImpl.createUser(user);
        return "redirect:/users";
    }

    @PostMapping ("/{id}")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userServiceImpl.updateUser(id, user);
        return "redirect:/users";
    }

    @GetMapping("{id}/delete")
    public String deleteUser(@ModelAttribute("user") User user, @PathVariable("id") int id){
        userServiceImpl.deleteUser(id, user);
        return "redirect:/users";
    }

}
