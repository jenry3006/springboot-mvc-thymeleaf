package com.jenry.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jenry.dao.FuncionarioDao;
import com.jenry.domain.Funcionario;

@Transactional(readOnly = true)
@Service
public class FuncionarioServiceImpl implements FuncionarioService{

	@Autowired
	private FuncionarioDao dao;
	
	@Transactional(readOnly = false)
	@Override
	public void salvar(Funcionario funcionario) {
		dao.save(funcionario);
		
	}

	@Transactional(readOnly = false)
	@Override
	public void editar(Funcionario funcionario) {
		dao.update(funcionario);
		
	}

	@Transactional(readOnly = false)
	@Override
	public void excluir(Long id) {
		dao.delete(id);
		
	}

	@Override
	public Funcionario buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<Funcionario> buscaTodos() {
		return dao.findAll();
	}

	@Override
	public List<Funcionario> buscarPorNome(String nome) {
		return dao.findByName(nome);
	}

	@Override
	public List<Funcionario> buscarPorCargo(Long id) {
		
		return dao.findByCargo(id);
	}

	@Override
	public List<Funcionario> buscarPorDatas(LocalDate entrada, LocalDate saida) {
		if(entrada !=null && saida !=null) {
			return dao.findByEntradaSaida(entrada,saida);
		} else if(entrada != null) {
			return dao.findByDataEntrada(entrada);
		} else if(saida != null) {
			return dao.findByDataSaida(saida);
		} else {
			return new ArrayList<>();
		}
	}

}
