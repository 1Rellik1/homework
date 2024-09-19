package scopestest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import scopes.ScopesApplication;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Класс тестов для скоупов session и request.
 * globalSession не реализовывался так как начиная со spring 5 он не поддерживается.
 * От него отказались т.к. избавились от поддержки портлетов, а в отрыве от них данный скоуп идентичен session.
 *
 * @author Alexey Gayntsev
 * @since 2024.09.15
 */
@SpringBootTest(classes = ScopesApplication.class)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class ScopeTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testRequestScopeWithOneSession() throws Exception {
        MockHttpServletRequestBuilder getRequest = get("/scope/request/message/get");
        //Выполняем первый запрос для получения сессии, ее используем далее для всех запросов.
        MockHttpSession session = (MockHttpSession) mockMvc.perform(getRequest).andReturn().getRequest().getSession();

        MockHttpServletRequestBuilder getRequestWithSession = getRequest.session(session);
        MockHttpServletRequestBuilder updateRequestWithSession = get("/scope/request/message/update").session(session);


        mockMvc.perform(getRequestWithSession).andExpect(status().isOk())
                .andExpect(content().string(containsString("")));
        mockMvc.perform(updateRequestWithSession).andExpect(status().isOk())
                .andExpect(content().string(containsString("text")));
        mockMvc.perform(getRequestWithSession).andExpect(status().isOk())
                .andExpect(content().string(containsString("")));
    }

    @Test
    public void testRequestScopeWithDifferentSession() throws Exception {
        MockHttpServletRequestBuilder getRequest = get("/scope/request/message/get");
        MockHttpServletRequestBuilder updateRequest = get("/scope/request/message/update");


        mockMvc.perform(getRequest).andExpect(status().isOk())
                .andExpect(content().string(containsString("")));
        mockMvc.perform(updateRequest).andExpect(status().isOk())
                .andExpect(content().string(containsString("text")));
        mockMvc.perform(getRequest).andExpect(status().isOk())
                .andExpect(content().string(containsString("")));
    }

    @Test
    public void testSessionScopeWithOneSession() throws Exception {
        MockHttpServletRequestBuilder getRequest = get("/scope/session/message/get");
        //Выполняем первый запрос для получения сессии, ее используем далее для всех запросов.
        MockHttpSession session = (MockHttpSession) mockMvc.perform(getRequest).andReturn().getRequest().getSession();

        MockHttpServletRequestBuilder getRequestWithSession = getRequest.session(session);
        MockHttpServletRequestBuilder updateRequestWithSession = get("/scope/session/message/update").session(session);

        mockMvc.perform(getRequestWithSession).andExpect(status().isOk())
                .andExpect(content().string(containsString("")));
        mockMvc.perform(updateRequestWithSession).andExpect(status().isOk())
                .andExpect(content().string(containsString("text")));
        mockMvc.perform(getRequestWithSession).andExpect(status().isOk())
                .andExpect(content().string(containsString("text")));
    }

    @Test
    public void testSessionScopeWithDifferentSessions() throws Exception {
        MockHttpServletRequestBuilder getRequest = get("/scope/session/message/get");
        MockHttpServletRequestBuilder updateRequest = get("/scope/session/message/update");

        mockMvc.perform(getRequest).andExpect(status().isOk())
                .andExpect(content().string(containsString("")));
        mockMvc.perform(updateRequest).andExpect(status().isOk())
                .andExpect(content().string(containsString("text")));
        mockMvc.perform(getRequest).andExpect(status().isOk())
                .andExpect(content().string(containsString("")));
    }
}
