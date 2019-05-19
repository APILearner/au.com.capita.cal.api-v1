package au.com.capita.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PartnerManagedDto extends BaseVerificationDto {
	@JsonProperty(value = "partnerCompanyId", required = true)
	private long partnerCompanyId;
	@JsonProperty(value = "partnerEmailId", required = true)
	private String partnerEmailId;
}
