package be.vdab.retrovideo.sessions;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.io.Serializable;

@Component
@SessionScope
public class KlantGekozen implements Serializable {
    private static final long serialVersionUID = 1L;
    private long klantId;

    public long getKlantId() {
        return klantId;
    }

    public void setKlantId(long klantId) {
        this.klantId = klantId;
    }
}
