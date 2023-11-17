package br.senac.sp.epictask.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.senac.sp.epictask.Model.Task;
import br.senac.sp.epictask.repository.TaskRepository;

@Controller
@RequestMapping("task")

public class taskController {
    @Autowired
    TaskRepository repository;

    @GetMapping
    public String index(Model model){
        var lista = repository.findAll();
        System.out.println(lista);
        model.addAttribute("tasks", lista);
        return "task/index";
    }

    @GetMapping("new")
    public String form(){
        return "task/form.html";
    }

    @PostMapping("new")
    public String save(Task task) {
        repository.save(task);
        return "redirect:/task";
    }
}
