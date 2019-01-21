package net.lebedko.requestparamvalidation;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("/request")
@Validated
public class RequestController {

    @GetMapping("/valid")
    public String request(@RequestParam("value")
                          @Min(2)
                          @Max(5)
                          @NotBlank String value) {
        return value;
    }
}
