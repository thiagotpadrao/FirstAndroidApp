package br.com.thiago.orgs.dao

import br.com.thiago.orgs.model.Produto

class ProdutosDao {

    private val listaProdutos = mutableListOf<Produto>()

    fun adiciona(produto : Produto){
        listaProdutos.add(produto)
    }

    fun buscaTodos() : List<Produto> {
        return listaProdutos.toList()
    }
}