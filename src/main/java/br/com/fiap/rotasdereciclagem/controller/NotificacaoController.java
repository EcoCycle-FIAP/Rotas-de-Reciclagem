package br.com.fiap.rotasdereciclagem.controller;

import br.com.fiap.rotasdereciclagem.dto.NotificacaoExibicaoDTO;
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
    private NotificacaoService NotificacaoService;

    @GetMapping("/notificacões")
    @ResponseStatus(HttpStatus.OK)
    public Page<NotificacaoExibicaoDTO> listarTodos(
            @PageableDefault(size = 15)Pageable paginacao
            ){
        return NotificacaoService.listarTodos(paginacao);
    }

    @GetMapping("/notificacõe/{idNotificacao}")
    public ResponseEntity<NotificacaoExibicaoDTO> buscarPorId(@PathVariable Long idNotificacao){
        try{
            return ResponseEntity.ok(NotificacaoService.buscarPorId(idNotificacao));
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
