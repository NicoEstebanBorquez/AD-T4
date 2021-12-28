package ad_t4_55124290y;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class EmpleadosHIBERNATE {

    public static void main(String[] args) throws ParseException {

        //APARTADO RA3_D:
        
        // Se crea el SessionFactory
        SessionFactory sf = SessionFactorySingleton.getSessionFactory();
        // Se abre una sesion
        Session sesion = sf.openSession();
        // Se crea una transaccion sobre la sesion
        Transaction transaccion = sesion.beginTransaction();

        try {
            String sFecha = "2021/11/23";
            Date fecha = new SimpleDateFormat("yyyy/MM/dd").parse(sFecha);
           
            // Se crea el objeto que se va a insertar en la BD
            Employees empleado = new Employees(207, null, "Nicolás", "Esteban", "nicolas.esteban@foc.es", 
                    "666555444", fecha, "IT_PROG", new BigDecimal(15000), null, (short) 60, null);
            // Se guarda el objeto en la BD
            sesion.save(empleado);
            // Se hace el commit
            transaccion.commit();
            System.out.println("Empleado insertado corectamente: \n" + empleado.toString());
            
        } catch (Exception e) {
            // Si algo falla, se hace un rollback
            transaccion.rollback();
            System.out.println("Ha ocurrido un error al insertar el empleado.");
            
        } finally {
            //Se cierra la sesión y el SessionFactory
            sesion.close();
            sf.close();
        } 
    }
}



/*
// APARTADO RA_3E:

// Se obtiene el empleado que se quiere modificar
        Query query = sesion.createQuery("from Employees where firstName = :n and lastName = :a");
        query.setString("n", "Nicolás");
        query.setString("a", "Esteban");
        try {

            List<Employees> lista = query.list();
            for (Employees empleado : lista) {
                empleado.setSalary(new BigDecimal(30000));
                sesion.update(empleado);
            }
            transaccion.commit();
            
        } catch (Exception e) {
            // Si algo falla, se hace un rollback
            transaccion.rollback();
            System.out.println("Ha ocurrido un error al insertar el empleado.");

        } finally {
            //Se cierra la sesión y el SessionFactory
            sesion.close();
            sf.close();
        }
 */

/*
// APARTADO RA3_F:

        // Se crea el SessionFactory
        SessionFactory sf = SessionFactorySingleton.getSessionFactory();
        // Se abre una sesion
        Session sesion = sf.openSession();
        // Se crea una transaccion sobre la sesion
        Transaction transaccion = sesion.beginTransaction();

            Query query = sesion.createQuery("SELECT firstName, lastName, salary FROM Employees WHERE salary > 20000");
            List<Employees> lista = query.list();

            System.out.println("EMPLEADOS:");
            Iterator iterador = lista.iterator();
            Object[] empleado = null;
            
            while (iterador.hasNext()) {
                empleado = (Object[]) iterador.next();

                System.out.println(
                    "Nombre: " + empleado[0] + " - "
                    "Apellido: " +  empleado[1] + " - "
                    "Salario: " + empleado[2]
                );
            }

            //Se cierra la sesión y el SessionFactory
            sesion.close();
            sf.close();
    }
}

*/