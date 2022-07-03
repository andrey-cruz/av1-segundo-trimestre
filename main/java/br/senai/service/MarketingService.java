package br.senai.service;

import br.senai.model.Marketing;

import java.util.List;

public interface MarketingService {
    public List<Marketing> findAll();
    public Marketing save(Marketing marketing);
    public Marketing findById(Long id);
    public void deleteById(Long id);
}
