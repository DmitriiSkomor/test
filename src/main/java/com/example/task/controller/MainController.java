package com.example.task.controller;

import com.example.task.entity.Part;
import com.example.task.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping("/")
    public String index(){
        return "redirect:/parts";
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @Autowired
    public PartService partService;


    @GetMapping("/parts")                                                                                                                       //2 - all, 0 - optional, 1 - required
    public String getAllParts(Model model, @RequestParam(required = false, defaultValue = "1") int page, @RequestParam(required = false, defaultValue = "2")int requiredFilter, @RequestParam(required = false) String search){
        List<Part> parts;
        int pagesCount;

        if (page < 1) {page++;}

        if (search != null){
            parts = partService.findAll(page,search);
            pagesCount = 1;
        }
        else {
            if (requiredFilter != 2) {
                boolean requiredBool;
                requiredBool = requiredFilter == 1 ? true : false;
                pagesCount = partService.getPagesCount(requiredBool);
                if (page > pagesCount) page = pagesCount;
                parts = partService.findAll(page, requiredBool);

            } else {
                pagesCount = partService.getPagesCount();
                if (page > pagesCount) page = pagesCount;
                parts = partService.findAll(page);
            }

        }
        model.addAttribute("pagesCount", pagesCount);
        model.addAttribute("requiredFilter", requiredFilter);
        model.addAttribute("parts", parts);
        model.addAttribute("computers",partService.collectComputers());
        model.addAttribute("page", page);
        return "partsList";
    }

    @GetMapping("search")
    public String search(@ModelAttribute("searchName") String name){
        return "redirect:/parts?search="+name;
    }
    @GetMapping("/part/{id}")
    public String getById(@PathVariable("id") int id, Model model){
        model.addAttribute("part",partService.getById(id));
        return "showPart";
    }

    @GetMapping("addPart")
    public String createPartPage(@RequestParam int page, Model model, @RequestParam(required = false, defaultValue = "2")int requiredFilter){
        model.addAttribute("page", page);
        model.addAttribute("requiredFilter",requiredFilter);
        return "createPart";
    }

    @PostMapping("addPart")
    public String addPart(@RequestParam int page, @ModelAttribute("part") Part part, @RequestParam(required = false, defaultValue = "2")int requiredFilter){
        partService.save(part);
        return "redirect:/parts?page="+page+"&requiredFilter="+requiredFilter;
    }
    @GetMapping("delete/{id}")
    public String deletePart(@RequestParam int page, @PathVariable("id") int id, @RequestParam(required = false, defaultValue = "2")int requiredFilter){
        partService.delete(id);
        return "redirect:/parts?page="+page+"&requiredFilter="+requiredFilter;
    }


    @GetMapping("update/{id}")
    public String updatePartPage( @RequestParam  int page, @PathVariable("id") int id, Model model, @RequestParam(required = false, defaultValue = "2")int requiredFilter){
        model.addAttribute("part",partService.getById(id));
        model.addAttribute("page", page);
        model.addAttribute("requiredFilter",requiredFilter);
        return "updatePart";
    }
    @PostMapping("update/{id}")
    public String updatePart(@RequestParam int page, @ModelAttribute("part") Part part, @RequestParam(required = false, defaultValue = "2")int requiredFilter){
      partService.update(part);
        return "redirect:/parts?page="+page+"&requiredFilter="+requiredFilter;
    }

}
