package br.senac.go.resource;

import br.senac.go.interfaces.IResource;
import br.senac.go.model.Conta;
import br.senac.go.model.TipoInvestimento;
import br.senac.go.service.TipoInvestimentoService;
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
@RequestMapping("api/tipo-investimento")
@Tags({
        @Tag(name = "tipo investimento", description = "documentação ao resource tipo investimento"),
        // @Tag(name = "investimento", description = "documentação para conta de investimento")
})
public class TipoInvestimentoResource implements IResource<TipoInvestimento, Integer> {

    @Autowired
    private TipoInvestimentoService investimentoService;

    @Override
    @Operation(
            summary = "Criar um tipo investimento",
            description = "Método responsável por criar um tipo investimento no sistema",
            tags = { "tipo investimento"}
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
    public TipoInvestimento create(TipoInvestimento entity) {
        log.info("Executado método TipoInvestimentoResource.create");
        log.debug(String.format("Executado método TipoInvestimentoResource.create | valores: %s",entity.toString()));
        return investimentoService.create(entity);
    }

    @Override
    @Operation(
            summary = "Recupera varias tipo investimento",
            description = "Método responsável para recuperar varias tipo investimento no sistema",
            tags = { "tipo investimento" }
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
    public TipoInvestimento read(TipoInvestimento entity) throws Exception {
        log.info("Executado método TipoInvestimentoResource.read");
        log.debug(String.format("Executado método TipoInvestimentoResource.read | valores: %s",entity.toString()));
        return investimentoService.read(entity);
    }

    @Override
    @Operation(
            summary = "Recupera uma tipo investimento",
            description = "Método responsável para recuperar um tipo investimento no sistema",
            tags = { "tipo investimento" }
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
    public TipoInvestimento readById(Integer id) throws Exception {
        log.info("Executado método TipoInvestimentoResource.readById");
        log.debug(String.format("Executado método TipoInvestimentoResource.readById | valores: %d",id ));
        return investimentoService.readById(id);
    }

    @Override
    @Operation(
            summary = "Alterar uma parte do tipo investimento",
            description = "Método responsável para alterar uma parte do tipo investimento no sistema",
            tags = { "tipo investimento" }
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
    public TipoInvestimento update(TipoInvestimento entity) {
        log.info("Executado método TipoInvestimentoResource.update");
        log.debug(String.format("Executado método TipoInvestimentoResource.update | valores: %s",entity.toString()));
        return investimentoService.updateFull(entity);
    }

    @Override
    @Operation(
            summary = "Alterar uma parte da tipo investimento",
            description = "Método responsável para alterar uma parte da tipo investimento no sistema",
            tags = { "tipo investimento" }
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
    public TipoInvestimento updatePart(Integer id, TipoInvestimento entity) throws Exception {
        log.info("Executado método TipoInvestimentoResource.updatePart");
        log.debug(String.format("Executado método TipoInvestimentoResource.updatePart | valores: %d %s",id ,entity.toString()));
        return investimentoService.updatePart(id, entity);
    }

    @Override
    @Operation(
            summary = "Alterar uma parte da tipo investimento",
            description = "Método responsável para alterar uma parte da tipo investimento no sistema",
            tags = { "tipo investimento" }
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
    public TipoInvestimento updateFull(Integer id, TipoInvestimento entity) {
        log.info("Executado método InvestimentoResource.update");
        log.debug(String.format("Executado método InvestimentoResource.update | valores: %s",entity.toString()));
        return investimentoService.updateFull(id, entity);
    }

    @Override
    @Operation(
            summary = "Deletar uma tipo investimento",
            description = "Método responsável por deletar uma tipo investimento no sistema",
            tags = { "tipo investimento" }
    )
    @ApiResponses({
            @ApiResponse(responseCode = "204", content = { @Content(schema = @Schema(implementation = Conta.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema(implementation = Conta.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) }
    )
    @DeleteMapping("/{id}")
    public void delete(Integer id) {
        log.info("Executado método InvestimentoResource.delete");
        log.debug(String.format("Executado método InvestimentoResource.delete | valores: %d", id));
        investimentoService.deleteById(id);
    }

    @Override
    @Operation(
            summary = "Deletar uma investimento",
            description = "Método responsável para Deletar uma investimento no sistema",
            tags = { "investimento" }
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
    public void deleteByEntity(TipoInvestimento entity) {
        log.info("Executado método CarteiraResource.delete");
        log.debug(String.format("Executado método CarteiraResource.delete | valores: %s",entity.toString()));
        investimentoService.delete(entity);
    }
}
