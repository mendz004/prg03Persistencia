package br.com.ifba;

import br.com.ifba.curso.view.CursoAdd;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Prg03SpringApplication {

	public static void main(String[] args) {
		
           ConfigurableApplicationContext context = 
                   new SpringApplicationBuilder(Prg03SpringApplication.class).
                   headless(false).run(args);
           
           CursoAdd telaCursoSave = context.getBean(CursoAdd.class);
           telaCursoSave.setVisible(true);
           
	}

}
