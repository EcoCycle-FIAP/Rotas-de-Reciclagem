package br.com.fiap.rotasdereciclagem.controller;

import br.com.fiap.rotasdereciclagem.dto.AgendamentoCadastroDTO;
import br.com.fiap.rotasdereciclagem.dto.AgendamentoExibicaoDTO;
import br.com.fiap.rotasdereciclagem.model.Agendamento;
import br.com.fiap.rotasdereciclagem.service.AgendamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reciclagem")
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    @PostMapping("/agendamentos")
    @ResponseStatus(HttpStatus.CREATED)
    public AgendamentoExibicaoDTO gravar (@RequestBody @Valid AgendamentoCadastroDTO agendamentoDTO){
        return agendamentoService.gravar(agendamentoDTO);
    }

    @GetMapping("/agendamentos")
    @ResponseStatus(HttpStatus.OK)
    public Page<AgendamentoExibicaoDTO> listarTodos(
            @PageableDefault(size = 15)Pageable paginacao
            ){
        return agendamentoService.listarTodos(paginacao);
    }

    @GetMapping("/agendamentos/{idAgendamento}")
    public ResponseEntity<AgendamentoExibicaoDTO> buscarPorId(@PathVariable Long idAgendamento){
        try{
            return ResponseEntity.ok(agendamentoService.buscarPorId(idAgendamento));
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/agendamentos/{id}")
    public ResponseEntity<String> deletarPorId(@PathVariable Long id) {
        try {
            agendamentoService.deletarPorId(id);
            return ResponseEntity.ok("Agendamento excluído com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro ao excluir agendamento: " + e.getMessage());
        }
    }

    @PutMapping("/agendamentos")
    @ResponseStatus(HttpStatus.OK)
    public AgendamentoExibicaoDTO atualizar(@RequestBody Agendamento agendamento){
        return agendamentoService.atualizar(agendamento);
    }
}
