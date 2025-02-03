package br.com.thiago.orgs.ui.activity

import android.app.Activity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.thiago.orgs.R
import br.com.thiago.orgs.model.Produto
import br.com.thiago.orgs.ui.recyclerview.adapter.ListaProdutosAdapter
import java.math.BigDecimal

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val nome = findViewById<TextView>(R.id.nome)
//        nome.text = "Cesta de frutas"
//        val descricao = findViewById<TextView>(R.id.descricao)
//        descricao.text = "Laranja, manga e maçã"
//        val valor = findViewById<TextView>(R.id.valor)
//        valor.text = "19.99"

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = ListaProdutosAdapter(context = this, produtos = listOf(
            Produto(
                nome = "teste",
                descricao = "testedesc",
                valor = BigDecimal("19.99")
            ),
            Produto(
                nome = "teste 1",
                descricao = "testedesc1",
                valor = BigDecimal("29.99")
            ),
            Produto(
                nome = "teste 2",
                descricao = "testedesc2",
                valor = BigDecimal("39.99")
            )
        ))

        recyclerView.layoutManager = LinearLayoutManager(this)

    }
}