package com.bah.msd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;

//import com.uber.jaeger.Configuration;
//import com.uber.jaeger.samplers.ProbabilisticSampler;
//
//import io.opentracing.Tracer;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		System.out.println("Starting service ......");
		SpringApplication.run(App.class, args);
	}

//	@Bean
//	public racer jaegerTracer() {
//		return new Configuration("spring-boot", new Configuration.SamplerConfiguration(ProbabilisticSampler.TYPE, 1),
//				new Configuration.ReporterConfiguration()).getTracer();
//	}

}
