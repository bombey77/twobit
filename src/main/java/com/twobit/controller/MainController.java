package com.twobit.controller;

import com.twobit.domain.Message;
import com.twobit.domain.User;
import com.twobit.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
    public String main(@RequestParam(required = false) String message, Model model) {
        Iterable<Message> messages;
        if (message != null && !message.isEmpty()) {
            messages = messageRepo.findByMessage(message);
            model.addAttribute("filter", message);
        } else {
            messages = messageRepo.findAll();
        }
        model.addAttribute("messages", messages);
        return "main";
    }

    @PostMapping
    public String addMessage(@AuthenticationPrincipal User user, @RequestParam String message, Model model) {
        if (user != null && message != null && !message.isEmpty()) {
            messageRepo.save(new Message(message, user));
        }
        model.addAttribute("messages", messageRepo.findAll());
        return "main";
    }
}
