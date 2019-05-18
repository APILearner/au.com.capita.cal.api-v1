package au.com.capita.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Getter
@Setter
public class CompanyDto {
	@JsonProperty(value = "companyId")
	private long id;
	@JsonProperty(value = "verificationData")
	private Verificationdto verificationData;
	

}
