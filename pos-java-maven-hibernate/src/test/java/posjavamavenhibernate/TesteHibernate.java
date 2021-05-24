package posjavamavenhibernate;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import dao.DaoGeneric;
import model.UsuarioPessoa;

public class TesteHibernate {
	
	@Test
	public void testeHibernateUtil() {
		/******  chamo o getEntitu para testar a conexao e criar as tabelas no banco ********/
//		HibernateUtil.getEntityManager();
				
	}
	
	@Test
	public void testeSalvar() {
		/******  chamo o getEntitu para testar a conexao e criar as tabelas no banco ********/
//		HibernateUtil.getEntityManager();
		
		/** Instantcio o DaoGenerix para que possa usar os atributos e métodos dessa classe, no caso salvar, por exemplo
		 * Eu já passo o tipo de entidade que quero persistir, no caso é o objeto/entidade pessoa**/
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		/**  Instancio um objeto pessoa para que possa setar os atributos. Caso estivesse vindo da tela, precisaria
		 * usar alguma função para dar um request da tela a atribuir os valores aos atributos antes de setar**/
		UsuarioPessoa pessoa = new UsuarioPessoa();
		
		/** Seto os valores nos atributos**/
		pessoa.setIdade(20);
		pessoa.setLogin("elis@");
		pessoa.setNome("Elisa");
		pessoa.setSenha("aklsj");
		pessoa.setSobrenome("Nascim");
		pessoa.setEmail("lisa@gmail.com");
		
		/** Chamo o Dao Generic e uso método salvar passano o objeto pessoa
		 * Dentro do salvar, ele abre a transação, persiste os dados e comita no banco**/
		daoGeneric.salvar(pessoa);
		
	}
	
	
	
	@Test
	public void testeBuscarObjeto() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		UsuarioPessoa pessoa = new UsuarioPessoa();
		
		pessoa.setId(11L);
		
		pessoa = daoGeneric.pesquisar(pessoa);		
		System.out.println("");
		System.out.println(pessoa);
		
	}
	
	@Test
	public void testeBuscarComID() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		UsuarioPessoa pessoa = daoGeneric.pesquisar(11L, UsuarioPessoa.class);		
		System.out.println("");
		System.out.println(pessoa);
		
	}
	
	@Test
	public void testeUpdate() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		UsuarioPessoa pessoa = daoGeneric.pesquisar(11L, UsuarioPessoa.class);		
		
		pessoa.setIdade(32);
		pessoa.setNome("Bruno Ramos Atualizado ");
		pessoa.setSenha("Programador FODA!");
		
		pessoa = daoGeneric.atualizar(pessoa);
		System.out.println("");
		System.out.println(pessoa);
	}
	
	@Test
	public void testeDelete() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		UsuarioPessoa pessoa = daoGeneric.pesquisar(13L, UsuarioPessoa.class);
		
		daoGeneric.deletarPorId(pessoa);
	}
	
	@Test
	public void testeListar() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		List<UsuarioPessoa> lista = daoGeneric.buscarTodos(UsuarioPessoa.class);
		for (UsuarioPessoa usuarioPessoa : lista) {
			System.out.println(usuarioPessoa);
			System.out.println("");	
		}
	
	}
	
	
	

}