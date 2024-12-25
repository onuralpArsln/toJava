package com.initapi.firstspring.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HtmlController {

    @GetMapping("/welcome")
    public String getDynamicPage(@RequestParam(defaultValue = "Guest") String name) {
        return """
            <!DOCTYPE html>
            <html lang="en">
            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Dynamic Page</title>
                <style>
                    body { font-family: Arial, sans-serif; text-align: center; margin-top: 50px; }
                    h1 { color: #4CAF50; }
                    ul { list-style-type: none; padding: 0; }
                    li { padding: 5px; }
                </style>
            </head>
            <body>
                <h1>Welcome, %s!</h1>
               <p>This is a simple HTML GUI served by your API.</p>
            </body>
            </html>
            """.formatted(name);
    }
}

// http://localhost:8080/welcome?name=Alp
