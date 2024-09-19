package scopes.requestscope;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import scopes.Message;

/**
 * todo agayntsev
 *
 * @author Alexey Gayntsev
 * @since 2024.09.15
 */
@Service
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MessageServiceRequestScope {

    private Message message = new Message();

    public void updateMessage() {
        message.setText("text");
    }

    public String getMessage() {
        return message.getText();
    }
}
