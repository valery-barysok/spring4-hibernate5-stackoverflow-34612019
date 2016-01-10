package hello;

import org.hibernate.boot.spi.MetadataImplementor;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.hbm2ddl.SchemaUpdate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        new SchemaExport((MetadataImplementor) HibernateInfoHolder.getMetadata()).create(true, true);
        new SchemaUpdate(HibernateInfoHolder.getServiceRegistry(), (MetadataImplementor) HibernateInfoHolder.getMetadata()).execute(true, true);
    }
}
