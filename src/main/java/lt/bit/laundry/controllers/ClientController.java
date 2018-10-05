package lt.bit.laundry.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lt.bit.laundry.entity.Client;
import lt.bit.laundry.service.ClientService;

@Controller
public class ClientController {

    private ClientService service;
    private String sortDateMethod = "ASC";

    @Autowired
    public void setClientService(ClientService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String list(Model model) {
        List<Client> notebook = filterAndSort();
        model.addAttribute("notes", notebook);
        model.addAttribute("sort", sortDateMethod);
        return "index";
    }

    @GetMapping("/sort/{sortDate}")
    public String sortChoose(@PathVariable String sortDate) {
        sortDateMethod = sortDate;
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Client note = service.getClientById(id);
        model.addAttribute("note", note);
        return "operations/edit";
    }

//    @PostMapping("/update")
//    public String saveNote(@RequestParam Integer id, @RequestParam String message,
//                           @RequestParam(value = "done", required = false) boolean done) {
//        service.updateNote(id, message, done);
//        return "redirect:/";
//    }

    @GetMapping("/new")
    public String newNote() {
        return "operations/new";
    }

//    @PostMapping("/save")
//    public String updateNote(@RequestParam String message) {
//        service.saveClient(new Client(message));
//        return "redirect:/";
//    }
//
//    @GetMapping("/delete/{id}")
//    public String delete(@PathVariable Integer id) {
//        service.deleteNote(id);
//        return "redirect:/";
//    }

    private List<Client> filterAndSort() {
        List<Client> notebook = null;
        switch (sortDateMethod) {
            case "ASC":
                notebook = service.findAllByOrderByIdAsc();
                break;
            case "DESC":
                notebook = service.findAllByOrderByIdDesc();
                break;
        }
        return notebook;
    }

}
