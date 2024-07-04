package com.abcbank.testsupport;

import org.junit.jupiter.api.Assertions;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

public class TestUtil {

    public static <T> T toResponse(Class<T> className, ResultActions result) {
        try {
            String content = result
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                    .andReturn()
                    .getResponse()
                    .getContentAsString();
            return null;//MessageMarshaller.fromJson(className, content);
        } catch (Exception e) {
            Assertions.fail("Cannot read or convert response: " + e.getMessage());
            throw new IllegalStateException("Cannot read or convert response", e);
        }
    }
}
