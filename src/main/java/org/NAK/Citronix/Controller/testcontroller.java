package org.NAK.Citronix.Controller;

import org.mapstruct.control.MappingControl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/test")
public class testcontroller {

    @GetMapping("/home")
    public String home() {
        return "Hello World";
    }
}
