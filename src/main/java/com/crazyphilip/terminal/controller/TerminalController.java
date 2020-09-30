package com.crazyphilip.terminal.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServlet;
import static com.crazyphilip.terminal.TerminalApplication.Commands;

@Controller
@CrossOrigin
public class TerminalController extends HttpServlet {

    @RequestMapping("/")
    public String index(String cmd){
        return "index";
    }

    @PostMapping("/command")
    public ResponseEntity<?> getSearchResultViaAjax(@RequestBody String cmd, Errors errors) {
        String result = "";

        if (errors.hasErrors()) {
            result = cmd;
            return ResponseEntity.badRequest().body(result);
        }

        if (Commands.containsKey(cmd)){
            result = Commands.get(cmd);
        }
        //System.out.println(result);
        return ResponseEntity.ok(result);
    }
}
