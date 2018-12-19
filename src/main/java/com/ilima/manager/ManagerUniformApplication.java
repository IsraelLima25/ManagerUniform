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
import com.ilima.manager.domains.ItemPedido;
import com.ilima.manager.domains.Pedido;
import com.ilima.manager.enuns.EstadoPedido;
import com.ilima.manager.enuns.TamanhoItem;
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
		
		ItemPedido i1 = new ItemPedido(p1,c1,15);
		ItemPedido i2 = new ItemPedido(p1,c3,20);
		
		ItemPedido i3 = new ItemPedido(p2,c2,8);
		ItemPedido i4 = new ItemPedido(p2,c4,7);
		
		p1.getItens().addAll(Arrays.asList(i1,i2));
		p2.getItens().addAll(Arrays.asList(i3,i4));
		
		c1.getPedidos().addAll(Arrays.asList(i1));
		c2.getPedidos().addAll(Arrays.asList(i3));
		c3.getPedidos().addAll(Arrays.asList(i2));
		c4.getPedidos().addAll(Arrays.asList(i4));
		
		
		repoPedido.saveAll(Arrays.asList(p1,p2));
		repoItemPedido.saveAll(Arrays.asList(i1,i2,i3,i4));
		
		

	}

}
