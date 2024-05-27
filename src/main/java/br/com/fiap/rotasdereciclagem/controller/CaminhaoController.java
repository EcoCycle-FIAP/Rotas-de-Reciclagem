package br.com.fiap.rotasdereciclagem.controller;

import br.com.fiap.rotasdereciclagem.dto.CaminhaoCadastroDTO;
import br.com.fiap.rotasdereciclagem.dto.CaminhaoExibicaoDTO;
import br.com.fiap.rotasdereciclagem.model.Caminhao;
import br.com.fiap.rotasdereciclagem.service.CaminhaoService;
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
public class CaminhaoController {

    @Autowired
    private CaminhaoService caminhaoService;

    @PostMapping("/caminhoes")
    @ResponseStatus(HttpStatus.CREATED)
    public CaminhaoExibicaoDTO gravar (@RequestBody @Valid CaminhaoCadastroDTO caminhaoDTO) {
        return caminhaoService.gravar(caminhaoDTO);
    }

    @GetMapping("/caminhoes")
    @ResponseStatus(HttpStatus.OK)
    public Page<CaminhaoExibicaoDTO> listarTodos(
            @PageableDefault(size = 15)Pageable paginacao
            ){
        return caminhaoService.listarTodos(paginacao);
    }

    @GetMapping("/caminhoes/{idCaminhao}")
    public ResponseEntity<CaminhaoExibicaoDTO> buscarPorId(@PathVariable Long idCaminhao){
        try{
            return ResponseEntity.ok(caminhaoService.buscarPorId(idCaminhao));
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<CaminhaoExibicaoDTO> buscarPorPlaca(@RequestParam String placa){
        try{
            return ResponseEntity.ok(caminhaoService.buscarPorPlaca(placa));
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/caminhoes/{id}")
    public ResponseEntity<String> deletarPorId(@PathVariable Long id) {
        try {
            caminhaoService.deletarPorId(id);
            return ResponseEntity.ok("Caminhão excluído com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro ao excluir caminhão: " + e.getMessage());
        }
    }

    @PutMapping("/caminhoes")
    @ResponseStatus(HttpStatus.OK)
    public CaminhaoExibicaoDTO atualizar(@RequestBody Caminhao caminhao){
        return caminhaoService.atualizar(caminhao);
    }
}
