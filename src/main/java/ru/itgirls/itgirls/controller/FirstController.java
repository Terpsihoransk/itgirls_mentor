package ru.itgirls.itgirls.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("index")
public class FirstController {

    private List<Map<String, String>> messages = new ArrayList<Map<String, String>>() {{
        add(new HashMap<String, String>() {{ put("id", "1"); put("Иван", "Иванов"); }});
        add(new HashMap<String, String>() {{ put("id", "2"); put("Петр", "Петров"); }});
        add(new HashMap<String, String>() {{ put("id", "3"); put("Константин", "Сидоров"); }});
    }};

    @GetMapping
    public List<Map<String, String>> list() {
        return messages;
    }

    @GetMapping("{id}")
    public Map<String, String> getOne(@PathVariable String id) {
        return messages.stream()
                .filter(message -> message.get("id").equals(id))
                .findFirst()
                .orElseThrow();
    }
}
