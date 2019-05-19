package au.com.capita.api;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.google.common.collect.Lists;

import au.com.capita.api.dto.BaseVerificationDto;
import au.com.capita.api.dto.DeserializerUtil;
import au.com.capita.api.dto.PartnerManagedDto;
import au.com.capita.api.dto.VisaManagedDto;

@SpringBootApplication
//@EnableAspectJAutoProxy(proxyTargetClass=true)
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
  
  @Bean
  public ModelMapper modelMapper() {
	  final ModelMapper modelMapper = new ModelMapper();
	  return modelMapper;
  }
  @Bean
public Module verificationDeserializerModule() {
	
	final DeserializerUtil deserializerUtil = new DeserializerUtil();
	deserializerUtil.registerEditable(Lists.newArrayList("partnerCompanyId"), PartnerManagedDto.class);
	deserializerUtil.registerEditable(Lists.newArrayList("verificationTransactionId"), VisaManagedDto.class);
	
	SimpleModule module = new SimpleModule();
	module.addDeserializer(BaseVerificationDto.class,deserializerUtil);
	return module;
	
}
}
