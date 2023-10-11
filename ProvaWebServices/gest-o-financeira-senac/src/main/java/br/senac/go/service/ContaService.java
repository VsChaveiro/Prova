package br.senac.go.service;

import br.senac.go.interfaces.IService;
import br.senac.go.model.Conta;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ContaService implements IService<Conta, Integer> {

    @Override
    public Conta create(Conta entity) {
        log.info("Executado método ContaService.create");
        log.debug(String.format("Executado método ContaService.create | valores: %s",entity.toString() ) );
        return null;
    }

    @Override
    public Conta readById(Integer id) throws Exception {
        log.info("Executado método ContaService.readById");
        log.debug(String.format("Executado método ContaService.readById | valores: %d",id));
        return null;
    }

    @Override
    public Conta read(Conta entity) throws Exception {
        log.info("Executado método ContaService.read");
        log.debug(String.format("Executado método ContaService.read | valores: %s",entity.toString()));
        return null;
    }

    @Override
    public Conta updateFull(Conta entity) {
        log.info("Executado método ContaService.updateFull");
        log.debug(String.format("Executado método ContaService.updateFull | valores: %s",entity.toString()));
        return null;
    }

    @Override
    public Conta updatePart(Integer id, Conta entity) throws Exception {
        log.info("Executado método ContaService.updatePart");
        log.debug(String.format("Executado método ContaService.updatePart | valores: %d %s", id, entity.toString()));
        return null;
    }

    @Override
    public Conta updateFull(Integer id, Conta entity) {
        log.info("Executado método ContaService.updateFull");
        log.debug(String.format("Executado método ContaService.updateFull | valores: %d %s",id,entity.toString()));
        return null;
    }

    @Override
    public Conta deleteById(Integer id) {
        log.info("Executado método ContaService.deleteById");
        log.debug(String.format("Executado método ContaService.deleteById | valores: %d", id));
        return null;
    }

    @Override
    public Conta delete(Conta entity) {
        log.info("Executado método ContaService.delete");
        log.debug(String.format("Executado método ContaService.delete | valores: %s",entity.toString()));
        return null;
    }
}
