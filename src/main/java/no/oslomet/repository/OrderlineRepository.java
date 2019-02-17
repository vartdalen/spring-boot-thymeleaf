package no.oslomet.repository;

import no.oslomet.model.Orderline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderlineRepository extends JpaRepository<Orderline, Long> {
}