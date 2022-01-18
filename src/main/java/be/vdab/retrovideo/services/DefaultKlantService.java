package be.vdab.retrovideo.services;

import be.vdab.retrovideo.domain.Klant;
import be.vdab.retrovideo.repositories.KlantRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DefaultKlantService implements KlantService {
    private final KlantRepository klantRepository;

    DefaultKlantService(KlantRepository klantRepository) {
        this.klantRepository = klantRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Klant> findByFamilienaamBevat(String familienaamBevat) {
        return klantRepository.findByFamilienaamBevat(familienaamBevat);
    }

    @Override
    public String getNaam(long id) {
        return klantRepository.getNaam(id);
    }
}
