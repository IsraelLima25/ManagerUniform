package com.ilima.manager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ilima.manager.domains.Funcionario;
import com.ilima.manager.dtos.FuncionarioDTO;
import com.ilima.manager.repositories.FuncionarioRepository;
import com.ilima.manager.services.exceptions.ObjectNotFoundException;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository repo;

	public List<Funcionario> findAll() {
		return repo.findAll();
	}

	public Funcionario find(Integer id) {
		Optional<Funcionario> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Funcionario.class.getName()));
	}

	public Funcionario insert(Funcionario obj) {
		if (obj == null) {
			throw new IllegalArgumentException();
		}
		obj = repo.save(obj);
		return obj;
	}

	public void update(Funcionario obj) {
		repo.save(obj);
	}

	public void delete(Integer id) {
		find(id);
		repo.deleteById(id);
	}

	public Funcionario fromDTO(FuncionarioDTO objDto) {
		return new Funcionario(null, objDto.getNome(), objDto.getCargo());
	}

}
