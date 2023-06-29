package com.devsuperior.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

import com.devsuperior.dsmeta.dto.SalesReportDTO;
import com.devsuperior.dsmeta.dto.SalesSummaryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;
	
	public SaleMinDTO findById(Long id) {
		Optional<Sale> result = repository.findById(id);
		Sale entity = result.get();
		return new SaleMinDTO(entity);
	}

	public List<SalesSummaryDTO> getSummary(String minDate, String maxDate){
		LocalDate min;
		LocalDate max;
		if(maxDate.isEmpty()){
			max = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		}else{
			max = LocalDate.parse(maxDate);
		}

		if(minDate.isEmpty()){
			min = max.minusYears(1);
		}else{
			min = LocalDate.parse(minDate);
		}

		return  repository.saleSummary(min, max);

	}

	public Page<SalesReportDTO> getReport(String minDate, String maxDate, String name, Pageable pageable){
		LocalDate min;
		LocalDate max;
		if(maxDate.isEmpty()){
			max = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		}else{
			max = LocalDate.parse(maxDate);
		}

		if(minDate.isEmpty()){
			min = max.minusYears(1);
		}else{
			min = LocalDate.parse(minDate);
		}

		return repository.salesReport(pageable, min, max, name);
	}





}
