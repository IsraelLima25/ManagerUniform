package com.ilima.manager;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ilima.manager.domains.Boina;
import com.ilima.manager.domains.Calca;
import com.ilima.manager.domains.Calcado;
import com.ilima.manager.domains.Camisa;
import com.ilima.manager.domains.Devolucao;
import com.ilima.manager.domains.Entrega;
import com.ilima.manager.domains.Funcionario;
import com.ilima.manager.domains.ItemEntrega;
import com.ilima.manager.domains.ItemPedido;
import com.ilima.manager.domains.Pedido;
import com.ilima.manager.enuns.EstadoPedido;
import com.ilima.manager.enuns.TamanhoItem;
import com.ilima.manager.repositories.DevolucaoRepository;
import com.ilima.manager.repositories.EntregaRepository;
import com.ilima.manager.repositories.FuncionarioRepository;
import com.ilima.manager.repositories.ItemEntregaRepository;
import com.ilima.manager.repositories.ItemPedidoRepository;
import com.ilima.manager.repositories.ItemRepository;
import com.ilima.manager.repositories.PedidoRepository;

@SpringBootApplication
public class ManagerUniformApplication implements CommandLineRunner {

	@Autowired
	private ItemRepository repoItem;
	@Autowired
	private PedidoRepository repoPedido;
	@Autowired
	private ItemPedidoRepository repoItemPedido;
	@Autowired
	private EntregaRepository repoEntrega;
	@Autowired
	private ItemEntregaRepository repoItemEntrega;
	@Autowired
	private DevolucaoRepository repoDevolucao;
	@Autowired
	private FuncionarioRepository repoFuncionario;

	public static void main(String[] args) {
		SpringApplication.run(ManagerUniformApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Camisa c1 = new Camisa(null, "Camisa de Farda Social", new Date(), "Marrom", 50, 5, TamanhoItem.M);
		Calcado c2 = new Calcado(null, "Bota Cano Curto", new Date(), "Preto", 100, 5, 40);
		Calca c3 = new Calca(null, "Calca Farda Social", new Date(), "Preto", 50, 5, TamanhoItem.G);
		Boina c4 = new Boina(null, "Boina Comum", new Date(), "Cinza", 50, 5);

		repoItem.saveAll(Arrays.asList(c1, c2, c3, c4));

		Pedido p1 = new Pedido(null, new Date(), EstadoPedido.PENDENTE);
		Pedido p2 = new Pedido(null, new Date(), EstadoPedido.PENDENTE);

		ItemPedido i1 = new ItemPedido(p1, c1, 15);
		ItemPedido i2 = new ItemPedido(p1, c3, 20);

		ItemPedido i3 = new ItemPedido(p2, c2, 8);
		ItemPedido i4 = new ItemPedido(p2, c4, 7);

		p1.getItens().addAll(Arrays.asList(i1, i2));
		p2.getItens().addAll(Arrays.asList(i3, i4));

		c1.getPedidos().addAll(Arrays.asList(i1));
		c2.getPedidos().addAll(Arrays.asList(i3));
		c3.getPedidos().addAll(Arrays.asList(i2));
		c4.getPedidos().addAll(Arrays.asList(i4));

		repoPedido.saveAll(Arrays.asList(p1, p2));
		repoItemPedido.saveAll(Arrays.asList(i1, i2, i3, i4));

		Funcionario f1 = new Funcionario(null, "Robson Cardoso Silva", "Segurança");
		Funcionario f2 = new Funcionario(null, "Luan Souza Oliveira", "Segurança");
		Funcionario f3 = new Funcionario(null, "Josenilton Soares Carvalho", "Supervisor");

		repoFuncionario.saveAll(Arrays.asList(f1, f2, f3));

		Entrega e1 = new Entrega(null, new Date());
		e1.setFuncionario(f1);
		ItemEntrega ie1 = new ItemEntrega(e1, c1, 1);
		ItemEntrega ie2 = new ItemEntrega(e1, c2, 2);

		c1.getEntrega().addAll(Arrays.asList(ie1));
		c2.getEntrega().addAll(Arrays.asList(ie2));
		e1.getItem().addAll(Arrays.asList(ie1, ie2));

		Entrega e2 = new Entrega(null, new Date());
		e2.setFuncionario(f2);
		ItemEntrega ie3 = new ItemEntrega(e2, c3, 1);

		c3.getEntrega().addAll(Arrays.asList(ie3));
		e2.getItem().addAll(Arrays.asList(ie3));

		Devolucao d1 = new Devolucao(null, new Date(), "Por Defeitos de Fábrica!!!");
		d1.setEntrega(e1);

		e1.setDevolucao(d1);

		repoEntrega.saveAll(Arrays.asList(e1, e2));
		repoItemEntrega.saveAll(Arrays.asList(ie1, ie2, ie3));
		repoDevolucao.saveAll(Arrays.asList(d1));

	}

}
