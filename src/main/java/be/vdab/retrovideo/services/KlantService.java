package be.vdab.retrovideo.services;

import be.vdab.retrovideo.domain.Klant;

import java.util.List;

public interface KlantService {
    List<Klant> findByFamilienaamBevat(String familienaamBevat);

    String getNaam(long id);
}
