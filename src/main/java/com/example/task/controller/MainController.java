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


    @Autowired
    public PartService partService;


    @GetMapping("/parts")                                                                                                                       //2 - all, 0 - optional, 1 - required
    public String getAllParts(Model model, @RequestParam(required = false, defaultValue = "1") int page, @RequestParam(required = false, defaultValue = "2")int requiredFilter, @RequestParam(required = false) String search){
    List<Part> parts;
        if (page < 1) {page++;}

        if (search != null){
            parts = partService.findAll(page,search);
        }
        else {
            if (requiredFilter != 2) {
                boolean requiredBool;
                requiredBool = requiredFilter == 1 ? true : false;

                parts = partService.findAll(page, requiredBool);
                while (parts.size() == 0 && page > 1) {
                    parts = partService.findAll(--page, requiredBool);
                }

            } else {
                parts = partService.findAll(page);
                if (parts.size() == 0 && page > 1) parts = partService.findAll(--page);
            }

        }
        int countComputers = Integer.MAX_VALUE;
        for (Part part : partService.findAll()){
            if (part.getRequired()==1 && part.getCount() < countComputers) countComputers = part.getCount();
        }
        if (countComputers == Integer.MAX_VALUE) countComputers = 0;

        model.addAttribute("requiredFilter", requiredFilter);
        model.addAttribute("parts", parts);
        model.addAttribute("computers",countComputers);
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
        List<Part> allParts = partService.findAll();
        boolean dublicate = false;
        for (int i = 0; i < allParts.size(); i++){
            Part partFromList = allParts.get(i);
            if (partFromList.equals(part)){
                partFromList.setCount(part.getCount() + partFromList.getCount());
                partService.update(partFromList);
                dublicate = true;
            }
        }
        if (!dublicate) partService.save(part);
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
