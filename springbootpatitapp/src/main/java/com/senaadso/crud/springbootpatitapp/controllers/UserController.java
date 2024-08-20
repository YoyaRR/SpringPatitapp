package com.senaadso.crud.springbootpatitapp.controllers;

import com.senaadso.crud.springbootpatitapp.modelos.User;
import com.senaadso.crud.springbootpatitapp.modelos.UserDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import com.senaadso.crud.springbootpatitapp.services.UsersRepository;

import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping("users")

public class UserController {
    @Autowired
    private UsersRepository repo;

    @GetMapping({"","/"})
    public String mostrarListaUsers(Model model) {
        List<User> users = repo.findAll();
        model.addAttribute("users", users);

        return "users/index";
    }

    @GetMapping("/crear")
    public String crearUser(Model model) {
        UserDTO userDTO = new UserDTO();
        model.addAttribute("userDTO", userDTO);

        return "users/crearuser";
    }

    @PostMapping("/crear")
    public String crearUser(
            @Valid @ModelAttribute UserDTO userDTO,
            BindingResult resultado){

        if (userDTO.getNombre().isEmpty()) {
            resultado.addError(new FieldError("userDTO", "nombre", "El nombre del usuario debe ser obligatorio"));
        }

        if (userDTO.getCedula() == 0) {
            resultado.addError(new FieldError("userDTO", "cedula", "La cedula del usuario no puede ser igual a 0"));
        }

        if(resultado.hasErrors()) {
            return "users/crearuser";
        }

        Date fechaRegistro = new Date(System.currentTimeMillis());

        User user = new User();
        user.setNombre(userDTO.getNombre());
        user.setCedula(userDTO.getCedula());
        user.setDireccion(userDTO.getDireccion());
        user.setEmail(userDTO.getEmail());
        user.setUsuario(userDTO.getUsuario());
        user.setContrasena(userDTO.getContrasena());
        user.setFecha_de_registro(fechaRegistro);

        repo.save(user);

        return "redirect:/users";
    }

    @GetMapping("/editar")
    public String showEditPage(Model model, @RequestParam int id){
        try {
            User user = repo.findById(id).get();

            model.addAttribute("user", user);

            UserDTO userDTO = new UserDTO();
            userDTO.setNombre(user.getNombre());
            userDTO.setCedula(user.getCedula());
            userDTO.setDireccion(user.getDireccion());
            userDTO.setEmail(user.getEmail());
            userDTO.setUsuario(user.getUsuario());
            userDTO.setContrasena(user.getContrasena());

            model.addAttribute("userDTO", userDTO);
        } catch (Exception ex) {
            System.out.println("Excepcion al editar: " + ex.getMessage());
            return "redirect:/users";
        }

        return "users/editarUser";
    }

    @PostMapping("/editar")
    public String actualizarUser(Model model, @RequestParam int id,
            @Valid @ModelAttribute UserDTO userDTO,
            BindingResult resultado){

        try {
            if (userDTO.getNombre().isEmpty()) {
                resultado.addError(new FieldError("userDTO", "nombre", "El nombre del usuario debe ser obligatorio"));
            }

            if (userDTO.getCedula() == 0) {
                resultado.addError(new FieldError("userDTO", "cedula", "La cedula del usuario no puede ser igual a 0"));
            }

            if(resultado.hasErrors()) {
                return "users/editarUser";
            }

            User user = repo.findById(id).get();

            model.addAttribute("user", user);

            user.setNombre(userDTO.getNombre());
            user.setUsuario(userDTO.getUsuario());
            user.setCedula(userDTO.getCedula());
            user.setDireccion(userDTO.getDireccion());
            user.setEmail(userDTO.getEmail());
            user.setContrasena(userDTO.getContrasena());

            repo.save(user);
        } catch (Exception ex) {
            System.out.println("Excepcion al grabar la Edicion: " + ex.getMessage());
            return "redirect:/users";
        }
        return "redirect:/users";
    }

    @GetMapping("/eliminar")
    public String eliminarUser(@RequestParam int id) {
        try {
            User user = repo.findById(id).get();

            repo.delete(user);

        } catch (Exception ex) {
            System.out.println("Excepcion al eliminar Usuario: " + ex.getMessage());
            return "redirect:/users";
        }
        List<User> users = repo.findAll();

        return "redirect:/users";
    }

}
