package be.vdab.retrovideo.sessions;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Component
@SessionScope
public class Mandje implements Serializable {
    private static final long serialVersionUID = 1L;
    private final Set<Long> ids = new LinkedHashSet<>();

    public void voegToe(long id) {
        ids.add(id);
    }

    public Set<Long> getIds() {
        return ids;
    }

    public void verwijder(Long[] filmIds) {
        for (var id : filmIds) {
            ids.remove(id);
        }
    }
    public boolean isNietLeeg() {
        return !ids.isEmpty();
    }

    public int aantalFilms(){
        return ids.size();
    }
}
