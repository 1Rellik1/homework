package scopes.requestscope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * todo agayntsev
 *
 * @author Alexey Gayntsev
 * @since 2024.09.15
 */
@RestController
@RequestMapping("/scope/request")
public class MessageControllerRequestScope {
    @Autowired
    private MessageServiceRequestScope messageServiceRequestScope;

    @GetMapping("/message/update")
    public String updateMessage() {
        messageServiceRequestScope.updateMessage();
        return messageServiceRequestScope.getMessage();
    }

    @GetMapping("/message/get")
    public String getMessage() {
        return messageServiceRequestScope.getMessage();
    }
}
