package br.senai.service;

import br.senai.model.Marketing;
import br.senai.repository.MarketingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarketingServiceImpl implements MarketingService{

    @Autowired
    MarketingRepository marketingRepository;

    @Override
    public List<Marketing> findAll() {return marketingRepository.findAll();}

    @Override
    public Marketing findById(Long id){
        Marketing findMarketing = marketingRepository.findById(id).get();
        return findMarketing != null ? findMarketing : new Marketing();
    }

    @Override
    public Marketing save(Marketing marketing){
        try {
            return marketingRepository.save(marketing);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void deleteById (Long id) {
        try {
            marketingRepository.deleteById(id);
        } catch (Exception e) {
            throw e;
        }
    }
}
