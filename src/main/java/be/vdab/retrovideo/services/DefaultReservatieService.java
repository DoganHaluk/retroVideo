package be.vdab.retrovideo.services;

import be.vdab.retrovideo.domain.Reservatie;
import be.vdab.retrovideo.repositories.ReservatieRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DefaultReservatieService implements ReservatieService {
    private final ReservatieRepository reservatieRepository;

    public DefaultReservatieService(ReservatieRepository reservatieRepository) {
        this.reservatieRepository = reservatieRepository;
    }

    @Override
    public void create(List<Reservatie> reservaties) {
        reservatieRepository.create(reservaties);
    }
}
