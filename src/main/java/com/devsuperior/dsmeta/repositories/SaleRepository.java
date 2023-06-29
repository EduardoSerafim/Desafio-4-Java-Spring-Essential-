package com.devsuperior.dsmeta.repositories;

import com.devsuperior.dsmeta.dto.SalesSummaryDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsmeta.entities.Sale;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query("SELECT new com.devsuperior.dsmeta.dto.SalesSummaryDTO(obj.seller.name, SUM(obj.amount))\n" +
            "FROM Sale obj\n" +
            "WHERE obj.date BETWEEN :minDate AND :maxDate\n" +
            "GROUP BY (obj.seller.name)")
    List<SalesSummaryDTO> saleSummary(LocalDate minDate, LocalDate maxDate);

}
