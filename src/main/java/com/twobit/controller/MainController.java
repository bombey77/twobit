package com.twobit.controller;

import com.twobit.domain.Message;
import com.twobit.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    private MessageRepo messageRepo;

    public MessageRepo getMessageRepo() {
        return messageRepo;
    }

    @Autowired
    public void setMessageRepo(MessageRepo messageRepo) {
        this.messageRepo = messageRepo;
    }

    @GetMapping
    public String main(Model model) {
        model.addAttribute("messages", messageRepo.findAll());
        return "main";
    }

    @PostMapping
    public String addMessage(@RequestParam String message, Model model) {
        if (message != null && !message.isEmpty()) {
            messageRepo.save(new Message(message));
        }
        model.addAttribute("messages", messageRepo.findAll());
        return "main";
    }

    @PostMapping("/filter")
    public String findMessage(@RequestParam(required = false) String message, Model model) {
        Iterable<Message> messages;
        if (message != null && !message.isEmpty()) {
            messages = messageRepo.findByMessage(message);
        } else {
            messages = messageRepo.findAll();
        }
        model.addAttribute("messages", messages);
        return "main";
    }
}
