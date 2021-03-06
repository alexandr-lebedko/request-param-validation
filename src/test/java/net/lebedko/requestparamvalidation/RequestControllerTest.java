package net.lebedko.requestparamvalidation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest
public class RequestControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void requestWithValid_whenParamIsInvalid_validationNotTriggered() throws Exception {
        mockMvc.perform(get("/request/valid")
                .param("value", "a"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
}