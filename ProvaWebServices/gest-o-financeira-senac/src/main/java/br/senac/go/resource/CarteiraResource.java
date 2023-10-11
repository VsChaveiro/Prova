package br.senac.go.resource;

import br.senac.go.interfaces.IResource;
import br.senac.go.model.Carteira;
import br.senac.go.model.Conta;
import br.senac.go.service.CarteiraService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/carteira")
@Tags({
        @Tag(name = "carteira", description = "documentação ao resource carteira"),
        // @Tag(name = "investimento", description = "documentação para conta de investimento")
})
public class CarteiraResource implements IResource<Carteira, Integer>  {

    @Autowired private CarteiraService carteiraService;

    @Override
    @Operation(
            summary = "Criar uma carteira",
            description = "Método responsável por criar uma carteira no sistema",
            tags = { "carteira"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = { @Content(schema = @Schema(implementation = Conta.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "304", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) })
    })
    @PostMapping(
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public Carteira create(@Valid @RequestBody Carteira entity) {
        log.info("Executado método CarteiraResource.create");
        log.debug(String.format("Executado método CarteiraResource.create | valores: %s",entity.toString()));
        return carteiraService.create(entity);
    }

    @Override
    @Operation(
            summary = "Recupera varias carteiras",
            description = "Método responsável para recuperar varias carteiras no sistema",
            tags = { "carteira" }
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Conta.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema(implementation = Conta.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) }
    )
    @GetMapping(
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public Carteira read(@Valid @RequestBody Carteira entity) throws Exception {
        log.info("Executado método CarteiraResource.read");
        log.debug(String.format("Executado método CarteiraResource.read | valores: %s",entity.toString()));
        return carteiraService.read(entity);
    }

    @Override
    @Operation(
            summary = "Recupera uma carteira",
            description = "Método responsável para recuperar uma carteira no sistema",
            tags = { "carteira" }
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Conta.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema(implementation = Conta.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) }
    )
    @GetMapping(value = "/{id}",
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public Carteira readById(@PathVariable Integer id) throws Exception {
        log.info("Executado método CarteiraResource.readById");
        log.debug(String.format("Executado método CarteiraResource.readById | valores: %d",id ));
        return carteiraService.readById(id);
    }

    @Override
    @Operation(
            summary = "Alterar uma parte da carteira",
            description = "Método responsável para alterar uma parte da carteira no sistema",
            tags = { "carteira" }
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Conta.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema(implementation = Conta.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) }
    )
    @PatchMapping(
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public Carteira update(@Valid @RequestBody Carteira entity) {
        log.info("Executado método CarteiraResource.update");
        log.debug(String.format("Executado método CarteiraResource.update | valores: %s",entity.toString()));
        return carteiraService.updateFull(entity);
    }

    @Override
    @Operation(
            summary = "Alterar uma parte da carteira",
            description = "Método responsável para alterar uma parte da carteira no sistema",
            tags = { "carteira" }
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Conta.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema(implementation = Conta.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) }
    )
    @PatchMapping(value ="/{id}",
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public Carteira updatePart(@PathVariable Integer id, @Valid @RequestBody Carteira entity) throws Exception {
        log.info("Executado método CarteiraResource.updatePart");
        log.debug(String.format("Executado método CarteiraResource.updatePart | valores: %d %s",id ,entity.toString()));
        return carteiraService.updatePart(id, entity);
    }

    @Override
    @Operation(
            summary = "Alterar uma parte da carteira",
            description = "Método responsável para alterar uma parte da carteira no sistema",
            tags = { "carteira" }
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Conta.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema(implementation = Conta.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) }
    )
    @PutMapping(value ="/{id}",
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public Carteira updateFull(@PathVariable Integer id, @Valid @RequestBody Carteira entity) {
        log.info("Executado método ContaResource.update");
        log.debug(String.format("Executado método ContaResource.update | valores: %s",entity.toString()));
        return carteiraService.updateFull(id, entity);
    }

    @Override
    @Operation(
            summary = "Deletar uma carteira",
            description = "Método responsável por deletar uma carteira no sistema",
            tags = { "carteira" }
    )
    @ApiResponses({
            @ApiResponse(responseCode = "204", content = { @Content(schema = @Schema(implementation = Conta.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema(implementation = Conta.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) }
    )
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        log.info("Executado método CarteiraResource.delete");
        log.debug(String.format("Executado método CarteiraResource.delete | valores: %d", id));
        carteiraService.deleteById(id);
    }

    @Override
    @Operation(
            summary = "Deletar uma carteira",
            description = "Método responsável para Deletar uma carteira no sistema",
            tags = { "carteira" }
    )
    @ApiResponses({
            @ApiResponse(responseCode = "204", content = { @Content(schema = @Schema(implementation = Conta.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema(implementation = Conta.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) }
    )
    @DeleteMapping(
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public void deleteByEntity(@Valid @RequestBody Carteira entity) {
        log.info("Executado método CarteiraResource.delete");
        log.debug(String.format("Executado método CarteiraResource.delete | valores: %s",entity.toString()));
        carteiraService.delete(entity);
    }
}
