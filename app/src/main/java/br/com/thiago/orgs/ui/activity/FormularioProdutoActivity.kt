package br.com.thiago.orgs.ui.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import br.com.thiago.orgs.R
import br.com.thiago.orgs.dao.ProdutosDao
import br.com.thiago.orgs.model.Produto
import java.math.BigDecimal

class FormularioProdutoActivity : AppCompatActivity(R.layout.activity_formulario_produto) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val botaoSalvar = findViewById<Button>(R.id.botao_salvar)
        botaoSalvar.setOnClickListener {
            val campoNome = findViewById<EditText>(R.id.nome)
            val nome = campoNome.text.toString()
            val campoDesricao = findViewById<EditText>(R.id.descricao)
            val descricao = campoDesricao.text.toString()
            val campoValor = findViewById<EditText>(R.id.valor)
            val valorEmTexto = campoValor.text.toString()
            val valor = if(valorEmTexto.isBlank()){
                BigDecimal.ZERO
            } else {
                BigDecimal(valorEmTexto)
            }

            val produtoNovo = Produto(
                nome = nome,
                descricao = descricao,
                valor = valor
            )
            Log.i("FormularioProduto","onCreate: $produtoNovo")

            val dao = ProdutosDao()

            dao.adiciona(produtoNovo)
            val produtos = dao.buscaTodos()
            Log.i("Produtos:", "$produtos")
            finish()
        }

    }
}