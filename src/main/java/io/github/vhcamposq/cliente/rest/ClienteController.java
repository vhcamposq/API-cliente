package io.github.vhcamposq.cliente.rest;

import io.github.vhcamposq.cliente.model.entity.Cliente;
import io.github.vhcamposq.cliente.model.repository.ClienteRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteRepository repository;

    @Autowired
    public ClienteController(ClienteRepository repository) {
        this.repository = repository;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente salvar(@RequestBody Cliente cliente){
        return repository.save(cliente);

    }
    @GetMapping("{id}")
    public Cliente acharPorId(@PathVariable Integer id){
            return repository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void deletar(@PathVariable Integer id){
        repository.findById(id).map(cliente -> {
            repository.delete(cliente);
            return Void.TYPE;
        }).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id, @RequestBody Cliente clienteAtualizado){
        repository.findById(id).map(cliente -> {
            clienteAtualizado.setId(cliente.getId());
            return repository.save(clienteAtualizado);
        }).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

}
