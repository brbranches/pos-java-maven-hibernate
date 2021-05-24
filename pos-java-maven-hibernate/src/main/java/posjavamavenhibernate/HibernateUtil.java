package posjavamavenhibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {
	
	public static EntityManagerFactory factory = null;
	
	static {
		init();
	}
	
	private static void init() {
		
		try {
			if (factory == null) {
				factory = Persistence.createEntityManagerFactory("pos-java-maven-hibernate");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
//	Prove a parte de persistência
	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
	
	/**Esse método retorna a primaryKey**/
	public static Object getPrimaryKey (Object entity) {
		/**Aqui eu passo o objeto inteiro para o getIdentifier para que ele pegue a chave primária desse objeto**/
		return factory.getPersistenceUnitUtil().getIdentifier(entity);
	}

}
