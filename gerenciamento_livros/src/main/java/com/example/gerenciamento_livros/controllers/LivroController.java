package com.example.gerenciamento_livros.controllers;

import com.example.gerenciamento_livros.models.LivroModel;
import com.example.gerenciamento_livros.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @PostMapping
    public ResponseEntity<LivroModel> criar(@RequestBody LivroModel livro) {
        LivroModel novoLivro = livroService.salvar(livro);
        URI uri = URI.create("/livros/" + novoLivro.getId());
        return ResponseEntity.created(uri).body(novoLivro);
    }

    @GetMapping
    public ResponseEntity<List<LivroModel>> listar() {
        return ResponseEntity.ok(livroService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroModel> buscar(@PathVariable Long id) {
        LivroModel livro = livroService.buscarPorId(id);

        if (livro == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(livro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LivroModel> atualizar(@PathVariable Long id, @RequestBody LivroModel livro) {
        LivroModel atualizado = livroService.atualizar(id, livro);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        livroService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}