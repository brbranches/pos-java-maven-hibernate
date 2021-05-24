package posjavamavenhibernate;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import dao.DaoGeneric;
import model.UsuarioPessoa;
import model.UsuarioTelefone;

public class TesteHibernate {

	@Test
	public void testeHibernateUtil() {
		/******
		 * chamo o getEntitu para testar a conexao e criar as tabelas no banco
		 ********/
//		HibernateUtil.getEntityManager();

	}

	@Test
	public void testeSalvar() {
		/******
		 * chamo o getEntitu para testar a conexao e criar as tabelas no banco
		 ********/
//		HibernateUtil.getEntityManager();

		/**
		 * Instantcio o DaoGenerix para que possa usar os atributos e métodos dessa
		 * classe, no caso salvar, por exemplo Eu já passo o tipo de entidade que quero
		 * persistir, no caso é o objeto/entidade pessoa
		 **/
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();

		/**
		 * Instancio um objeto pessoa para que possa setar os atributos. Caso estivesse
		 * vindo da tela, precisaria usar alguma função para dar um request da tela a
		 * atribuir os valores aos atributos antes de setar
		 **/
		UsuarioPessoa pessoa = new UsuarioPessoa();

		/** Seto os valores nos atributos **/
		pessoa.setIdade(20);
		pessoa.setLogin("elis@");
		pessoa.setNome("Elisa");
		pessoa.setSenha("aklsj");
		pessoa.setSobrenome("Nascim");
		pessoa.setEmail("lisa@gmail.com");

		/**
		 * Chamo o Dao Generic e uso método salvar passano o objeto pessoa Dentro do
		 * salvar, ele abre a transação, persiste os dados e comita no banco
		 **/
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

	@Test
	public void testeQueryList() {

		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		List<UsuarioPessoa> lista = daoGeneric.getEntityManager().createQuery("from UsuarioPessoa").getResultList();
//		List<UsuarioPessoa> lista = daoGeneric.getEntityManager().createQuery("from UsuarioPessoa where nome = 'Bruno'").getResultList();

		for (UsuarioPessoa usuarioPessoa : lista) {
			System.out.println("");
			System.out.println(usuarioPessoa);
		}
	}
	
	
	@Test
	public void testeQueryListOrderByNome() {

		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		List<UsuarioPessoa> lista = daoGeneric.getEntityManager().createQuery("from UsuarioPessoa order by nome").getResultList();

		for (UsuarioPessoa usuarioPessoa : lista) {
			System.out.println("");
			System.out.println(usuarioPessoa);
		}
	}
	
	@Test
	public void testeQueryListOrderByNomeMaxResult() {

		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		List<UsuarioPessoa> lista = daoGeneric.getEntityManager().createQuery("from UsuarioPessoa order by nome").setMaxResults(2).getResultList();

		for (UsuarioPessoa usuarioPessoa : lista) {
			System.out.println("");
			System.out.println(usuarioPessoa);
		}
	}
	
	
	@Test
	public void testeQueryListParametro() {

		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		/* o segundo parâmentro setParameter("nome","Burno") BRUNO, seria o parâmentro que viria da tela*/
		List<UsuarioPessoa> lista = daoGeneric.getEntityManager().createQuery("from UsuarioPessoa where nome = :nome").setParameter("nome", "Bruno").getResultList();

		for (UsuarioPessoa usuarioPessoa : lista) {
			System.out.println("");
			System.out.println(usuarioPessoa);
		}
	}
	
	@Test
	public void testeQuerySomaIdade() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		Long somaIdade = (Long) daoGeneric.getEntityManager().createQuery("select sum (u.idade) from UsuarioPessoa u").getSingleResult();
	
		System.out.println("Soma de todas as idade é > " + somaIdade);
	}
	
	@Test
	public void testeNameQueryListarTodos() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		List<UsuarioPessoa> lista = daoGeneric.getEntityManager().createNamedQuery("UsuarioPessoa.listarTodos").getResultList();
		
		for (UsuarioPessoa usuarioPessoa : lista) {
			System.out.println("");
			System.out.println(usuarioPessoa);
		}
		
	}
	
	
	@Test
	public void testeNameQueryBuscaPorNome() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		List<UsuarioPessoa> lista = daoGeneric.getEntityManager().createNamedQuery("UsuarioPessoa.buscarPorNome").setParameter("nome", "Bruno").getResultList();
		
		for (UsuarioPessoa usuarioPessoa : lista) {
			System.out.println("");
			System.out.println(usuarioPessoa);
		}
		
	}
	
	@Test
	public void testeSalvarTelefone() {
		DaoGeneric daoGeneric = new DaoGeneric();
		
		UsuarioPessoa pessoa = (UsuarioPessoa) daoGeneric.pesquisar(15L, UsuarioPessoa.class);
		
		UsuarioTelefone telefone = new UsuarioTelefone();
		
		telefone.setTipo("Celular");
		telefone.setNumero("(14) 99844-0565");
		telefone.setUsuarioPessoa(pessoa);
		
		daoGeneric.salvar(telefone);
	}
	
	@Test
	public void testeBuscarTelefoneComID() {
		DaoGeneric<UsuarioTelefone> daoGeneric = new DaoGeneric<UsuarioTelefone>();

		UsuarioTelefone telefone = daoGeneric.pesquisar(17L, UsuarioTelefone.class);
		System.out.println("");
		System.out.println(telefone.getUsuarioPessoa().getNome());
		System.out.println(telefone.getUsuarioPessoa().getEmail());

	}


}
