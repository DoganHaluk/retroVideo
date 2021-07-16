package be.vdab.retrovideo.services;

import be.vdab.retrovideo.domain.Reservatie;

import java.util.List;

public interface ReservatieService {
    void create(List<Reservatie> reservaties);
}
