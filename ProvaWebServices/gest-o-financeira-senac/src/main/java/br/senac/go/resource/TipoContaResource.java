package br.senac.go.resource;

import br.senac.go.interfaces.IResource;
import br.senac.go.model.Conta;
import br.senac.go.model.TipoConta;
import br.senac.go.service.TipoContaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "api/tipo-conta")
@Tags({
        @Tag(name = "tipo conta", description = "documentação ao resource tipo conta"),
        // @Tag(name = "investimento", description = "documentação para conta de investimento")
})
public class TipoContaResource implements IResource<TipoConta, Integer> {

    @Autowired
    private TipoContaService tipoContaService;

    @Override
    @Operation(
            summary = "Criar um tipo de conta",
            description = "Método responsável por criar um tipo de conta no sistema",
            tags = { "tipo de conta"}
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
    public TipoConta create(TipoConta entity) {
        log.info("Executado método TipoContaResource.create");
        log.debug(String.format("Executado método TipoContaResource.create | valores: %s",entity.toString()));
        return tipoContaService.create(entity);
    }

    @Override
    @Operation(
            summary = "Recupera varias tipo conta",
            description = "Método responsável para recuperar varias tipos de conta no sistema",
            tags = { "tipo conta" }
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
    public TipoConta read(TipoConta entity) throws Exception {
        log.info("Executado método TipoContaResource.read");
        log.debug(String.format("Executado método TipoContaResource.read | valores: %s",entity.toString()));
        return tipoContaService.read(entity);
    }

    @Override
    @Operation(
            summary = "Recupera um tipo de conta",
            description = "Método responsável para recuperar um tipo de conta no sistema",
            tags = { "tipo conta" }
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
    public TipoConta readById(Integer id) throws Exception {
        log.info("Executado método TipoContaResource.readById");
        log.debug(String.format("Executado método TipoContaResource.readById | valores: %d",id));
        return tipoContaService.readById(id);
    }

    @Override
    @Operation(
            summary = "Alterar um tipo de conta",
            description = "Método responsável para alterar um tipo de conta no sistema",
            tags = { "tipo conta" }
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
    public TipoConta update(TipoConta entity) {
        log.info("Executando metodo update");
        log.debug(String.format("Executado método TipoContaResource.update | valores: %s",entity.toString()));
        return tipoContaService.updateFull(entity);
    }

    @Override
    @Operation(
            summary = "Alterar uma parte do tipo de conta",
            description = "Método responsável para alterar uma parte da do tipo de conta no sistema",
            tags = { "tipo conta" }
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
    public TipoConta updatePart(Integer id, TipoConta entity) throws Exception {
        log.info("Executado método TipoContaResource.update");
        log.debug(String.format("Executado método TipoContaResource.update | valores: %s",entity.toString()));
        return tipoContaService.updatePart(id, entity);
    }

    @Override
    @Operation(
            summary = "Alterar um tipo de conta toda",
            description = "Método responsável para alterar um tipo de conta por completo no sistema",
            tags = { "tipo conta" }
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
    public TipoConta updateFull(Integer id, TipoConta entity) {
        log.info("Executado método TipoContaResource.update");
        log.debug(String.format("Executado método TipoContaResource.update | valores: %s",entity.toString()));
        return tipoContaService.updateFull(id, entity);
    }

    @Override
    @Operation(
            summary = "Deletar um tipo de conta",
            description = "Método responsável por deletar um tipo de conta no sistema",
            tags = { "tipo conta" }
    )
    @ApiResponses({
            @ApiResponse(responseCode = "204", content = { @Content(schema = @Schema(implementation = Conta.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema(implementation = Conta.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) }
    )
    public void delete(Integer id) {
        log.info("Executado método TipoContaResource.delete");
        log.debug(String.format("Executado método TipoContaResource.delete | valores: %d",id));
        tipoContaService.deleteById(id);
    }

    @Override
    @Operation(
            summary = "Deletar um tipo de conta",
            description = "Método responsável para Deletar um tipo de conta no sistema",
            tags = { "tipo conta" }
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
    public void deleteByEntity(TipoConta entity) {
        log.info("Executado método TipoContaResource.delete");
        log.debug(String.format("Executado método TipoContaResource.delete | valores: %s",entity.toString()));
        tipoContaService.delete(entity);
    }
}
