package au.com.capita.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class VisaManagedDto extends BaseVerificationDto{

	@JsonProperty(value = "verificationTransactionId", required = true)
	private String  verificationTransactionId;
}
