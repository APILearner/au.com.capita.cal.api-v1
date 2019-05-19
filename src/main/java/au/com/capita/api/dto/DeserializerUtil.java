package au.com.capita.api.dto;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.Lists;

public class DeserializerUtil extends StdDeserializer<BaseVerificationDto> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6486391768378365339L;
	private static transient Map<List<String>,Class <? extends BaseVerificationDto>> registry = new HashMap<>();
	
	public DeserializerUtil() {
		super(BaseVerificationDto.class);
	}
	public void registerEditable(List<String> uniqueNodes, Class<?extends BaseVerificationDto> verificatioClass) {
		registry.put(uniqueNodes, verificatioClass);
	}
    @Override
    public BaseVerificationDto deserialize(JsonParser jsonParser,  DeserializationContext ctxt) throws IOException, JsonProcessingException {
        ObjectMapper mapper = (ObjectMapper) jsonParser.getCodec();
        ObjectNode root = (ObjectNode) mapper.readTree(jsonParser);
        
        Class<? extends BaseVerificationDto> verificationClass = null;
        final List<String> nodeElements = Lists.newArrayList(root.fieldNames());
        
        for(Map.Entry<List<String>, Class<? extends BaseVerificationDto>> uniqueNodes : registry.entrySet()) {
        	if(nodeElements.containsAll(uniqueNodes.getKey())) {
        		verificationClass=uniqueNodes.getValue();
        		break;
        	}
        }
        if (verificationClass == null){
            return null;
        }
        return mapper.treeToValue(root, verificationClass);
    }

}
