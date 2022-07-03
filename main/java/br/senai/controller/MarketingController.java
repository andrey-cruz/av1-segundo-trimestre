package br.senai.controller;

import br.senai.model.Funcionario;
import br.senai.model.Marketing;
import br.senai.service.MarketingService;
import br.senai.service.ProjetoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MarketingController {

    @Autowired
    MarketingService marketingService;

    @Autowired
    ProjetoServiceImpl projetoService;

    @GetMapping("/marketing/list")
    public String findAll (Model model){
        model.addAttribute("marketings", marketingService.findAll());
        return "marketing/list";
    }

    @GetMapping("/marketing/add")
    public String add(Model model){
        model.addAttribute("marketing", new Marketing());
        model.addAttribute("projetos", projetoService.findAll());
        return "marketing/add";
    }

    @GetMapping("/marketing/edit/{id}")
    public String edit(Model model, @PathVariable long id){
        System.out.println( marketingService.findById(id));
        model.addAttribute("marketing",marketingService.findById(id));
        return "marketing/edit";
    }

    @PostMapping("/marketing/save")
    public String save(Marketing marketing, Model model){
        try{
            marketingService.save(marketing);
            model.addAttribute("marketing", marketing);
            model.addAttribute("isSaved",true);
            return "marketing/add";
        } catch (Exception e){
            model.addAttribute("marketing", marketing);
            model.addAttribute("isError", true);
            model.addAttribute("errorMsg", e.getMessage());
            return "marketing/add";
        }
    }

    @GetMapping("/marketing/delete/{id}")
    public String delete(@PathVariable long id){
        try{
            marketingService.deleteById(id);
        }catch (Exception e){
            System.out.println("Erro: " + e.getMessage());
        }
        return "redirect:/marketing/list";
    }
}
