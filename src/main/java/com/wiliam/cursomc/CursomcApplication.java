package com.wiliam.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.wiliam.cursomc.domain.Categoria;
import com.wiliam.cursomc.domain.Cidade;
import com.wiliam.cursomc.domain.Cliente;
import com.wiliam.cursomc.domain.Endereco;
import com.wiliam.cursomc.domain.Estado;
import com.wiliam.cursomc.domain.ItemPedido;
import com.wiliam.cursomc.domain.Pagamento;
import com.wiliam.cursomc.domain.PagamentoComBoleto;
import com.wiliam.cursomc.domain.PagamentoComCartao;
import com.wiliam.cursomc.domain.Pedido;
import com.wiliam.cursomc.domain.Produto;
import com.wiliam.cursomc.domain.enums.EstadoPagamento;
import com.wiliam.cursomc.domain.enums.TipoCliente;
import com.wiliam.cursomc.repositories.CategoriaRepository;
import com.wiliam.cursomc.repositories.CidadeRepository;
import com.wiliam.cursomc.repositories.ClienteRepository;
import com.wiliam.cursomc.repositories.EnderecoRepository;
import com.wiliam.cursomc.repositories.EstadoRepository;
import com.wiliam.cursomc.repositories.ItemPedidoRepository;
import com.wiliam.cursomc.repositories.PagamentoRepository;
import com.wiliam.cursomc.repositories.PedidoRepository;
import com.wiliam.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		
	}

}
