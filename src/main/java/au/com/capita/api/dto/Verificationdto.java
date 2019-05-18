package au.com.capita.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Verificationdto {

	@JsonProperty(value="type", required=true)
	private String type; 
	@JsonProperty(value="value", required=true)
	private BaseVerificationDto value;
}
