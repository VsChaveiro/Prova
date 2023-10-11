package br.senac.go.service;

import br.senac.go.interfaces.IService;
import br.senac.go.model.Carteira;
import br.senac.go.model.Conta;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CarteiraService implements IService<Carteira, Integer>  {
    @Override
    public Carteira create(Carteira entity) {
        log.info("Executado método CarteiraService.create");
        log.debug(String.format("Executado método CarteiraService.create | valores: %s",entity.toString() ) );
        return null;
    }

    @Override
    public Carteira readById(Integer id) throws Exception {
        log.info("Executado método CarteiraService.readById");
        log.debug(String.format("Executado método CarteiraService.readById | valores: %d",id ) );
        return null;
    }

    @Override
    public Carteira read(Carteira entity) throws Exception {
        log.info("Executado método CarteiraService.read");
        log.debug(String.format("Executado método CarteiraService.read | valores: %s",entity.toString() ) );
        return null;
    }

    @Override
    public Carteira updateFull(Carteira entity) {
        log.info("Executado método CarteiraService.updateFull");
        log.debug(String.format("Executado método CarteiraService.updateFull | valores: %s",entity.toString() ) );
        return null;
    }

    @Override
    public Carteira updatePart(Integer id, Carteira entity) throws Exception {
        log.info("Executado método CarteiraService.updatePart");
        log.debug(String.format("Executado método CarteiraService.updatePart | valores: %d %s",id ,entity.toString() ) );
        return null;
    }

    @Override
    public Carteira updateFull(Integer id, Carteira entity) {
        log.info("Executado método CarteiraService.updateFull");
        log.debug(String.format("Executado método CarteiraService.updateFull | valores: %d %s",id ,entity.toString() ) );
        return null;
    }

    @Override
    public Carteira deleteById(Integer id) {
        log.info("Executado método CarteiraService.deleteById");
        log.debug(String.format("Executado método CarteiraService.deleteById | valores: %d",id ) );
        return null;
    }

    @Override
    public Carteira delete(Carteira entity) {
        log.info("Executado método CarteiraService.delete");
        log.debug(String.format("Executado método CarteiraService.delete | valores: %s",entity.toString() ) );
        return null;
    }
}
