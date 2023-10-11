package br.senac.go.resource;

import br.senac.go.interfaces.IResource;
import br.senac.go.model.Conta;
import br.senac.go.service.ContaService;
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
@RequestMapping("api/conta")
@Tags({
          @Tag(name = "conta", description = "documentação ao resource conta"),
          // @Tag(name = "investimento", description = "documentação para conta de investimento")
        })
public class ContaResource implements IResource<Conta, Integer> {

    @Autowired
    private ContaService contaService;

    @Override
    @Operation(
            summary = "Criar uma conta",
            description = "Método responsável por criar uma conta no sistema",
            tags = { "conta"}
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
    public Conta create(@Valid @RequestBody Conta entity) {
        log.info("Executado método ContaResource.create");
        log.debug(String.format("Executado método ContaResource.create | valores: %s",entity.toString()));
        return contaService.create(entity);
    }

    @Override
    @Operation(
            summary = "Recupera varias conta",
            description = "Método responsável para recuperar varias conta no sistema",
            tags = { "conta" }
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
    public Conta read(@Valid @RequestBody Conta entity) throws Exception {
        log.info("Executado método ContaResource.read");
        log.debug(String.format("Executado método ContaResource.read | valores: %s",entity.toString()));
        return contaService.read(entity);
    }

    @Override
    @Operation(
            summary = "Recupera uma conta",
            description = "Método responsável para recuperar uma conta no sistema",
            tags = { "conta" }
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
    public Conta readById(@PathVariable("id") Integer id) throws Exception {
        log.info("Executado método ContaResource.readById");
        log.debug(String.format("Executado método ContaResource.readById | valores: %d",id));
        return contaService.readById(id);
    }

    @Override
    @Operation(
            summary = "Alterar uma parte da conta",
            description = "Método responsável para alterar uma parte da conta no sistema",
            tags = { "conta" }
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
    public Conta updatePart(@PathVariable("id") Integer id, @Valid @RequestBody Conta entity) throws Exception {
        log.info("Executado método ContaResource.update");
        log.debug(String.format("Executado método ContaResource.update | valores: %s",entity.toString()));
        return contaService.updatePart(id, entity);
    }

    @Override
    @Operation(
            summary = "Alterar uma conta toda",
            description = "Método responsável para alterar uma conta por completo no sistema",
            tags = { "conta" }
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Conta.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema(implementation = Conta.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) }
    )
    @PutMapping(value = "/{id}",
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public Conta updateFull(@PathVariable("id") Integer id, @Valid @RequestBody Conta entity) {
        log.info("Executado método ContaResource.update");
        log.debug(String.format("Executado método ContaResource.update | valores: %s",entity.toString()));
        return contaService.updateFull(id, entity);
    }

    @Override
    @Operation(
            summary = "Alterar uma conta",
            description = "Método responsável para alterar uma conta no sistema",
            tags = { "conta" }
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Conta.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema(implementation = Conta.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) }
    )
    @PutMapping(
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public Conta update(@Valid @RequestBody Conta entity) {
        log.info("Executando metodo update");
        log.debug(String.format("Executado método ContaResource.update | valores: %s",entity.toString()));
        return contaService.updateFull(entity);
    }

    @Override
    @Operation(
            summary = "Deletar uma conta",
            description = "Método responsável por deletar uma conta no sistema",
            tags = { "conta" }
    )
    @ApiResponses({
            @ApiResponse(responseCode = "204", content = { @Content(schema = @Schema(implementation = Conta.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema(implementation = Conta.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) }
    )
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        log.info("Executado método ContaResource.delete");
        log.debug(String.format("Executado método ContaResource.delete | valores: %d",id));
        contaService.deleteById(id);
    }

    @Override
    @Operation(
            summary = "Deletar uma conta",
            description = "Método responsável para Deletar uma conta no sistema",
            tags = { "conta" }
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
    public void deleteByEntity(@Valid @RequestBody Conta entity) {
        log.info("Executado método ContaResource.delete");
        log.debug(String.format("Executado método ContaResource.delete | valores: %s",entity.toString()));
        contaService.delete(entity);
    }
}
