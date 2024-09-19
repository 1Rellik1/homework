package scopes.sessionscope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * todo agayntsev
 *
 * @author Alexey Gayntsev
 * @since 2024.09.15
 */
@RestController
@RequestMapping("/scope/session")
public class MessageControllerSessionScope {
    @Autowired
    private MessageServiceSessionScope messageServiceSessionScope;

    @GetMapping("/message/update")
    public String updateMessage(HttpSession session) {
        messageServiceSessionScope.updateMessage();
        return messageServiceSessionScope.getMessage();
    }

    @GetMapping("/message/get")
    public String getMessage(HttpSession session) {
        return messageServiceSessionScope.getMessage();
    }
}
