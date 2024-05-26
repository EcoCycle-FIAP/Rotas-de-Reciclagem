package br.com.fiap.rotasdereciclagem.controller;

import br.com.fiap.rotasdereciclagem.dto.NotificacaoExibicaoDTO;
import br.com.fiap.rotasdereciclagem.model.Notificacao;
import br.com.fiap.rotasdereciclagem.service.NotificacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reciclagem")
public class NotificacaoController {

    @Autowired
    private NotificacaoService notificacaoService;

    @PostMapping("/notificacoes")
    @ResponseStatus(HttpStatus.CREATED)
    public NotificacaoExibicaoDTO gravar(@RequestBody Notificacao notificacao){
        return notificacaoService.gravar(notificacao);
    }

    @GetMapping("/notificacoes")
    @ResponseStatus(HttpStatus.OK)
    public Page<NotificacaoExibicaoDTO> listarTodos(
            @PageableDefault(size = 15)Pageable paginacao
            ){
        return notificacaoService.listarTodos(paginacao);
    }

    @GetMapping("/notificacoes/{idNotificacao}")
    public ResponseEntity<NotificacaoExibicaoDTO> buscarPorId(@PathVariable Long idNotificacao){
        try{
            return ResponseEntity.ok(notificacaoService.buscarPorId(idNotificacao));
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/notificacoes/{id}")
    public ResponseEntity<String> deletarPorId(@PathVariable Long id) {
        try {
            notificacaoService.deletarPorId(id);
            return ResponseEntity.ok("Notificação excluída com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro ao excluir notificação: " + e.getMessage());
        }
    }

    @PutMapping("/notificacoes")
    @ResponseStatus(HttpStatus.OK)
    public NotificacaoExibicaoDTO atualizar(@RequestBody Notificacao notificacao){
        return notificacaoService.atualizar(notificacao);
    }
}
