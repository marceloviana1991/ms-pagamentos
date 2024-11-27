package marceloviana1991.sergipefood.pagamentos.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import marceloviana1991.sergipefood.pagamentos.dto.PagamentoRequestDto;
import marceloviana1991.sergipefood.pagamentos.dto.PagamentoResponseDto;
import marceloviana1991.sergipefood.pagamentos.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoService service;

    @GetMapping
    public List<PagamentoResponseDto> getPagePagamentos(@PageableDefault(size = 10) Pageable pageable) {
        return service.getPagePagamentos(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PagamentoResponseDto> getPagamento(@PathVariable @NotNull Long id) {
        PagamentoResponseDto responseDto = service.getPagamento(id);
        return ResponseEntity.ok(responseDto);
    }

    @PostMapping
    public ResponseEntity<PagamentoResponseDto> savePagamento(@RequestBody @Valid PagamentoRequestDto requestDto,
                                                              UriComponentsBuilder uriBuilder) {
        PagamentoResponseDto responseDto = service.savePagamento(requestDto);
        URI endereco = uriBuilder.path("/pagamentos/{id}").buildAndExpand(responseDto.id()).toUri();
        return ResponseEntity.created(endereco).body(responseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PagamentoResponseDto> updatePagamento(@PathVariable @NotNull Long id,
                                                                @RequestBody @Valid PagamentoRequestDto requestDto) {
        PagamentoResponseDto responseDto = service.updatePagamento(id, requestDto);
        return ResponseEntity.ok(responseDto);
    }

    @PutMapping("/confirmado/{id}")
    public ResponseEntity<PagamentoResponseDto> updateStatusConfirmadoPagamento(@PathVariable @NotNull Long id) {
        PagamentoResponseDto responseDto = service.updateStatusConfirmadoPagamento(id);
        return ResponseEntity.ok(responseDto);
    }

    @PutMapping("/cancelado/{id}")
    public ResponseEntity<PagamentoResponseDto> updateStatusCanceladoPagamento(@PathVariable @NotNull Long id) {
        PagamentoResponseDto responseDto = service.updateStatusCanceladoPagamento(id);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PagamentoResponseDto> deletePagamento(@PathVariable @NotNull Long id) {
        service.deletePagamento(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/confirmar")
    public void confirmarPagamento(@PathVariable @NotNull Long id){
        service.confirmarPagamento(id);
    }

    @GetMapping("/porta")
    public String retornaPorta(@Value("${local.server.port}") String porta){
        return String.format("Requisição respondida pela instância executando na porta %s", porta);
    }
}
